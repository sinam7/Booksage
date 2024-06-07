package com.sinam7.booksage.domain.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BookDTO {
    private String title;
    private String author;
    private String company;
    private String price;
    private String link;
    private String imageSrc;
}
