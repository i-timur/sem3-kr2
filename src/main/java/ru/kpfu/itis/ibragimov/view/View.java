package ru.kpfu.itis.ibragimov.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import ru.kpfu.itis.ibragimov.App;
import ru.kpfu.itis.ibragimov.client.HttpClient;
import ru.kpfu.itis.ibragimov.client.HttpClientImpl;
import ru.kpfu.itis.ibragimov.models.TimeBuses;

public class View {

  private final static String URL = "http://data.kzn.ru:8082/api/v0/dynamic_datasets/bus.json";

  private final HttpClient client = new HttpClientImpl();

  private TextField input;

  private TextArea info;

  private Button getInfo;

  private VBox vBox;

  private AnchorPane pane;

  private final EventHandler getInfoEvent = new EventHandler() {
    @Override
    public void handle(Event event) {
      if (event.getSource() == getInfo) {
        input.setText("");
        String busResponse = client.get(URL, null, null);

        if (busResponse != null) {

          GsonBuilder builder = new GsonBuilder();
          Gson gson = builder.create();
          TimeBuses[] parsedBusResponse = gson.fromJson(busResponse, TimeBuses[].class);

          for (TimeBuses timeBuses : parsedBusResponse) {
            if (input.getText().equals(timeBuses.getData().getMarsh())) {
              appendMessageToInfo("Garag number: " + timeBuses.getData().GaragNumb +
                ", latitude: " + timeBuses.getData().getLatitude() + ", longitude: "
                + timeBuses.getData().getLongitude() + "\n");
            }
          }
        }
      }
    }
  };

  private void createView() {
    pane = new AnchorPane();

    vBox = new VBox(2);

    input = new TextField();
    getInfo = new Button("Get info");

    info = new TextArea();
    info.setEditable(false);
    info.setWrapText(true);

    vBox.getChildren().addAll(input, getInfo, info);

    AnchorPane.setTopAnchor(vBox, 10.0);
    AnchorPane.setLeftAnchor(vBox, 10.0);
    AnchorPane.setRightAnchor(vBox, 10.0);

    pane.getChildren().addAll(vBox);

    getInfo.setOnAction(getInfoEvent);
  }

  public Parent getView() {
    if (pane == null) {
      this.createView();
    }

    return pane;
  }

  public void appendMessageToInfo(String text) {
    if (text != null) {
      info.appendText(text);
    }
  }
}
