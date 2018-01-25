package com.example.sambal.quicknews.Model;

import java.util.List;

/**
 * Created by Sambal on 1/5/2018.
 */

class UrlsToLogos{
    private String small, medium, large;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
public class Source {

    private String id, name, description, url, category, language, country;
    private UrlsToLogos UrlsToLogos;
    private List<String> SortBysAvailable;

    public Source() {
    }

    public Source(String id, String name, String description, String url, String category, String language, String country, com.example.sambal.quicknews.Model.UrlsToLogos urlsToLogos, List<String> sortBysAvailable) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.category = category;
        this.language = language;
        this.country = country;
        UrlsToLogos = urlsToLogos;
        SortBysAvailable = sortBysAvailable;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public com.example.sambal.quicknews.Model.UrlsToLogos getUrlsToLogos() {
        return UrlsToLogos;
    }

    public void setUrlsToLogos(com.example.sambal.quicknews.Model.UrlsToLogos urlsToLogos) {
        UrlsToLogos = urlsToLogos;
    }

    public List<String> getSortBysAvailable() {
        return SortBysAvailable;
    }

    public void setSortBysAvailable(List<String> sortBysAvailable) {
        SortBysAvailable = sortBysAvailable;
    }
}
