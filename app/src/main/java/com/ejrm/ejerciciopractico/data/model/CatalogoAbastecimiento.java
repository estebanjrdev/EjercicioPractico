package com.ejrm.ejerciciopractico.data.model;

public class CatalogoAbastecimiento {
    private int id;
    private String papel;
    private String toallas;
    private String desorodante;
    private String jabon;
    private String agua;
    public CatalogoAbastecimiento(int id, String papel, String toallas, String desorodante, String jabon, String agua) {
        this.id = id;
        this.papel = papel;
        this.toallas = toallas;
        this.desorodante = desorodante;
        this.jabon = jabon;
        this.agua = agua;
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
