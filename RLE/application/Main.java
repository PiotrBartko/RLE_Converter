package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) 
	{
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,250);
			root.getStyleClass().add("root");
			
			
			TextField  text1 = new TextField();
			
			primaryStage.setTitle("Kompresowanie RLE");
			text1.setLayoutY(0);
			text1.setLayoutX(-40);
			text1.setPrefSize(220, 10);
			text1.getStyleClass().add("textfields");
			
			Label label1 = new Label("Zród³o: ");
			label1.setLayoutY(-20);
			label1.setLayoutX(-40);
			label1.getStyleClass().add("labels");
			
			
			Label label2 = new Label("Wynik Operacji:");
			label2.setLayoutX(-40);
			label2.setLayoutY(80);
			label2.getStyleClass().add("labels");
			
			Label label3 = new Label("Operacje:");
			label3.getStyleClass().add("labels");
			
		
			

			
			TextField  text2 = new TextField();
			text2.setLayoutY(100);
			text2.setLayoutX(-40);
			text2.setPrefSize(220, 10);
			text2.getStyleClass().add("textfields");
			
			Button button1 = new Button("Kopiuj");
			button1.setLayoutY(30);
			button1.setLayoutX(100);
			button1.setPrefSize(80, 10);
			button1.getStyleClass().add("button1");
			
			
			Button button2 = new Button("Wykonaj");
			button2.setLayoutY(130);
			button2.setLayoutX(-40);
			button2.setPrefSize(80,10);
			button2.getStyleClass().add("button1");
			
			Button button3 = new Button("Wyczyœæ");
			button3.setLayoutY(130);
			button3.setLayoutX(100);
			button3.setPrefSize(80,10);
			button3.getStyleClass().add("button1");
			
			
			
			
			Group centerGroup = new Group();
			centerGroup.getStyleClass().add("root");
			
			centerGroup.getChildren().add(label1);
			centerGroup.getChildren().add(text1);
			centerGroup.getChildren().add(button1);
			centerGroup.getChildren().add(label2);
			centerGroup.getChildren().add(text2);	
			centerGroup.getChildren().add(button2);
			
			
	
			RadioButton radiobutton1 = new RadioButton("kodowanie");
			radiobutton1.setUserData("wybrano kodowanie");
			radiobutton1.setSelected(true);
			radiobutton1.getStyleClass().add("radiobutttons");
			
			
			RadioButton radiobutton2 = new RadioButton("dekodowanie");
			radiobutton2.setUserData("wybrano dekodowanie");
			radiobutton2.getStyleClass().add("radiobutttons");
			
			ToggleGroup toggle = new ToggleGroup();
			
			radiobutton1.setToggleGroup(toggle);
			radiobutton2.setToggleGroup(toggle);
			
			VBox button_vbox = new VBox(10);
			button_vbox.getChildren().addAll(label3,radiobutton1,radiobutton2,button3);
			button_vbox.setSpacing(15);
			button_vbox.getStyleClass().add("vbox");
			
			button2.setOnAction(event ->
			{
				if(radiobutton1.isSelected() == true) 
				{
					text2.setText(Obliczenia.kodowanie(text1.getText()));
					
				}
				else if(radiobutton2.isSelected()== true) 
				{
					
					text2.setText(Obliczenia.dekodowanie(text1.getText()));
				}
				});
			
			
			button1.setOnAction(event->
			{
			
				text1.setText(text2.getText());
				text2.setText(null);
				});
			
			
			button3.setOnAction(event->
			{
				text1.setText("");
				text2.setText("");
				
			}
					
					
					);
			root.setRight(button_vbox);
	
			
			
			root.setCenter(centerGroup);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
