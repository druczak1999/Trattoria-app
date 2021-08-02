package Model;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;

public class Order {
    private String username;
    private HashMap<Pizza, Integer> pizzas;
    private double sum;

    public double getSum() {
        return sum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<Pizza, Integer> getPizzas() {return pizzas;}

    public void setSum(double sum) {this.sum = sum; }

    public Order() {
        pizzas=new HashMap<>();
    }

    public boolean addPizza(int numberOfPizza, int amount, HashSet<String> ing, HashSet<String> removed){
        Pizza p;
        if(numberOfPizza==1) p =new Margherita();
        else if (numberOfPizza==2)p = new Capriciosa();
        else p = new Calzone();
        if(removed!=null){
            for(int i=0;i <removed.size();i++) p.getIngredients().remove(removed.toArray()[i]);
        }

        if(ing!=null)
        p.getIngredients().addAll(ing);
        if(ing!=null)
        p.setPrice(p.getPrice()+(2*ing.size()));


        int s=pizzas.size();
        boolean added=false;
        if(s>0){
            for(int i=0;i<s;i++){
                Pizza pizza = (Pizza) pizzas.keySet().toArray()[i];
                if(pizza.getName().equals(p.getName()) && pizza.getIngredients().equals(p.getIngredients())
                        && pizza.getIngredients().size()==p.getIngredients().size()){
                    if(!added) {
                        pizzas.put(pizza, pizzas.get(pizza) + amount);
                        added = true;
                    }
                }
                else {
                    if(!added){
                        pizzas.put(p,amount);
                        added=true;
                    }
                }
            }
        }
        else pizzas.put(p,amount);
        sum+=p.getPrice()*amount;
        return true;
    }
    public String toString(){
        String order="";
        for(int i=0;i<pizzas.size();i++){
            order+=i+1+". "+pizzas.keySet().toArray()[i]+" - "+pizzas.get(pizzas.keySet().toArray()[i]);
            order+='\n';
        }
        order+="Price: "+sum;
        return order;
    }
}
