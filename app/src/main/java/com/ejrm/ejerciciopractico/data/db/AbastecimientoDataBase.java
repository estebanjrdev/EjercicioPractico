package com.ejrm.ejerciciopractico.data.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ejrm.ejerciciopractico.data.model.AbastecimientoModel;

@Database(entities = {AbastecimientoModel.class}, version = 1, exportSchema = false)
public abstract class AbastecimientoDataBase extends RoomDatabase {
    public abstract AbastecimientoDao abastecimientoDao();
    private static volatile AbastecimientoDataBase INSTANCE;
    public static AbastecimientoDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AbastecimientoDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AbastecimientoDataBase.class, "abastecimiento-database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

