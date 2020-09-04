package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class shootingSceneController implements Initializable{

	@FXML AnchorPane shootingPane;
	@FXML Button exitButton;
	@FXML Button createButton;
	@FXML ImageView aimImage;
	@FXML ImageView villianImage0;
	@FXML ImageView villianImage1;
	@FXML ImageView villianImage2;
	@FXML ImageView villianImage3;
	@FXML ImageView villianImage4;
	@FXML TextField targetCount;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		exitButton.setOnAction(event-> {
			Platform.exit();
		});
		
		targetCount.setOnAction(event-> {
			
			for (int i = 0; i < 5; i++ ) {
				
			}
			
			int count = 0;
			count = Integer.parseInt(targetCount.getText());
			
			int[] random = new int[count];
			for (int i = 0; i < random.length; i++) {
				random[i] = (int) Math.random()*5;
				
			}
		});
		
		createButton.setOnAction(event-> {
			
		});
		
		shootingPane.setOnMouseMoved(event-> {
			aimImage.setLayoutX(event.getSceneX()-(aimImage.getFitWidth()/2)+28);
			aimImage.setLayoutY(event.getSceneY()-(aimImage.getFitHeight()/2));
		});
		
		villianImage0.setOnMouseClicked(event-> {
			villianImage0.setVisible(false);
		});
		villianImage1.setOnMouseClicked(event-> {
			villianImage1.setVisible(false);
		});
		villianImage2.setOnMouseClicked(event-> {
			villianImage2.setVisible(false);
		});
		villianImage3.setOnMouseClicked(event-> {
			villianImage3.setVisible(false);
		});
		villianImage4.setOnMouseClicked(event-> {
			villianImage4.setVisible(false);
		});
	}
}
