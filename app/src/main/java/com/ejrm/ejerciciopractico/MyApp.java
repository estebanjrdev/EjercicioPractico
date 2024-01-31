package com.ejrm.ejerciciopractico;

import android.app.Application;

import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.ejrm.ejerciciopractico.data.db.AppDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyApp extends Application {
    public static AppDatabase database;
    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS temp_catalogo_abastecimiento (" +
                    "id INTEGER PRIMARY KEY NOT NULL," +
                    "papel TEXT," +
                    "toallas TEXT," +
                    "desorodante TEXT," +
                    "jabon TEXT," +
                    "agua TEXT," +
                    "imagen BLOB)");

            // Copia los datos de la tabla original a la tabla temporal
            database.execSQL("INSERT INTO temp_catalogo_abastecimiento (id, papel, toallas, desorodante, jabon, agua, imagen) " +
                    "SELECT id, papel, toallas, desorodante, jabon, agua, imagen FROM catalogo_abastecimiento");

            // Elimina la tabla original
            database.execSQL("DROP TABLE catalogo_abastecimiento");

            // Renombra la tabla temporal a su nombre original
            database.execSQL("ALTER TABLE temp_catalogo_abastecimiento RENAME TO catalogo_abastecimiento");
        }
    };
    @Override
    public void onCreate() {
        super.onCreate();

        // Configurar la instancia de Room
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app-database").allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2)
                .build();

    }
}
