package com.example.azatkariuly.bainews.newsfragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.azatkariuly.bainews.Adapter;
import com.example.azatkariuly.bainews.FavouriteNewsActivity;
import com.example.azatkariuly.bainews.MainActivity;
import com.example.azatkariuly.bainews.MyAdapter;
import com.example.azatkariuly.bainews.NewsDesc;
import com.example.azatkariuly.bainews.NewsDetail1Activity;
import com.example.azatkariuly.bainews.NewsDetailActivity;
import com.example.azatkariuly.bainews.OpenGLActivity;
import com.example.azatkariuly.bainews.R;
import com.example.azatkariuly.bainews.models.Article;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SavedFragment extends Fragment {

    private TextView txtProfile;

    private FirebaseAuth firebaseAuth;
    private String userEmail;

    LinearLayout mLinearProfile, mLinearLogOut, mLinearOpenGL;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved, container, false);
        setHasOptionsMenu(true);

        txtProfile = view.findViewById(R.id.txt_profile);
        firebaseAuth = FirebaseAuth.getInstance();

        userEmail = firebaseAuth.getCurrentUser().getEmail();
        txtProfile.setText(userEmail);

        mLinearProfile = view.findViewById(R.id.linear_profile);
        mLinearLogOut = view.findViewById(R.id.linear_logout);
        mLinearOpenGL = view.findViewById(R.id.linear_openGL);

        mLinearProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FavouriteNewsActivity.class));
            }
        });

        mLinearLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(), MainActivity.class));
                getActivity().finish();
            }
        });

        mLinearOpenGL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), OpenGLActivity.class));
            }
        });

        return view;
    }
}
