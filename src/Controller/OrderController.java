package Controller;

import Model.Order;
import Model.Pizza;

import java.util.HashSet;

public class OrderController {
    private Order order;

    public OrderController() {
       order=new Order();
    }

    public boolean addPizzaToOrder(int numberOfPizza, int amount, HashSet<String> ing , HashSet<String> removed){

        return  order.addPizza(numberOfPizza,amount,ing, removed);
    }
    public void addUserToOrder(String username){
        order.setUsername(username);
    }
    public String getUsername(){
        return order.getUsername();
    }
    public String getPizzas(){
        return order.toString();
    }

    public int getAmount(){
        return order.getPizzas().size();
    }
    public boolean removePizzaFromOrder(int number){
        if(number>order.getPizzas().size() || number<1) return false;
       if((int)order.getPizzas().values().toArray()[number-1]>1){
           Pizza p=(Pizza)order.getPizzas().keySet().toArray()[number-1];
           order.setSum(order.getSum()-p.getPrice());
           this.order.getPizzas().put((Pizza) this.order.getPizzas().keySet().toArray()[number-1],this.order.getPizzas().get(this.order.getPizzas().keySet().toArray()[number-1])-1);
       }
       else{
           Pizza p=(Pizza)order.getPizzas().keySet().toArray()[number-1];
           order.setSum(order.getSum()-p.getPrice());
           this.order.getPizzas().remove(order.getPizzas().keySet().toArray()[number-1]);
       }
       return true;
    }
}
