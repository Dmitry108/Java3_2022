package annotations;

public class TestingWithAfterException {

    @BeforeSuite
    public static void before() {
        System.out.println("before testing");
    }

    @Test(priority = 2)
    public static void testTwo() {
        System.out.println("test 2");
    }

    @Test
    public static void testDefault() {
        System.out.println("test 5");
    }

    @AfterSuite
    public static void afterOne() {
        System.out.println("one after testing");
    }

    @AfterSuite
    public static void afterTwo() {
        System.out.println("two after testing");
    }
}