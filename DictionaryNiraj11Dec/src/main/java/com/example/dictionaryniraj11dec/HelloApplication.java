package com.example.dictionaryniraj11dec;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



import java.io.IOException;

public class HelloApplication extends Application {

    Label meaningLable;
    Button searchButton;
    TextField wordTextField;
    ListView<String> suggestionList;

    DictionaryUSingMashMap dictionaryUsingHashMap = new DictionaryUSingMashMap();
    Pane createContent()
    {
        Pane root = new Pane();
        root.setPrefSize(400,600);

        wordTextField = new TextField();
        wordTextField.setTranslateX(20);
        wordTextField.setTranslateY(40);

        searchButton = new Button("Search");
        searchButton.setTranslateX(210);
        searchButton.setTranslateY(40);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                meaningLable.setText("Button is clicked");
//                wordTextField.getText();
                String word = wordTextField.getText();
                if(word.isBlank() || word.isEmpty())
                {
                    meaningLable.setText("Please enter word");
                    meaningLable.setTextFill(Color.RED);
                }
                else
                {
                    String meaning = dictionaryUsingHashMap.getMeaning(word);
                    meaningLable.setText(meaning);
                    meaningLable.setTextFill(Color.BLACK);
                }
            }
        });

        meaningLable = new Label("I am meaning");
        meaningLable.setTranslateX(20);
        meaningLable.setTranslateY(80);

        suggestionList = new ListView<>();
        suggestionList.setTranslateX(20);
        suggestionList.setTranslateY(120);
        suggestionList.setMinSize(350,40);
        suggestionList.setMaxSize(300,50);
        String[] wordList = {"Karan","Ramesh","Krishna"};
        suggestionList.getItems().addAll(wordList);
        suggestionList.setOrientation(Orientation.HORIZONTAL);

        suggestionList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String selectedWord = suggestionList.getSelectionModel().getSelectedItem();
                meaningLable.setText(selectedWord);
            }
        });

        root.getChildren().addAll(wordTextField,searchButton,meaningLable,suggestionList);

        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Dictionary!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}