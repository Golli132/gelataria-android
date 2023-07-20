package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WaffleDao {
    @Query("SELECT * FROM waffle")
    List<Waffle> getAll();

    @Query("SELECT * FROM waffle WHERE waffleId = :waffleId")
    Waffle getById(long waffleId);
}
