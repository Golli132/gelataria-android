package pt.ipbeja.estig.twdm.pdm1.myapplication;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class GeladoItems {
    @PrimaryKey (autoGenerate = true)
    private long gelId;
    private String gelName;
    private String gelPrice;

    public GeladoItems(long gelId, String gelName, String gelPrice){
        this.gelId = gelId;
        this.gelName = gelName;
        this.gelPrice = gelPrice;
    }

    public long getGelId(){ return gelId; }

    public String getGelName() {return gelName;}

    public String getGelPrice() {return gelPrice;}


}
