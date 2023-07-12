package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CrepeDao {
    @Query("SELECT * FROM crepe")
    List<Crepe> getAll();

    @Query("SELECT * FROM crepe WHERE crepeId = :crepeId")
    Crepe getById(long crepeId);
}
