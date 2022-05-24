import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CalculatorTest {
    @Test
    public void testAddOne(){
        Calculator sut = new Calculator();
        sut.add(1);
        assertEquals("0+1 = 1",1, sut.getState());
    }

    @Test
    public void testAddZero(){
        Calculator sut = new Calculator();
        sut.add(0);
        assertEquals("0+0 = 0",0, sut.getState());
    }

    @Test
    public void testAddMinusValue(){
        Calculator sut = new Calculator();
        sut.add(-2);
        assertEquals("0+(-2) = -2",-2, sut.getState());
    }

    @Test 
    public void testMultOneByTwo(){
        Calculator sut = new Calculator();
        sut.setState(1);
        sut.mult(2);
        assertEquals("1*2 = 2", 2, sut.getState());
    }

    @Test 
    public void testMultByZero(){
        Calculator sut = new Calculator();
        sut.setState(2);
        sut.mult(0);
        assertEquals("2*0 = 0", 0, sut.getState());
    }

    @Test 
    public void testMultByMinusValue(){
        Calculator sut = new Calculator();
        sut.setState(1);
        sut.mult(-2);
        assertEquals("1*(-2) = -2", -2, sut.getState());
    }

    @Test
    public void testMultByMaxInt(){
        Calculator sut = new Calculator();
        sut.setState(1);
        sut.mult(2147483647);
        assertEquals("1*2147483647 = 2147483647", 2147483647, sut.getState());
    }

    @Test
    public void testMultMinInt(){
        Calculator sut = new Calculator();
        sut.setState(1);
        sut.mult(-2147483648);
        assertEquals(-2147483648, sut.getState());
    }

    @Test
    public void testSubByMinusValue(){
        Calculator sut = new Calculator();
        sut.setState(5);
        sut.subtraction(-2);;
        assertEquals(7, sut.getState());
    }

    @Test
    public void testSubByFive(){
        Calculator sut = new Calculator();
        sut.setState(2);
        sut.subtraction(5);;
        assertEquals(-3, sut.getState());
    }

    @Test
    public void testDivByTwo(){
        Calculator sut = new Calculator();
        sut.setState(6);
        sut.division(2);
        assertEquals(3, sut.getState());
    }

    @Test
    public void testDivByZero(){
        try {
            Calculator sut = new Calculator();
            sut.division(0);
           }
        catch(ArithmeticException e) {
            assertEquals(e.getMessage(), "You cannot divide by zero");
           }
        }
}
