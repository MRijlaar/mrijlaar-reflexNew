package ca.ualberta.cs.mrijlaar_reflex;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by mrijlaar on 10/3/15.
 */
public class BuzzSumStats {
    private Integer mode;
    private Integer totalGames;
    private Integer p1Wins, p2Wins, p3Wins, p4Wins;

    public BuzzSumStats(Integer m){
        this.mode=m;
        this.p1Wins = new Integer(0);
        this.p2Wins = new Integer(0);
        this.p3Wins = new Integer(0);
        this.p4Wins = new Integer(0);
        this.totalGames = new Integer(0);
    }

    public BuzzSumStats(ArrayList<BuzzStat> al) throws InvalidParameterException{
        this.p1Wins = new Integer(0);
        this.p2Wins = new Integer(0);
        this.p3Wins = new Integer(0);
        this.p4Wins = new Integer(0);
        this.totalGames = new Integer(0);
        if (al.size()!=0){
            this.mode = al.get(0).getMode();
            calcSumStats(al);
        }
    }

    public BuzzSumStats getStats(ArrayList<BuzzStat> al){

        if (al.get(0).getMode()!=mode)return null;
        calcSumStats(al);

        return this;
    }

    private void calcSumStats(ArrayList<BuzzStat> al){

        this.totalGames = al.size();

        Iterator<BuzzStat> itr = al.iterator();
        BuzzStat b;
        while (itr.hasNext()){
            b = itr.next();
            switch (b.getPlayer()){
                case 1: this.p1Wins++; break;
                case 2: this.p2Wins++; break;
                case 3: this.p3Wins++; break;
                case 4: this.p4Wins++; break;
            }
        }
    }

    public Integer getMode() {
        return mode;
    }

    public Integer getTotalGames() {
        return totalGames;
    }

    public Integer getP1Wins() {
        return p1Wins;
    }

    public Integer getP2Wins() {
        return p2Wins;
    }

    public Integer getP3Wins() {
        return p3Wins;
    }

    public Integer getP4Wins() {
        return p4Wins;
    }
}
