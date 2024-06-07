package com.sinam7.booksage.service.webscrapper;

import com.sinam7.booksage.domain.book.BookDTO;
import com.sinam7.booksage.domain.book.LibraryBookDTO;
import com.sinam7.booksage.domain.book.LibraryBookBestRawJson;
import com.sinam7.booksage.domain.book.LibraryBookQuerySearchRawJson;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryScrapperService extends ScrapperService {

    private final WebClient libraryApiProductClient;

    public LibraryScrapperService(@Qualifier("LibraryApiProductClient") WebClient libraryApiProductClient) {
        this.libraryApiProductClient = libraryApiProductClient;
    }

    @Override
    public List<? extends BookDTO> getBooks() {
        LibraryBookBestRawJson raw = libraryApiProductClient
                .get()
                .uri("/pyxis-api/1/popular-charged-books?max=20&durationMonth=")
                .retrieve()
                .bodyToMono(LibraryBookBestRawJson.class)
                .block(REQUEST_TIMEOUT);

        assert raw != null;

        List<LibraryBookBestRawJson.DataList> list = raw.getData().getDataList();
        ArrayList<LibraryBookDTO> res = new ArrayList<>();
        for (LibraryBookBestRawJson.DataList json : list) res.add(LibraryBookDTO.build(json));
        return res;
    }


    // GET
    // https://lib.kookmin.ac.kr/pyxis-api/1/collections/1/search?all=k|a|검색어&abc=
    @Override
    public List<? extends BookDTO> searchBook(String query) {

        LibraryBookQuerySearchRawJson raw = libraryApiProductClient
                .get()
                .uri("/pyxis-api/1/collections/1/" +
                        "search?all=k|a|"+query+"&abc=")
                .retrieve()
                .bodyToMono(LibraryBookQuerySearchRawJson.class)
                .block(REQUEST_TIMEOUT);

        assert raw != null;

        List<LibraryBookQuerySearchRawJson.DataList> list = raw.getData().getDataList();
        ArrayList<LibraryBookDTO> res = new ArrayList<>();
        for (LibraryBookQuerySearchRawJson.DataList json : list) res.add(LibraryBookDTO.build(json));
        return res;

    }

}
