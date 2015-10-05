package ca.ualberta.cs.mrijlaar_reflex;

import android.os.CountDownTimer;

/**
 * Created by mrijlaar on 10/4/15.
 */
public class Timer {

    long randTime;
    ReactionActivity act;
    CountDownTimer cd;
    Boolean delaying, waiting;//waiting for reaction not in general
    long startTime, endTime;

/*typically this program will go
    constructor => click => randomWait === cd.onFinish === click => timeReac => restartReac
                                       === click => tooSoon ==> restartReac

 */

    public Timer(ReactionActivity a){
        act = a;
        delaying = false;
        waiting = false;

    }

    public void randomWait(){

        randTime = (long)(Math.random()*1990 + 10);
        delaying = true;
        act.setReacButtonText("Wait for it...");
        cd = new CountDownTimer(randTime, 1000) {

            public void onTick(long millisUntilFinished) {}

            public void onFinish() {
                act.setReacButtonText("Now!");
                startTime = System.currentTimeMillis();
                waiting = true;
                delaying = false;
            }
        }.start();
    }

    public void click(){
        if (delaying)tooSoon();
        else if (waiting)
            timeReac();
        else
            randomWait();
    }

    public void tooSoon(){
        cd.cancel();
        act.setReacButtonText("Too Soon! Press to Play again");

        restartReac();
    }

    public void timeReac(){
        endTime = System.currentTimeMillis();
        Long time = endTime - startTime;
        Double d = time.doubleValue() / 1000;
        act.sendReac(d);

        act.setLastTime(d);


        act.setReacButtonText("Press To Start");
        restartReac();
    }

    public void restartReac(){
        waiting = false;
        delaying = false;// to be sure

    }












    public long getRandTime() {
        return randTime;
    }

    public void setRandTime(long randTime) {
        this.randTime = randTime;
    }
}
