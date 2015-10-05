package ca.ualberta.cs.mrijlaar_reflex;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PlayerSelectActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_select);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player_select, menu);
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

    public void buzz2PButtonClick(View v){
        Intent intent = new Intent(this, Buzz2PActivity.class);
        startActivity(intent);
    }

    public void buzz3PButtonClick(View v){
        Intent intent = new Intent(this, Buzz3PActivity.class);
        startActivity(intent);
    }

    public void buzz4PButtonClick(View v){
        Intent intent = new Intent(this, Buzz4PActivity.class);
        startActivity(intent);
    }
}
