import org.siit.course.Calc;
import org.testng.Assert;
import org.testng.annotations.*;


@Test //all public tests (methods) inside the class will execute
public class MyFirstTestNGTest {
        Calc c; //define variable
        int count;
    @BeforeClass
    public void setUp() { //method to setup c variable
    c = new Calc();
        System.out.println("Setup on before class");
    }

    @BeforeTest
    public void setUpTest() {
        count = 0;
        System.out.println("Setup on before test");
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Setup on before method");
    }

    @Test(
            description = "This is test 1",
            groups = {"Smoke", "Regression"}
    )
    public void test1() {
        System.out.println("test 1");
    }


    @Test(
            description = "This is test 2",
            enabled = true,  // enabled false > test skipped
            groups = {"Regression"}
    )
    public void test2() {
        System.out.println("test 2");
    }


//    @Test //private method will run only if set, not recommended to have private tests (method)
    private void test3() {
        System.out.println("test 3");
    }

    @DataProvider
    public Object[][] calculatorDataProvider() {
        return new Object[][] {
                {5,2,3,"+",0},
                {10, -2, -5,"*",0},
                {10, 20, 2, "/", 0},
                {1.4142, 2, 0, "SQRT", 0.0001}
        };
    }

    @Test(dataProvider = "calculatorDataProvider")
    public void verifyCalculatorTest(
            double expectedResult,
            double d1,
            double d2,
            String operator,
            double delta
    ) {
        System.out.println("Addition test");
        System.out.println("Compute calculator assert with delta " + delta + " for: " + d1 + " " + operator + " " + d2 + " = "+ expectedResult);
        Assert.assertEquals(expectedResult, c.compute(d1, d2, operator), delta);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void divisionExceptionTest() {
        c.compute(5,0,"/"); //check exception to throw
    }


    @Test(invocationCount = 2) //repeat test
    public void testMe() {
        count++;
        System.out.println("Current value for count: " + count);
    }
    @Test(
            groups = {"Smoke", "Regression"}
    )
    public void login() {
        System.out.println("Login with user");
        Assert.assertTrue(false); //will always fail
    }

    @Test(
            dependsOnMethods = {"logout"},
            alwaysRun = true, //execute anyway
            groups = {"Smoke", "Regression"}
    )
    public void closeTabAtEnd () {
        System.out.println("close at end");
    }


    @Test(
            priority = 1,  //priority set
            dependsOnMethods = {"login"}, //if login fail, logout is skipped
            groups = {"Smoke", "Regression"}
    )
    public void logout() {
        System.out.println("Log out");
    }

//    Test to check parameter from VM options/configurations
    @Test
    public void getParamsFromCmd() {
        String browser = System.getProperty("browser");
        System.out.println("Run tests with browser: " + browser);
        Assert.assertNotNull(browser,"Browser is not null");
        String environment = System.getProperty("env");
        System.out.println("Run tests on environment: " + environment);
        Assert.assertNotNull(environment,"Environment is not null");
    }


}
