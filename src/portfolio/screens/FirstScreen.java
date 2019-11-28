package portfolio.screens;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FirstScreen extends Application{  
	Scene scene1, scene2;
	StackPane layout1,layout2;
	Label label1,label2;
	Button btn1,btn2;
	HBox hBox ;
@Override
  public void start(Stage primaryStage) throws Exception {
    /**
     * 
     * App components (Buttons Layouts,Scenes,Labels...)
     * 
     */
	
	btn1 = new Button("Start");
    btn2 = new Button("Search");
    label1 = new Label("Welcome Page");
    label2 = new Label("Search Loans");
    layout1 = new StackPane();
    layout2 = new StackPane();
    scene1 = new Scene(layout1, 1200, 600);
    scene2 = new Scene(layout2, 1200, 600);
    TextField textField = new TextField();
    hBox = new HBox(textField,btn2);//Add btn2 and textField to hBox
    
    
    /*****************************************************************************************/
    
    /**
     * 
     * Styling the layouts and whatnots
     * 
     */
    
    scene1.getStylesheets().addAll(this.getClass().getResource("/background.css").toExternalForm());
    scene2.getStylesheets().addAll(this.getClass().getResource("/background.css").toExternalForm());
    StackPane.setAlignment(label1, Pos.TOP_CENTER);
    StackPane.setAlignment(label2, Pos.TOP_CENTER);
    StackPane.setAlignment(btn1, Pos.CENTER);
    StackPane.setAlignment(btn2, Pos.CENTER);
    hBox.setAlignment(Pos.TOP_CENTER);
    StackPane.setMargin(hBox, new Insets(50, 50, 50, 50));
    label1.setFont(Font.font ("Verdana",FontWeight.BOLD, 30));
    label2.setFont(Font.font ("Verdana",FontWeight.BOLD, 30));
    label1.setTextFill(Color.WHITE);
    label2.setTextFill(Color.WHITE);
    layout1.setId("bodybg");
    layout2.setId("bodybg");
    textField.setPromptText("Search Loans");
    
    
    /*****************************************************************************************/
    
    /**
     * 
     * Setting Actions on elements
     * 
     */
    
    btn1.setOnAction((e) -> primaryStage.setScene(scene2)); 
    //TO DO : method to search Loans
    //btn2.setOnAction((e) -> SearchLoans()); 
    
    
    /***************************************************************************************/
    
    /**
     * 
     * Adding Children Nodes to Parents
     * 
     */
    
    layout1.getChildren().addAll(label1,btn1);
    layout2.getChildren().addAll(label2,hBox);
    
    
    /***************************************************************************************/
    
    primaryStage.setTitle("Green Portfolio");
    primaryStage.setScene(scene1);
    primaryStage.show();
    
  }  
	
	public static void main(String[] args) {
		launch(args);
  }
	
}

