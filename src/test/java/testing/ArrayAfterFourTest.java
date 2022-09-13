package testing;

import org.junit.Assert;
import org.junit.Test;

public class ArrayAfterFourTest {
    @Test
    public void arrayAfterFourTest1() {
        Assert.assertArrayEquals(new int[]{5, 6}, Main.arrayAfterFour(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    public void arrayAfterFourTest2() {
        Assert.assertArrayEquals(new int[]{1, 1, 1, 1}, Main.arrayAfterFour(new int[]{7, 4, 5, 4, 1, 1, 1, 1}));
    }

    @Test
    public void arrayAfterFourTest3() {
        Assert.assertArrayEquals(new int[]{}, Main.arrayAfterFour(new int[]{0, 4}));
    }

    @Test(expected = RuntimeException.class)
    public void arrayAfter4TestException() {
        Main.arrayAfterFour(new int[]{1, 1, 1, 1, 1});
    }
}