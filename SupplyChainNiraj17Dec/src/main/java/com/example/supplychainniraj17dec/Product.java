package com.example.supplychainniraj17dec;

import javafx.beans.Observable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.ResultSet;

public class Product {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleDoubleProperty prize;

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public double getPrize() {
        return prize.get();
    }

    public SimpleDoubleProperty prizeProperty() {
        return prize;
    }

    public  Product(int id , String name , double prize){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.prize = new SimpleDoubleProperty(prize);
    }

    public static ObservableList<Product> getAllProducts(){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        ObservableList<Product> productList = FXCollections.observableArrayList();
        String selectProducts = "SELECT * FROM product";
        try{
            ResultSet rs = databaseConnection.getQueryTable(selectProducts);
            while (rs.next()){
                productList.add(new Product(rs.getInt("product_id"),
                        rs.getString("name"),rs.getDouble("prize")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }

    public static ObservableList<Product> getProductByName(String productName){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        ObservableList<Product> productList = FXCollections.observableArrayList();
        String selectProducts = String.format(" SELECT * FROM product WHERE lower(name) like '%%%s%%' " ,
                productName.toLowerCase());
        try{
            ResultSet rs = databaseConnection.getQueryTable(selectProducts);
            while (rs.next()){
                productList.add(
                        new Product(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("prize")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }


}
