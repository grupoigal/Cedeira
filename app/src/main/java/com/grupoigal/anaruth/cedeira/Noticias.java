package com.grupoigal.anaruth.cedeira;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;


public class Noticias extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // Progress Dialog
    private ProgressDialog pDialog;

    // Creating JSON Parser object
    JSONParser jParser = new JSONParser();

    ArrayList<HashMap<String, String>> eventosList;


    // url to get all products list
    private static String url_all_eventos = "https://cedeira.000webhostapp.com/conexion/buscar_noticia.php";

    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_EVENTOS = "noticias";
    private static final String TAG_ID = "id";
    private static final String TAG_TITULO = "titulo";
    private static final String TAG_DESCRIPCION = "descripcion";
    private static final String TAG_ENLACE_PDF1 = "enlace_pdf1";

    String[] descripcionArray = new String[25];
    String[] tituloArray = new String[25];
    String[] enlace_pdf1_Array= new String[25];


    // products JSONArray
    JSONArray eventos = null;

    ListView lista;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        // Hashmap para el ListView
        eventosList = new ArrayList<HashMap<String, String>>();

        // Cargar los productos en el Background Thread
        new LoadAllEventos().execute();
        lista = (ListView) findViewById(R.id.listAllEventos);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }//fin onCreate


    class LoadAllEventos extends AsyncTask<String, String, String> {

        /**
         * Antes de empezar el background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Noticias.this);
            pDialog.setMessage("Cargando noticias. Por favor espere...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * obteniendo todos los productos
         * */
        protected String doInBackground(String... args) {

            // Building Parameters
            List params = new ArrayList();

            // getting JSON string from URL
            JSONObject json = jParser.makeHttpRequest(url_all_eventos, "GET", params);

            // Check your log cat for JSON reponse
            Log.d("All Products: ", json.toString());

            try {


                // Checking for SUCCESS TAG
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // products found
                    // Getting Array of Products
                    eventos = json.getJSONArray(TAG_EVENTOS);

                    // looping through All Products
                    //Log.i("ana", "produtos.length" + products.length());
                    for (int i = 0; i < eventos.length(); i++) {
                        JSONObject c = eventos.getJSONObject(i);

                        // Storing each json item in variable
                        String id = c.getString(TAG_ID);
                        String titulo = c.getString(TAG_TITULO);
                        tituloArray[i]=titulo;
                        String descripcion = c.getString(TAG_DESCRIPCION);
                        descripcionArray[i] = descripcion;
                        String enlace_pdf_1 = c.getString(TAG_ENLACE_PDF1);
                        enlace_pdf1_Array[i] = enlace_pdf_1;


                        // creating new HashMap
                        HashMap map = new HashMap();



                        // adding each child node to HashMap key => value
                        map.put(TAG_ID, id);
                        map.put(TAG_TITULO, titulo);

                        eventosList.add(map);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all products
            pDialog.dismiss();
            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed JSON data into ListView
                     * */
                    ListAdapter adapter;
                    adapter = new SimpleAdapter(
                            Noticias.this,
                            eventosList,
                            R.layout.single_post,
                            new String[] {
                                    TAG_ID,
                                    TAG_TITULO,
                            },
                            new int[] {
                                    R.id.single_post_tv_id,
                                    R.id.single_post_tv_nombre,
                            });
                    // updating listview
                    //setListAdapter(adapter);
                    final String eventual="";
                    lista.setAdapter(adapter);
                    lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent i = new Intent(getApplicationContext(), Noticia.class);
                            int identificador = (int) id;
                            i.putExtra("id",id +1 );
                            i.putExtra("titulo", tituloArray[identificador] );
                            i.putExtra("descripcion", descripcionArray[identificador] );
                            i.putExtra("enlace1", enlace_pdf1_Array[identificador] );
                            startActivity(i);



                        }
                    });
                }
            });
        }
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
