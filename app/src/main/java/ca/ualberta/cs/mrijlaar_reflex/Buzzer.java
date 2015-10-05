package ca.ualberta.cs.mrijlaar_reflex;

import android.content.Context;

/**
 * Created by mrijlaar on 10/3/15.
 */
public class Buzzer extends MainActivity{

    private int p;
    private int m;

    public Buzzer(int p, int m){
        this.p = p;
        this.m = m;
    }

    public void click(Context context){
        super.sm.addBuzz(new BuzzStat(p,m));
        buzzAlert(p, context);
    }
}
