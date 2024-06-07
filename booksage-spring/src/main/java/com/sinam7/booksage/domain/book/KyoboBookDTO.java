package com.sinam7.booksage.domain.book;

import jakarta.annotation.Nullable;
import lombok.Getter;

import java.text.DecimalFormat;

@Getter
public class KyoboBookDTO extends BookDTO {

    static final DecimalFormat decimalFormat = new DecimalFormat("#,###");

    // author nullable when the book is paper; published by institute.
    public KyoboBookDTO(String title, @Nullable String author, String company, String price, String link, String imageSrc) {
        super(title, author, company, price, link, imageSrc);
    }

    public static KyoboBookDTO build(KyoboBookRawJson.KyoboBookJson json) {
        return new KyoboBookDTO(json.getCmdtName(), json.getChrcName(), json.getPbcmName(), decimalFormat.format(json.getSapr()) + "원",
                "https://product.kyobobook.co.kr/detail/" + json.getSaleCmdtid(),
                "https://contents.kyobobook.co.kr/sih/fit-in/300x0/pdt/" + json.getCmdtCode() + ".jpg");
    }
}
