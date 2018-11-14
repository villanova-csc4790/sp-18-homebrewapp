package io.alexaggs.project.CommercialBeer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CommercialBeer {

    @Id
    private String cbId;
    private String name, company, url;
    private String abv;
    private String style;

    public CommercialBeer() {}

    public CommercialBeer(String cbId, String name, String company, String url, String abv, String style) {
        this.cbId = cbId;
        this.name = name;
        this.company = company;
        this.url = url;
        this.abv = abv;
        this.style = style;
    }

    public void setCBId(String cbId) {
        this.cbId = cbId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) { this.company = company; };

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAbv(String abv) { this.abv = abv; };

    public void setStyle(String style) {
        this.style = style;
    }

    public String getId() {
        return cbId;
    }

    public String getName() {
        return name;
    }

    public String getCompany() { return company; }

    public String getUrl() {
        return url;
    }

    public String getAbv() { return abv; }

    public String getStyle() {
        return style;
    }
}