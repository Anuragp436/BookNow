package com.example.booknow;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;



@Entity(tableName = "users")
public class MainData{



    @ColumnInfo(name = "date_time")
    public String DateTime;

    @ColumnInfo(name = "product_name")
    public String ProductNAME;

    @ColumnInfo(name = "price")
    public int Price;

    @ColumnInfo(name = "unit")
    public String Unit;

    @ColumnInfo(name = "quantity")
    public int Quantity;

    @ColumnInfo(name="purchase")
    public int purchase;

    @ColumnInfo(name="sell")
    public int sell;

    @PrimaryKey(autoGenerate = true)
    public int uid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getProductNAME() {
        return ProductNAME;
    }

    public void setProductNAME(String productNAME) {
        ProductNAME = productNAME;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getPurchase() {
        return purchase;
    }

    public void setPurchase(int purchase) {
        this.purchase = purchase;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }
}
