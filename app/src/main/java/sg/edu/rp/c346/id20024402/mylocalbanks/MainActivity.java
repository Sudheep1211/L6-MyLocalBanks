package sg.edu.rp.c346.id20024402.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String wordClicked = "";
    boolean dbsfavourite = false;
    boolean ocbcfavourite = false;
    boolean uobfavourite = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDbs);
        tvOCBC = findViewById(R.id.textViewOcbc);
        tvUOB = findViewById(R.id.textViewUob);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2,"Toggle Favourite");

        if(v == tvDBS){
            wordClicked = "dbs";
        }else if(v == tvOCBC){
            wordClicked = "ocbc";
        }else{
            wordClicked = "uob";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.webbank1)));
                startActivity(intent);

            } else if (item.getItemId() == 1) {
                Intent intentcall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.telbank1)));
                startActivity(intentcall);

                return true;

            } else if(item.getItemId() == 2){
                if(!dbsfavourite){
                    tvDBS.setTextColor(Color.RED);
                    dbsfavourite = true;
                }else{
                    tvDBS.setTextColor(Color.BLACK);
                    dbsfavourite = false;
                }

            }

        }

        if(wordClicked.equalsIgnoreCase("ocbc")){
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.webbank2)));
                startActivity(intent);

            } else if (item.getItemId() == 1) {
                Intent intentcall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.telbank2)));
                startActivity(intentcall);

                return true;

            } else if(item.getItemId() == 2){
                if(!ocbcfavourite){
                    tvOCBC.setTextColor(Color.RED);
                    ocbcfavourite = true;
                }else{
                    tvOCBC.setTextColor(Color.BLACK);
                    ocbcfavourite = false;
                }

            }
        }

        if(wordClicked.equalsIgnoreCase("uob")){
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.webbank3)));
                startActivity(intent);

            } else if (item.getItemId() == 1) {
                Intent intentcall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.telbank3)));
                startActivity(intentcall);

                return true;

            }else if(item.getItemId() == 2){
                if(!uobfavourite){
                    tvUOB.setTextColor(Color.RED);
                    uobfavourite = true;
                }else{
                    tvUOB.setTextColor(Color.BLACK);
                    uobfavourite = false;
                }

            }
        }


        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.EnglishSelection){
            tvDBS.setText(getString(R.string.Ebank1));
            tvOCBC.setText(getString(R.string.Ebank2));
            tvUOB.setText(getString(R.string.Ebank3));
        } else if (id == R.id.chineseSelection){
            tvDBS.setText(getString(R.string.Cbank1));
            tvOCBC.setText(getString(R.string.Cbank2));
            tvUOB.setText(getString(R.string.Cbank3));
        }else{
            tvDBS.setText("Error in translation");
            tvOCBC.setText("Error in translation");
            tvUOB.setText("Error in translation");
        }

        return super.onOptionsItemSelected(item);
    }
}