package com.grupoigal.anaruth.cedeira;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaTlf extends ActionBarActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView imgImagen1, imgImagen2, imgImagen3, imgImagen4, imgImagen5, imgImagen6, imgImagen7;
    private TextView txtTitulo1, txtTitulo2,txtTitulo3, txtTitulo4,txtTitulo5, txtTitulo6, txtTitulo7;
    String[] titulo1, titulo2, titulo3, titulo4, titulo5, titulo6, titulo7;


    private int[] imagenes = {
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_home_black_24dp,
            R.drawable.tlf_img,
            R.drawable.arroba_img,
            R.drawable.arroba_img,
            R.drawable.ic_access_time_black_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);



        Bundle extras = getIntent().getExtras();

        //Construimos el mensaje a mostrar
        final int position = extras.getInt("position");


            txtTitulo1 = (TextView) findViewById(R.id.tv_titulo_home1);
            imgImagen1 = (ImageView) findViewById(R.id.img_home1);
            txtTitulo2 = (TextView) findViewById(R.id.tv_home2);
            imgImagen2 = (ImageView) findViewById(R.id.img_home2);
            txtTitulo3 = (TextView) findViewById(R.id.tv_home3);
            imgImagen3 = (ImageView) findViewById(R.id.img_home3);
            txtTitulo4 = (TextView) findViewById(R.id.tv_tlf1);
            imgImagen4 = (ImageView) findViewById(R.id.img_tlf1);
            txtTitulo5 = (TextView) findViewById(R.id.tv_arroba1);
            imgImagen5 = (ImageView) findViewById(R.id.img_arroba1);
            txtTitulo6 = (TextView) findViewById(R.id.tv_arroba2);
            imgImagen6 = (ImageView) findViewById(R.id.img_arroba2);
            txtTitulo7 = (TextView) findViewById(R.id.tv_time1);
            imgImagen7 = (ImageView) findViewById(R.id.img_time1);

            switch (position) {
                case 0: //concello
                    titulo1 = getResources().getStringArray(R.array.directorio_direccion_1);
                    txtTitulo1.setText(titulo1[position]);
                    txtTitulo1.setVisibility(View.VISIBLE);
                    imgImagen1.setImageResource(imagenes[0]);
                    imgImagen1.setVisibility(View.VISIBLE);


                    titulo4 = getResources().getStringArray(R.array.tlf);
                    txtTitulo4.setText(titulo4[position]);
                    txtTitulo4.setVisibility(View.VISIBLE);
                    imgImagen4.setImageResource(imagenes[3]);
                    imgImagen4.setVisibility(View.VISIBLE);

                    titulo5 = getResources().getStringArray(R.array.arroba);
                    txtTitulo5.setText(titulo5[position]);
                    txtTitulo5.setVisibility(View.VISIBLE);
                    imgImagen5.setImageResource(imagenes[4]);
                    imgImagen5.setVisibility(View.VISIBLE);

                    titulo6 = getResources().getStringArray(R.array.arroba2);
                    txtTitulo6.setText(titulo6[position]);
                    txtTitulo6.setVisibility(View.VISIBLE);
                    imgImagen6.setImageResource(imagenes[5]);
                    imgImagen6.setVisibility(View.VISIBLE);

                    titulo7 = getResources().getStringArray(R.array.time);
                    txtTitulo7.setText(titulo7[position]);
                    txtTitulo7.setVisibility(View.VISIBLE);
                    imgImagen7.setImageResource(imagenes[6]);
                    imgImagen7.setVisibility(View.VISIBLE);
                    break;
                case 1: //polic�a local
                    titulo1 = getResources().getStringArray(R.array.directorio_direccion_1);
                    txtTitulo1.setText(titulo1[position]);
                    txtTitulo1.setVisibility(View.VISIBLE);
                    imgImagen1.setImageResource(imagenes[0]);
                    imgImagen1.setVisibility(View.VISIBLE);

                    titulo4 = getResources().getStringArray(R.array.tlf);
                    txtTitulo4.setText(titulo4[position]);
                    txtTitulo4.setVisibility(View.VISIBLE);
                    imgImagen4.setImageResource(imagenes[3]);
                    imgImagen4.setVisibility(View.VISIBLE);

                    titulo5 = getResources().getStringArray(R.array.arroba);
                    txtTitulo5.setText(titulo5[position]);
                    txtTitulo5.setVisibility(View.VISIBLE);
                    imgImagen5.setImageResource(imagenes[4]);
                    imgImagen5.setVisibility(View.VISIBLE);
                    break;

                case 2:
                    titulo1 = getResources().getStringArray(R.array.directorio_direccion_1);
                    txtTitulo1.setText(titulo1[position]);
                    txtTitulo1.setVisibility(View.VISIBLE);
                    imgImagen1.setImageResource(imagenes[0]);
                    imgImagen1.setVisibility(View.VISIBLE);

                    titulo4 = getResources().getStringArray(R.array.tlf);
                    txtTitulo4.setText(titulo4[position]);
                    txtTitulo4.setVisibility(View.VISIBLE);
                    imgImagen4.setImageResource(imagenes[3]);
                    imgImagen4.setVisibility(View.VISIBLE);
                    break;

                case 3:
                    titulo4 = getResources().getStringArray(R.array.tlf);
                    txtTitulo4.setText(titulo4[position]);
                    txtTitulo4.setVisibility(View.VISIBLE);
                    imgImagen4.setImageResource(imagenes[3]);
                    imgImagen4.setVisibility(View.VISIBLE);

                    break;

                case 4:
                    titulo1 = getResources().getStringArray(R.array.directorio_direccion_1);
                    txtTitulo1.setText(titulo1[position]);
                    txtTitulo1.setVisibility(View.VISIBLE);
                    imgImagen1.setImageResource(imagenes[0]);
                    imgImagen1.setVisibility(View.VISIBLE);

                    titulo2 = getResources().getStringArray(R.array.directorio_direccion_2);
                    txtTitulo2.setText(titulo2[position]);
                    txtTitulo2.setVisibility(View.VISIBLE);
                    imgImagen2.setImageResource(imagenes[1]);
                    imgImagen2.setVisibility(View.VISIBLE);

                    titulo3 = getResources().getStringArray(R.array.directorio_direccion_3);
                    txtTitulo3.setText(titulo3[position]);
                    txtTitulo3.setVisibility(View.VISIBLE);
                    imgImagen3.setImageResource(imagenes[2]);
                    imgImagen3.setVisibility(View.VISIBLE);
                    break;

                case 5:
                    titulo1 = getResources().getStringArray(R.array.directorio_direccion_1);
                    txtTitulo1.setText(titulo1[position]);
                    txtTitulo1.setVisibility(View.VISIBLE);
                    imgImagen1.setImageResource(imagenes[0]);
                    imgImagen1.setVisibility(View.VISIBLE);

                    titulo4 = getResources().getStringArray(R.array.tlf);
                    txtTitulo4.setVisibility(View.VISIBLE);
                    txtTitulo4.setText(titulo4[position]);
                    imgImagen4.setImageResource(imagenes[3]);
                    imgImagen4.setVisibility(View.VISIBLE);
                    break;

                default:
                    Toast.makeText(getApplicationContext(), "no esta cargado, pronto lo estar�", Toast.LENGTH_SHORT).show();
            }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento1 = new Intent(getApplicationContext(), MainConcello.class);
                startActivityForResult(intento1, 0);
            }
        });




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



    //Opciones del men�
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
