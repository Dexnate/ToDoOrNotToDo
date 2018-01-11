package mk.fr.todoornottodo;

import android.app.ActionBar;
import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import fr.mk.database.DatabaseHandler;

public class FormActivity extends AppCompatActivity {

    private EditText editTextNom;
    private int checked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void onValid(View v) {
        //Récuperation de la saisie de l'utilisateur
        String name = ((EditText) findViewById(R.id.editTextNom)).getText().toString();
        checked=1;




        //Instanciation de la connexion à la base de données
        DatabaseHandler db = new DatabaseHandler(this);

        //définition des données à inserer
        ContentValues insertValues = new ContentValues();
        insertValues.put("name", name);
        insertValues.put("checked", checked);


        try {
            db.getWritableDatabase().insert("taches", null, insertValues);
            Toast.makeText(this, "Insertion OK", Toast.LENGTH_SHORT).show();




        } catch (SQLiteException ex) {
            Log.e("SQL EXCEPTION", ex.getMessage());
        }

    }






}
