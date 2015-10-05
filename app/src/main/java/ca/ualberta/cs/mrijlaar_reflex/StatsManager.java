package ca.ualberta.cs.mrijlaar_reflex;

import java.util.*;

/**
 * Created by mrijlaar on 10/3/15.
 */
public class StatsManager {
    private ArrayList<ReacStat> reacStats;
    private ArrayList<BuzzStat> buzzStats;
    private ArrayList<ReacSumStats> reacSums;
    private ArrayList<BuzzSumStats> buzzSums;

    public StatsManager(){
        reacStats = new ArrayList<ReacStat>();
        buzzStats = new ArrayList<BuzzStat>();
        reacSums = new ArrayList<ReacSumStats>();
        buzzSums = new ArrayList<BuzzSumStats>();
    }

    public void addReac(ReacStat rs) {
        this.reacStats.add(rs);
        ;
    }

    public void addBuzz(BuzzStat b){
        this.buzzStats.add(b);
    }

    public boolean reacIsEmpty(){
        return reacStats.isEmpty();
    }

    public boolean buzzIsEmpty(){
        return buzzStats.isEmpty();
    }

    public ArrayList<BuzzSumStats> getBuzzSums(){
        Iterator<BuzzStat> itr = buzzStats.iterator();
        ArrayList<BuzzStat> m2 = new ArrayList<BuzzStat>();
        ArrayList<BuzzStat> m3 = new ArrayList<BuzzStat>();
        ArrayList<BuzzStat> m4 = new ArrayList<BuzzStat>();
        BuzzStat b;

        while (itr.hasNext()){
            b = itr.next();

            switch (b.getMode()){
                case 2: m2.add(b); break;
                case 3: m3.add(b); break;
                case 4: m4.add(b);
            }
        }

        if (buzzSums.size()>0)buzzSums.clear();

        // if m* is null is other constructor BuzzSumStats(int)
        if (m2.size()!=0)buzzSums.add(new BuzzSumStats(m2));else buzzSums.add(new BuzzSumStats(2));
        if (m3.size()!=0)buzzSums.add(new BuzzSumStats(m3));else buzzSums.add(new BuzzSumStats(3));
        if (m4.size()!=0)buzzSums.add(new BuzzSumStats(m4));else buzzSums.add(new BuzzSumStats(4));

        return buzzSums;
    }

    public ArrayList<ReacSumStats> getReacSums(){// loads them all{F,S,A,M}

        if (reacSums.size()>0)reacSums.clear();

        int size = reacStats.size();

        reacSums.add(new ReacSumStats(reacStats));

        if (size>=100) reacSums.add(new ReacSumStats(reacStats.subList(size-100,size-1)));
        else reacSums.add(reacSums.get(0));

        if (size>=10) reacSums.add(new ReacSumStats(reacStats.subList(size-10,size-1)));
        else reacSums.add(reacSums.get(0));

        return reacSums;
    }

    //used for testing and debugging

    public ArrayList<ReacStat> getReacStats() {
        return reacStats;
    }

    public int getReacStatsSize(){
        return reacStats.size();
    }

    public ArrayList<BuzzStat> getBuzzStats() {
        return buzzStats;
    }

    public String reacSumsToString(){
        String ret = "";

        for (int i = 0; i <reacSums.size(); i++){
            ret = ret + reacSums.get(i).getFastest().toString() + ", " + reacSums.get(i).getSlowest().toString() + ", "
                    + reacSums.get(i).getAvg().toString() + ", " + reacSums.get(i).getMedian().toString() + ", ";
        }


        return ret;
    }
}
