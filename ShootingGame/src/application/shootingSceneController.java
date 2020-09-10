package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class shootingSceneController implements Initializable{

	@FXML ImageView villian;
	@FXML ImageView bluevillian;
	@FXML ImageView yellowvillian;
	@FXML ImageView aim;
	@FXML AnchorPane pane;
	@FXML Label point;
	
	double villianX, villianY;
	double bluevillianX, bluevillianY;
	double yellowvillianX, yellowvillianY;
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
					
					point.setText(Integer.toString(Integer.parseInt(point.getText())+100));
				}
			}
			if (pressX >= bluevillian.getLayoutX() && pressX <= bluevillian.getLayoutX() + bluevillian.getFitWidth()) {
				if (pressY >= bluevillian.getLayoutY() && pressY <= bluevillian.getLayoutY() + bluevillian.getFitHeight()) {
					
					point.setText(Integer.toString(Integer.parseInt(point.getText())+200));
				}
			}
			if (pressX >= yellowvillian.getLayoutX() && pressX <= yellowvillian.getLayoutX() + yellowvillian.getFitWidth()) {
				if (pressY >= yellowvillian.getLayoutY() && pressY <= yellowvillian.getLayoutY() + yellowvillian.getFitHeight()) {
					
					point.setText(Integer.toString(Integer.parseInt(point.getText())+300));
				}
			}
		});
		
		Thread thread = new Thread( () -> {
			while(true) {
				villianX = Math.random()*750;
				villianY = Math.random()*500;
				bluevillianX = Math.random()*750;
				bluevillianY = Math.random()*500;
				yellowvillianX = Math.random()*750;
				yellowvillianY = Math.random()*500;
				try {
					Thread.sleep(400);
					Platform.runLater(()-> {
						villian.setLayoutX(villianX);
						villian.setLayoutY(villianY);
						bluevillian.setLayoutX(bluevillianX);
						bluevillian.setLayoutY(bluevillianY);
						yellowvillian.setLayoutX(yellowvillianX);
						yellowvillian.setLayoutY(yellowvillianY);
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
