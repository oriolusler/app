package com.app.app.Domini;

public class Botiga {

    private int idBotiga;
    private String email;
    private String nomTenda;
    private double lat;
    private double lng;
    private int tipus;

    public Botiga(int idBotiga, String email, String nomTenda, double lat, double lng, int tipus) {
        this.idBotiga = idBotiga;
        this.email = email;
        this.nomTenda = nomTenda;
        this.lat = lat;
        this.lng = lng;
        this.tipus = tipus;
    }

    public int getIdBotiga() {
        return idBotiga;
    }

    public void setIdBotiga(int idBotiga) {
        this.idBotiga = idBotiga;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomTenda() {
        return nomTenda;
    }

    public void setNomTenda(String nomTenda) {
        this.nomTenda = nomTenda;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
    }
}
