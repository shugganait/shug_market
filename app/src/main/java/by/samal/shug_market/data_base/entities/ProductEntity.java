package by.samal.shug_market.data_base.entities;

import static by.samal.shug_market.base.Constants.PRODUCTS_TABLE_DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = PRODUCTS_TABLE_DB)
public class ProductEntity {

    private String category;
    private String description;

    @PrimaryKey
    private int id;
    private List<String> image;
    private double price;
    private String title;

    // Конструктор
    public ProductEntity(String category, String description, int id, List<String> image, double price, String title) {
        this.category = category;
        this.description = description;
        this.id = id;
        this.image = image;
        this.price = price;
        this.title = title;
    }

    // Геттеры и сеттеры
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

