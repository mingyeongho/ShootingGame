package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController implements Initializable{

	@FXML Button enterButton;
	@FXML Button exitButton;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		enterButton.setOnAction(event-> {
			try {
				Parent shooting = FXMLLoader.load(getClass().getResource("shootingScene.fxml"));
				
				Scene scene = new Scene(shooting);
				
				
				Stage shootingStage = (Stage) enterButton.getScene().getWindow();
				shootingStage.setScene(scene);
				
			} catch(Exception e) {
				System.out.println("submitButton Exception");
			}
		});
		
		exitButton.setOnAction(event-> {
			Platform.exit();
		});
		
	}
}
