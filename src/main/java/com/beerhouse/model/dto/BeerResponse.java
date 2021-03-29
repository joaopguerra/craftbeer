package com.beerhouse.model.dto;

import com.beerhouse.model.entity.Beer;

public class BeerResponse {

    private Long id;
    private String name;
    private String ingredients;
    private String alcoholContent;
    private Double price;
    private String category;

    public BeerResponse(Long id, String name, String ingredients, String alcoholContent, Double price, String category) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.alcoholContent = alcoholContent;
        this.price = price;
        this.category = category;
    }

    public BeerResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(String alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static BeerResponse valueOf(Beer beer){
        return new BeerResponse(beer.getId(), beer.getName(), beer.getIngredients(),
                beer.getAlcoholContent(), beer.getPrice(), beer.getCategory());
    }
}
