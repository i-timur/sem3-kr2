package ru.kpfu.itis.ibragimov.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpClientImpl implements HttpClient {
  @Override
  public String get(String url, Map<String, String> headers, Map<String, String> params) {
    String result = null;

    try {
//      url += "?";
      if (params != null) {
        for (String param : params.keySet()) {
          url += param + "=" + params.get(param) + "&";
        }
      }

      HttpURLConnection connection = createConnection(url);

      setHeaders(connection, headers);

      connection.setDoOutput(true);

      connection.setRequestMethod("GET");

      result = getResponse(connection);

      connection.disconnect();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public String post(String url, Map<String, String> headers, Map<String, String> params) {
    String result = null;

    try {
      HttpURLConnection connection = createConnection(url);

      connection.setRequestMethod("POST");

      setHeaders(connection, headers);

      connection.setDoOutput(true);

      String jsonInputString = paramsToJSON(params);
      try (OutputStream os = connection.getOutputStream()) {
        byte[] input = jsonInputString.getBytes();
        os.write(input, 0, input.length);
      }

      result = getResponse(connection);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  private HttpURLConnection createConnection(String url) throws IOException {
    return (HttpURLConnection)(new URL(url).openConnection());
  }

  private HttpURLConnection setHeaders(HttpURLConnection connection, Map<String, String> headers) {
    if (headers != null) {
      for (String header : headers.keySet()) {
        connection.setRequestProperty(header, headers.get(header));
      }
    }
    return connection;
  }

  private String paramsToJSON(Map<String, String> params) {
    String result = "";
    for (String param : params.keySet()) {
      result += "\"" + param + "\":" + "\"" + params.get(param) + "\"" + ",";
    }
    return "{" + result + "}";
  }

  private String getResponse(HttpURLConnection connection) throws IOException {
    try (BufferedReader reader = new BufferedReader(
      new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)
    )
    ) {
      StringBuilder content = new StringBuilder();
      String input;
      while ((input = reader.readLine()) != null) {
        content.append(input);
      }
      return content.toString();
    }
  }
}
