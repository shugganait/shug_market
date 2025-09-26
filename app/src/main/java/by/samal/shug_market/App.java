package by.samal.shug_market;

import static by.samal.shug_market.base.Constants.ROOM_NAME_DB;

import android.app.Application;

import androidx.room.Room;

import by.samal.shug_market.data_base.DataBase;

public class App extends Application {

    private static App instance;
    private DataBase database;

    public static App getInstance() {
        return instance;
    }

    public DataBase getDatabase() {
        return database;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

//         Инициализация базы данных
        database = Room.databaseBuilder(
                getApplicationContext(),
                DataBase.class,
                ROOM_NAME_DB
        ).build();
    }
}