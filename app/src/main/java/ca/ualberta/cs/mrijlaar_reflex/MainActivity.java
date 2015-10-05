/*
        Reflex-Buzzer: Contains two games, One tests reaction speeds, the other provides a buzzer for trivia games

        Copyright (C) 2015  Michael Rijlaarsdam

        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package ca.ualberta.cs.mrijlaar_reflex;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.io.*;

public class MainActivity extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    static StatsManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(this.sm==null)sm = new StatsManager();/////////////////////////////////////////////// replace when save load works
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gsom = new Gson();
            sm = gsom.fromJson(in, StatsManager);

        } catch (FileNotFoundException e) {
            sm = new StatsManager();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(sm, osw);
            osw.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void reflexButtonClick(View v){
        Intent intent = new Intent(this, ReactionActivity.class);
        startActivity(intent);
    }

    public void buzzButtonClick(View v){
        Intent intent = new Intent(this, PlayerSelectActivity.class);
        startActivity(intent);
    }

    public void statsButtonClick(MenuItem v){
        Intent intent = new Intent(this, StatsActivity.class);
        startActivity(intent);
    }

    public void buzzAlert(int p, Context context){// code modified from StackOverFlow user David Hedlund see README for more
        new AlertDialog.Builder(context)
                .setTitle("Winner")
                .setMessage("Player " + p + " buzzed first")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
