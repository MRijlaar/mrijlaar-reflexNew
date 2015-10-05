package ca.ualberta.cs.mrijlaar_reflex;

/**
 * Created by mrijlaar on 10/3/15.
 */
public class BuzzStat {
    private Integer player;
    private Integer mode;

    public BuzzStat(Integer p, Integer m) {
        this.player = p;
        this.mode = m;
    }

    public Integer getPlayer(){
        return this.player;
    }

    public Integer getMode(){
        return this.mode;
    }
}
