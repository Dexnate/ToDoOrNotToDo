package fr.mk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

import mk.fr.todoornottodo.Tache;

/**
 * Created by Formation on 11/01/2018.
 */

public class TacheDAO implements DAOTache<Tache> {

    private DatabaseHandler db;

    public TacheDAO(DatabaseHandler db) {
        this.db = db;
    }


    //Récuperation d'une tâche en fonction de sa clef primaire


    @Override
    public Tache findOneById(Long id)throws SQLiteException {

        //Execution de la requête
        String[] params={String.valueOf(id)};
        String sql="SELECT id, name, checked FROM taches WHERE id=?";
        Cursor cursor = this.db.getReadableDatabase().rawQuery(sql, params);

        //Instanciation d'une tâche
        Tache tache = new Tache();

        //Hydratation de la tâche
        if(cursor.moveToNext()){
            tache = hydrateTache(cursor);
        }

        //Fermeture du cursor
        cursor.close();

        return tache;
    }

    private Tache hydrateTache(Cursor cursor) {
        Tache tache = new Tache() ;
        tache.setId(cursor.getLong(0));
        tache.setName(cursor.getString(1));
        tache.setChecked(cursor.getInt(2));


        return tache;
    }


    @Override
    public List<Tache> findAll() throws SQLiteException{
        //Instanciation de la liste des taches
        List<Tache> contactList = new ArrayList<>();

        // Execution de la requête sql
        String sql = "SELECT id, name, checked FROM taches";
        Cursor cursor = this.db.getReadableDatabase().rawQuery(sql, null);

        //Boucle sur le curseur
        while(cursor.moveToNext()){
            contactList.add(this.hydrateTache(cursor));
        }

        //fermeture du curseur
        cursor.close();
        return contactList;

    }

    //    Suppression d'une tâche en fonction de sa clef primaire
    @Override
    public void deleteOneById(Long id) throws SQLiteException{
        String[] params = {id.toString()};
        String sql = "DELETE FROM taches WHERE id=?";
        this.db.getWritableDatabase().execSQL(sql, params);

    }

    @Override
    public void persist(Tache entity){
        if (entity.getId() == null){
            this.insert(entity);
        }else{
            this.update(entity);
        }
    }

    private ContentValues getContentValuesFromEntity(Tache entity){
        ContentValues values = new ContentValues();
        values.put("name", entity.getName());
        values.put("checked", entity.getChecked());

        return values;
    }

    private void insert(Tache entity) {
        Long id=this.db.getWritableDatabase().insert("taches", null,this.getContentValuesFromEntity(entity));
        entity.setId(id);
    }

    private void update(Tache entity) {
        String[] params = {entity.getId().toString()};
        this.db.getWritableDatabase().update("taches", this.getContentValuesFromEntity(entity),"id=?",params);
    }






}
