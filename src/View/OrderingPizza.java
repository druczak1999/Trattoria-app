package View;
import Controller.OrderController;
import java.util.HashSet;
import java.util.Scanner;

public class OrderingPizza {
    private OrderController order;
    public OrderingPizza() {
        order=new OrderController();
    }
    public static void sayHello(){
        System.out.println("Hello user! I've heard that you want order a pizza. This is our menu: ");
        menu();
    }
    public static void menu(){
        System.out.println("-------------------------------------MENU-------------------------------------");
        System.out.println("1. Margherita - dough, cheese, tomato sauce, basil                       25.99");
        System.out.println("2. Capriciosa - dough, cheese, tomato sauce, ham, mushrooms              29.99");
        System.out.println("3. Calzone    - dough, cheese, tomato sauce, ham, mushrooms, red pepper  31.99");
        System.out.println("We have only one size of pizza (32 cm)");

    }
    public void  choosePizza(){
        int numberOfPizza = 0;
        System.out.println("Which pizza do you want? Type number of pizza:");
        Scanner scan =new Scanner(System.in);
        boolean choosen=false;
        while (choosen==false) {
            int number=0;
            try{number  = scan.nextInt();}
            catch(Exception e){choosePizza();}

            if(number>3 || number<1) System.out.println("Please, type number from 1 to 3");
            else {
                System.out.println("You chose pizza nr "+number);
                choosen=true;
                numberOfPizza=number;
            }
        }
        HashSet<String> removed = removeIng(numberOfPizza);
        HashSet<String> ing =addIng();
        int amount=howMuchPizza();
        order.addPizzaToOrder(numberOfPizza,amount,ing, removed);
        System.out.println("Do you want order more pizzas? Type yes or no");
        String cont=scan.next();
        if(cont.equals("yes")){
            menu();
            choosePizza();
        }
        else addUsername();

    }
    public static HashSet<String> removeIng(int typeOfPizza){
        HashSet<String> ing = new HashSet<String>();
        Scanner scan =new Scanner(System.in);
        boolean removesth=false;
        int maxInt=0;
        while (removesth==false) {
            System.out.println("Do you want remove some ingredients from your pizza? If yes type number of ingredient else type 0");
            System.out.println("You can not remove dough, cheese and tomato sauce");
            if(typeOfPizza==1) {
                System.out.println("1. basil");
                maxInt=1;
            }
            else{
                maxInt=2;
                System.out.println("1. ham");
                System.out.println("2. mushrooms");
                if(typeOfPizza==3) {
                    System.out.println("3. red pepper");
                    maxInt=3;
                }
            }
            int number =0;
            try{number=scan.nextInt();}
            catch(Exception e){number=0; }
            if(number>maxInt || number<0) System.out.println("Please, type number from 1 to "+maxInt+" or 0 to exit");
            if(number==0) removesth=true;
            else {
                System.out.println("You chose ingredient nr "+number);
                switch(number){
                    case 1:
                        if(typeOfPizza==1)
                        ing.add("basil");
                        else ing.add("ham");
                        break;
                    case 2:
                        ing.add("mushrooms");
                        break;
                    case 3:
                        ing.add("red pepper");
                        break;

                }
                System.out.println("Do you want remove more ingredients? Type yes or no ");
                String agreed=scan.next();
                if(agreed.equals("no")) removesth=true;
                else if(!agreed.equals("no") && !agreed.equals("yes"))  System.out.println("It meens to me like no");
            }
        }
        return ing;
    }
    public static HashSet<String> addIng(){
        HashSet<String> ing = new HashSet<String>();
        Scanner scan =new Scanner(System.in);
        boolean addsth=false;
        while (addsth==false) {
            System.out.println("Do you want add some ingredients from list to your pizza? If yes type number of ingredient else type 0");
            System.out.println("Each ingredient cost 2zł");
            System.out.println("1. extra cheese");
            System.out.println("2. salami");
            System.out.println("3. corn");
            System.out.println("4. brocoli");
            System.out.println("5. olives");
            int number =0;
            try{
                number=scan.nextInt();
            }
            catch(Exception e){
                number=0;
            }
            if(number>5 || number<0) System.out.println("Please, type number from 1 to 5 or 0 to exit");
            if(number==0) addsth=true;
            else {
                System.out.println("You chose ingredient nr "+number);
                switch(number){
                    case 1:
                        ing.add("extra cheese");
                        break;
                    case 2:
                        ing.add("salami");
                        break;
                    case 3:
                        ing.add("corn");
                        break;
                    case 4:
                        ing.add("brocoli");
                        break;
                    case 5:
                        ing.add("olives");
                        break;
                }

                System.out.println("Do you want add more ingredients? Type yes or no ");
                String agreed=scan.next();
                if(agreed.equals("no")) addsth=true;
                else if(!agreed.equals("no") && !agreed.equals("yes"))  System.out.println("It meens to me like no");
            }
        }
        return ing;
    }
    public static int howMuchPizza(){
        Scanner scan =new Scanner(System.in);
        boolean correctAmount=false;
        int amount=0;
        while (correctAmount==false){
            System.out.println("How much pizzas like this do you want?");
            int howMuchPizza=1;
            try{
                howMuchPizza=scan.nextInt();
            }
            catch (Exception e){
                howMuchPizza=1;
            }
            if(howMuchPizza<=0) System.out.println("Type number bigger than 0");
            else {
                correctAmount=true;
                amount=howMuchPizza;
            }
        }
        return amount;
    }

    public void addUsername(){
        System.out.println("Please enter your name");
        Scanner scan =new Scanner(System.in);
        String user = scan.nextLine();
        order.addUserToOrder(user);
        summary();
    }
    public void summary(){
        System.out.println("This is the summary of your order "+order.getUsername());
        System.out.println(order.getPizzas());
        ending();
    }
    public void ending(){
        Scanner scan =new Scanner(System.in);
        boolean exit=false;
        while (exit==false) {
            System.out.println("What do you prefer to do now " + order.getUsername());
            System.out.println("1. I want to finish my order and wait for delivery man");
            System.out.println("2. I want to add more pizzas to my order");
            System.out.println("3. I want to remove pizza from my order");
            int number = 1;
            try{
                number = scan.nextInt();
            }
            catch(Exception e){
                ending();
            }
            if (number > 3 || number < 1) System.out.println("Type number from 1 to 3");
            else if (number==2){
                exit=true;
                menu();
                choosePizza();
            }
            else if(number==1) {
                exit=true;
                System.out.println("Thank you and enjoy your meal!");
            }
            else {
                removePizza();
                summary();
            }
        }
    }
    public void removePizza(){
        Scanner scan =new Scanner(System.in);
        System.out.println("This is the summary of your order "+order.getUsername());
        System.out.println(order.getPizzas());
        System.out.println("You can remove pizza by type number of it");
        int number = 0;
        try{
            number = scan.nextInt();
        }
        catch(Exception e){
            ending();
        }
        if (number > order.getAmount() || number < 1) System.out.println("Type number from 1 to "+order.getAmount());
        else{
            order.removePizzaFromOrder(number);
        }
    }
}
