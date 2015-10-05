package ca.ualberta.cs.mrijlaar_reflex;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Buzz4PActivity extends MainActivity {

    private Buzzer p1m4,p2m4,p3m4,p4m4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzz_4p);
        if (p1m4 == null){
            p1m4 = new Buzzer(1,4);
            p2m4 = new Buzzer(2,4);
            p3m4 = new Buzzer(3,4);
            p4m4 = new Buzzer(4,4);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_buzz4, menu);
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

    public void p1m4Click(View v){
        p1m4.click();
    }

    public void p2m4Click(View v){
        p2m4.click();
    }

    public void p3m4Click(View v){
        p3m4.click();
    }

    public void p4m4Click(View v){
        p4m4.click();
    }
}
