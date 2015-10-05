package ca.ualberta.cs.mrijlaar_reflex;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Buzz3PActivity extends MainActivity {

    private Buzzer p1m3,p2m3,p3m3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzz_3p);
        if (p1m3 == null){
            p1m3 = new Buzzer(1,3);
            p2m3 = new Buzzer(2,3);
            p3m3 = new Buzzer(3,3);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_buzz3, menu);
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

    public void p1m3Click(View v){
        p1m3.click();
    }

    public void p2m3Click(View v){
        p2m3.click();
    }

    public void p3m3Click(View v){
        p3m3.click();
    }
}
