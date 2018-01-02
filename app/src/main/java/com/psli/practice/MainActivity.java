package com.psli.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextView tvQuestion;
    private TextView tvAnswer0;
    private TextView tvAnswer1;
    private TextView tvAnswer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQuestion = (TextView) findViewById(R.id.question);
        tvAnswer0 = (TextView) findViewById(R.id.answer0);
        tvAnswer1 = (TextView) findViewById(R.id.answer1);
        tvAnswer2 = (TextView) findViewById(R.id.answer2);

        // Database
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference refQuestion = firebaseDatabase.getReference("question");
        refQuestion.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question = (String) dataSnapshot.getValue();
                tvQuestion.setText(question);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
