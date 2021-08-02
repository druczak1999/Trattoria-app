package Tests;

import Controller.OrderController;
import Model.Order;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class Tests {
    @Test
    public void addPizzaToOrder(){
        OrderController order = new OrderController();
        Assert.assertTrue(order.addPizzaToOrder(1,1,null,null));
    }
    @Test
    public void addPizzaWithIngredientToOrder(){
        OrderController order = new OrderController();
        HashSet<String> ing = new HashSet<>();
        ing.add("corn");
        Assert.assertTrue(order.addPizzaToOrder(1,1,ing,null));
    }
    @Test
    public void addPizzaWithLessIngredientsToOrder(){
        OrderController order = new OrderController();
        HashSet<String> ing = new HashSet<>();
        ing.add("basil");
        Assert.assertTrue(order.addPizzaToOrder(1,1,null,ing));
    }
    @Test
    public void addSecondTheSamePizzaToOrder(){
        OrderController order = new OrderController();
        order.addPizzaToOrder(1,1,null,null);
        order.addPizzaToOrder(1,1,null,null);
        Assert.assertTrue(order.getAmount()==1);
    }
    @Test
    public void addSecondPizzaToOrder(){
        OrderController order = new OrderController();
        order.addPizzaToOrder(1,1,null,null);
        Assert.assertTrue(order.addPizzaToOrder(2,1,null,null));
    }
    @Test
    public void removePizzaFromOrder(){
        OrderController order = new OrderController();
        order.addPizzaToOrder(1,1,null,null);
        Assert.assertTrue(order.removePizzaFromOrder(1));
    }
    @Test
    public void notRemovePizzaFromOrder(){
        OrderController order = new OrderController();
       //order.addPizzaToOrder(1,1,null,null);
        Assert.assertFalse(order.removePizzaFromOrder(1));
    }
    @Test
    public void notRemovePizzaFromOrder2(){
        OrderController order = new OrderController();
        order.addPizzaToOrder(1,1,null,null);
        Assert.assertFalse(order.removePizzaFromOrder(2));
    }
    @Test
    public void removeOneOfTwoTheSamePizzaFromOrder(){
        OrderController order = new OrderController();
        order.addPizzaToOrder(1,1,null,null);
        order.addPizzaToOrder(1,1,null,null);
        Assert.assertTrue(order.getAmount()==1);
    }
}
