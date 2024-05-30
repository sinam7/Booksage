package com.sinam7.booksage.service;

import com.sinam7.booksage.domain.Book;
import com.sinam7.booksage.domain.InterparkBook;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterparkScrapperService extends ScrapperService {


    private final String origin = "https://book.interpark.com";
    //    private final String pathquery = "/display/collectlist.do?_method=BestsellerHourNew201605&bestTp=1&dispNo=028";

    private final WebDriver webDriver;

    private static parsedResult getParsedResult(WebElement e) {
        WebElement info = e.findElement(By.cssSelector("div.info"));
        String imageSrc = e.findElement(By.cssSelector("img.bd")).getAttribute("src");
        WebElement titleEle = info.findElement(By.cssSelector("p.tit b a"));
        String link = titleEle.getAttribute("href");
        String title = titleEle.getText();
        String[] writerSplit = info.findElement(By.cssSelector("p.writer")).getText().split("I");
        String author;
        String company;
        if (writerSplit.length == 2) {
            author = null;
            company = writerSplit[0];
        } else {
            author = writerSplit[0];
            company = writerSplit[1];
        }
        WebElement priceEle = e.findElement(By.cssSelector("div.price"));

        String text;
        List<WebElement> element = priceEle.findElements(By.cssSelector("span.nowMoney"));
        if (!element.isEmpty()) {
            text = element.getFirst().getText();
        } else {
            text = priceEle.findElement(By.cssSelector("p.defaultNum")).getText();
        }
        String price = text.substring(0, text.indexOf("원") + 1);
        return new parsedResult(imageSrc, link, title, author, company, price);
    }

    @PreDestroy
    public void cleanup() {
        // WebDriver 종료
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Override
    public List<InterparkBook> getBooks() {

        Elements select = getMS949Elements("/display/collectlist.do?_method=BestsellerHourNew201605&bestTp=1&dispNo=028",
                "div.rankBestContentList ol li div.listItem");

        ArrayList<InterparkBook> interparkBooks = new ArrayList<>();

        for (Element e : select) {
            String imageSrc = e.select("div.coverImage img").attr("src");
            String link = e.select("div.coverImage label a").attr("href");
            String title = e.select("div.itemName strong").html();
            String author = e.select("div.itemMeta span.author").html();
            String company = e.select("div.itemMeta span.company").html();
            Elements select1 = e.select("div.priceWrap span.price");
            String price = select1.select("em").html() + select1.select("span.currency").html();

            interparkBooks.add(new InterparkBook(title, author, company, price, link, imageSrc));
        }

        return interparkBooks;
    }

    @Override
    public List<? extends Book> searchBook(String query) {


        List<WebElement> select;
        try {
            webDriver.get("https://bsearch.interpark.com" + "/dsearch/book.jsp?sch=all&sc.shopNo=&bookblockname=s_main&booklinkname=s_main&bid1=search_auto&bid2=product&bid3=000&bid4=001" + "&query=" + URLEncoder.encode(query, "EUC-KR"));
            select = webDriver.findElements(By.className("list_wrap"));

        } catch (/*InterruptedException |*/ UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        ArrayList<InterparkBook> interparkBooks = new ArrayList<>();

        for (WebElement e : select) {
            parsedResult result = getParsedResult(e);
            interparkBooks.add(new InterparkBook(result.title(), result.author(), result.company(), result.price(), result.link(), result.imageSrc()));
        }

        return interparkBooks;
    }

    private Elements getMS949Elements(String pathQuery, String cssQuery) {
        Elements select;
        try {
            Document doc = Jsoup.connect(origin + pathQuery).header("Content-Type", "text/html; charset=MS949").get();
//            String ms949Html = new String(doc.html().getBytes(Charset.forName("MS949")), StandardCharsets.UTF_8);
            Thread.sleep(3000);
//            select = Jsoup.parse(ms949Html).select("div.rankBestContentList ol li div.listItem");
            select = doc.select(cssQuery);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return select;
    }

    public String getHtml(String url) {

        try {
            URL targetUrl = new URI(url).toURL();
            BufferedReader reader = new BufferedReader(new InputStreamReader(targetUrl.openStream(), StandardCharsets.UTF_8));
            StringBuilder html = new StringBuilder();

            String current = "";
            while ((current = reader.readLine()) != null) {
                html.append(current);
            }

            reader.close();

            return html.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private record parsedResult(String imageSrc, String link, String title, String author, String company,
                                String price) {
    }
}

