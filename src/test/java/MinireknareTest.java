import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.junit.Assert.*;

public class MinireknareTest {

    private Minireknare minireknare = new Minireknare();

    @Rule // För att kunna testa avsluta metoden
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddition() throws Exception {
        double a = 5;
        double b = 5;

        assertEquals("Testar addition", 10, minireknare.addition(a, b), 0);

        double c = 0;
        double d = 0;

        assertEquals("Testar addition", 0, minireknare.addition(c, d), 0);


        double e = -8;
        double f = -6;

        assertEquals("Testar att addera negativa tal", -14, minireknare.addition(e, f), 0);

        double g = -10;
        double h = 100;

        assertEquals("Testar negativ och positiva ta", 90, minireknare.addition(g, h), 0);
    }

    @Test
    public void testPi() throws Exception {
        double pi = 3.1415;

        assertEquals("Testar pi", pi, minireknare.pi(), 0);
    }

    @Test
    public void testMultiplikation() throws Exception {
        double a = 10;
        double b = 10;

        assertEquals("Testar multiplikation", 100, minireknare.multiplikation(a, b), 0);

        double c = 10000;
        double d = 100000;

        assertEquals("Testar stora tal", 1000000000, minireknare.multiplikation(c, d), 0);

        double e = -7;
        double f = 8;

        assertEquals("Testar att multiplicera med negativa tal", -56, minireknare.multiplikation(e, f), 0);

        double g = -9;
        double h = -3;

        assertEquals("Testar två negativa tal", 27, minireknare.multiplikation(g, h), 0);
    }

    @Test
    public void testDivision() throws Exception {
        double a = 10;
        double b = 2;

        assertEquals("Testar division", 5, minireknare.division(a, b), 0);

        double c = 2;
        double d = 14;

        assertEquals("Testar att dela ett mindre tal i ett större", 0.14, minireknare.division(c, d), 1);
    }

    @Test
    public void testKvadratroten() throws Exception {
        double a = 25;

        assertEquals("Testar kvadratroten", 5, minireknare.kvadratroten(a), 0);
    }

    @Test
    public void testSubtraktion() throws Exception {
        double a = 7;
        double b = 4;

        assertEquals("Testar subtraktion", 3, minireknare.subtraktion(a, b), 0);


        double c = 4;
        double d = 8;

        assertEquals("Testar att se om minustal fungerar", -4, minireknare.subtraktion(c, d), 0);

        double e = -5;
        double f = -7;

        assertEquals("Testar negativa tal", 2, minireknare.subtraktion(e, f), 0);
    }

    @Test
    public void testValidRaknesattMulti() throws Exception {
        String raknesatt = "*";
        assertEquals("teststar räknesättet", true, minireknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testValidRaknesattSub() throws Exception {
        String raknesatt = "-";
        assertEquals("teststar räknesättet", true, minireknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testValidRaknesattAdd() throws Exception {
        String raknesatt = "+";
        assertEquals("teststar räknesättet", true, minireknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testValidraknesattDiv() throws Exception {
        String raknesatt = "/";
        assertEquals("testar räknesättet", true, minireknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testRaknesattFail() throws Exception {
        String raknesatt = "något som inte finns";
        assertEquals("testar om räknesättet finns", false, minireknare.checkValidRaknesatt(raknesatt));
    }

    @Test
    public void testAvsluta() throws Exception {
        exit.expectSystemExit();
        minireknare.avsluta();
    }

    @Test
    public void testGetSumAdd() throws Exception {
        String raknesatt = "+";
        double input1 = 5;
        double input2 = 5;

        assertEquals("testar metoden getsum", 10, minireknare.getSum(raknesatt, input1, input2), 0);
    }

    @Test
    public void testGetSumMulti() throws Exception {
        String raknesatt = "*";
        double input1 = 4;
        double input2 = 2;

        assertEquals("testar getsum multiplikation", 8, minireknare.getSum(raknesatt, input1, input2), 0);
    }

    @Test
    public void testGetSumDiv() throws Exception {
        String raknesatt = "/";
        double input1 = 10;
        double input2 = 2;

        assertEquals("testar getsum division", 5, minireknare.getSum(raknesatt, input1, input2), 0);
    }

    @Test
    public void testGetSumSub() throws Exception {
        String raknesatt = "-";
        double input1 = 4;
        double input2 = 2;

        assertEquals("testar getsum subtraktion", 2, minireknare.getSum(raknesatt, input1, input2), 0);
    }

    @Test
    public void testInputValidator() throws Exception {
        String input1 = "5";
        assertTrue(minireknare.inputValidating(input1));

        String input2 = "asdasd";
        assertFalse(minireknare.inputValidating(input2));
    }

    @Test
    public void testCheckAvsluta() throws Exception {
        String input1 = "x";
        String input2 = "avsluta";
        String input3 = "tiotusen";

        exit.expectSystemExit();
        minireknare.checkAvsluta(input1);

        exit.expectSystemExit();
        minireknare.checkAvsluta(input2);

        assertEquals("ska inte inte avsluta", false, minireknare.checkAvsluta(input3));

    }
}
