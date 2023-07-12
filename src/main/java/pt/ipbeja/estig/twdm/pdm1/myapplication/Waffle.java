package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Waffle {
    @PrimaryKey
    private long waffleId;
    private String waffleName;
    private String wafflePrice;
    private String waffleImg;

    public Waffle(long waffleId, String waffleName, String wafflePrice, String waffleImg){
        this.waffleId = waffleId;
        this.waffleName = waffleName;
        this.wafflePrice = wafflePrice;
        this.waffleImg = waffleImg;
    }

    public long getWaffleId(){
        return waffleId;
    }

    public String getWaffleName() {
        return waffleName;
    }

    public String getWafflePrice() {
        return wafflePrice;
    }

    public String getWaffleImg() {
        return waffleImg;
    }
}