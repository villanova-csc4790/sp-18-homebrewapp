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
        for (Element row : doc.select("table td")) {
            String title = row.select("a b").text();
            if (!title.equals("")) {
                topBeers.add(new CommercialBeer(title, ""));
            }
        }
        for (Element row : doc.select("table td a")) {
            String url = row.attr("href");
            if (url.length() > 20 && !(url.length() > 50)) {
                topBeers.get(index).setUrl(url);
                index++;
            }
        }
        return topBeers;
    }

    public static ArrayList<String> getBeerData(String url) throws Exception {
        ArrayList<String> beerInfo = new ArrayList<String>();
        Document doc = Jsoup.connect(url).get();
        for (Element row : doc.select("div#info_box")) {
            String info = row.select("a b").text();
            String text = row.ownText();
            /* I have it at 13 because that should be large enough to obtain the abv % for
             * every beer. Each abv entry will have some arbitrary text but I am just going
             * to filter that out.
             */
            String abv = text.substring(0, 8);
            abv = abv.replace(',', ' ');
            if(!abv.contains("%")) {
                abv = "No Listed ABV";
            }
            System.out.println(abv);
            beerInfo.add(info);
            beerInfo.add(abv);
        }
        return beerInfo;
    }
}