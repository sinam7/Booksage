package com.sinam7.booksage.domain.book;

import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class LibraryBookDTO extends BookDTO {

    // author nullable when the book is paper; published by institute.
    public LibraryBookDTO(String title, @Nullable String author, String company, String link, String imageSrc) {
        super(title, author, company, "소장 장서", link, imageSrc);
    }

    public static LibraryBookDTO build(LibraryBookQuerySearchRawJson.DataList json) {
        return new LibraryBookDTO(json.getTitleStatement(), json.getAuthor(), json.getPublication(),
                "https://lib.kookmin.ac.kr/#/search/detail/" + json.getId(),
                json.getThumbnailUrl());
    }
    public static LibraryBookDTO build(LibraryBookBestRawJson.DataList json) {
        return new LibraryBookDTO(json.getTitleStatement(), json.getAuthor(), json.getPublication(),
                "https://lib.kookmin.ac.kr/#/search/detail/" + json.getId(),
                json.getThumbnailUrl());
    }

}
