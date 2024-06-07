package com.sinam7.booksage.domain.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/** @noinspection unused*/
public class LibraryBookBestRawJson {

    @JsonProperty("data")
    @Getter
    private Data data;
    @JsonProperty("message")
    private String message;
    @JsonProperty("code")
    private String code;
    @JsonProperty("success")
    private boolean success;

    public static class Data {
        @JsonProperty("list")
        @Getter
        private List<DataList> dataList;
        @JsonProperty("totalCount")
        private int totalCount;
    }

    @Getter
    public static class DataList {
        @JsonProperty("thumbnailUrl")
        private String thumbnailUrl;
        @JsonProperty("chargeCnt")
        private int chargeCnt;
        @JsonProperty("isbn")
        private String isbn;
        @JsonProperty("biblioType")
        private BiblioType biblioType;
        @JsonProperty("publication")
        private String publication;
        @JsonProperty("author")
        private String author;
        @JsonProperty("titleStatement")
        private String titleStatement;
        @JsonProperty("id")
        private int id;
    }

    public static class BiblioType {
        @JsonProperty("biblioSchema")
        private BiblioSchema biblioSchema;
        @JsonProperty("materialType")
        private MaterialType materialType;
        @JsonProperty("name")
        private String name;
        @JsonProperty("id")
        private int id;
    }

    public static class BiblioSchema {
        @JsonProperty("isMarc")
        private boolean isMarc;
        @JsonProperty("name")
        private String name;
        @JsonProperty("id")
        private int id;
    }

    public static class MaterialType {
        @JsonProperty("name")
        private String name;
        @JsonProperty("id")
        private int id;
    }
}
