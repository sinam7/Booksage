package com.sinam7.booksage.domain.book;

import lombok.Getter;

@Getter
public class InterparkBookDTO extends BookDTO {
    public InterparkBookDTO(String title, String author, String company, String price, String link, String imageSrc) {
        super(title, author, company, price, link, imageSrc);
    }
//
//    private String imageSrc;
//    private String link;
//    private String title;
//    private String author;
//    private String company;
//    private String price;

}
