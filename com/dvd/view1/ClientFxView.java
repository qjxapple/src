package com.dvd.view1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ClientFxView extends Application {

	/*
	 * 初始化操作
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();	//使用BorderPane、 		、 		
		HBox hBox = addHBox();		//水平盒子
		borderPane.setTop(hBox);	//borderPane顶部
		borderPane.setCenter(addAnchorPane(addContentPane())); //BorderPane中部

		Scene scene = new Scene(borderPane);	//Scene
		primaryStage.setScene(scene);			//设置到
		primaryStage.setTitle("Layout Sample");
		primaryStage.show();
	}

	/*
	 * 退出button
	 */
	private Node addAnchorPane(Node grid) {
		AnchorPane anchorpane = new AnchorPane();

		Button btnExit = new Button("退出");

		HBox hb = new HBox();
		hb.setPadding(new Insets(0, 10, 10, 10));
		hb.setSpacing(10);
		hb.getChildren().addAll(btnExit);

		anchorpane.getChildren().addAll(grid, hb);
		// Anchor buttons to bottom right, anchor grid to top
		AnchorPane.setBottomAnchor(hb, 8.0);
		AnchorPane.setRightAnchor(hb, 5.0);
		AnchorPane.setTopAnchor(grid, 10.0);

		return anchorpane;
	}

	/*
	 * ImageView
	 */
	private Node addContentPane() {
		GridPane gridPane = new GridPane();
		ImageView image1 = new ImageView(new Image(ClientFxView.class.getResourceAsStream("/images/pic01.jpg")));
		image1.setFitWidth(600);
		image1.setPreserveRatio(true);
		gridPane.add(image1, 0, 0);
		return gridPane;
	}

	/*
	 * 顶部按钮
	 */
	private HBox addHBox() {
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(15, 12, 15, 12));
		hBox.setSpacing(10);
		hBox.setStyle("-fx-background-color:#336699");

		Button button1 = new Button("查询DVD信息");
		button1.setPrefSize(150, 20);

		Button button2 = new Button("查询租赁信息");
		button2.setPrefSize(150, 20);

		hBox.getChildren().addAll(button1, button2);

		return hBox;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
