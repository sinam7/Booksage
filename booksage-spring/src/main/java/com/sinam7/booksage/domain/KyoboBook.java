package com.sinam7.booksage.domain;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.DecimalFormat;

@Getter
public class KyoboBook extends Book {

    static final DecimalFormat decimalFormat = new DecimalFormat("#,###");

    // author nullable when the book is paper; published by institute.
    public KyoboBook(String title, @Nullable String author, String company, String price, String link, String imageSrc) {
        super(title, author, company, price, link, imageSrc);
    }

    public static KyoboBook build(KyoboBookRawJson.KyoboBookJson json) {
        return new KyoboBook(json.getCmdtName(), json.getChrcName(), json.getPbcmName(), decimalFormat.format(json.getSapr()) + "원",
                "https://product.kyobobook.co.kr/detail/" + json.getSaleCmdtid(),
                "https://contents.kyobobook.co.kr/sih/fit-in/300x0/pdt/" + json.getCmdtCode() + ".jpg");
    }
}
