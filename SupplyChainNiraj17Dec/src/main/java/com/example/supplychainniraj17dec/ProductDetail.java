package com.example.supplychainniraj17dec;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ProductDetail {
    public TableView<Product> productTable;

    public Pane getAllProducts(){
        TableColumn id = new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn prize = new TableColumn("Prize");
        prize.setCellValueFactory(new PropertyValueFactory<>("prize"));

        /*ObservableList<Product> data = FXCollections.observableArrayList();
        data.add(new Product(1,"Lenovo",8439));
        data.add(new Product(2,"HP",8590));*/
        ObservableList<Product> products = Product.getAllProducts();

        productTable = new TableView<>();
        productTable.setItems(products);
        productTable.getColumns().addAll(id,name,prize);
        productTable.setMinSize(SupplyChain.width,SupplyChain.height);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        Pane tablePane = new Pane();
        //tablePane.setStyle("-fx-background-color: #C0C0C0");
        tablePane.setMinSize(SupplyChain.width,SupplyChain.height);
        tablePane.getChildren().add(productTable);
        return tablePane;
    }

    public Pane getProductsByName(String productname){
        TableColumn id = new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name = new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn prize = new TableColumn("Prize");
        prize.setCellValueFactory(new PropertyValueFactory<>("prize"));

        /*ObservableList<Product> data = FXCollections.observableArrayList();
        data.add(new Product(1,"Lenovo",8439));
        data.add(new Product(2,"HP",8590));*/

        ObservableList<Product> products = Product.getProductByName(productname);

        productTable = new TableView<>();
        productTable.setItems(products);
        productTable.getColumns().addAll(id,name,prize);
        productTable.setMinSize(SupplyChain.width,SupplyChain.height);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        Pane tablePane = new Pane();
        //tablePane.setStyle("-fx-background-color: #C0C0C0");
        tablePane.setMinSize(SupplyChain.width,SupplyChain.height);
        tablePane.getChildren().add(productTable);
        return tablePane;
    }

    public Product getSelectedProduct(){
        try {
            Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
            return selectedProduct;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
