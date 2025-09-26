package by.samal.shug_market.data_base;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import by.samal.shug_market.base.Converter;
import by.samal.shug_market.data_base.entities.CartEntity;
import by.samal.shug_market.data_base.entities.ProductEntity;

@Database(entities = {ProductEntity.class, CartEntity.class}, version = 1, exportSchema = false)
@TypeConverters(Converter.class)
public abstract class DataBase extends RoomDatabase {
    public abstract DAO dbDao();
}