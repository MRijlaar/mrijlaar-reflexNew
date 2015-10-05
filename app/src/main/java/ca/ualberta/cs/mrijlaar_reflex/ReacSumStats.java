package ca.ualberta.cs.mrijlaar_reflex;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mrijlaar on 10/3/15.
 */
public class ReacSumStats {

    private Double fastest, slowest, avg, median;

    public ReacSumStats(){
        fastest =-1.0;
        slowest =-1.0;
        avg =-1.0;
        median =-1.0;
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

        if (size==0){
            fastest = -1.0;
            slowest = -1.0;
            avg = -1.0;
            median = -1.0;

            return;
        }

        ArrayList<Double> medList = new ArrayList<Double>();


        Double d;
        Iterator<ReacStat> itr = al.iterator();
        while (itr.hasNext()){

            d = itr.next().getTime();

            if (d<this.fastest)this.fastest = d;
            if (d>this.slowest)this.slowest = d;
            medList.add(d);

            sum += d;



        }

        Collections.sort(medList, new Comparator<Double>() {// Code modified from StackOverflow user arshajii. See README
            @Override
            public int compare(Double d1, Double d2) {
                return Double.compare(d1, d2);
            }
        });

        if (size%2==1)this.median = medList.get(s);
        else {
            this.median = (al.get(s).getTime() + medList.get(s-1))/2;
        }

        this.avg=sum/size;
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
