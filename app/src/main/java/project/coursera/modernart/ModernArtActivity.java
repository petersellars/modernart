package project.coursera.modernart;

import android.app.Activity;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ModernArtActivity extends Activity {

    private SeekBar colorControl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modern_art);

        final LinearLayout redBox = (LinearLayout) findViewById(R.id.redBox);
        final LinearLayout cyanBox = (LinearLayout) findViewById(R.id.cyanBox);
        final LinearLayout blueBox = (LinearLayout) findViewById(R.id.blueBox);
        final LinearLayout yellowBox = (LinearLayout) findViewById(R.id.yellowBox);
        final LinearLayout yellowBoxEmbedded = (LinearLayout) findViewById(R.id.yellowBoxEmbedded);
        final LinearLayout greenBox = (LinearLayout) findViewById(R.id.greenBox);
        final LinearLayout brownBox = (LinearLayout) findViewById(R.id.brownBox);
        final LinearLayout brownBoxBottom = (LinearLayout) findViewById(R.id.brownBoxBottom);

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
                setProgressBasedBackgroundColor(yellowBoxEmbedded, originalYellow);
                setProgressBasedBackgroundColor(greenBox, originalGreen);
                setProgressBasedBackgroundColor(brownBox, originalBrown);
                setProgressBasedBackgroundColor(brownBoxBottom, originalBrown);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            private void setProgressBasedBackgroundColor(LinearLayout box, int OriginalBoxColor) {
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
