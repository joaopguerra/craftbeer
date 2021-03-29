package com.beerhouse.model.entity;

import com.beerhouse.model.dto.BeerRequest;
import com.beerhouse.model.dto.BeerResponse;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_beer")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ingredients;
    private String alcoholContent;
    private Double price;
    private String category;

    public Beer(){
    }

    public Beer(Long id, String name, String ingredients, String alcoholContent, Double price, String category) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.alcoholContent = alcoholContent;
        this.price = price;
        this.category = category;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beer)) return false;
        Beer beer = (Beer) o;
        return Objects.equals(getId(), beer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public static Beer valueOf(BeerRequest beerRequest){
        return new Beer(beerRequest.getId(), beerRequest.getName(), beerRequest.getIngredients(),
                beerRequest.getAlcoholContent(), beerRequest.getPrice(), beerRequest.getCategory());
    }
}
