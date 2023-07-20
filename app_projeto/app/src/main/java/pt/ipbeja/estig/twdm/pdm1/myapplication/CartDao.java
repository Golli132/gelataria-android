package pt.ipbeja.estig.twdm.pdm1.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CartDao {
    @Query("SELECT * FROM CartItem WHERE amount > 0")
    List<CartItem> getAll();

    @Insert
    void insert(CartItem cartItem);

    @Query("SELECT SUM(price * amount) FROM CartItem")
    double getTotalPrice();

    @Delete
    void delete(CartItem cartItem);

    @Query("UPDATE CartItem SET amount = :amount WHERE itemId = :itemId")
    void updateAmount(int amount, int itemId);
}
