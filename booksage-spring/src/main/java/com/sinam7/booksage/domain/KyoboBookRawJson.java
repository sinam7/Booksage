package com.sinam7.booksage.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class KyoboBookRawJson {
    @JsonProperty("resultMessage")
    private String resultMessage;
    @JsonProperty("resultCode")
    private String resultCode;
    @JsonProperty("statusCode")
    private int statusCode;
    @JsonProperty("data")
    private Data data;

    @Getter
    public static class Data {
        @JsonProperty("total")
        private int total;
        @JsonProperty("ymw")
        private String ymw;
        @JsonProperty("page")
        private int page;
        @JsonProperty("bestSeller")
        private List<KyoboBookJson> kyoboBookJson;
    }

    @Getter
    public static class KyoboBookJson {
        @JsonProperty("productInfo")
        private ProductInfo productInfo;
        @JsonProperty("rowNum")
        private int rowNum;
        @JsonProperty("total")
        private int total;
        @JsonProperty("ymw")
        private String ymw;
        @JsonProperty("saleLmttAge")
        private int saleLmttAge;
        @JsonProperty("cmdtCode")
        private String cmdtCode;
        @JsonProperty("cmdtCdtnCode")
        private String cmdtCdtnCode;
        @JsonProperty("saleCdtnCode")
        private String saleCdtnCode;
        @JsonProperty("saleCmdtClstName")
        private String saleCmdtClstName;
        @JsonProperty("saleCmdtClstCode")
        private String saleCmdtClstCode;
        @JsonProperty("saleCmdtDvsnCode")
        private String saleCmdtDvsnCode;
        @JsonProperty("likeWhether")
        private boolean likeWhether;
        @JsonProperty("preview")
        private boolean preview;
        @JsonProperty("frmrRnkn")
        private int frmrRnkn;
        @JsonProperty("revwEmtnKywrName")
        private String revwEmtnKywrName;
        @JsonProperty("buyRevwRvgr")
        private double buyRevwRvgr;
        @JsonProperty("buyRevwNumc")
        private int buyRevwNumc;
        @JsonProperty("upntAcmlAmnt")
        private int upntAcmlAmnt;
        @JsonProperty("upntAcmlRate")
        private int upntAcmlRate;
        @JsonProperty("dscnRate")
        private int dscnRate;
        @JsonProperty("sapr")
        private int sapr;
        @JsonProperty("price")
        private int price;
        @JsonProperty("inbukCntt")
        private String inbukCntt;
        @JsonProperty("rlseDate")
        private String rlseDate;
        @JsonProperty("pbcmName")
        private String pbcmName;
        @JsonProperty("chrcName")
        private String chrcName;
        @JsonProperty("cmdtName")
        private String cmdtName;
        @JsonProperty("saleCmdtGrpDvsnCode")
        private String saleCmdtGrpDvsnCode;
        @JsonProperty("saleCmdtid")
        private String saleCmdtid;
        @JsonProperty("prstRnkn")
        private int prstRnkn;

    }

    public static class ProductInfo {
        @JsonProperty("cutPrice")
        private boolean cutPrice;
        @JsonProperty("bind")
        private boolean bind;
        @JsonProperty("fixPrice")
        private boolean fixPrice;
        @JsonProperty("incomeDeduction")
        private boolean incomeDeduction;
        @JsonProperty("event")
        private boolean event;
        @JsonProperty("gifts")
        private boolean gifts;
        @JsonProperty("limitSale")
        private boolean limitSale;
        @JsonProperty("onlyKyobo")
        private boolean onlyKyobo;
        @JsonProperty("specialOrder")
        private boolean specialOrder;
        @JsonProperty("mdChoice")
        private boolean mdChoice;
        @JsonProperty("todayBook")
        private boolean todayBook;
        @JsonProperty("shippingText")
        private String shippingText;
        @JsonProperty("shippingCode")
        private String shippingCode;
        @JsonProperty("releaseOnOff")
        private boolean releaseOnOff;
        @JsonProperty("reStockOnOff")
        private boolean reStockOnOff;
        @JsonProperty("viewDetails")
        private boolean viewDetails;
        @JsonProperty("direct")
        private boolean direct;
        @JsonProperty("buy")
        private boolean buy;
        @JsonProperty("basket")
        private boolean basket;
        @JsonProperty("like")
        private boolean like;
    }
}
