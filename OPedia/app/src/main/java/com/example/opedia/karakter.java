package com.example.newopedia;

public class karakter {
    private int id;
    private String nama;
    private String jenis_kelamin;
    private String bounty;
    private String anggota;
    private String posisi;
    private String haki;
    private String buah_iblis;
    private String tipe_buah;
    private String biografi;
    private byte[] image;

    public karakter(int id, String nama, String jenis_kelamin, String bounty, String anggota, String posisi, String haki, String buah_iblis, String tipe_buah, String biografi, byte[] image) {
        this.id = id;
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.bounty = bounty;
        this.anggota = anggota;
        this.posisi = posisi;
        this.haki = haki;
        this.buah_iblis = buah_iblis;
        this.tipe_buah = tipe_buah;
        this.biografi = biografi;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getBounty() {
        return bounty;
    }

    public void setBounty(String bounty) {
        this.bounty = bounty;
    }

    public String getAnggota() {
        return anggota;
    }

    public void setAnggota(String anggota) {
        this.anggota = anggota;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getHaki() {
        return haki;
    }

    public void setHaki(String haki) {
        this.haki = haki;
    }

    public String getBuah_iblis() {
        return buah_iblis;
    }

    public void setBuah_iblis(String buah_iblis) {
        this.buah_iblis = buah_iblis;
    }

    public String getTipe_buah() {
        return tipe_buah;
    }

    public void setTipe_buah(String tipe_buah) {
        this.tipe_buah = tipe_buah;
    }

    public String getBiografi() {
        return biografi;
    }

    public void setBiografi(String biografi) {
        this.biografi = biografi;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
