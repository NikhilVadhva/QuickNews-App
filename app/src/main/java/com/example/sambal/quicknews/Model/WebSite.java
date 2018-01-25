package com.example.sambal.quicknews.Model;

import java.util.List;

/**
 * Created by Sambal on 1/5/2018.
 */

public class WebSite {

    private String status;
    private List<com.example.sambal.quicknews.Model.Source> sources;

    public WebSite() {
    }

    public WebSite(String status, List<com.example.sambal.quicknews.Model.Source> sources) {
        this.status = status;
        this.sources = sources;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<com.example.sambal.quicknews.Model.Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
