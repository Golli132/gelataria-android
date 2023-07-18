package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pedido {
    @PrimaryKey (autoGenerate = false)
    private long pedId;


}
