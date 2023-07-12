package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CartItem {
    @PrimaryKey(autoGenerate = true)
    private int itemId;
    private String itemName;
    private String itemPrice;
    private String itemTopping;

    public CartItem(int itemId, String itemName, String itemPrice, String itemTopping) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemTopping = itemTopping;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemTopping(){
        return itemTopping;
    }

    public int getItemId(){return itemId;}
}


