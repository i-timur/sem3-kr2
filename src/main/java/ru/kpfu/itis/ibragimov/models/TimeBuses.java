package ru.kpfu.itis.ibragimov.models;

public class TimeBuses {
  public String updated_at;
  public Data data;

  public TimeBuses(String updated_at, Data data) {
    this.updated_at = updated_at;
    this.data = data;
  }

  public String getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(String updated_at) {
    this.updated_at = updated_at;
  }

  public Data getData() {
    return data;
  }

  public void setData(Data data) {
    this.data = data;
  }
}
