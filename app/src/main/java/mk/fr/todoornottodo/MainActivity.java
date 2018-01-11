package mk.fr.todoornottodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import fr.mk.database.DatabaseHandler;
import fr.mk.database.TacheDAO;

public class MainActivity extends AppCompatActivity {

    private ListView tacheListView;
    private TextView filterView;
    private Spinner spinner;
    private List<Tache> tacheList;

    private DatabaseHandler db;
    private TacheDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference aux widgets
        tacheListView = findViewById(R.id.tacheListView);
        filterView = findViewById(R.id.filterView);
       // spinner = findViewById(R.id.spinner);

        this.db = new DatabaseHandler(this);
        this.dao = new TacheDAO(this.db);
        tacheListInit();
        //Instanciation de la connexion à la base de données
        this.db = new DatabaseHandler(this);

        //Instanciation du DAO pour les contacts
        this.dao = new TacheDAO(this.db);






    }

    private void tacheListInit() {
        //Recuperation de la liste des contacts
        tacheList = this.dao.findAll();

        //Création d'un contactArrayAdapter
        TacheArrayAdapter tacheAdapter = new TacheArrayAdapter(this, tacheList);

        //Definition de l'adapter de notre listView
       tacheListView.setAdapter(tacheAdapter);

        //definition d'un écouteur d'évenement pour onItemclick
        //tacheListView.setOnItemClickListener(this);
    }



    public void onAddTache(View view) {
        Intent formIntent = new Intent(this, FormActivity.class);
        startActivity(formIntent);

    }
}
