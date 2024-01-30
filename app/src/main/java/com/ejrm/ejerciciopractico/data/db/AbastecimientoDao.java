package com.ejrm.ejerciciopractico.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ejrm.ejerciciopractico.data.model.AbastecimientoModel;

import java.util.List;

@Dao
public interface AbastecimientoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    static void insert(List<AbastecimientoModel> abastecimientoModelsList) {

    }

    @Query("SELECT * FROM abastecimiento_table")
    LiveData<List<AbastecimientoModel>> getAll();

}
