package com.groupC.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.StrictMode;
import android.util.Log;

public class JsonParser {
        public JsonParser(){
                
        }
        public String readData(String url) {
        	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            // Create download objects
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(url);
            StringBuilder content = new StringBuilder();
            
            try {
                // Execute response and create input stream
                HttpResponse response = client.execute(get);
                int responseCode = response.getStatusLine().getStatusCode();
                if (responseCode == 200) {
                    InputStream in = response.getEntity().getContent();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    
                    // Build string from input stream
                    String readLine = reader.readLine();
                    while (readLine != null) {
                        content.append(readLine);
                        readLine = reader.readLine();
                        
                        
                    }
                } else {
                    Log.w("DATA RETRIEVAL","Unable to read data.  HTTP response code = " + responseCode);
                    content = null;
                }
            } catch (ClientProtocolException e) {
                Log.e("readData","ClientProtocolException:\n"+e.getMessage());
            } catch (IOException e) {
                Log.e("readData","IOException:\n+e.getMessage()");
            }
                
            // return data
            if (content==null) {
                return(null);
            } else {
                return(content.toString());
            }
            
        }

}