package io.alexaggs.project.CommercialBeer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CommercialBeer {

    @Id
    String cbId;
    String name, company, url;
    String abv;

    public CommercialBeer() {}

    public CommercialBeer(String cbId, String name, String company, String url, String abv) {
        this.cbId = cbId;
        this.name = name;
        this.company = company;
        this.url = url;
        this.abv = abv;
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
}