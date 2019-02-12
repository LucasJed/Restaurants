package hei.Descamps_Duclos_Farge.restaurants;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.liste_simples);
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            stringList.add("Element " + i);
        }

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,stringList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.layout_item_simple, R.id.myTextView, stringList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "On a clique sur " + position, Toast.LENGTH_LONG).show();

            }
        });

    }

    private class fetchURLTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("Downloading Data...");
            dialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.d(TAG, "doInBackground 1");
            try {
                Log.d(TAG, "doInBackground 2");
                return loadFromNetwork(strings[0]);
            } catch (IOException e) {
                Log.d(TAG, "doInBackground 3");
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d(TAG, "onPostExecute");
            super.onPostExecute(result);
            buildPersonList(result);
        }
    }

    private String loadFromNetwork(String urlString) throws IOException {
        Log.d(TAG, "loadFromNetwork");
        InputStream stream = null;
        String str = "";
        try {
            stream = downloadURL(urlString);
            str = readIt(stream);
        } finally {
            {
                if (stream != null) {
                    stream.close();
                }
            }
        }
        return str;
    }

    private InputStream downloadURL(String urlString) throws IOException {
        Log.d(TAG, "downloadURL " + urlString);
        URL url = new URL(urlString);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        //conn.setReadTimeout(10000);
        //conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }

    private String readIt(InputStream stream) throws IOException, UnsupportedEncodingException {
        Log.d(TAG, "readIt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

}
