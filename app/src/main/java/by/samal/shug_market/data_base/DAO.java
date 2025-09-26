package by.samal.shug_market.data_base;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import by.samal.shug_market.base.Constants;
import by.samal.shug_market.data_base.entities.CartEntity;
import by.samal.shug_market.data_base.entities.ProductEntity;

@Dao
public interface DAO {

    // PRODUCTS
    @Query("SELECT * FROM " + Constants.PRODUCTS_TABLE_DB)
    List<ProductEntity> getAllProducts();

    @Query("SELECT * FROM " + Constants.PRODUCTS_TABLE_DB + " WHERE category = :category")
    List<ProductEntity> getProductsByCategory(String category);

    @Query("SELECT * FROM " + Constants.PRODUCTS_TABLE_DB + " WHERE id = :id")
    ProductEntity getProductById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduct(ProductEntity productEntity);

//    @Query("DELETE FROM " + Constants.PRODUCTS_TABLE_DB)
//    void deleteAllProducts();

    // CART
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCart(CartEntity cartEntity);

    @Query("SELECT * FROM " + Constants.CART_TABLE_DB)
    List<CartEntity> getAllCart();

    @Query("DELETE FROM " + Constants.CART_TABLE_DB)
    void deleteAllCart();

    @Query("DELETE FROM " + Constants.CART_TABLE_DB + " WHERE id = :id")
    void deleteCartById(int id);
}

