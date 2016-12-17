package com.gmonetix.menu;

        import android.content.Context;
        import android.content.SharedPreferences;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.Menu;
        import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String TAG = "save";
    private static final String COLOR = "color";
    int color_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //checks if shared preference contains stored colors
        sharedPreferences = getSharedPreferences(TAG , Context.MODE_PRIVATE);
        if(sharedPreferences.contains(COLOR)){
            int name = sharedPreferences.getInt(COLOR,0);
            toolbar.setBackgroundColor(name);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        editor = sharedPreferences.edit();
        switch (id){
            case R.id.red:
                color_code = Color.RED;
                editor.putInt(COLOR,color_code);
                editor.commit();
                if(item.isChecked())
                    item.setChecked(false);
                else item.setChecked(true);
                toolbar.setBackgroundColor(color_code);
                return  true;
            case R.id.blue:
                color_code = Color.BLACK;
                editor.putInt(COLOR,color_code);
                editor.commit();
                if(item.isChecked())
                    item.setChecked(false);
                else item.setChecked(true);
                toolbar.setBackgroundColor(color_code);
                return  true;
            case R.id.green:
                color_code = Color.GREEN;
                editor.putInt(COLOR,color_code);
                editor.commit();
                if(item.isChecked())
                    item.setChecked(false);
                else item.setChecked(true);
                toolbar.setBackgroundColor(color_code);
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
