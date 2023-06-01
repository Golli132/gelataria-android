package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.view.View;

import androidx.room.Entity;

@Entity
public class WaffleItems {
    private String name;
    private String price;

    public WaffleItems(String name, String price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getPrice(){
        return price;
    }
}
