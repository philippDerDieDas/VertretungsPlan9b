package tk.neunbbgg.vertretungsplan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class bilderActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    ImageView g;
    public static int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        g = (ImageView) findViewById(R.id.g);
        g.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://9b-gg.jimdo.com/"));
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_bild);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_bild);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bilder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        else if (id == R.id.action_aktu){
            new DownloadFileFromURL().execute(Login.file_heute_url, getFilesDir().getPath());
            new DownloadFileFromURL2().execute(Login.file_morgen_url, getFilesDir().getPath());
            new DownloadFileFromURL3().execute(Login.file_mensa_url, getFilesDir().getPath());
            new DownloadFileFromURLS().execute(stundenActivity.file_stunden_url, getFilesDir().getPath());
            Toast.makeText(getApplicationContext(), "Alles Aktualisiert", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.action_chpw){
        startActivity(new Intent(this, changepwActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(this, naviActivity.class));
        } else if (id == R.id.nav_gallery) {
            //nichts
        } else if (id == R.id.nav_share) {
            startActivity(new Intent(this, plan1Activity.class));
        } else if (id == R.id.nav_send) {
            startActivity(new Intent(this, plan2Activity.class));
        }
        else if (id == R.id.nav_view) {
            startActivity(new Intent(this, haActivity.class));
        }else if (id == R.id.nav_k){
            startActivity(new Intent(this, termineActivity.class));
        }else if (id == R.id.nav_slideshow){
            startActivity(new Intent(this, mensaActivity.class));

        }else if (id == R.id.stundenplan){
            startActivity(new Intent(this, stundenActivity.class));
        }else if (id == R.id.telefon){
            startActivity(new Intent(this, telefonActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_bild);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.g:
                if (i==22){
                i=0;
                }
                i=i+1;


                break;
        }
    }
}

