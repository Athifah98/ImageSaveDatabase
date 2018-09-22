package com.example.user.imagesavedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.user.imagesavedatabase.MainActivity.imageViewToByte;

public class UpdateDeleteActivity extends AppCompatActivity {
    private UserModel userModel;
    private EditText  etjenisaduan, etnama, etalamat, ettelefon, etemel, ettarikh , etaduan;
    private Button btnupdate, btndelete;
    private ImageView imageView;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);
        Intent intent = getIntent();

        userModel = (UserModel) intent.getSerializableExtra("user");
        databaseHelper = new DatabaseHelper(this);

        etjenisaduan = (EditText) findViewById(R.id.etJenisAduan);
        etnama = (EditText) findViewById(R.id.etNama);
        etalamat = (EditText) findViewById(R.id.etAlamat);
        ettelefon = (EditText) findViewById(R.id.etTelefon);
        etemel = (EditText) findViewById(R.id.etEmel);
        ettarikh = (EditText) findViewById(R.id.etTarikh);
        etaduan = (EditText) findViewById(R.id.etAduan);
        imageView = (ImageView) findViewById(R.id.imageView);;
        btndelete = (Button) findViewById(R.id.btndelete);
        btnupdate = (Button) findViewById(R.id.btnupdate);

        etjenisaduan.setText(userModel.getJenisaduan());
        etnama.setText(userModel.getNama());
        etalamat.setText(userModel.getAlamat());
        ettelefon.setText(userModel.getTelefon());
        etemel.setText(userModel.getEmel());
        ettarikh.setText(userModel.getTarikh());
        etaduan.setText(userModel.getAduan());
        MainActivity.imageViewToByte(imageView);


        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.updateUser(userModel.getId(), etjenisaduan.getText().toString(),etnama.getText().toString(),
                        etalamat.getText().toString(), ettelefon.getText().toString(), etemel.getText().toString(),
                        ettarikh.getText().toString(), etaduan.getText().toString(), MainActivity.imageViewToByte(imageView));


                Toast.makeText(UpdateDeleteActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(UpdateDeleteActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteUSer(userModel.getId());
                Toast.makeText(UpdateDeleteActivity.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateDeleteActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}

