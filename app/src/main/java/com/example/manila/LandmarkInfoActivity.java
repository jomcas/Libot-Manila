package com.example.manila;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class LandmarkInfoActivity extends AppCompatActivity {
    private ImageView imageView;
    private ImageView imageView1;
    private ImageView imageView3;
    private LinearLayout layout;
    private Button Goback;
    private Button ViewButton;
    private TextView text;
    private DatabaseHelperForUsers mydb;
    private ImageView AddButton;
    private int UserID;
    private int LandmarksID;
    private Calendar calendar;
    private TextView Title;
    private TextView Address;
    private SimpleDateFormat dateFormat;
    private String date;
    private String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landmark_info);
        mydb = new DatabaseHelperForUsers(this);
        imageView=findViewById(R.id.picture);
        Title=findViewById(R.id.tvLandTitle);
        Address=findViewById(R.id.tvLandAddress);
        layout=findViewById(R.id.InnerLayout);
        Goback=findViewById(R.id.btnBack);
        ViewButton=findViewById(R.id.btnViewDetails);
        imageView1=findViewById(R.id.imageViewFirst);
        imageView3=findViewById(R.id.imageViewThird);
        text=findViewById(R.id.tvDetails);
        Goback.setVisibility(View.GONE);
        AddButton=findViewById(R.id.AddButton2);
        calendar = Calendar.getInstance();
        String landmarks = getIntent().getStringExtra("Title");
        Title.setText(landmarks);
        user = getIntent().getStringExtra("User");
        UserID=mydb.getIDFromTableUser(user);
        LandmarksID=mydb.getIDFromTableLandmarks(landmarks);
        if(mydb.CheckIfUser_ListExist(UserID,LandmarksID)){
            AddButton.setClickable(false);
            AddButton.setVisibility(View.GONE);
        }

        Toast.makeText(this, landmarks, Toast.LENGTH_SHORT).show();
        CreateSomething(landmarks);
    }
    public void CreateSomething(String Title){
        mydb = new DatabaseHelperForUsers(this);
        if(Title.equals("National Planetarium")){
            imageView.setImageResource(R.drawable.rizal);
            imageView1.setImageResource(R.drawable.rizal);
            imageView3.setImageResource(R.drawable.rizal);
            Address.setText(mydb.getLandmarkAdress(Title));
            text.setText(mydb.Description("National Planetarium"));
        }else if(Title.equals("National Museum of Fine Arts")){
            imageView.setImageResource(R.drawable.nationalmuseumoffinearts);
            imageView1.setImageResource(R.drawable.nationalmuseumoffinearts);

            imageView3.setImageResource(R.drawable.nationalmuseumoffinearts);
            Address.setText(mydb.getLandmarkAdress(Title));
            text.setText(mydb.Description("National Museum of Fine Arts"));
        }else if(Title.equals("National Museum of Natural History")){
            imageView.setImageResource(R.drawable.nationalmuseumofhistory);
            imageView1.setImageResource(R.drawable.nationalmuseumofhistory);
            imageView3.setImageResource(R.drawable.nationalmuseumofhistory);
            Address.setText(mydb.getLandmarkAdress(Title));
            text.setText(mydb.Description("National Museum of Natural History"));
        }
    }
    public void onClickAddFromLandmarkInfo(View view){
        mydb = new DatabaseHelperForUsers(this);
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = dateFormat.format(calendar.getTime());
        Boolean inserted=mydb.insertDataInUserVisit(UserID,LandmarksID,date);
        if(inserted){
            Toast.makeText(this, "Successfully Inserted", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.putExtra("User", user);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Failed to insert", Toast.LENGTH_SHORT).show();
        }


    }
    public void ViewDetails(View view){
    layout.setVisibility(View.GONE);
    ViewButton.setVisibility(View.GONE);
    Goback.setVisibility(View.VISIBLE);
    }

    public void GoBack(View view){
        Goback.setVisibility(View.GONE);
        layout.setVisibility(View.VISIBLE);
        ViewButton.setVisibility(View.VISIBLE);
    }


}
