package com.grupoigal.anaruth.cedeira;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Turismo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

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
    private int[] san_andres = {
            R.drawable.o_santuario_01,
            R.drawable.san_andres_02,
            R.drawable.lendas_03,
            R.drawable.romarias_04,
            R.drawable.andresinos_05,
            R.drawable.fonte_06,
            R.drawable.herba_namorar_07,
            R.drawable.visitas_08,
            R.drawable.rutas_09
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

    String[] titulo;
    String[] contenido;

    private ListView lista;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turismo);

        Bundle extras = getIntent().getExtras();

        //Construimos el mensaje a mostrar
        final int idTurismo = extras.getInt("turismo");

        lista = (ListView) findViewById(R.id.listView_listarCircuito);
        switch (idTurismo){
            case 0:
                titulo = getResources().getStringArray(R.array.titulo_praias);
                contenido = getResources().getStringArray(R.array.descripcion_corta_praias);
                adapter = new ListViewAdapter(this, praias, titulo, contenido);
                break;
            case 1:
                titulo = getResources().getStringArray(R.array.titulo_miradoiros);
                contenido = getResources().getStringArray(R.array.descripcion_corta_miradoiros);
                adapter = new ListViewAdapter(this, miradoiros, titulo, contenido);
                break;

            case 2:
                titulo = getResources().getStringArray(R.array.titulo_patrimonio);
                contenido = getResources().getStringArray(R.array.descripcion_corta_patrimonio);
                adapter = new ListViewAdapter(this, patrimonio, titulo, contenido);
                break;

            case 3:
                titulo = getResources().getStringArray(R.array.titulo_rutas);
                contenido = getResources().getStringArray(R.array.descripcion_corta_rutas);
                adapter = new ListViewAdapter(this, rutas, titulo, contenido);
                break;

            case 4: //San Andres
                titulo = getResources().getStringArray(R.array.titulo_san_andres);
                contenido = getResources().getStringArray(R.array.descripcion_corta_san_andres);
                adapter = new ListViewAdapter(this, san_andres, titulo, contenido);
                break;

            case 5:
                Intent i = new Intent(getApplicationContext(), Hosteleria.class);
                startActivity(i);
                break;
            case 6:
                titulo = getResources().getStringArray(R.array.titulo_restaurante);
                contenido = getResources().getStringArray(R.array.descripcion_corta_restaurante);
                adapter = new ListViewAdapter(this, restaurantes, titulo, contenido);
                break;
            case 7:
                titulo = getResources().getStringArray(R.array.titulo_hotel);
                contenido = getResources().getStringArray(R.array.descripcion_corta_hotel);
                adapter = new ListViewAdapter(this, hoteles, titulo, contenido);
                break;

            default:
                Toast.makeText(getApplicationContext(), "no esta cargado, pronto lo estar�", Toast.LENGTH_SHORT).show();
        }
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(idTurismo == 4 && titulo[position].equals("RUTAS")){
                    Intent i = new Intent(getApplicationContext(), Rutas_San_Andres.class);
                    startActivity(i);
                } else{
                Intent i = new Intent(getApplicationContext(), ListaUnaFicha.class);
                i.putExtra("idturismo",idTurismo);
                i.putExtra("position", position);
                startActivity(i);}
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


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
        return true;}
    public class ListViewAdapter extends BaseAdapter {
        // Declare Variables
        Context context;
        int[] imagenes;
        String[] titulos;
        String[] contenido;
        LayoutInflater inflater;

        public ListViewAdapter(Context context, int[] imagenes, String[] titulos, String[] contenido ) {
            this.context = context;
            this.imagenes = imagenes;
            this.titulos = titulos;
            this.contenido = contenido;
        }

        @Override
        public int getCount() {
            return titulos.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            // Declare Variables
            ImageView imgImg;
            TextView txtTitle;
            TextView txtContenido;

            //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View itemView = inflater.inflate(R.layout.list_row, parent, false);

            // Locate the TextViews in listview_item.xml
            imgImg = (ImageView) itemView.findViewById(R.id.imagen_single_post);
            txtTitle = (TextView) itemView.findViewById(R.id.tv_titulo_single_post);
            txtContenido = (TextView) itemView.findViewById(R.id.tv_contenido_single_post);

            // Capture position and set to the TextViews
            imgImg.setImageResource(imagenes[position]);
            txtTitle.setText(titulos[position]);
            txtContenido.setText(contenido[position]);

            return itemView;
        }
    }

}
