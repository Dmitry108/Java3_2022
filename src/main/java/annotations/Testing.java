package annotations;

public class Testing {

    @BeforeSuite
    public static void before() {
        System.out.println("before testing");
    }

    @Test(priority = 1)
    public static void testOne() {
        System.out.println("test 1");
    }

    @Test(priority = 2)
    public static void testTwo() {
        System.out.println("test 2");
    }

    @Test(priority = 2)
    public static void testTwoAnother() {
        System.out.println("test 2");
    }

    @Test
    private static void testDefault() {
        System.out.println("test 5");
    }

    @Test(priority = 6)
    public static void testSix() {
        System.out.println("test 6");
    }

    @Test(priority = 10)
    public static void testTen() {
        System.out.println("test 10");
    }

    @AfterSuite
    public static void after() {
        System.out.println("after testing");
    }
}