package ca.ualberta.cs.mrijlaar_reflex;

import java.util.Date;

/**
 * Created by mrijlaar on 10/3/15.
 */
public class ReacStat {
    private Date date;
    private Double time;

    public ReacStat(Double d){
        this.date= new Date();
        this.time= d;
    }

    public Double getTime() {
        return this.time;
    }

    public Date getDate(){
        return this.date;
    }
}
