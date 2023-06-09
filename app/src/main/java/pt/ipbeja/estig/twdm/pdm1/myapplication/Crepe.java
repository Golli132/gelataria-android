package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import android.os.Bundle;

@Entity
public class Crepe {
    @PrimaryKey
    private long crepeId;
    private String crepeName;
    private String crepePrice;
    private String crepeImg;

    public Crepe(long crepeId, String crepeName, String crepePrice, String crepeImg){
        this.crepeId = crepeId;
        this.crepeName = crepeName;
        this.crepePrice = crepePrice;
        this.crepeImg = crepeImg;
    }

    public long getCrepeId(){
        return crepeId;
    }

    public String getCrepeName() {
        return crepeName;
    }

    public String getCrepePrice() {
        return crepePrice;
    }

    public String getCrepeImg() {
        return crepeImg;
    }

}