package Model;

import java.util.ArrayList;
import java.util.HashSet;

public class Pizza {
    private String name;
    private HashSet<String> ingredients;
    private double price;

    public Pizza() {
        ingredients=new HashSet<String>();
        ingredients.add("dough");
        ingredients.add("cheese");
        ingredients.add("tomato sauce");
    }
    public String getName() {return name;}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<String> getIngredients() {
        return ingredients;
    }

    public String toString(){
        return this.name + " - " + this.ingredients;
    }

    public void addIngredients(String ingredient){
        this.ingredients.add(ingredient);
    }
}
