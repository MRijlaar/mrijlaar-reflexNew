package ca.ualberta.cs.mrijlaar_reflex;

import junit.framework.TestCase;
import java.util.Date;

/**
 * Created by mrijlaar on 10/3/15.
 */
public class ReacStatTest extends TestCase {



    public void testReacStat(){

        Double d = new Double(0.521);

        ReacStat rs = new ReacStat(d);
        assertTrue("Time match failed"+Double.toString(rs.getTime()),rs.getTime()==d);
        assertFalse(rs.getDate() == null);

    }

}