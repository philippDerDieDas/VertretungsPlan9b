package tk.neunbbgg.vertretungsplan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Person> persons;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://9b-gg.jimdo.com/"));
                startActivity(intent);
            }
        });

        rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        initializeData();
        initializeAdapter();

    }
    private void initializeData(){
        persons = new ArrayList<>();
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String news = sharedPreferences.getString("news", "Nichts");
        persons.add(new Person("App-Version", R.drawable.orange_circle, View.GONE, "Version: " + MainActivity.appversion, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }));
        persons.add(new Person("Kontakt", R.drawable.orange_circle, View.VISIBLE, "Kontaktiere mich, falls du ein Problem mit der App hast", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "mb.nbapp@cedgetec.com", null));
                i.putExtra(Intent.EXTRA_SUBJECT, "9bApp");
                startActivity(Intent.createChooser(i, "Email Senden"));
            }
        }));
        persons.add(new Person("Neu:", R.drawable.orange_circle, View.GONE, news, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }

}
