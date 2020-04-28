package com.example.convert.view.java;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.convert.R;
import com.example.convert.view.simple.MySimpleActivity;
import com.example.convert.view.simple.MySimplePresenter;
import kotlin.Lazy;

import static org.koin.java.KoinJavaComponent.inject;

public class JavaActivity extends AppCompatActivity {

    private Lazy<MySimplePresenter> presenter = inject(MySimplePresenter.class);
    private Lazy<MyJavaPresenter> javaPresenter = inject(MyJavaPresenter.class);

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        setTitle("MyJavaActivity");

        TextView text = findViewById(R.id.text);
        ConstraintLayout background = findViewById(R.id.background);

        text.setText(presenter.getValue().sayHello() + "\n" + javaPresenter.getValue().sayHello());

        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), MySimpleActivity.class));
            }
        });
    }
}
