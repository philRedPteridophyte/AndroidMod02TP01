package com.unicorn.androidmod02tp01.model;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Article implements Serializable {

    private long id;
    private String label;
    private Double price;
    private String description;
    private Float rating;
    private String url;
    private boolean bought;
/*
    public Article() {
        super();
    }

    public Article(int id) {
        super();
        this.id = id;
    }

    public Article(int id, String label, Double price, String description, Float rating, String url, boolean bought) {
        this.id = id;
        this.label = label;
        this.price = price;
        this.description = description;
        this.rating = rating;
        this.url = url;
        this.bought = bought;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

 */
}
