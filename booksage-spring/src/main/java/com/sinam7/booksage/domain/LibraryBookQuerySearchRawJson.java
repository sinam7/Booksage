package com.sinam7.booksage.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

public class LibraryBookQuerySearchRawJson {

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
        @JsonProperty("facets")
        private List<Facets> facets;
        @JsonProperty("list")
        @Getter
        private List<DataList> dataList;
        @JsonProperty("max")
        private int max;
        @JsonProperty("offset")
        private int offset;
        @JsonProperty("totalCount")
        private int totalCount;
        @JsonProperty("isFuzzy")
        private boolean isFuzzy;

    }

    public static class Facets {
        @JsonProperty("items")
        private List<Items> items;
        @JsonProperty("size")
        private int size;
        @JsonProperty("name")
        private String name;
        @JsonProperty("code")
        private String code;
    }

    public static class Items {
        @JsonProperty("count")
        private int count;
        @JsonProperty("value")
        private String value;
        @JsonProperty("label")
        private String label;
    }

    public static class BranchVolumes {
        @JsonProperty("hasItem")
        private boolean hasItem;
        @JsonProperty("cStateCode")
        private String cStateCode;
        @JsonProperty("cState")
        private String cState;
        @JsonProperty("volume")
        private String volume;
        @JsonProperty("isCr")
        private boolean isCr;
        @JsonProperty("name")
        private String name;
        @JsonProperty("id")
        private int id;
    }


    @Getter
    public static class DataList {
        @JsonProperty("dateReceived")
        private String dateReceived;
        @JsonProperty("similars")
        private List<Similars> similars;
        @JsonProperty("newResources")
        private NewResources newResources;
        @JsonProperty("resources")
        private Resources resources;
        @JsonProperty("erSources")
        private List<ErSources> erSources;
        @JsonProperty("branchVolumes")
        private List<BranchVolumes> branchVolumes;
        @JsonProperty("etcContent")
        private String etcContent;
        @JsonProperty("publication")
        private String publication;
        @JsonProperty("author")
        private String author;
        @JsonProperty("titleStatement")
        private String titleStatement;
        @JsonProperty("isbn")
        private String isbn;
        @JsonProperty("thumbnailUrl")
        private String thumbnailUrl;
        @JsonProperty("biblioType")
        private BiblioType biblioType;
        @JsonProperty("id")
        private int id;
    }


    public static class Similars {
        @JsonProperty("publication")
        private String publication;
        @JsonProperty("titleStatement")
        private String titleStatement;
        @JsonProperty("id")
        private int id;
    }

    public static class NewResources {
        @JsonProperty("W")
        private List<NewResourcesW> W;
    }

    public static class NewResourcesW {
        @JsonProperty("sortOrder")
        private int sortOrder;
        @JsonProperty("code")
        private String code;
        @JsonProperty("id")
        private int id;
        @JsonProperty("count")
        private int count;
        @JsonProperty("imageMapOffset")
        private int imageMapOffset;
        @JsonProperty("name")
        private String name;
    }

    public static class Resources {
        @JsonProperty("W")
        private List<ResourcesW> W;
    }

    public static class ResourcesW {
        @JsonProperty("type")
        private String type;
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("count")
        private String count;
    }

    public static class ErSources {
        @JsonProperty("url")
        private String url;
        @JsonProperty("embargoPeriod")
        private String embargoPeriod;
        @JsonProperty("coverageEnd")
        private String coverageEnd;
        @JsonProperty("coverageBegin")
        private String coverageBegin;
        @JsonProperty("name")
        private String name;
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
