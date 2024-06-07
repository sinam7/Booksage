package com.sinam7.booksage.domain.book;

import com.sinam7.booksage.domain.account.Account;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bookmark_user_id", referencedColumnName = "id", nullable = false)
    private Account bookmarkUser;

    private String title;
    private String author;
    private String company;
    private String price;
    private String link;
    private String imageSrc;

    public static Book build(BookDTO dto) {
        return new BookBuilder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .company(dto.getCompany())
                .price(dto.getPrice())
                .link(dto.getLink())
                .imageSrc(dto.getImageSrc())
                .build();
    }
}