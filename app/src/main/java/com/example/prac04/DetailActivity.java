package com.example.prac04;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String studentJson = getIntent().getStringExtra("student");
        Student student = new Gson().fromJson(studentJson, Student.class);


        TextView textViewFullName = findViewById(R.id.text_view_full_name);
        TextView textViewBirthDate = findViewById(R.id.text_view_birth_date);
        TextView textViewEmail = findViewById(R.id.text_view_email);
        TextView textViewAddress = findViewById(R.id.text_view_address);
        TextView textViewMajor = findViewById(R.id.text_view_major);
        TextView textViewGPA = findViewById(R.id.text_view_gpa);
        ImageView imageViewProfile = findViewById(R.id.image_view_profile);


        textViewFullName.setText(student.getFull_name().getFirst() + " " + student.getFull_name().getLast());
        textViewBirthDate.setText("Birth Date: " + student.getBirth_date());
        textViewEmail.setText("Email: " + student.getEmail());
        textViewAddress.setText("Address: " + student.getAddress());
        textViewMajor.setText("Major: " + student.getMajor());
        textViewGPA.setText("GPA: " + student.getGpa());


    }
}
