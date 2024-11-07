import org.example.Variant18;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestVariant18 {

    @Test
    public void testGetEvenIndexedElements() {
        Variant18 variant = new Variant18();

        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {2, 4, 6, 8};
        assertArrayEquals(expected, variant.getEvenIndexedElements(A));

        int[] B = {10, 20, 30, 40, 50, 60};
        int[] expectedB = {20, 40, 60};
        assertArrayEquals(expectedB, variant.getEvenIndexedElements(B));
    }

    @Test
    public void testAreAllPositive() {
        Variant18 variant = new Variant18();

        assertTrue(variant.areAllPositive(1, 2, 3));
        assertFalse(variant.areAllPositive(1, -2, 3));
        assertFalse(variant.areAllPositive(0, 1, 2));
        assertTrue(variant.areAllPositive(10, 20, 30));
    }

    @Test
    public void testIfTask() {
        Variant18 variant = new Variant18();

        assertEquals(5, variant.ifTask(5, 3));
        assertEquals(10, variant.ifTask(7, 10));
        assertEquals(0, variant.ifTask(0, -1));
    }

    @Test
    public void testSwitchTask() {
        Variant18 variant = new Variant18();

        assertEquals(1.0, variant.switchTask(1, 10.0));
        assertEquals(10000.0, variant.switchTask(2, 10.0));
        assertEquals(10.0, variant.switchTask(3, 10.0));
        assertEquals(0.01, variant.switchTask(4, 10.0));
        assertEquals(0.1, variant.switchTask(5, 10.0));
    }

    @Test
    public void testForTask() {
        Variant18 variant = new Variant18();

        double[] expected = {10.0, 12.0, 14.0, 16.0, 18.0, 20.0};
        assertArrayEquals(expected, variant.forTask(10.0));
    }

    @Test
    public void testWhileTask() {
        Variant18 variant = new Variant18();

        assertEquals(15.0, variant.whileTask(5));
        assertEquals(105.0, variant.whileTask(7));
    }

    @Test
    public void testArrayTask() {
        Variant18 variant = new Variant18();

        int[] expected = {1, 2, 3, 6, 12};
        assertArrayEquals(expected, variant.arrayTask(5, 1, 2));
    }

    @Test
    public void testTwoDimensionArrayTask() {
        Variant18 variant = new Variant18();

        int[] arr = {1, 2, 3};
        int[][] expected = {
                {1, 2, 3},
                {2, 4, 6},
                {4, 8, 12}
        };
        assertArrayEquals(expected, variant.twoDimensionArrayTask(3, 3, 2, arr));
    }
}
