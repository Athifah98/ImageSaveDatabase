package com.example.user.imagesavedatabase;

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

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<UserModel> userModelArrayList;
    public CustomAdapter(Context context, ArrayList<UserModel> userModelArrayList) {
        this.context = context;
        this.userModelArrayList = userModelArrayList;
    }
    @Override
    public int getCount() {
        return userModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return userModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item, null, true);

            holder.tvjenisaduan = (TextView) convertView.findViewById(R.id.JenisAduan);
            holder.tvnama = (TextView) convertView.findViewById(R.id.Nama);
            holder.tvalamat = (TextView) convertView.findViewById(R.id.Alamat);
            holder.tvtelefon = (TextView) convertView.findViewById(R.id.Telefon);
            holder.tvemel = (TextView) convertView.findViewById(R.id.Emel);
            holder.tvtarikh = (TextView) convertView.findViewById(R.id.Tarikh);
            holder.tvaduan = (TextView) convertView.findViewById(R.id.Aduan);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView3);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvjenisaduan.setText("Jenis Aduan: "+userModelArrayList.get(position).getJenisaduan());
        holder.tvnama.setText("Nama: "+userModelArrayList.get(position).getNama());
        holder.tvalamat.setText("Alamat: "+userModelArrayList.get(position).getAlamat());
        holder.tvtelefon.setText("Telefon: "+userModelArrayList.get(position).getTelefon());
        holder.tvemel.setText("Emel: "+userModelArrayList.get(position).getEmel());
        holder.tvtarikh.setText("Tarikh: "+userModelArrayList.get(position).getTarikh());
        holder.tvaduan.setText("Aduan: "+userModelArrayList.get(position).getAduan());

        byte[] Image =userModelArrayList.get(position).getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(Image, 0, Image.length);
        holder.imageView.setImageBitmap(bitmap);
        return convertView;
    }
    private class ViewHolder {
        protected TextView tvjenisaduan, tvnama, tvalamat, tvtelefon, tvemel, tvtarikh, tvaduan ;
        protected ImageView imageView;
    }
}



