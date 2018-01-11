package mk.fr.todoornottodo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Formation on 11/01/2018.
 */

public class TacheArrayAdapter extends ArrayAdapter {

    private Activity context;
    private List<Tache> data;
    private int ressource;
    private LayoutInflater inflater;

    public TacheArrayAdapter(@NonNull Context context, List<Tache> data) {
        super(context,0,data);
        this.context = (Activity)context;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Instanciation de la vue
        View view = this.inflater.inflate(R.layout.list_view_taches, parent, false);

        //Recuperation des données d'une ligne
        Tache tacheData = this.data.get(position);

        //Liaison entre les données et la vue
        TextView nameTextView = view.findViewById(R.id.listTextViewName);
        nameTextView.setText(tacheData.getName());




        return view;
    }
}
