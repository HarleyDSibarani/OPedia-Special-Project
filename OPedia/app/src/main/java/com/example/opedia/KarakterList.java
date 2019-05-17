package com.example.newopedia;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;


public class KarakterList extends AppCompatActivity {

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

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                CharSequence[] items = {"Update", "Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(KarakterList.this);

                dialog.setTitle("Choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (item == 0) {
                            Cursor c = MainActivity.sqLiteHelper.getData("SELECT id FROM KARAKTER");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            // show dialog update at here
                            showDialogUpdate(KarakterList.this, arrID.get(position));

                        } else {
                            // delete
                            Cursor c = MainActivity.sqLiteHelper.getData("SELECT id FROM KARAKTER");
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            showDialogDelete(arrID.get(position));
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });
    }

    ImageView imageViewKarakter;
    private void showDialogUpdate(Activity activity, final int position){

        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.update_karakter_activity);
        dialog.setTitle("Update");

        imageViewKarakter = (ImageView) dialog.findViewById(R.id.imageKarakter);
        final EditText edtNama = (EditText) dialog.findViewById(R.id.edtNama);
        final EditText edtJk = (EditText) dialog.findViewById(R.id.edtJk);
        final EditText edtBounty = (EditText) dialog.findViewById(R.id.edtBounty);
        final EditText edtAnggota = (EditText) dialog.findViewById(R.id.edtAnggota);
        final EditText edtPosisi = (EditText) dialog.findViewById(R.id.edtPosisi);
        final EditText edtHaki = (EditText) dialog.findViewById(R.id.edtHaki);
        final EditText edtBuah = (EditText) dialog.findViewById(R.id.edtBuah);
        final EditText edtTipe = (EditText) dialog.findViewById(R.id.edtTippe);
        final EditText edtBiografi = (EditText) dialog.findViewById(R.id.edtBiografi);
        Button btnUpdate = (Button) dialog.findViewById(R.id.btnUpdate);

        // set width for dialog
        int width = (int) (activity.getResources().getDisplayMetrics().widthPixels * 0.95);
        // set height for dialog
        int height = (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.7);
        dialog.getWindow().setLayout(width, height);
        dialog.show();

        imageViewKarakter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // request photo library
                ActivityCompat.requestPermissions(
                        KarakterList.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        888
                );
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    MainActivity.sqLiteHelper.updateData(
                            edtNama.getText().toString().trim(),
                            edtJk.getText().toString().trim(),
                            edtBounty.getText().toString().trim(),
                            edtAnggota.getText().toString().trim(),
                            edtPosisi.getText().toString().trim(),
                            edtHaki.getText().toString().trim(),
                            edtBuah.getText().toString().trim(),
                            edtTipe.getText().toString().trim(),
                            edtBiografi.getText().toString().trim(),
                            MainActivity.imageViewToByte(imageViewKarakter),
                            position
                    );
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Update successfully!!!", Toast.LENGTH_SHORT).show();
                }
                catch (Exception error) {
                    Log.e("Update error", error.getMessage());
                }
                updateKarakterList();
            }
        });
    }

    private void showDialogDelete(final int idkarakter){
        final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(KarakterList.this);

        dialogDelete.setTitle("Warning!!");
        dialogDelete.setMessage("Are you sure you want to this delete?");
        dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    MainActivity.sqLiteHelper.deleteData(idkarakter);
                    Toast.makeText(getApplicationContext(), "Delete successfully!!!", Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Log.e("error", e.getMessage());
                }
                updateKarakterList();
            }
        });

        dialogDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogDelete.show();
    }

    private void updateKarakterList(){
        // get all data from sqlite
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

            list.add(new karakter(id,nama,jenis_kelamin,bounty,anggota,posisi,haki,buah_iblis,tipe_buah,biografi , image));
        }
        adapter.notifyDataSetChanged();
    }

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
