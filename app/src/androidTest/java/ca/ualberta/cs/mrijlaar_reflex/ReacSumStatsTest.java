package ca.ualberta.cs.mrijlaar_reflex;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by mrijlaar on 10/3/15.
 */
public class ReacSumStatsTest extends TestCase {

    public void testReacSumStats(){
        ReacSumStats rss = new ReacSumStats();
        assertFalse(rss==null);

        StatsManager sm = new StatsManager();
        assertFalse(sm == null);

        Double d = 0.521;
        ReacStat rs = new ReacStat(d);
        assertTrue(rs.getTime() == d);

        sm.addReac(rs);
        assertTrue(rs.getTime() == sm.getReacStats().get(0).getTime());

        ArrayList<ReacStat> al = new ArrayList<ReacStat>();
        al.add(rs);

        rss.getStats(al);
        assertTrue(rss.getFastest()==d);



    }
}