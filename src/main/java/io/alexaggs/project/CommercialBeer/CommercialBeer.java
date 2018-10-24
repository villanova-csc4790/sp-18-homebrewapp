package io.alexaggs.project.CommercialBeer;

public class CommercialBeer {

    String name, company, url;
    String abv;

    public CommercialBeer(String name, String company, String url, String abv) {
        this.name = name;
        this.company = company;
        this.url = url;
        this.abv = abv;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) { this.company = company; };

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAbv(String abv) { this.abv = abv; };

    public String getName() {
        return name;
    }

    public String getCompany() { return company; }

    public String getUrl() {
        return url;
    }

    public String getAbv() { return abv; }
}