package com.grupoigal.anaruth.cedeira;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;



public class Evento extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_EVENTOS = "eventos";
    private static final String TAG_ID = "id";
    private static final String TAG_TITULO = "titulo";
    private static final String TAG_FECHA = "fecha";
    private static final String TAG_HORA = "hora";
    private static final String TAG_LUGAR = "lugar";
    private static final String TAG_DESCRIPCION = "descripcion";
    private static final String TAG_ENLACE_PDF1 = "enlace_pdf1";
    private static final String TAG_ENLACE_PDF2 = "enlace_pdf2";
    private static int id;
    private static String lugar;
    private static String fecha;
    private static String tiempo;
    private static String descripcion;
    private static String enlace1;
    private static String enlace2;
    private static String titulo;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);

        Bundle extras = getIntent().getExtras();
        id = extras.getInt("id");
        descripcion = extras.getString("descripcion");
        lugar = extras.getString("lugar");
        fecha = extras.getString("fecha");
        tiempo = extras.getString("tiempo");
        enlace1 = extras.getString("enlace1");
        enlace2 = extras.getString("enlace2");
        titulo = extras.getString("titulo");



        TextView txtTitulo = (TextView) findViewById(R.id.tv_titulo);
        TextView txtContenido = (TextView) findViewById(R.id.tv_contenido);
        TextView txtEnlace = (TextView) findViewById(R.id.tv_enlace);
        TextView txtEnlace2 = (TextView) findViewById(R.id.tv_enlace2);
        TextView txtFecha = (TextView) findViewById(R.id.tv_fecha);
        TextView txtHora = (TextView) findViewById(R.id.tv_tiempo);
        TextView txtLugar = (TextView) findViewById(R.id.tv_lugar);
        TextView txtEnlacePdf1 = (TextView) findViewById(R.id.tv_enlace);
        TextView txtEnlacePdf2 = (TextView) findViewById(R.id.tv_enlace2);

        if(!titulo.equals("")){
        txtTitulo.setText(titulo);
        txtTitulo.setVisibility(View.VISIBLE);}
        if(!descripcion.equals("")){
            txtContenido.setText(descripcion);
            txtContenido.setVisibility(View.VISIBLE);}
        if(!enlace1.equals("")){
            txtEnlace.setText(enlace1);
            txtEnlace.setVisibility(View.VISIBLE);}
        if(!enlace2.equals("")){
            txtEnlace2.setText(enlace2);
            txtEnlace2.setVisibility(View.VISIBLE);}
        txtFecha.setText(fecha);
        txtHora.setText(tiempo);
        txtLugar.setText(lugar);




        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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
            // Abre visual con la descripci�n del concello y un listado de tel�fonos de importancia
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
