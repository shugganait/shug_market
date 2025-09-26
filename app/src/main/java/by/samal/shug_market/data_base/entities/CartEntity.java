package by.samal.shug_market.data_base.entities;

import static by.samal.shug_market.base.Constants.CART_TABLE_DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = CART_TABLE_DB)
public class CartEntity {

    @PrimaryKey
    private int id;
    private String title;
    private double price;
    private String image;

    // Конструктор
    public CartEntity(int id, String title, double price, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.image = image;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

