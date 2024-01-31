package com.ejrm.ejerciciopractico.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CatalogoAbastecimientoDao {
    @Insert
    void insert(CatalogoAbastecimientoEntity catalogoAbastecimiento);

    @Query("SELECT * FROM catalogo_abastecimiento")
    List<CatalogoAbastecimientoEntity> getAllCatalogoAbastecimientos();
}
