package ch.alika.algorithms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.alika.algorithms.Searches.SubarrayResult;

public class SearchTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFindMaximalSubarray() {
        int a[] = { 0, -1, 2, 5, -5, 6 };
        SubarrayResult r = Searches.findMaxSubarray(a);
        assertEquals("from", 2, r.from);
        assertEquals("to", 6, r.to);
        assertEquals("total", 8, r.total);

        int b[] = { 9, -3, 2, 0, -5, 6 };
        r = Searches.findMaxSubarray(b);
        assertEquals("from", 0, r.from);
        assertEquals("to", 1, r.to);
        assertEquals("total", 9, r.total);

        int c[] = { 6, -3, 2, 0, -5, 9 };
        r = Searches.findMaxSubarray(c);
        assertEquals("from", 5, r.from);
        assertEquals("to", 6, r.to);
        assertEquals("total", 9, r.total);
    }

}
