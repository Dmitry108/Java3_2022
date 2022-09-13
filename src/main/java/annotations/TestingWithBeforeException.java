package annotations;

public class TestingWithBeforeException {

    @BeforeSuite
    public static void beforeOne() {
        System.out.println("one before testing");
    }

    @BeforeSuite
    public static void beforeTwo() {
        System.out.println("two before testing");
    }

    @Test(priority = 0)
    public static void testZero() {
        System.out.println("test 0");
    }

    @Test(priority = 1)
    public static void testOne() {
        System.out.println("test 1");
    }

    @Test
    public static void testDefault() {
        System.out.println("test 5");
    }

    @AfterSuite
    public static void after() {
        System.out.println("after testing");
    }
}