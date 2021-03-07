package com.example.firestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static final String AUTHOR_KEY = "author";
    public static final String QUOTE_KEY = "quote";
    EditText quoteView ;
    EditText authorView ;
    Button btn;

    private FirebaseFirestore mDocRef = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         quoteView = (EditText) findViewById(R.id.quote);
         authorView = (EditText) findViewById(R.id.author);
         btn = (Button) findViewById(R.id.save);
         btn.setBackgroundColor(Color.WHITE);
         btn.setTextColor(Color.BLACK);
    }

    public void saveQuote(View view) {
        String quoteText = quoteView.getText().toString();
        String authorText = authorView.getText().toString();
        if (quoteText.isEmpty() || authorText.isEmpty()) {
            return;
        }
        Map<String, Object> dataToSave = new HashMap<>();
        dataToSave.put(QUOTE_KEY, quoteText);
        dataToSave.put(AUTHOR_KEY, authorText);

        mDocRef.collection("My Notes").document("My First Note").set(dataToSave)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this,"quoteSaved",Toast.LENGTH_SHORT);
                        Log.d("TAG", "Document has been saved! ");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,"Error!",Toast.LENGTH_SHORT);
                        Log.d("TAG",e.toString());
                    }
                });
    }
}