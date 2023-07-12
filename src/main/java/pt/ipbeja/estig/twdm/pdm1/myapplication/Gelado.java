package pt.ipbeja.estig.twdm.pdm1.myapplication;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity
    public class Gelado {
        @PrimaryKey
        private long gelId;
        private String gelName;
        private String gelPrice;
        private String gelImg;


        public Gelado(long gelId, String gelName, String gelPrice, String gelImg){
            this.gelId = gelId;
            this.gelName = gelName;
            this.gelPrice = gelPrice;
            this.gelImg = gelImg;
        }

        public long getGelId(){
            return gelId;
        }

        public String getGelName() { return gelName; }

        public String getGelPrice() {
            return gelPrice;
        }

        public String getGelImg() {
            return gelImg;
        }
    }
