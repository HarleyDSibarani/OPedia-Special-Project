package com.example.newopedia;

import android.support.v7.app.AppCompatActivity;

public class SoalPilihanGanda
{
    public String pertanyaan[] = {
            "Topi jerami yang dipakai Luffy dititipkan oleh ...",
            "Poseidon berwujud manusia ikan bernama ...",
            "Siapakah nama pencipta One Piece ?",
            "Umur Luffy setelah time skip ...",
            "Berapakah Bounty Luffy yang terbaru ?",
            "Siapakah Raja bajak laut yang telah dieksekusi ?",
            "Kapal pertama kru topi jerami adalah ...",
            "Shicibukai beranggotakan ... orang ",
            "Pulau yang terletak 10.000 meter di atas permukaan air adalah ...",
            "One Piece pernah melakukan Time Skip yaitu ... tahun"
    };

    private String pilihanJawaban[][] = {
            {"Edward Newgate","Gol D. Roger","Akagami Shanks"},
            {"Putri Shirahoshi","Van Der Decken","Neptune"},
            {"Takahashi Rie","Eiichiro Oda","Masashii Kishimoto"},
            {"17","19","21"},
            {"500.000.000 berry","1.500.000.000 berry","1.000.000 berry"},
            {"Gold D. Roger","Gold Roger","Gol D. Roger"},
            {"Going Merry","Thousand Sunny","Black Pearl"},
            {"5","7","9"},
            {"Skypia","Fishman Island","Red Belt"},
            {"2","3","4"},
    };

    private String jawabanBenar[] = {
            "Akagami Shanks",
            "Putri Shirahoshi",
            "Eiichiro Oda",
            "19",
            "1.500.000.000 berry",
            "Gol D. Roger",
            "Going Merry",
            "7",
            "Skypia",
            "2",
    };

    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    //membuat getter untuk mengambil pilihan jawaban 1
    public String getPilihanJawaban1(int x){
        String jawaban1 = pilihanJawaban[x][0];
        return jawaban1;
    }

    //membuat getter untuk mengambil pilihan jawaban 2
    public String getPilihanJawaban2(int x){
        String jawaban2 = pilihanJawaban[x][1];
        return jawaban2;
    }

    //membuat getter untuk mengambil pilihan jawaban 3
    public String getPilihanJawaban3(int x){
        String jawaban3 = pilihanJawaban[x][2];
        return jawaban3;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}
