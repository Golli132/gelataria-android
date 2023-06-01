package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface GeladoDao {
    @Query("SELECT * FROM GeladoItems")
    List<GeladoItems> getAll();

    @Query("SELECT * FROM GeladoItems WHERE gelId = :gelId")
    GeladoItems getById(long gelId);
}
