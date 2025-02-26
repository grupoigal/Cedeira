package com.grupoigal.anaruth.cedeira;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainTurismo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_turismo);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //Va a la galer�a(peque�a)
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento2 = new Intent(getApplicationContext(), MainGaleria.class);
                startActivityForResult(intento2, 0);
            }
        });


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    public void playas(View view){
        Intent i = new Intent(getApplicationContext(), Turismo.class);
        i.putExtra("turismo", 0);
        //i.putExtra("nombreDirectorio", titulo[position]);

        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_item));
        startActivity(i);

    }
    public void miradores(View view){
        Intent i = new Intent(getApplicationContext(), Turismo.class);
        i.putExtra("turismo", 1);
        //i.putExtra("nombreDirectorio", titulo[position]);

        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_item));
        startActivity(i);

    }
    public void patrimonio(View view){
        Intent i = new Intent(getApplicationContext(), Turismo.class);
        i.putExtra("turismo", 2);
        //i.putExtra("nombreDirectorio", titulo[position]);

        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_item));
        startActivity(i);

    }
    public void rutas(View view){
        Intent i = new Intent(getApplicationContext(), Turismo.class);
        i.putExtra("turismo", 3);
        //i.putExtra("nombreDirectorio", titulo[position]);
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_item));
        startActivity(i);

    }
    public void san_andres(View view){
        Intent i = new Intent(getApplicationContext(), Turismo.class);
        i.putExtra("turismo", 4);
        //i.putExtra("nombreDirectorio", titulo[position]);
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_item));
        startActivity(i);

    }
    public void hosteler�a(View view){
        Intent i = new Intent(getApplicationContext(), Hosteleria.class);
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_item));
        startActivity(i);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            // Abre visual con la descripci?n del concello y un listado de tel?fonos de importancia
            // como el de los bomberos
            Intent intento1 = new Intent(getApplicationContext(), MainActivity.class);
            startActivityForResult(intento1, 0);

        } else if (id == R.id.nav_concello) {
            Intent intento2 = new Intent(getApplicationContext(), MainConcello.class);
            startActivityForResult(intento2, 0);
        } else if (id == R.id.nav_turismo) {
            Intent intento1 = new Intent(getApplicationContext(), MainTurismo.class);
            startActivityForResult(intento1, 0);
        } else if (id == R.id.nav_san_andres) {
            Intent i = new Intent(getApplicationContext(), Turismo.class);
            i.putExtra("turismo", 4);
            startActivity(i);
        } else if (id == R.id.nav_actualidad) {
            Intent intento1 = new Intent(getApplicationContext(), Actualidade.class);
            startActivityForResult(intento1, 0);
        } else if (id == R.id.nav_participa) {
            Intent intento1 = new Intent(getApplicationContext(), MainParticipa.class);
            startActivityForResult(intento1, 0);
        } else if (id == R.id.nav_QR) {
            Intent intento1 = new Intent(getApplicationContext(), MainQR.class);
            startActivityForResult(intento1, 0);
        } else if (id == R.id.nav_webs) {
            Intent intento1 = new Intent(getApplicationContext(), MainWeb.class);
            startActivityForResult(intento1, 0);
        }
        else if (id == R.id.nav_restaurantes) {
            Intent i = new Intent(getApplicationContext(), Turismo.class);
            i.putExtra("turismo", 6);
            startActivity(i);
        }
        else if (id == R.id.nav_hoteles) {
            Intent i = new Intent(getApplicationContext(), Turismo.class);
            i.putExtra("turismo", 7);
            startActivity(i);
        }
        else if (id == R.id.nav_gastronomia) {
            Intent intento1 = new Intent(getApplicationContext(), MainGastroniomia.class);
            startActivityForResult(intento1, 0);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
