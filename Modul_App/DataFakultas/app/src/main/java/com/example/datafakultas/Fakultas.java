package com.example.datafakultas;

public class Fakultas {
    public String idFk;
    public String namaFk;

    // table & activity column
    public static final String TABLE_FK = "fakultas";
    public static final String KEY_FK_ID = "id_fk";
    public static final String KEY_FK_NAME = "fk_name";

    public Fakultas(String idFk, String namaFk) {
        this.idFk = idFk;
        this.namaFk = namaFk;
    }

    public Fakultas() {
    }

    public String getIdFk() {
        return idFk;
    }

    public void setIdFk(String idFk) {
        this.idFk = idFk;
    }

    public String getNamaFk() {
        return namaFk;
    }

    public void setNamaFk(String namaFk) {
        this.namaFk = namaFk;
    }
}
