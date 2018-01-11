package mk.fr.todoornottodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView tacheListView;
    private TextView filterView;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference aux widgets
        tacheListView = findViewById(R.id.tacheListView);
        filterView = findViewById(R.id.filterView);
        spinner = findViewById(R.id.spinner);


    }



    public void onAddTache(View view) {
        Intent formIntent = new Intent(this, FormActivity.class);
        startActivity(formIntent);

    }
}
