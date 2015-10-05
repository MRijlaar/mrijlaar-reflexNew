package ca.ualberta.cs.mrijlaar_reflex;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReactionActivity extends MainActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction);
        timer = new Timer(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reaction, menu);
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

    public void reacGameButtonClick(View v){
        timer.click();
    }

    public void setReacButtonText(String s){

        Button rb = (Button)findViewById(R.id.reacButton);
        rb.setText(s);
    }

    public void setLastTime(Double d){
        TextView tv = (TextView)findViewById(R.id.editText);
        tv.setText(d.toString());
    }

    public void sendReac(Double d){
        super.sm.addReac(new ReacStat(d));
    }
}
