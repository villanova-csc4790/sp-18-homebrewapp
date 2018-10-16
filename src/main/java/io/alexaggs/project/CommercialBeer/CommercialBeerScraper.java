package io.alexaggs.project.CommercialBeer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.ArrayList;

public class CommercialBeerScraper {

    //Gets the name of the beer,
    public static ArrayList<String> getData() throws Exception {
        ArrayList<String> topBeerNames = new ArrayList<String>();
        final Document doc = Jsoup.connect("https://www.beeradvocate.com/lists/top/").get();
        for(Element row: doc.select("table td")) {
            String title = row.select("a b").text();
            if(!title.equals("")) {
                topBeerNames.add(title);
            }
        }
        return topBeerNames;
    }
}
