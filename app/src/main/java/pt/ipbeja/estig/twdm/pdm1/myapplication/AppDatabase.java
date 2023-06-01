package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {GeladoItems.class, Waffle.class, Crepe.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract GeladoDao getGeladoDao();
    public abstract WaffleDao getWaffleDao();
    public abstract CrepeDao getCrepeDao();

    private static AppDatabase INSTANCE;
}
