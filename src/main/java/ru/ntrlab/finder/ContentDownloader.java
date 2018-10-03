package ru.ntrlab.finder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ContentDownloader {


    public String getContent() throws Exception {
        String url = "https://news.yandex.ru/computers.html";
        Document document = Jsoup.connect(url).get();
        String text = document.body().text();
        return text;
    }
}
