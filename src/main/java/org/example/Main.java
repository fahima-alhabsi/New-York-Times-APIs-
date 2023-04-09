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
import java.sql.*;

public class Main {




    public static void main(String[] args) {
           String API_URL = "https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=Wd8C9hK5fPz1jvGC4jPDa0Ibc0F0wRVu";
        System.out.println("Hello ");
        String urll = "jdbc:sqlserver://localhost:1433;" +
                "databaseName=newyork articles;" +
                "encrypt=true;" +
                "trustServerCertificate=true";
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the user to access the database");
        String user = scanner.nextLine()  ;
        System.out.println("enter the user the password");
        String pass = scanner.nextLine()  ;
        //newsMain newsMain = new newsMain();
        Connection con = null;




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
            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(urll, user, pass);
            Statement stt = con.createStatement();
            System.out.println("enter the category name");
            String sql1 = "Select * from Articles where category = '"+scanner.nextLine()+"'";
            Statement sttt = con.createStatement();
            ResultSet resultSet = sttt.executeQuery(sql1);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("ArticleTitle"));
                System.out.println(resultSet.getString("author"));
                System.out.println(resultSet.getString("PublicationDate"));
                System.out.println(resultSet.getString("category"));
                System.out.println(resultSet.getString("content"));
            }

            for (docs d: m.response.getDocs()) {
                String sql = "insert into articles values('" + d.getHeadline().getMain()
                        + "','" + d.getSource() + "','" + "1994/02/02" + "','"+d.getDocument_type()+"','"+d.getLead_paragraph()+"')";
                stt.execute(sql);
                int i =1;
                System.out.println(d);
                int y =1;
                for (multimedia  multimedia : d.getMultimedia()) {
                    System.out.println("subtype: " + multimedia.getSubtype());
                    System.out.println("caption: " + multimedia.getSubtype());
                    System.out.println("credit: " + multimedia.getCredit());
                    System.out.println("type: " + multimedia.getType());
                    System.out.println("url: " + multimedia.getUrl());
                    System.out.println("subType: " + multimedia.getSubType());
                    System.out.println("crop_name: " + multimedia.getCrop_name());
                    System.out.println("rank: " + multimedia.getRank());
                    System.out.println("height: " + multimedia.getHeight());
                    System.out.println("width: " + multimedia.getWidth());
                    i++;

                    for (keywords  keyword : d.getKeywords()) {
                        int z=1;
                        System.out.println("name: " + keyword.getName());
                        System.out.println("value: " + keyword.getValue());
                        System.out.println("major: " + keyword.getMajor());
                        System.out.println("rank: " + keyword.getRank());
                        System.out.println("value: " + keyword.getValue());




                    }


                }
            }



            docs docs = gson.fromJson(json.toString(), docs.class);
            System.out.println("web_url: " + docs.getWeb_url());
            System.out.println("snippet: " + docs.getSnippet());
            System.out.println("lead_paragraph: " + docs.getLead_paragraph());
            System.out.println("source: " + docs.getSource());
            System.out.println("pub_date: " + docs.getPub_date());
            System.out.println("document_type: " + docs.getDocument_type());
            System.out.println("news_desk: " + docs.getNews_desk());
            System.out.println("section_name: " + docs.getSection_name());
            System.out.println("subsection_name: " + docs.getSubsection_name());
            System.out.println("type_of_material: " + docs.getType_of_material());
            System.out.println("_id: " + docs.get_id());
            System.out.println("uri: " + docs.getUri());
            System.out.println("word_count: " + docs.getWord_count());



            meta meta = gson.fromJson(json.toString(), meta.class);
            System.out.println("hits: " + meta.getHits());
            System.out.println("offset: " + meta.getOffset());
            System.out.println("time: " + meta.getTime());






            legacy legacy = gson.fromJson(json.toString(), legacy.class);
            System.out.println("xlarge: " + legacy.getXlarge());
            System.out.println("xlargewidth: " + legacy.getXlargewidth());
            System.out.println("xlargeheight: " + legacy.getXlargeheight());


            headline headline = gson.fromJson(json.toString(), headline.class);
            System.out.println("main: " + headline.getMain());
            System.out.println("kicker: " + headline.getKicker());
            System.out.println("content_kicker: " + headline.getContent_kicker());
            System.out.println("print_headline: " + headline.getPrint_headline());
            System.out.println("name: " + headline.getName());
            System.out.println("seo: " + headline.getSeo());
            System.out.println("sub: " + headline.getSub());




        } catch (ProtocolException ex) {
            throw new RuntimeException(ex);
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }




}