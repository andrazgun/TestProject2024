package Tests.LegacyTests;

import org.junit.*;
import org.siit.course.*;

public class Course07Test {

    @BeforeClass
    public static void beforeAll(){
        System.out.println("@BeforeClass - This will execute once before all tests in the class");
    }

    @Before
    public void beforeTest() {
        System.out.println("@Before - This will execute before every test");
    }

    @Test
    public void computeRectangleAreaTest() {
        Rectangle r = new Rectangle(2, 3);
        System.out.println("Check correct area of rectangle");
//        if(r.computeArea() == 6) {
//            System.out.println("Test passed");
//        } else {
//            System.out.println("Test failed");
//        }
        Assert.assertEquals("Area is not computed correctly", 6, r.computeArea());
        r.setHeight(0);
        Assert.assertEquals("Area is not computed correctly.", 0, r.computeArea());

    }


    @Test
    public void checkIfPersonIsHungryTest() {
        Person p = new Person(14, 'f', "Ilan", 150, 45, true, 1999, new Shape());
        Assert.assertTrue("Person is hungry", p.isHungry());
        p.eat(); // will set isHungry to false
        Assert.assertFalse("Person is hungry", p.isHungry());
    }

    @Test
//    @Ignore
    public void computeSquareAreaTest() {
        Square s = new Square(5);
        System.out.println("Check correct area of square");
        Assert.assertEquals("Area of square is not computed correctly", 25, s.computeArea());
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkCircleAreaTest() {
        Circle c = new Circle(6);
        c.setRadius(-6); //Checked that the exception is thrown legally
    }

    @After
    public void afterTest() {
        System.out.println("@After - This will execute at the end of every test");
    }
    @AfterClass
    public static void afterAll(){
        System.out.println("@AfterClass - This will execute once before all tests in the class");
    }

}
