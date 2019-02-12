package hei.Descamps_Duclos_Farge.restaurants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
