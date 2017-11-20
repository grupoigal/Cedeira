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
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaUnaFicha extends ActionBarActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView imgImagen;
    private TextView txtTitulo, txtContenido, txtCoord1, txtCoord2, txtEnlace1, txtEnlace2, txtEnlace3, txtEnlace4,  txtEnlaceOculto;
    String[] titulo, enlace1_S, enlace2_S, enlace3_S, enlace4_S;
    String[] contenido;
    String[] coord1;
    String[] coord2;


    private int[] praias = {
            R.drawable.praia_magdalena_,
            R.drawable.praia_arealonga_,
            R.drawable.calasonrieiras03,
            R.drawable.calaburbullas01
    };
    private int[] miradoiros = {
            R.drawable.puntasarridal01,
            R.drawable.corveiro,
            R.drawable.candieira,
            R.drawable.cruceiro_teixidelo,
            R.drawable.garitadaherbeira,
            R.drawable.carris,
            R.drawable.chao_do_monte,
            R.drawable.farorobaleira01,
            R.drawable.sanfiz01,
            R.drawable.miradortarroiba,
            R.drawable.penedoedroso,
            R.drawable.mapapozadaauga
    };
    private int[] patrimonio = {
            R.drawable.garita_de_herbeira,
            R.drawable.casteloconcepcion05,
            R.drawable.santo_anton,
            R.drawable.museo09,
            R.drawable.casco_vello1,
            R.drawable.lonxa,
            R.drawable.porto
    };
    private int[] rutas = {
            R.drawable.faunadaserra01,
            R.drawable.ruta_das_portas,
            R.drawable.ruta_das_portas,
            R.drawable.ruta_das_portas,
            R.drawable.ruta_das_portas,
            R.drawable.paseomaritimo,
            R.drawable.paseo_fluvial,
            R.drawable.praza_roxa,
            R.drawable.parque_da_revolta,
            R.drawable.parque_floreal,
            R.drawable.parqueromeiro02,
            R.drawable.rua_dos_marineiros,
            R.drawable.rutaferrolsanandres,
            R.drawable.rutaterrasdecedeira,
            R.drawable.rutalinnareserobaleira,
            R.drawable.xeorutas_01,
            R.drawable.xeoruta_02,
            R.drawable.xeoruta_03,
            R.drawable.xeorutadocromo
    };
    private int[] hoteles = {
            R.drawable.hoteles,
            R.drawable.hoteles,
            R.drawable.hoteles,
            R.drawable.hoteles,
            R.drawable.hoteles,
            R.drawable.hoteles,
            R.drawable.hoteles,
            R.drawable.hoteles,
            R.drawable.hoteles,
            R.drawable.hoteles
    };
    private int[] restaurantes = {
            R.drawable.restaurante_1,
            R.drawable.restaurante_2,
            R.drawable.restaurante_3,
            R.drawable.restaurante_4,
            R.drawable.restaurante_5,
            R.drawable.restaurante_6,
            R.drawable.restaurante_7,
            R.drawable.restaurante_8,
            R.drawable.restaurante_9,
            R.drawable.restaurante_10,
            R.drawable.restaurante_11,
            R.drawable.restaurante_12,
            R.drawable.restaurante_13,
            R.drawable.restaurante_14,
            R.drawable.restaurante_15,
            R.drawable.restaurante_16,
            R.drawable.restaurante_17,
            R.drawable.restaurante_18,
            R.drawable.restaurante_19,
            R.drawable.restaurante_20,
            R.drawable.restaurante_21,
            R.drawable.restaurante_22,
            R.drawable.restaurante_23,
            R.drawable.restaurante_24,
            R.drawable.restaurante_25,
            R.drawable.restaurante_26,
            R.drawable.restaurante_27,
            R.drawable.restaurante_28
    };
    private int[] san_andres = {
            R.drawable.o_santuario_01,
            R.drawable.san_andres_02,
            R.drawable.lendas_03,
            R.drawable.romarias_04,
            R.drawable.andreseinos_2,
            R.drawable.fonte_06,
            R.drawable.herba_namorar_07,
            R.drawable.visitas_08,
            R.drawable.rutas_09
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_una_ficha);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);



        Bundle extras = getIntent().getExtras();
        final int idTurismo = extras.getInt("idturismo");
        final int position = extras.getInt("position");


        txtTitulo = (TextView) findViewById(R.id.tv_titulo);
        txtContenido = (TextView) findViewById(R.id.tv_contenido);
        txtCoord1 = (TextView) findViewById(R.id.textViewCoord1);
        txtCoord2 = (TextView) findViewById(R.id.textViewCoord2);
        txtEnlace1 = (TextView) findViewById(R.id.textViewEnlace1);
        txtEnlace2 = (TextView) findViewById(R.id.textViewEnlace2);
        txtEnlace3 = (TextView) findViewById(R.id.textViewEnlace3);
        txtEnlace4 = (TextView) findViewById(R.id.textViewEnlace4);
        txtEnlaceOculto = (TextView) findViewById(R.id.textViewEnlaceOculto);
        imgImagen = (ImageView) findViewById(R.id.iv_imagen);

        switch (idTurismo){
            case 0: //Playas
                titulo = getResources().getStringArray(R.array.titulo_praias);
                contenido = getResources().getStringArray(R.array.descripcion_larga_praias);
                coord1 = getResources().getStringArray(R.array.praias_coord_1);
                coord2 = getResources().getStringArray(R.array.praias_coord_2);
                imgImagen.setImageResource(praias[position]);
                break;
            case 1: //Miradores
                titulo = getResources().getStringArray(R.array.titulo_miradoiros);
                contenido = getResources().getStringArray(R.array.descripcion_larga_miradoiros);
                coord1 = getResources().getStringArray(R.array.miradoiros_coord_1);
                coord2 = getResources().getStringArray(R.array.miradoiros_coord_2);
                imgImagen.setImageResource(miradoiros[position]);
                break;

            case 2: //Patrimonio
                titulo = getResources().getStringArray(R.array.titulo_patrimonio);
                contenido = getResources().getStringArray(R.array.descripcion_larga_patrimonio);
                coord1 = getResources().getStringArray(R.array.patrimonio_coord_1);
                coord2 = getResources().getStringArray(R.array.patrimonio_coord_2);
                imgImagen.setImageResource(patrimonio[position]);
                break;

            case 3: //Rutas
                titulo = getResources().getStringArray(R.array.titulo_rutas);
                contenido = getResources().getStringArray(R.array.descripcion_larga_rutas);
                imgImagen.setImageResource(rutas[position]);
                coord1 = getResources().getStringArray(R.array.rutas_coord_1);
                coord2 = getResources().getStringArray(R.array.rutas_coord_2);
                enlace1_S = getResources().getStringArray(R.array.pdf1_rutas);
                enlace2_S = getResources().getStringArray(R.array.pdf2_rutas);
                enlace3_S = getResources().getStringArray(R.array.pdf3_rutas);
                enlace4_S = getResources().getStringArray(R.array.pdf4_rutas);

                if(!enlace1_S[position].equals("")){
                    txtEnlaceOculto.setText(enlace1_S[position]);
                    txtEnlace1.setText("Galego");
                    txtEnlace1.setVisibility(View.VISIBLE);}else{};
                if(enlace2_S[position].equals("")){}else{
                    txtEnlaceOculto.setText(enlace2_S[position]);
                    txtEnlace2.setText("Castellano");
                    txtEnlace2.setVisibility(View.VISIBLE);}
                if(enlace3_S[position].isEmpty()){}else{
                    txtEnlaceOculto.setText(enlace3_S[position]);
                    txtEnlace3.setText(Html.fromHtml("1ª parte"));
                    txtEnlace3.setVisibility(View.VISIBLE);}
                if(enlace4_S[position].isEmpty()){}else{
                    txtEnlaceOculto.setText(enlace4_S[position]);
                    txtEnlace4.setText("2ª parte ");
                    txtEnlace4.setVisibility(View.VISIBLE);}

                break;

            case 4: //San Andrés
                titulo = getResources().getStringArray(R.array.titulo_san_andres);
                coord1 = getResources().getStringArray(R.array.coord_san_andres_01);
                coord2 = getResources().getStringArray(R.array.coord_san_andres_02);
                contenido = getResources().getStringArray(R.array.descripcion_larga_san_andres);
                imgImagen.setImageResource(san_andres[position]);
                break;

            case 5: //Hosteleria
                Intent i = new Intent(getApplicationContext(), Hosteleria.class);
                startActivity(i);
                break;
            case 6: //Restaurantes
                titulo = getResources().getStringArray(R.array.titulo_restaurante);
                coord1 = getResources().getStringArray(R.array.coord_san_andres_01);
                coord2 = getResources().getStringArray(R.array.coord_san_andres_02);
                contenido = getResources().getStringArray(R.array.descripcion_larga_restaurante);
                imgImagen.setImageResource(restaurantes[position]);
                break;
            case 7: //Hoteles
                titulo = getResources().getStringArray(R.array.titulo_hotel);
                coord1 = getResources().getStringArray(R.array.coord_san_andres_01);
                coord2 = getResources().getStringArray(R.array.coord_san_andres_02);
                contenido = getResources().getStringArray(R.array.descripcion_larga_restaurante);
                imgImagen.setImageResource(hoteles[position]);
                break;

            default:
                Toast.makeText(getApplicationContext(), "no esta cargado, pronto lo estar�", Toast.LENGTH_SHORT).show();
        }
        txtTitulo.setText(titulo[position]);
        txtContenido.setText(contenido[position]);
        txtCoord1.setText(coord1[position]);
        txtCoord2.setText(coord2[position]);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if(!coord1[position].equals("") && !coord2[position].equals("")){
            fab.setVisibility(View.VISIBLE);
        }else{
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("turismo", idTurismo);
                double coordenada1 = Double.parseDouble(coord1[position].toString());
                double coordenada2 = Double.parseDouble(coord2[position].toString());
                i.putExtra("coor1", coordenada1);
                i.putExtra("coor2", coordenada2);
                i.putExtra("lugar", titulo[position]);
                //i.putExtra("nombreDirectorio", titulo[position]);
                startActivity(i);
            }
        });


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }
    public void irPdf(View view) {
        Intent i = new Intent(getApplicationContext(), CargaWeb.class);
        i.putExtra("id", 10);
        i.putExtra("enlace", txtEnlaceOculto.getText());
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

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



    //Opciones del men?
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
