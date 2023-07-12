package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Insert;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GeladoDao {
    @Query("SELECT * FROM Gelado")
    List<Gelado> getAll();

    @Query("SELECT * FROM Gelado WHERE gelId = :gelId")
    Gelado getById(long gelId);
}
