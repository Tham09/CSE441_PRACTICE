package com.example.prac04;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private List<Student> students;
    private Context context;

    public StudentAdapter(List<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = students.get(position);
        holder.textViewName.setText(student.getFull_name().getFirst() + " " + student.getFull_name().getLast());
        holder.textViewCode.setText(student.getId());
        holder.textViewGpa.setText(String.valueOf(student.getGpa()));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("student", new Gson().toJson(student)); // Pass student data
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName, textViewCode, textViewGpa;
        public ImageView imageViewProfile;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewCode = itemView.findViewById(R.id.text_view_code);
            textViewGpa = itemView.findViewById(R.id.text_view_gpa);
            imageViewProfile = itemView.findViewById(R.id.image_view_profile);
        }
    }
}
