package ca.ualberta.cs.mrijlaar_reflex;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class StatsActivity extends MainActivity {

    StatsManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        sm = super.sm;
        update();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stats, menu);
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

    public void eMailButtonClicked(MenuItem v){

    }

    public void clearStatsButtonClicked(MenuItem v){

    }

    public void update(){
        ArrayList<ReacSumStats> rssa = sm.getReacSums();
        TextView[] v = new TextView[12];
        ReacSumStats rss;

        v[0]=(TextView)findViewById(R.id.RFA);
        v[1]=(TextView)findViewById(R.id.RSA);
        v[2]=(TextView)findViewById(R.id.RAA);
        v[3]=(TextView)findViewById(R.id.RMA);

        v[4]=(TextView)findViewById(R.id.RF100);
        v[5]=(TextView)findViewById(R.id.RS100);
        v[6]=(TextView)findViewById(R.id.RA100);
        v[7]=(TextView)findViewById(R.id.RM100);

        v[8]=(TextView)findViewById(R.id.RF10);
        v[9]=(TextView)findViewById(R.id.RS10);
        v[10]=(TextView)findViewById(R.id.RA10);
        v[11]=(TextView)findViewById(R.id.RM10);

        for (int i =0; i<rssa.size();i++){
            rss = rssa.get(i);
            v[0+i*4].setText(rss.getFastest().toString().substring(0,3));
            v[1+i*4].setText(rss.getSlowest().toString().substring(0,3));
            v[2+i*4].setText(rss.getAvg().toString().substring(0,3));
            v[3 + i * 4].setText(rss.getMedian().toString().substring(0,3));
        }


        sm.getBuzzSums();
        ;
    }
}
