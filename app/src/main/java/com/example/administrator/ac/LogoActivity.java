package com.example.administrator.ac;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.administrator.slidingmenu.view.SlidingMenu;

public class LogoActivity extends Activity {
    private ProgressBar progressBar;
    private Button backButton;

    private SlidingMenu mLeftMenu;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去除标题
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mLeftMenu = (SlidingMenu) findViewById(R.id.id_menu);

//        progressBar = (ProgressBar) findViewById(R.id.pgBar);
//        backButton = (Button) findViewById(R.id.btn_back);
//        progressBar.setMax(3000);
//
//        Intent intent = new Intent(this, MainActivity.class);
//        LogoActivity.this.startActivity(intent);
//
//        backButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                finish();
//
//            }
//        });

    }
    public void toggleMenu(View view)
    {
        mLeftMenu.toggle();
    }

}
