package org.example;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;


public class Main {

    private static final String API_KEY = "Wd8C9hK5fPz1jvGC4jPDa0Ibc0F0wRVu";
    private static final String API_URL = "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=" + API_KEY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter category you want : ");
        String query = scanner.nextLine();
        scanner.close();

        try {
            URL url = new URL(API_URL + "&q=" + query);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            NYTimesSearchResponse response = new Gson().fromJson(reader, NYTimesSearchResponse.class);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }




    }




}