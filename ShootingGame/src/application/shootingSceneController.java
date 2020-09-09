package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class shootingSceneController implements Initializable{

	@FXML ImageView villian;
	@FXML ImageView aim;
	@FXML AnchorPane pane;
	
	double villianX, villianY;
	double pressX, pressY;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		pane.setOnMouseMoved(event-> {
			aim.setLayoutX(event.getSceneX()-36);
			aim.setLayoutY(event.getSceneY()-36);
		});
		
		pane.setOnMousePressed(event-> {
			pressX = event.getSceneX();
			pressY = event.getSceneY();
			if (pressX >= villian.getLayoutX() && pressX <= villian.getLayoutX() + villian.getFitWidth()) {
				if (pressY >= villian.getLayoutY() && pressY <= villian.getLayoutY() + villian.getFitHeight()) {
					villian.setVisible(false);
					
				}
			}
		});
		
		Thread thread = new Thread( () -> {
			while(true) {
				villianX = Math.random()*750;
				villianY = Math.random()*500;
				try {
					Thread.sleep(300);
					Platform.runLater(()-> {
						villian.setLayoutX(villianX);
						villian.setLayoutY(villianY);
					});
				} catch(Exception e) {
					System.out.println("villian Error");
				}
			}
		});
		thread.setDaemon(true);
		thread.start();
		
	}
}
