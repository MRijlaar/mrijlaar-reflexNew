package ca.ualberta.cs.mrijlaar_reflex;

import junit.framework.TestCase;
import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by mrijlaar on 10/3/15.
 */
public class BuzzStatTest extends TestCase {

        public void testBuzzStat(){
            Integer m = new Integer(4);
            Integer p = 1;


            BuzzStat b = new BuzzStat(p, m);
            assertTrue(b.getPlayer()==p);
            assertTrue(b.getMode()==m);
        }
}