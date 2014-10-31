package project.coursera.modernart;

import android.app.Activity;
import android.app.DialogFragment;
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

        final TextView redBox = (TextView) findViewById(R.id.redBox);
        final TextView cyanBox = (TextView) findViewById(R.id.cyanBox);
        final TextView blueBox = (TextView) findViewById(R.id.blueBox);
        final TextView yellowBox = (TextView) findViewById(R.id.yellowBox);
        final TextView greenBox = (TextView) findViewById(R.id.greenBox);
        final TextView brownBox = (TextView) findViewById(R.id.brownBox);
        final TextView brownBox2 = (TextView) findViewById(R.id.brownBox2);

        final int originalRed = ((ColorDrawable) redBox.getBackground()).getColor();
        final int originalCyan = ((ColorDrawable) cyanBox.getBackground()).getColor();
        final int originalBlue = ((ColorDrawable) blueBox.getBackground()).getColor();
        final int originalYellow = ((ColorDrawable) yellowBox.getBackground()).getColor();
        final int originalGreen = ((ColorDrawable) greenBox.getBackground()).getColor();
        final int originalBrown = ((ColorDrawable) brownBox.getBackground()).getColor();

        colorControl = (SeekBar) findViewById(R.id.colorControl);
        colorControl.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progressChanged = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                // Log.d("DEBUG", "Progress is " + progressChanged);
                setProgressBasedBackgroundColor(redBox, originalRed);
                setProgressBasedBackgroundColor(cyanBox, originalCyan);
                setProgressBasedBackgroundColor(blueBox, originalBlue);
                setProgressBasedBackgroundColor(yellowBox, originalYellow);
                setProgressBasedBackgroundColor(greenBox, originalGreen);
                setProgressBasedBackgroundColor(brownBox, originalBrown);
                setProgressBasedBackgroundColor(brownBox2, originalBrown);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            private void setProgressBasedBackgroundColor(TextView box, int OriginalBoxColor) {
                float[] hsvColor = new float[3];
                Color.colorToHSV(OriginalBoxColor, hsvColor);
                hsvColor[0] = hsvColor[0] + progressChanged;
                hsvColor[0] = hsvColor[0] % 360;
                box.setBackgroundColor(Color.HSVToColor(Color.alpha(OriginalBoxColor), hsvColor));
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
        if (id == R.id.action_more_information) {
            DialogFragment moreInfoFragment = new MoreInfoDialogFragment();
            moreInfoFragment.show(getFragmentManager(), "moreInfo");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
