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
        String title = "", url = "", name = "";
        final Document doc = Jsoup.connect("https://www.beeradvocate.com/lists/top/").get();

        //Gets the name of each beer
        for(Element row: doc.select("table td")) {
            name = row.select("b").text();
            if(name.length() > 8)
                topBeers.add(new CommercialBeer("", name, "", "", ""));

        }

        //Gets the url for each beer profile
        for (Element row : doc.select("table td a")) {
            url = row.attr("href");
            if (url.length() > 20 && !(url.length() > 50) && index < topBeers.size()) {
                topBeers.get(index).setUrl(url);
                index++;
            }
        }

        return topBeers;
    }

    public static ArrayList<CommercialBeer> getTopBeers(String beerStyle) throws Exception {
        ArrayList<CommercialBeer> topBeers = new ArrayList<CommercialBeer>();
        int index = 0;
        String title = "", url = "", name = "";
        final Document doc = Jsoup.connect("https://www.beeradvocate.com/lists/style/" + beerStyle).get();
        //Gets the name of each beer
        for(Element row: doc.select("table td")) {
            name = row.select("b").text();
            if(name.length() > 8)
                topBeers.add(new CommercialBeer("", name, "", "", ""));

        }

        index = 0;
        //Gets the url for each beer profile
        for (Element row : doc.select("table td a")) {
            url = row.attr("href");
            if (url.length() > 20 && !(url.length() > 50) && index < topBeers.size()) {
                topBeers.get(index).setUrl(url);
                index++;
            }
        }

        return topBeers;
    }

    public static ArrayList<String> getBeerData(String url) throws Exception {
        ArrayList<String> beerInfo = new ArrayList<String>();
        int index = 0;
        String info = "", text = "", abv = "";
        Document doc = Jsoup.connect(url).get();
        for (Element row : doc.select("div#info_box")) {
            info = row.select("a b").text();
            text = row.ownText();
            abv = text.substring(0, 8);
            abv = abv.replace(',', ' ');
            if (!abv.contains("%")) {
                abv = "No Listed ABV";
            }
            beerInfo.add(info);
            beerInfo.add(abv);
        }
        return beerInfo;
    }
}