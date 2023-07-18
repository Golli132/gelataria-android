package pt.ipbeja.estig.twdm.pdm1.myapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Gelado.class, Waffle.class, Crepe.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract GeladoDao getGeladoDao();
    public abstract WaffleDao getWaffleDao();
    public abstract CrepeDao getCrepeDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "jollyDB").allowMainThreadQueries().addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            db.execSQL("INSERT INTO Gelado VALUES(1, 'Morango','1.50€', 'https://i0.wp.com/chocolateamais.com/wp-content/uploads/2018/07/gelado-morango-6.jpg?fit=800%2C533&ssl=1')");
                            db.execSQL("INSERT INTO Gelado VALUES(2, 'Baunilha','1.50€', 'https://www.foodfromportugal.com/content/uploads/2012/11/gelado-chocolate-01.jpg\"')");
                            db.execSQL("INSERT INTO Gelado VALUES(3, 'Chocolate','1.50€', 'https://www.foodfromportugal.com/content/uploads/2012/11/gelado-chocolate-01.jpg')");
                            db.execSQL("INSERT INTO Gelado VALUES(4, 'Caramelo','1.50€', 'https://www.cozinhatradicional.com/wp-content/uploads/2010/07/Molho-de-Caramelo-para-Gelados.jpg')");

                            db.execSQL("INSERT INTO Waffle VALUES(1, 'Xarope', '2.35€', 'https://cdn.shopify.com/s/files/1/0148/1945/9126/articles/Maple_Waffles_89a00241-086e-4724-918a-521f852e00ad_720x.jpg?v=1586286648')");
                            db.execSQL("INSERT INTO Waffle VALUES(2, 'Nutella', '2.35€', 'https://w7.pngwing.com/pngs/90/104/png-transparent-belgian-waffle-treacle-tart-danish-pastry-belgian-cuisine-chocolate-food-breakfast-frozen-dessert.png')");
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
