package com.example.newopedia;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;


public class KarakterList_User extends AppCompatActivity {

    GridView gridView;
    ArrayList<karakter> list;
    KarakterListAdapter adapter = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karaker_list);

        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new KarakterListAdapter(this, R.layout.karakter_item, list);
        gridView.setAdapter(adapter);

        //mendapatkan data dari sqlite
        Cursor cursor = MainActivity.sqLiteHelper.getData("SELECT * FROM KARAKTER");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String nama = cursor.getString(1);
            String jenis_kelamin = cursor.getString(2);
            String bounty = cursor.getString(3);
            String anggota = cursor.getString(4);
            String posisi = cursor.getString(5);
            String haki = cursor.getString(6);
            String buah_iblis = cursor.getString(7);
            String tipe_buah = cursor.getString(8);
            String biografi = cursor.getString(9);
            byte[] image = cursor.getBlob(10);

            list.add(new karakter(id,nama,jenis_kelamin,bounty,anggota,posisi,haki,buah_iblis,tipe_buah,biografi, image));
        }
        adapter.notifyDataSetChanged();

        gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c = MainActivity.sqLiteHelper.getData("SELECT id FROM KARAKTER");
                ArrayList<Integer> arrID = new ArrayList<Integer>();
                while (c.moveToNext()){
                    arrID.add(c.getInt(0));
                }
            }
        });

    }

    ImageView imageViewKarakter;
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 888){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 888);
            }
            else {
                Toast.makeText(getApplicationContext(), "You don't have permission to access file location!", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 888 && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageViewKarakter.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}

