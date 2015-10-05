package ca.ualberta.cs.mrijlaar_reflex;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by mrijlaar on 10/3/15.
 */
public class StatsManagerTest extends TestCase {

    public void testStatsManager(){

        StatsManager sm = new StatsManager();

        assertFalse(sm == null);

        Double d = new Double(0.521);
        ReacStat rs = new ReacStat(d);
        assertFalse(rs==null);
        assertFalse(sm == null);

        Integer p, m;
        p = 1;
        m = 2;
        BuzzStat b = new BuzzStat(p,m);

        sm.addReac(rs);
        assertFalse(sm.reacIsEmpty());

        sm.addBuzz(b);
        assertFalse(sm.buzzIsEmpty());


        ReacSumStats rss = new ReacSumStats();
        assertFalse(rss == null);

        ArrayList<ReacSumStats> alrss = sm.getReacSums();

        assertTrue(sm.getReacStats().get(0).getTime() == d);
        assertTrue(sm.getReacStatsSize() == 1);


        assertTrue(d < Double.MAX_VALUE);


        assertFalse(alrss.get(0) == null);

        assertFalse(sm.reacIsEmpty());
        assertTrue(alrss.get(0).getFastest() == d);
        assertTrue(alrss.get(0).getSlowest() == d);
        assertTrue(alrss.get(0).getAvg().toString().equalsIgnoreCase(d.toString()));
        assertTrue(alrss.get(0).getMedian()==d);

        d = 0.01;
        for (int i= 0; i< 110; i++){
            //d = Math.random()*.01; // .01-1.01
            sm.addReac(new ReacStat(d));
            d+= 0.01;
        }

        sm.getReacSums();
        assertTrue(sm.reacSumsToString(), Boolean.TRUE);//assert False and read output

        assertTrue(sm.getBuzzStats().size() == 1);
        assertTrue(sm.getBuzzStats().get(0).getPlayer()==1);
        p=2;
        m=4;
        for (int i= 0; i< 110; i++){
            /*p = (int)Math.random()*4+1; // 1,2,3,4
            m = (int)Math.random()*3+2; //2,3,4*/
            sm.addBuzz(new BuzzStat(p,m));

        }
        assertTrue(sm.getBuzzStats().get(0).getPlayer()==1);
        assertTrue(sm.getBuzzStats().size()==111);
        assertTrue(sm.getBuzzSums().get(0).getTotalGames().toString(),
                sm.getBuzzSums().get(0).getTotalGames()==1);
        assertTrue(sm.getBuzzSums().get(1).getTotalGames().toString(),
                sm.getBuzzSums().get(1).getTotalGames()==0);
        assertTrue(sm.getBuzzSums().get(2).getTotalGames().toString()
                ,sm.getBuzzSums().get(2).getTotalGames()==110);
        assertTrue(sm.getBuzzSums().get(2).getP2Wins().toString(), Boolean.FALSE);

    }



}