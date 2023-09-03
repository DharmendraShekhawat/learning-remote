package org.example;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

       // step 1 define the URl using URL class
        URL ul = new URL( "https://api.nationalize.io/?name=nathaniel");
        // step 2 opening the connection
        HttpURLConnection connection = (HttpURLConnection) ul.openConnection();
        // step 3 setting the request method
        connection.setRequestMethod("GET");
     // step 4 here we are fetching the response code
        int responseCode = connection.getResponseCode();
        if(responseCode == 200){
            // getting the InputStream  from the connection
            // InputStreamreader is responsible for converting the byte codes into characters
            // The main purpose of InputStreamReader is to provide a way to read text data from an input stream,
            //				such as reading text files or reading data from a network connection, where the data is represented
            //				as a sequence of bytes. InputStreamReader converts these bytes into characters using a specified
            //				character encoding, allowing the data to be processed as text in Java.

            InputStream inputstream = connection.getInputStream();
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
            // bufferedReader is responsible for efficiently reading the data
            BufferedReader bf = new BufferedReader(inputstreamreader);
            String line;
            StringBuilder sb = new StringBuilder();
            while( (line = bf.readLine()) != null){
                sb.append(line);
            }
            bf.close();
            inputstream.close();
            System.out.println(sb.toString());

            JSONObject jn = new JSONObject(sb.toString());

            System.out.println();
            String prettyJSON = jn.toString(2);
            System.out.println(prettyJSON);
        }
        else{
            System.out.println("Connection failed");
        }
    }
}