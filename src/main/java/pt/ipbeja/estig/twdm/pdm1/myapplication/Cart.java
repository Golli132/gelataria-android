package pt.ipbeja.estig.twdm.pdm1.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Cart instance;
    private List<Gelado> items;

    private Cart() {
        items = new ArrayList<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public void addItem(Gelado gelado) {
        items.add(gelado);
    }

    public List<Gelado> getItems() {
        return items;
    }
}









