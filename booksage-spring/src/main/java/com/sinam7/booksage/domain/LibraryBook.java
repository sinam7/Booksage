package com.sinam7.booksage.domain;

import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class LibraryBook extends Book {

    // author nullable when the book is paper; published by institute.
    public LibraryBook(String title, @Nullable String author, String company, String link, String imageSrc) {
        super(title, author, company, "소장 장서", link, imageSrc);
    }

    public static LibraryBook build(LibraryBookQuerySearchRawJson.DataList json) {
        return new LibraryBook(json.getTitleStatement(), json.getAuthor(), json.getPublication(),
                "https://lib.kookmin.ac.kr/#/search/detail/" + json.getId(),
                json.getThumbnailUrl());
    }
    public static LibraryBook build(LibraryBookBestRawJson.DataList json) {
        return new LibraryBook(json.getTitleStatement(), json.getAuthor(), json.getPublication(),
                "https://lib.kookmin.ac.kr/#/search/detail/" + json.getId(),
                json.getThumbnailUrl());
    }

}
