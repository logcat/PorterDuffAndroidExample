package com.example.porterduff;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Mode[] mPorterDuffModes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView) findViewById(R.id.grid);
        mPorterDuffModes = new PorterDuff.Mode[] {Mode.ADD, Mode.CLEAR, Mode.DARKEN, Mode.DST, Mode.DST_ATOP, Mode.DST_IN, Mode.DST_OUT, Mode.DST_OVER, Mode.LIGHTEN, Mode.MULTIPLY, Mode.OVERLAY, Mode.SCREEN, Mode.SCREEN, Mode.SRC, Mode.SRC_ATOP, Mode.SRC_IN, Mode.SRC_OUT, Mode.SRC_OVER, Mode.XOR};
        grid.setAdapter(new PorterDuffAdapter());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private class PorterDuffAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mPorterDuffModes.length;
        }

        @Override
        public Mode getItem(int position) {
            return mPorterDuffModes[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = new TextView(MainActivity.this);
            }
            
            TextView image = (TextView) convertView;
            
            Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);
            drawable = new BitmapDrawable(((BitmapDrawable) drawable).getBitmap());
            drawable.setColorFilter(Color.GREEN, getItem(position));
            drawable.setBounds(0, 0, 60, 60);
            image.setText(getItem(position).toString());
            image.setCompoundDrawables(null, null, drawable, null);
            
            return image;
        }
        
    }
    
}
