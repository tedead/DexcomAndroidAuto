package org.nibbler.zoe.dexcomandroidauto;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.os.AsyncTask;

public class URLRequest extends AsyncTask<String, Void, String>
{
    public static String response = "";

    protected void onPostExecute(String result) {
        // TODO Update the UI thread with the final result
    }

    @Override
    protected String doInBackground(String... uri) {
        StringBuilder sb = new StringBuilder();

        try {
            URL url = new URL(uri[0]);
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        try
        {
            BufferedReader bin = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String inputLine;

            while ((inputLine = bin.readLine()) != null)
            {
                sb.append(inputLine);
            }

        }
        finally
        {
            urlConnection.disconnect();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        response = sb.toString();
        return response;
    }
}
