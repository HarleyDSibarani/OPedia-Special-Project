package com.example.newopedia;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MusicPlayer extends AppCompatActivity implements View.OnClickListener {

    //Deklarasi Variable
    private Button Play, Pause, Stop;
    private Button Play2, Pause2, Stop2;
    private Button Play3, Pause3, Stop3;
    private Button Play4, Pause4, Stop4;
    private Button Play5, Pause5, Stop5;

    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaPlayer3;
    private MediaPlayer mediaPlayer4;
    private MediaPlayer mediaPlayer5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        //Inisialisasi Button
        Play = findViewById(R.id.play);
        Pause = findViewById(R.id.pause);
        Stop = findViewById(R.id.stop);

        Play2 = findViewById(R.id.play2);
        Pause2 = findViewById(R.id.pause2);
        Stop2 = findViewById(R.id.stop2);

        Play3 = findViewById(R.id.play3);
        Pause3 = findViewById(R.id.pause3);
        Stop3 = findViewById(R.id.stop3);

        Play4 = findViewById(R.id.play4);
        Pause4 = findViewById(R.id.pause4);
        Stop4 = findViewById(R.id.stop4);

        Play5 = findViewById(R.id.play5);
        Pause5 = findViewById(R.id.pause5);
        Stop5 = findViewById(R.id.stop5);

        //Menambahkan Listener pada Button
        Play.setOnClickListener(this);
        Pause.setOnClickListener(this);
        Stop.setOnClickListener(this);

        Play2.setOnClickListener(this);
        Pause2.setOnClickListener(this);
        Stop2.setOnClickListener(this);

        Play3.setOnClickListener(this);
        Pause3.setOnClickListener(this);
        Stop3.setOnClickListener(this);

        Play4.setOnClickListener(this);
        Pause4.setOnClickListener(this);
        Stop4.setOnClickListener(this);

        Play5.setOnClickListener(this);
        Pause5.setOnClickListener(this);
        Stop5.setOnClickListener(this);

        stateAwal();
    }

    //Untuk menentukan kondisi saat aplikasi pertama kali berjalan
    private void stateAwal() {
        Play.setEnabled(true);
        Pause.setEnabled(false);
        Stop.setEnabled(false);

        Play2.setEnabled(true);
        Pause2.setEnabled(false);
        Stop2.setEnabled(false);

        Play3.setEnabled(true);
        Pause3.setEnabled(false);
        Stop3.setEnabled(false);

        Play4.setEnabled(true);
        Pause4.setEnabled(false);
        Stop4.setEnabled(false);

        Play5.setEnabled(true);
        Pause5.setEnabled(false);
        Stop5.setEnabled(false);

    }

    //Method untuk memainkan musik
    private void playAudio() {
        mediaPlayer = MediaPlayer.create(MusicPlayer.this, R.raw.hikari);
        Play.setEnabled(false);
        Pause.setEnabled(true);
        Stop.setEnabled(true);

        Play3.setEnabled(false);
        Pause3.setEnabled(false);
        Stop3.setEnabled(false);

        Play2.setEnabled(false);
        Pause2.setEnabled(false);
        Stop2.setEnabled(false);

        Play4.setEnabled(false);
        Pause4.setEnabled(false);
        Stop4.setEnabled(false);

        Play5.setEnabled(false);
        Pause5.setEnabled(false);
        Stop5.setEnabled(false);


        try {
            mediaPlayer.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    private void playAudio2() {
        mediaPlayer2 = MediaPlayer.create(MusicPlayer.this, R.raw.wecan);
        Play2.setEnabled(false);
        Pause2.setEnabled(true);
        Stop2.setEnabled(true);

        Play.setEnabled(false);
        Pause.setEnabled(false);
        Stop.setEnabled(false);

        Play3.setEnabled(false);
        Pause3.setEnabled(false);
        Stop3.setEnabled(false);

        Play4.setEnabled(false);
        Pause4.setEnabled(false);
        Stop4.setEnabled(false);

        Play5.setEnabled(false);
        Pause5.setEnabled(false);
        Stop5.setEnabled(false);

        try {
            mediaPlayer2.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer2.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    private void playAudio3() {
        mediaPlayer3 = MediaPlayer.create(MusicPlayer.this, R.raw.run);
        Play3.setEnabled(false);
        Pause3.setEnabled(true);
        Stop3.setEnabled(true);

        Play.setEnabled(false);
        Pause.setEnabled(false);
        Stop.setEnabled(false);

        Play2.setEnabled(false);
        Pause2.setEnabled(false);
        Stop2.setEnabled(false);

        Play4.setEnabled(false);
        Pause4.setEnabled(false);
        Stop4.setEnabled(false);

        Play5.setEnabled(false);
        Pause5.setEnabled(false);
        Stop5.setEnabled(false);

        try {
            mediaPlayer3.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer3.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    private void playAudio4() {
        mediaPlayer4 = MediaPlayer.create(MusicPlayer.this, R.raw.therootles);
        Play3.setEnabled(false);
        Pause3.setEnabled(false);
        Stop3.setEnabled(false);

        Play.setEnabled(false);
        Pause.setEnabled(false);
        Stop.setEnabled(false);

        Play2.setEnabled(false);
        Pause2.setEnabled(false);
        Stop2.setEnabled(false);

        Play4.setEnabled(false);
        Pause4.setEnabled(true);
        Stop4.setEnabled(true);

        Play5.setEnabled(false);
        Pause5.setEnabled(false);
        Stop5.setEnabled(false);

        try {
            mediaPlayer4.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer4.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    private void playAudio5() {
        mediaPlayer5 = MediaPlayer.create(MusicPlayer.this, R.raw.handsup);
        Play3.setEnabled(false);
        Pause3.setEnabled(false);
        Stop3.setEnabled(false);

        Play.setEnabled(false);
        Pause.setEnabled(false);
        Stop.setEnabled(false);

        Play2.setEnabled(false);
        Pause2.setEnabled(false);
        Stop2.setEnabled(false);

        Play4.setEnabled(false);
        Pause4.setEnabled(false);
        Stop4.setEnabled(false);

        Play5.setEnabled(false);
        Pause5.setEnabled(true);
        Stop5.setEnabled(true);

        try {
            mediaPlayer5.prepare();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        mediaPlayer5.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    //Method untuk mengentikan musik
    private void pauseAudio() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer.isPlaying()) {
            if (mediaPlayer != null) {
                mediaPlayer.pause();
                Pause.setText("Lanjut");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer != null) {
                mediaPlayer.start();
                Pause.setText("Pause");
            }
        }
    }

    private void pauseAudio2() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer2.isPlaying()) {
            if (mediaPlayer2 != null) {
                mediaPlayer2.pause();
                Pause2.setText("Lanjut");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer2 != null) {
                mediaPlayer2.start();
                Pause2.setText("Pause");
            }
        }
    }

    private void pauseAudio3() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer3.isPlaying()) {
            if (mediaPlayer3 != null) {
                mediaPlayer3.pause();
                Pause3.setText("Lanjut");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer3 != null) {
                mediaPlayer3.start();
                Pause3.setText("Pause");
            }
        }
    }

    private void pauseAudio4() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer4.isPlaying()) {
            if (mediaPlayer4 != null) {
                mediaPlayer4.pause();
                Pause4.setText("Lanjut");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer4 != null) {
                mediaPlayer4.start();
                Pause4.setText("Pause");
            }
        }
    }

    private void pauseAudio5() {
        //Jika audio sedang dimainkan, maka audio dapat di pause
        if (mediaPlayer5.isPlaying()) {
            if (mediaPlayer5 != null) {
                mediaPlayer5.pause();
                Pause5.setText("Lanjut");
            }
        } else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if (mediaPlayer5 != null) {
                mediaPlayer5.start();
                Pause5.setText("Pause");
            }
        }
    }

    //Method untuk mengakhiri musik
    private void stopAudio() {
        mediaPlayer.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        stateAwal();
    }

    private void stopAudio2() {
        mediaPlayer2.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer2.prepare();
            mediaPlayer2.seekTo(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        stateAwal();
    }

    private void stopAudio3() {
        mediaPlayer3.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer3.prepare();
            mediaPlayer3.seekTo(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        stateAwal();
    }

    private void stopAudio4() {
        mediaPlayer4.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer4.prepare();
            mediaPlayer4.seekTo(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        stateAwal();
    }

    private void stopAudio5() {
        mediaPlayer3.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer5.prepare();
            mediaPlayer5.seekTo(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        stateAwal();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                playAudio();
                break;

            case R.id.pause:
                pauseAudio();
                break;

            case R.id.stop:
                stopAudio();
                break;

            case R.id.play2:
                playAudio2();
                break;

            case R.id.pause2:
                pauseAudio2();
                break;

            case R.id.stop2:
                stopAudio2();
                break;

            case R.id.play3:
                playAudio3();
                break;

            case R.id.pause3:
                pauseAudio3();
                break;

            case R.id.stop3:
                stopAudio3();
                break;

            case R.id.play4:
                playAudio4();
                break;

            case R.id.pause4:
                pauseAudio4();
                break;

            case R.id.stop4:
                stopAudio4();
                break;

            case R.id.play5:
                playAudio5();
                break;

            case R.id.pause5:
                pauseAudio5();
                break;

            case R.id.stop5:
                stopAudio5();
                break;
        }
    }
}
