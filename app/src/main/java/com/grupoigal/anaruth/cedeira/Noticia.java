package com.grupoigal.anaruth.cedeira;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Noticia extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private static final String TAG_SUCCESS = "success";
    private static final String TAG_EVENTOS = "eventos";
    private static final String TAG_ID = "id";
    private static final String TAG_TITULO = "titulo";
    private static final String TAG_DESCRIPCION = "descripcion";
    private static final String TAG_ENLACE_PDF1 = "enlace_pdf1";
    private static int id;
    private static String descripcion;
    private static String enlace1;
    private static String titulo;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        Bundle extras = getIntent().getExtras();
        id = extras.getInt("id");
        descripcion = extras.getString("descripcion");
        enlace1 = extras.getString("enlace1");
        titulo = extras.getString("titulo");



        TextView txtTitulo = (TextView) findViewById(R.id.tv_titulo);
        TextView txtEnlaceOculto = (TextView) findViewById(R.id.tv_enlace_oculto);
        TextView txtContenido = (TextView) findViewById(R.id.tv_contenido);
        TextView txtEnlace = (TextView) findViewById(R.id.tv_enlace);

        if(!titulo.equals("")){
            txtTitulo.setText(titulo);
            txtTitulo.setVisibility(View.VISIBLE);}
        if(!descripcion.equals("")){
            txtContenido.setText(descripcion);
            txtContenido.setVisibility(View.VISIBLE);}
        if(!enlace1.equals("")){
            txtEnlaceOculto.setText(enlace1);
            txtEnlace.setText("PDF");
            txtEnlace.setVisibility(View.VISIBLE);}

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }
    public void irPDF(View view) {
        Intent i = new Intent(getApplicationContext(), CargaWeb.class);
        i.putExtra("id", 10);
        i.putExtra("enlace", enlace1);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
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
