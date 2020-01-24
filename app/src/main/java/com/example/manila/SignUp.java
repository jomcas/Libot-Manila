package com.example.manila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
   private EditText etFirstName, etLastName, etEmail, etPassword, etConfirm;
   private Button btnRegister, btnCancel;
    private DatabaseHelperForUsers mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
//        etConfirm = (EditText) findViewById(R.id.etConfirm);
        btnCancel = (Button) findViewById(R.id.btnSignIn);
//        etConfirm.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if(!etPassword.getText().toString().equals(etConfirm.getText().toString())){
//                    Toast.makeText(SignUp.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

    public void register(View view) {
        if(etFirstName.getText().toString().isEmpty()||etLastName.getText().toString().isEmpty()||etEmail.getText().toString().isEmpty()||etPassword.getText().toString().isEmpty()){
            Toast.makeText(this, "Fill all the TextField", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()){
            Toast.makeText(this, "Enter a Valid Email", Toast.LENGTH_SHORT).show();
            return;
        }
//        if(!etConfirm.getText().toString().equals(etPassword.getText().toString())){
//            Toast.makeText(SignUp.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
//            return;
//        }

        mydb= new DatabaseHelperForUsers(this);
        SQLiteDatabase db = mydb.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Accounts_List WHERE Email = ? ", new String[]{etEmail.getText().toString()});

        if(res.getCount()==0){
            Boolean inserted=mydb.insertData(etFirstName.getText().toString(),etLastName.getText().toString(),etEmail.getText().toString(),etPassword.getText().toString(),1,0);
            if(inserted){
                Toast.makeText(SignUp.this, "Successfully Inserted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,SignIn.class));
            }else{
                Toast.makeText(SignUp.this, "Failed to insert", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Email is already taken", Toast.LENGTH_SHORT).show();
        }



    }

    public void cancel(View view) {
        startActivity(new Intent(this, Start.class));
    }
}


