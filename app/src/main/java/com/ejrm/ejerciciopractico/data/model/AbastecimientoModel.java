package com.ejrm.ejerciciopractico.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


public class AbastecimientoModel {

    @SerializedName("idAbastecimiento")
    private int idAbastecimiento;
    @SerializedName("tipoAbastecimiento")
    private String tipoAbastecimiento;
    @SerializedName("usuarioCreacion")
    private String usuarioCreacion;
    @SerializedName("usuarioModificacion")
    private String usuarioModificacion;
    @SerializedName("usuarioEliminacion")
    private String usuarioEliminacion;
    @SerializedName("fechaCreacion")
    private String fechaCreacion;
    @SerializedName("fechaModificacion")
    private String fechaModificacion;
    @SerializedName("fechaEliminacion")
    private String fechaEliminacion;

    public AbastecimientoModel(int idAbastecimiento, String tipoAbastecimiento, String usuarioCreacion, String usuarioModificacion, String usuarioEliminacion, String fechaCreacion, String fechaModificacion, String fechaEliminacion) {
        this.idAbastecimiento = idAbastecimiento;
        this.tipoAbastecimiento = tipoAbastecimiento;
        this.usuarioCreacion = usuarioCreacion;
        this.usuarioModificacion = usuarioModificacion;
        this.usuarioEliminacion = usuarioEliminacion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.fechaEliminacion = fechaEliminacion;
    }

    public int getIdAbastecimiento() {
        return idAbastecimiento;
    }

    public void setIdAbastecimiento(int idAbastecimiento) {
        this.idAbastecimiento = idAbastecimiento;
    }

    public String getTipoAbastecimiento() {
        return tipoAbastecimiento;
    }

    public void setTipoAbastecimiento(String tipoAbastecimiento) {
        this.tipoAbastecimiento = tipoAbastecimiento;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getUsuarioEliminacion() {
        return usuarioEliminacion;
    }

    public void setUsuarioEliminacion(String usuarioEliminacion) {
        this.usuarioEliminacion = usuarioEliminacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getFechaEliminacion() {
        return fechaEliminacion;
    }

    public void setFechaEliminacion(String fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }

}
