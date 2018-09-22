package com.example.user.imagesavedatabase;

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
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class GetAllUsersActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<UserModel> userModelArrayList;
    private CustomAdapter customAdapter;
    private DatabaseHelper databaseHelper;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_users);

        listView = (ListView) findViewById(R.id.lv);
        databaseHelper = new DatabaseHelper(this);
        userModelArrayList = databaseHelper.getAllUsers();
        customAdapter = new CustomAdapter(this, userModelArrayList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GetAllUsersActivity.this, UpdateDeleteActivity.class);
                intent.putExtra("user", userModelArrayList.get(position));
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 888 && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
                // give your image file url in mCurrentPhotoPath


                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                // In case you want to compress your image, here it's at 40%
                bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();



            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        byte[] byteArray;

        super.onActivityResult(requestCode, resultCode, data);
    }

//    private String getBase64String() {

      //  InputStream inputStream = getContentResolver().openInputStream(uri);

        // give your image file url in mCurrentPhotoPath
      //  Bitmap bitmap = BitmapFactory.decodeFile(inputStream);
      //  ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // In case you want to compress your image, here it's at 40%
      //  bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
        //byte[] byteArray = byteArrayOutputStream.toByteArray();
      //  return Base64.encodeToString(byteArray, Base64.DEFAULT);
    //}



   // private void decodeBase64AndSetImage(String completeImageData, ImageView imageView) {

        // Incase you're storing into aws or other places where we have extension stored in the starting.
      //  String imageDataBytes = completeImageData.substring(completeImageData.indexOf(",") + 1);

      //  InputStream stream = new ByteArrayInputStream(Base64.decode(imageDataBytes.getBytes(), Base64.DEFAULT));

      //  Bitmap bitmap = BitmapFactory.decodeStream(stream);

     //   imageView.setImageBitmap(bitmap);

   // }
}

