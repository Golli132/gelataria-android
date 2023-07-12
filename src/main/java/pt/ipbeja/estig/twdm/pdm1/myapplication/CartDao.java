package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CartDao {
    @Query("SELECT * FROM CartItem")
    List<CartItem> getAll();
}
