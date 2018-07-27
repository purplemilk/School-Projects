import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {

	public static void main(String[] args){
		launch(args);
	}
	private static final String TITLE = StringResource.PRI_STAGE_TITLE + "Designed By:" + StringResource.AUTH
            + "    V" + StringResource.VERSION_MAX + "." + StringResource.VERSION_MID + "."
            + StringResource.VERSION_MIN;
@Override

	public void start(Stage primaryStage) throws Exception{

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(5, 5, 5, 5));

		Label label = new Label(StringResource.PASSWORD_MESSAGE);
        label.setFont(new Font(19));
        grid.add(label, 0, 1);
		TextField textField = new TextField(Password.genRandomNum(false, false, false, 8));
		textField.setFont(new Font(19));
		grid.add(textField, 1, 1);

		RadioButton rB1 = new RadioButton("8");
		rB1.setUserData("8");
		rB1.setSelected(true);
		RadioButton rB2 = new RadioButton("16");
		rB2.setUserData("16");
		RadioButton rB3 = new RadioButton("32");

		ToggleGroup radioGroup = new ToggleGroup();

		rB1.setToggleGroup(radioGroup);
		rB2.setToggleGroup(radioGroup);
		rB3.setToggleGroup(radioGroup);

		HBox h1 = new HBox();
        h1.setSpacing(20);
        h1.getChildren().add(rB1);
        h1.getChildren().add(rB2);
        h1.getChildren().add(rB3);
        grid.add(h1, 1, 2);

        grid.add(new Label(StringResource.COMPEXITY), 0, 3);
        CheckBox checkBox1 = new CheckBox("Use Caps");
        CheckBox checkBox2 = new CheckBox("Use Special Chars");
        CheckBox checkBox3 = new CheckBox("Use Numbers");

        HBox h2 = new HBox();
        h2.setSpacing(20);
        h2.getChildren().add(checkBox1);
        h2.getChildren().add(checkBox2);
        h2.getChildren().add(checkBox3);
        grid.add(h2, 1, 3);

		Button button = new Button();
        button.setText(StringResource.BTN_PASSWORD_REFRESH);
        
        button.setOnAction(ActionEvent ->{
        	String size = radioGroup.getSelectedToggle().getUserData().toString();
            // System.out.println(Integer.parseInt());
            boolean caps = checkBox1.isSelected();
            boolean special = checkBox2.isSelected();
            boolean numbers = checkBox3.isSelected();

            String newPassword = Password.genRandomNum(special, caps, numbers, Integer.parseInt(size));
            System.out.println(StringResource.PASSWORD_MESSAGE + newPassword);
            textField.setText(newPassword);
            } );

        grid.add(button, 2, 1);
        Scene scene = new Scene(grid, 725, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle(TITLE);
        primaryStage.show();

		}
	}