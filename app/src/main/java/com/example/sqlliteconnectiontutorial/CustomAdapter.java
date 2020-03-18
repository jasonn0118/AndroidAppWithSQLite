package com.example.sqlliteconnectiontutorial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList book_id, book_title, book_author, book_pages;
    Animation translate_anim;

    public CustomAdapter(Activity activity, Context context, ArrayList book_id, ArrayList book_title, ArrayList book_author, ArrayList book_pages) {
        this.activity = activity;
        this.context = context;
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_pages = book_pages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.txtBookid.setText(String.valueOf(book_id.get(position)));
        holder.txtBookTitle.setText(String.valueOf(book_title.get(position)));
        holder.txtBookAuthor.setText(String.valueOf(book_author.get(position)));
        holder.txtBookPages.setText(String.valueOf(book_pages.get(position)));
        holder.myRowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(book_id.get(position)));
                intent.putExtra("title", String.valueOf(book_title.get(position)));
                intent.putExtra("author", String.valueOf(book_author.get(position)));
                intent.putExtra("pages", String.valueOf(book_pages.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtBookid, txtBookTitle, txtBookAuthor, txtBookPages;
        LinearLayout myRowLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            txtBookid = itemView.findViewById(R.id.txtBook_id);
            txtBookTitle = itemView.findViewById(R.id.txtBook_Title);
            txtBookAuthor = itemView.findViewById(R.id.txtBook_Author);
            txtBookPages = itemView.findViewById(R.id.txtBook_pages);
            myRowLayout = itemView.findViewById(R.id.my_row);

            //Animate RecycleView
            translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            myRowLayout.setAnimation(translate_anim);


        }
    }
}
