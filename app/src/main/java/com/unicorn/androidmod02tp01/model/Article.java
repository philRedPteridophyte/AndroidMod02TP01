package com.unicorn.androidmod02tp01.model;

public class Article {

    private int id;
    private String label;
    private Double price;
    private String description;
    private Float rating;

    public Article() {
        super();
    }

    public Article(int id) {
        super();
        this.id = id;
    }

    public Article(int id, String label, Double price, String description, Float rating) {
        super();
        this.id = id;
        this.label = label;
        this.price = price;
        this.description = description;
        this.rating = rating;
    }

    public Article(String label, Double price, String description, Float rating) {
        super();
        this.label = label;
        this.price = price;
        this.description = description;
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
}
