package portfolio.screens;

import javafx.application.Application;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.collections.transformation.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import portfolio.dao.GreenLabelsDAO;
import portfolio.pojo.GreenLabel;

public class GreenLabelScreen extends Application{
	private String[] propertyName = {"id","name", "description"};
	private String[] propertyLabel = {"ID","Name", "Description"};
	private GreenLabelsDAO greenLabel = new GreenLabelsDAO();
	private final GridPane gridPane = new GridPane();
	private final Label lblName = new Label("Search by Name");
	private final TextField searchField = new TextField();
	private FilteredList<GreenLabel> filteredData;
	private final ListView<GreenLabel> listView = new ListView<GreenLabel>() ;
	TableView<GreenLabel> contactTableView = new TableView<>();
	
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
	
//	btn1 = new Button("Start");
//    btn2 = new Button("Search");
//    label1 = new Label("Welcome Page");
//    label2 = new Label("Search Loans");
//    layout1 = new StackPane();
//    layout2 = new StackPane();
//    scene1 = new Scene(layout1, 1200, 600);
//    scene2 = new Scene(layout2, 1200, 600);
//    TextField textField = new TextField();
//    hBox = new HBox(textField,btn2);//Add btn2 and textField to hBox
//    
//    
//    /*****************************************************************************************/
//    
//    /**
//     * 
//     * Styling the layouts and whatnots
//     * 
//     */
//    
//    scene1.getStylesheets().addAll(this.getClass().getResource("/background.css").toExternalForm());
//    scene2.getStylesheets().addAll(this.getClass().getResource("/background.css").toExternalForm());
//    StackPane.setAlignment(label1, Pos.TOP_CENTER);
//    StackPane.setAlignment(label2, Pos.TOP_CENTER);
//    StackPane.setAlignment(btn1, Pos.CENTER);
//    StackPane.setAlignment(btn2, Pos.CENTER);
//    hBox.setAlignment(Pos.TOP_CENTER);
//    StackPane.setMargin(hBox, new Insets(50, 50, 50, 50));
//    label1.setFont(Font.font ("Verdana",FontWeight.BOLD, 30));
//    label2.setFont(Font.font ("Verdana",FontWeight.BOLD, 30));
//    label1.setTextFill(Color.WHITE);
//    label2.setTextFill(Color.WHITE);
//    layout1.setId("bodybg");
//    layout2.setId("bodybg");
//    textField.setPromptText("Search Loans");
//    
//    
//    /*****************************************************************************************/
//    
//    /**
//     * 
//     * Setting Actions on elements
//     * 
//     */
//    
//    btn1.setOnAction((e) -> primaryStage.setScene(scene2)); 
//    //TO DO : method to search Loans
//    //btn2.setOnAction((e) -> SearchLoans()); 
//    
//    
//    /***************************************************************************************/
//    
//    /**
//     * 
//     * Adding Children Nodes to Parents
//     * 
//     */
//    
//    layout1.getChildren().addAll(label1,btn1);
//    layout2.getChildren().addAll(label2,hBox);
//    
//    
//    /***************************************************************************************/
//    
//    primaryStage.setTitle("Green Portfolio");
//    primaryStage.setScene(scene1);
//    primaryStage.show();
	 primaryStage.setTitle("Green Loan");
     primaryStage.setMaximized(true);
     BorderPane borderPane = new BorderPane();
     Scene scene = new Scene(borderPane,650,400,true);
     gridPane.setPadding(new Insets(10));
     gridPane.setHgap(5);
     gridPane.setVgap(5);
     gridPane.add(lblName, 0, 0);
     gridPane.add(searchField, 0, 1);
     // Search TextField event handling
     searchField.textProperty().addListener
     ((observable, oldValue, newValue) ->filteredData.setPredicate(str -> {
              if (newValue == null || newValue.isEmpty())
                 return true;
              if (str.getName().toLowerCase().contains(newValue.toLowerCase()))
                 return true;
              return false;
     }));
     listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
     listView.setPrefHeight(Integer.MAX_VALUE);
     // Sets a new cell factory to use in the ListView.
     // This throws away all old list cells and new ListCells
     // created with the new cell factory.
     listView.setCellFactory(listView-> {
        Tooltip tooltip = new Tooltip();
        ListCell<GreenLabel> cell = new ListCell<GreenLabel>() {
           public void updateItem(GreenLabel greenLabel,Boolean empty) {
              super.updateItem(greenLabel, empty);
              if (greenLabel != null) {
                 setText(greenLabel.getName());
                 tooltip.setText(greenLabel.getDescription());
                 setTooltip(tooltip);
              } else
                 setText(null);
           }
        };
        return cell;
     });
     gridPane.add(listView, 0, 2);
     // Create and initializing TableView
     ObservableList<GreenLabel> contactPeopleList = FXCollections.observableArrayList();
     contactTableView.setItems(contactPeopleList);
     contactTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
     for (int i = 0; i < propertyLabel.length; i++) {
        TableColumn<GreenLabel, Object> col = new TableColumn<>(propertyLabel[i]);
        col.setCellValueFactory(new PropertyValueFactory<>(propertyName[i]));
        contactTableView.getColumns().add(col);
     }
     borderPane.setCenter(contactTableView);
     borderPane.setLeft(gridPane);
     // TableView will populate from the contactPeopleList
     // contactPeopleList will have value according to the
     // item selected in the ListView
     listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<GreenLabel>() {
	@Override
	public void changed(ObservableValue<? extends GreenLabel> observable, GreenLabel oldValue, GreenLabel newValue) {
			if (observable != null &&observable.getValue() != null) {
                 contactPeopleList.clear();
                 contactPeopleList.addAll(greenLabel.getLabelByName(newValue.getName()));
                 }
		}
});
     primaryStage.setScene(scene);
     primaryStage.show();
    
    
    
    
    
  }  
	
	public static void main(String[] args) {
		launch(args);
  }
	
}

