package Model;

import java.util.HashSet;

public class Capriciosa extends Pizza{

    public Capriciosa() {
        super();
        this.setName("Capriciosa");
        this.setPrice(29.99);
        this.addIngredients("ham");
        this.addIngredients("mushrooms");
    }
}
