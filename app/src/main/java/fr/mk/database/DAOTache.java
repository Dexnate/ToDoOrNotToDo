package fr.mk.database;

import android.database.sqlite.SQLiteException;

import java.util.List;

import mk.fr.todoornottodo.Tache;

/**
 * Created by Formation on 11/01/2018.
 */

interface DAOTache<DTO> {
    DTO findOneById(Long id)throws SQLiteException;

    List<DTO> findAll() throws SQLiteException;

    //    Suppression d'une tâche en fonction de sa clef primaire
    void deleteOneById(Long id) throws SQLiteException;

    void persist(Tache entity);
}
