package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import com.google.gson.Gson;
import java.util.Scanner;


public class Main {




    public static void main(String[] args) {
           String API_URL = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=Wd8C9hK5fPz1jvGC4jPDa0Ibc0F0wRVu";
        System.out.println("Hello world!");

        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            StringBuilder json = new StringBuilder();
            while ((output = br.readLine()) != null) {
                json.append(output);
            }
            conn.disconnect();
            Gson gson = new Gson();

            newYorkArticle m = gson.fromJson(json.toString(), newYorkArticle.class);
            System.out.println("Cca2: " + m.getStatus());
            System.out.println("Copyright: " + m.getCopyright());

            response response = gson.fromJson(json.toString(), response.class);

            docs docs = gson.fromJson(json.toString(), docs.class);
            System.out.println("web_url: " + docs.getWeb_url());
            System.out.println("snippet: " + docs.getSnippet());
            System.out.println("lead_paragraph: " + docs.getLead_paragraph());


        } catch (ProtocolException ex) {
            throw new RuntimeException(ex);
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }





    }




}