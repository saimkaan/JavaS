import org.junit.*;

/**
 * Created by saim on 20/06/16.
 */
public class SimpleTest {

    @BeforeClass
    public static void init(){

    }

    @Test
    public void test1() {
//        System.out.println("Test1...");
        Assert.assertTrue(true);
        Assert.assertFalse(false);
    }

    @Test
    public void test2() {
        System.out.println("Test2...");
    }

    @Test
    public void test3() {
        System.out.println("Test3...");
    }
}
