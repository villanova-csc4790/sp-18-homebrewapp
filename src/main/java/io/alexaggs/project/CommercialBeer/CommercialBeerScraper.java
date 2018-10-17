package io.alexaggs.project.CommercialBeer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.ArrayList;

public class CommercialBeerScraper {

    //Gets the name of the beer,
    public static ArrayList<CommercialBeer> getTopBeers() throws Exception {
        ArrayList<CommercialBeer> topBeers = new ArrayList<CommercialBeer>();
        int index = 0;
        final Document doc = Jsoup.connect("https://www.beeradvocate.com/lists/top/").get();
        for(Element row: doc.select("table td")) {
            String title = row.select("a b").text();
            if(!title.equals("")) {
                topBeers.add(new CommercialBeer(title, ""));
            }
        }
        for(Element row: doc.select("table td a")) {
            while(index < topBeers.size()) {
                String url = row.attr("href");
                if (url.length() > 20) {
                    topBeers.get(index).setUrl(url);
                }
                index++;
            }
        }
        return topBeers;
    }

    public static ArrayList<String> getBeerData(String url) throws Exception {
        ArrayList<String> beerInfo = new ArrayList<String>();
        Document doc = Jsoup.connect(url).get();
        for(Element row: doc.select("div#info_box")) {
            String info = row.select("a b").text();
            String text = row.ownText();
            String abv = text.substring(2, 8);
            beerInfo.add(info);
            beerInfo.add(abv);
        }
        return beerInfo;
    }
}
