package com.example.administrator.ac;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {
    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.index);

        TextView main_tab_new_message = (TextView) findViewById(R.id.main_tab_new_message);
        main_tab_new_message.setVisibility(View.VISIBLE);
        main_tab_new_message.setText("10");

        tabHost=this.getTabHost();
        TabHost.TabSpec spec;
        Intent intent;

        intent=new Intent().setClass(this, AddExamActivity.class);
        spec=tabHost.newTabSpec("1111").setIndicator("1111").setContent(intent);
        tabHost.addTab(spec);

        intent=new Intent().setClass(this,MyExamActivity.class);
        spec=tabHost.newTabSpec("2222").setIndicator("2222").setContent(intent);
        tabHost.addTab(spec);

        intent=new Intent().setClass(this, MyMessageActivity.class);
        spec=tabHost.newTabSpec("333333").setIndicator("33333").setContent(intent);
        tabHost.addTab(spec);


        intent=new Intent().setClass(this, SettingActivity.class);
        spec=tabHost.newTabSpec("444").setIndicator("444").setContent(intent);
        tabHost.addTab(spec);
        tabHost.setCurrentTab(1);

        RadioGroup radioGroup=(RadioGroup) this.findViewById(R.id.main_tab_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.main_tab_addExam:
                        tabHost.setCurrentTabByTag("1111");
                        break;
                    case R.id.main_tab_myExam:
                        tabHost.setCurrentTabByTag("22222");
                        break;
                    case R.id.main_tab_message:
                        tabHost.setCurrentTabByTag("3333");
                        break;
                    case R.id.main_tab_settings:
                        tabHost.setCurrentTabByTag("4444");
                        break;
                    default:
                        //tabHost.setCurrentTabByTag("4444");
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
