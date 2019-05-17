package com.example.newopedia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class KarakterListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<karakter> karaktersList;

    public KarakterListAdapter(Context context, int layout, ArrayList<karakter> karaktersList) {
        this.context = context;
        this.layout = layout;
        this.karaktersList = karaktersList;
    }

    @Override
    public int getCount() {
        return karaktersList.size();
    }

    @Override
    public Object getItem(int position) {
        return karaktersList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtnama;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtnama = (TextView) row.findViewById(R.id.txtnama);
            holder.imageView = (ImageView) row.findViewById(R.id.imgkarakter);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        karakter karakter = karaktersList.get(position);

        holder.txtnama.setText(karakter.getNama());

        byte[] karakterImage = karakter.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(karakterImage, 0, karakterImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}

