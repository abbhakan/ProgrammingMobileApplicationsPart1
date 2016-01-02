package modernuilab.labs.course.modernartui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    static private final String URL = "http://www.moma.org";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView textViewRed = (TextView) findViewById(R.id.textViewRed);
        final TextView textViewBlue = (TextView) findViewById(R.id.textViewBlue);
        final TextView textViewGreen = (TextView) findViewById(R.id.textViewGreen);
        final TextView textViewWhite = (TextView) findViewById(R.id.textViewWhite);
        final TextView textViewYellow = (TextView) findViewById(R.id.textViewYellow);

        final SeekBar sk=(SeekBar) findViewById(R.id.seekBar);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int currentProgress = 0;

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stub
                currentProgress = progress;

                if (currentProgress < 10) {
                    textViewRed.setBackgroundResource(R.color.red1);
                    textViewBlue.setBackgroundResource(R.color.blue1);
                    textViewGreen.setBackgroundResource(R.color.green1);
                    textViewYellow.setBackgroundResource(R.color.yellow1);
                }
                else {

                    switch (currentProgress) {
                        case 10:
                            textViewRed.setBackgroundResource(R.color.red1);
                            textViewBlue.setBackgroundResource(R.color.blue1);
                            textViewGreen.setBackgroundResource(R.color.green1);
                            textViewYellow.setBackgroundResource(R.color.yellow1);
                            break;
                        case 20:
                            textViewRed.setBackgroundResource(R.color.red2);
                            textViewBlue.setBackgroundResource(R.color.blue2);
                            textViewGreen.setBackgroundResource(R.color.green2);
                            textViewYellow.setBackgroundResource(R.color.yellow2);
                            break;
                        case 30:
                            textViewRed.setBackgroundResource(R.color.red3);
                            textViewBlue.setBackgroundResource(R.color.blue3);
                            textViewGreen.setBackgroundResource(R.color.green3);
                            textViewYellow.setBackgroundResource(R.color.yellow3);
                            break;
                        case 40:
                            textViewRed.setBackgroundResource(R.color.red4);
                            textViewBlue.setBackgroundResource(R.color.blue4);
                            textViewGreen.setBackgroundResource(R.color.green4);
                            textViewYellow.setBackgroundResource(R.color.yellow4);
                            break;
                        case 50:
                            textViewRed.setBackgroundResource(R.color.red5);
                            textViewBlue.setBackgroundResource(R.color.blue5);
                            textViewGreen.setBackgroundResource(R.color.green5);
                            textViewYellow.setBackgroundResource(R.color.yellow5);
                            break;
                        case 60:
                            textViewRed.setBackgroundResource(R.color.red6);
                            textViewBlue.setBackgroundResource(R.color.blue6);
                            textViewGreen.setBackgroundResource(R.color.green6);
                            textViewYellow.setBackgroundResource(R.color.yellow6);
                            break;
                        case 70:
                            textViewRed.setBackgroundResource(R.color.red7);
                            textViewBlue.setBackgroundResource(R.color.blue7);
                            textViewGreen.setBackgroundResource(R.color.green7);
                            textViewYellow.setBackgroundResource(R.color.yellow7);
                            break;
                        case 80:
                            textViewRed.setBackgroundResource(R.color.red8);
                            textViewBlue.setBackgroundResource(R.color.blue8);
                            textViewGreen.setBackgroundResource(R.color.green8);
                            textViewYellow.setBackgroundResource(R.color.yellow8);
                            break;
                        case 90:
                            textViewRed.setBackgroundResource(R.color.red9);
                            textViewBlue.setBackgroundResource(R.color.blue9);
                            textViewGreen.setBackgroundResource(R.color.green9);
                            textViewYellow.setBackgroundResource(R.color.yellow9);
                            break;
                        case 100:
                            textViewRed.setBackgroundResource(R.color.red10);
                            textViewBlue.setBackgroundResource(R.color.blue10);
                            textViewGreen.setBackgroundResource(R.color.green10);
                            textViewYellow.setBackgroundResource(R.color.yellow10);
                            break;
                    }

                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.information:

                AlertDialog.Builder builder = new AlertDialog.Builder(context);//Context parameter
                builder.setTitle("More information");

                // set dialog message
                builder
                        .setMessage("Inspired by the works of artists such as Piet Mondrian and Ben Nicholson" + "\n\n" + "Click below to learn more!")
                        .setCancelable(false)
                        .setPositiveButton("Not now",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("Visit MOMA", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                Intent baseIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                                startActivity(baseIntent);
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = builder.create();

                // show it
                alertDialog.show();

                return true;

            default:
                return false;
        }
    }
}
