package project.coursera.modernart;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class ModernArtActivity extends Activity {

    private SeekBar colorControl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modern_art);

        final TextView test = (TextView) findViewById(R.id.blackBox);
        final ColorDrawable testCD = (ColorDrawable) test.getBackground();
        final TextView test2 = (TextView) findViewById(R.id.cyanBox);
        final ColorDrawable testCD2 = (ColorDrawable) test2.getBackground();

        colorControl = (SeekBar) findViewById(R.id.colorControl);
        colorControl.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progressChanged = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                Log.d("DEBUG", "Progress is " + progressChanged);
                test.setBackgroundColor(
                        Color.argb(255 - progressChanged,
                                Color.red(testCD.getColor()),
                                Color.green(testCD.getColor()),
                                Color.blue(testCD.getColor())));
                test2.setBackgroundColor(
                        Color.argb(255 - progressChanged,
                                Color.red(testCD2.getColor()),
                                Color.green(testCD2.getColor()),
                                Color.blue(testCD2.getColor())));
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modern_art, menu);
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
