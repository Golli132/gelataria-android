package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ToppingsDao {
    @Query("SELECT * FROM Toppings")
    List<Toppings> getAll();

    @Query("SELECT * FROM toppings WHERE topId = :topId")
    Toppings getById(long topId);
}
