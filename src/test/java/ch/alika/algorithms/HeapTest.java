package ch.alika.algorithms;

import static org.junit.Assert.*;
import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

public class HeapTest {
    private Comparator<Integer> descending = new IsLessThan();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPop() {
        Integer data[] = { 2, 8, 9, 37, 9 };
        Heap<Integer> heap = new Heap<Integer>(data, descending);
        assertEquals(5, heap.size());
        assertEquals((Integer) 2, heap.peek());
        assertEquals((Integer) 2, heap.pop());
        assertEquals(4, heap.size());
        assertEquals((Integer) 8, heap.pop());
        assertEquals(3, heap.size());
    }

    private static final class IsLessThan implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2)
                return 1;

            if (o1 == o2)
                return 0;

            return -1;
        }
    }
}
