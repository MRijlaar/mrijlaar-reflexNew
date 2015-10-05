package ca.ualberta.cs.mrijlaar_reflex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mrijlaar on 10/3/15.
 */
public class ReacSumStats {

    private Double fastest, slowest, avg, median;

    public ReacSumStats(){
        fastest =Double.MAX_VALUE;
        slowest =Double.MIN_VALUE;
        avg =0.0;
        median =0.0;
    }

    public ReacSumStats(List<ReacStat> al){
        fastest =Double.MAX_VALUE;
        slowest =Double.MIN_VALUE;
        avg =0.0;
        median =0.0;
        calcStats(al);
    }

    public ReacSumStats getStats(List<ReacStat> al){
        calcStats(al);
        return this;
    }

    private void calcStats(List<ReacStat> al){
        Integer size = al.size();
        Double sum = 0.0;

        int s = ((int)size/2);// proper way median is calculated
        if (size%2==1)this.median = al.get(s).getTime();
        else {
            this.median = (al.get(s).getTime() + al.get(s+1).getTime())/2;
        }

        Double d;
        Iterator<ReacStat> itr = al.iterator();
        while (itr.hasNext()){

            d = itr.next().getTime();

            if (d<this.fastest)this.fastest = d;
            if (d>this.slowest)this.slowest = d;

            sum += d;

        }

        avg = sum/size;
    }

    public Double getFastest() {
        return fastest;
    }

    public Double getSlowest() {
        return slowest;
    }

    public Double getAvg() {
        return avg;
    }

    public Double getMedian() {
        return median;
    }
}
