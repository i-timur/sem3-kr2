package ru.kpfu.itis.ibragimov;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.kpfu.itis.ibragimov.view.View;

public class App extends Application {

  private Group root;

  private Scene scene;

  private BorderPane rootLayout;

  private View view;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    root = new Group();

    view = new View();

    rootLayout = new BorderPane();

    rootLayout.setCenter(view.getView());

    root.getChildren().add(rootLayout);

    scene = new Scene(root, 600, 600);

    primaryStage.setTitle("Bus");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
