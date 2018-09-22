package com.example.user.imagesavedatabase;

import java.io.Serializable;
public class UserModel implements Serializable {
    private String jenisaduan, nama, alamat, telefon, emel, tarikh, aduan;
    private int id;
    private byte[] image;

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id; }

    public String getJenisaduan() {
        return jenisaduan;
    }
    public void setJenisaduan(String jenisaduan) { this.jenisaduan = jenisaduan; }

    public String getNama() {
        return nama ;
    }
    public void setNama(String nama) { this.nama  = nama ; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public String getEmel() {
        return emel;
    }
    public void setEmel(String emel) { this.emel = emel; }

    public String getTarikh() {
        return tarikh;
    }
    public void setTarikh(String tarikh) { this.tarikh = tarikh; }

    public String getAduan() {
        return aduan;
    }
    public void setAduan(String aduan) { this.aduan = aduan; }

    public byte[] getImage() {
        return image;
    }
    public void setImage2(byte[] image) {
        this.image = image;
    }


}



