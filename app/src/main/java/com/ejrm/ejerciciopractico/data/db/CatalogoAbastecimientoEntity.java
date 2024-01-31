package com.ejrm.ejerciciopractico.data.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "catalogo_abastecimiento")
public class CatalogoAbastecimientoEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "imagen")
    private byte[] imagen;
    @ColumnInfo(name = "papel")
    private String papel;
    @ColumnInfo(name = "toallas")
    private String toallas;
    @ColumnInfo(name = "desorodante")
    private String desorodante;
    @ColumnInfo(name = "jabon")
    private String jabon;
    @ColumnInfo(name = "agua")
    private String agua;

    public CatalogoAbastecimientoEntity(byte[] imagen, String papel, String toallas, String desorodante, String jabon, String agua) {
        this.imagen = imagen;
        this.papel = papel;
        this.toallas = toallas;
        this.desorodante = desorodante;
        this.jabon = jabon;
        this.agua = agua;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public String getToallas() {
        return toallas;
    }

    public void setToallas(String toallas) {
        this.toallas = toallas;
    }

    public String getDesorodante() {
        return desorodante;
    }

    public void setDesorodante(String desorodante) {
        this.desorodante = desorodante;
    }

    public String getJabon() {
        return jabon;
    }

    public void setJabon(String jabon) {
        this.jabon = jabon;
    }

    public String getAgua() {
        return agua;
    }

    public void setAgua(String agua) {
        this.agua = agua;
    }
}
