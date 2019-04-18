package com.example.azatkariuly.bainews;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FavouriteNewsActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseBook;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<NewsDesc> list = new ArrayList<>();
    private String userEmail;
    private MyAdapter myAdapter;
    private TextView txtSaved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_news);

        txtSaved = findViewById(R.id.txt_saved);


        firebaseAuth = FirebaseAuth.getInstance();

        userEmail = firebaseAuth.getCurrentUser().getEmail();

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        databaseBook = FirebaseDatabase.getInstance().getReference(encodeUserEmail(userEmail));

        databaseBook.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!list.isEmpty()) {
                    list.clear();
                }
                txtSaved.setVisibility(View.INVISIBLE);

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    NewsDesc newsDesc = dataSnapshot1.getValue(NewsDesc.class);
                    list.add(newsDesc);
                }

                myAdapter = new MyAdapter(list, FavouriteNewsActivity.this);
                recyclerView.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();


                initListener();

                if (list.isEmpty()) {
                    txtSaved.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    static String encodeUserEmail(String userEmail) {
        return userEmail.replace(".", ",");
    }

    static String decodeUserEmail(String userEmail) {
        return userEmail.replace(",", ".");
    }

    private void initListener() {
        myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ImageView imageView = view.findViewById(R.id.img);

                Intent intent = new Intent(FavouriteNewsActivity.this, NewsDetail1Activity.class);

                NewsDesc article = list.get(position);
                intent.putExtra("url", article.getmUrl());
                intent.putExtra("title", article.getmTitle());
                intent.putExtra("img", article.getmImg());
                intent.putExtra("date", article.getmDate());
                intent.putExtra("source", article.getmSource());
                intent.putExtra("author", article.getmAuthor());

                Pair<View, String> pair = Pair.create((View) imageView, ViewCompat.getTransitionName(imageView));
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        FavouriteNewsActivity.this,
                        pair
                );

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    startActivity(intent, optionsCompat.toBundle());
                } else {
                    startActivity(intent);
                }
            }
        });
    }

}
