package ru.kpfu.itis.ibragimov.models;

public class Data {
  public String GaragNumb;
  public String Azimuth;
  public String Graph;
  public String Latitude;
  public String Longitude;
  public String Marsh;
  public String Smena;
  public String Speed;
  public String TimeNav;

  public Data(String garagNumb, String azimuth, String graph, String latitude, String longitude, String marsh, String smena, String speed, String timeNav) {
    this.GaragNumb = garagNumb;
    this.Azimuth = azimuth;
    this.Graph = graph;
    this.Latitude = latitude;
    this.Longitude = longitude;
    this.Marsh = marsh;
    this.Smena = smena;
    this.Speed = speed;
    this.TimeNav = timeNav;
  }

  public String getGaragNumb() {
    return GaragNumb;
  }

  public void setGaragNumb(String garagNumb) {
    this.GaragNumb = garagNumb;
  }

  public String getAzimuth() {
    return Azimuth;
  }

  public void setAzimuth(String azimuth) {
    this.Azimuth = azimuth;
  }

  public String getGraph() {
    return Graph;
  }

  public void setGraph(String graph) {
    this.Graph = graph;
  }

  public String getLatitude() {
    return Latitude;
  }

  public void setLatitude(String latitude) {
    this.Latitude = latitude;
  }

  public String getLongitude() {
    return Longitude;
  }

  public void setLongitude(String longitude) {
    this.Longitude = longitude;
  }

  public String getMarsh() {
    return Marsh;
  }

  public void setMarsh(String marsh) {
    this.Marsh = marsh;
  }

  public String getSmena() {
    return Smena;
  }

  public void setSmena(String smena) {
    this.Smena = smena;
  }

  public String getSpeed() {
    return Speed;
  }

  public void setSpeed(String speed) {
    this.Speed = speed;
  }

  public String getTimeNav() {
    return TimeNav;
  }

  public void setTimeNav(String timeNav) {
    this.TimeNav = timeNav;
  }
}
