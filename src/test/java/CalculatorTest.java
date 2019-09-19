import org.junit.*;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(NumberRowSupplier.class )
public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void initTest(){
        calculator = new Calculator();
    }

    @Test
    public void sum() {
        assertEquals(10, calculator.sum(5,5));
    }

    @Test
    public void divide() {
        assertEquals(5,calculator.divide(25,5));
        assertEquals(-5,calculator.divide(25,-5));
        assertEquals(5,calculator.divide(-25,-5));
    }

    @Test
    public void multiple() {
        assertEquals(36,calculator.multiple(6,6));
        assertEquals(36,calculator.multiple(-6,-6));
        assertEquals(-36,calculator.multiple(-6,6));
    }

    @Test
    public void subtraction() {
        assertEquals(0, calculator.subtraction(5,5));
        assertEquals(5, calculator.subtraction(10,5));
        assertEquals(-5, calculator.subtraction(5,10));
    }

    @Test
    public void sqrt() {
        assertEquals(2,calculator.sqrt(4),0);
        assertEquals(0,calculator.sqrt(0),0);
    }

    @Test(timeout = 1500)
    public void isPrime() {
        assertTrue(calculator.isPrime(11));
        assertTrue(calculator.isPrime(3467));
        assertFalse(calculator.isPrime(3468));
    }

    @Test
    public void fibonacci() {
        assertEquals(8, calculator.fibonacci(6));
        assertEquals(21, calculator.fibonacci(8));
        assertEquals(1, calculator.fibonacci(1));
        assertEquals(1, calculator.fibonacci(2));
    }

    @Test
    public void summarizeNumberRow() {
        NumberRowSupplier numberRowSupplier = new NumberRowSupplier();
        assertEquals(6, calculator.summarizeNumberRow(numberRowSupplier.getArrayFinalMethod()));
    }

    @Test
    public void summarizeNumberRowFinalMethod() {
        NumberRowSupplier numberRowSupplier = PowerMockito.mock(NumberRowSupplier.class);
        PowerMockito.when(numberRowSupplier.getArrayFinalMethod()).thenReturn(new int[]{1,0,0});
        assertEquals(1, calculator.summarizeNumberRow(numberRowSupplier.getArrayFinalMethod()));
    }

    @Test
    public void summarizeNumberRowStaticMethod() {
        PowerMockito.mockStatic(NumberRowSupplier.class);
        PowerMockito.when(NumberRowSupplier.getArrayStaticMethod()).thenReturn(new int[]{10,10,10});
        assertEquals(30, calculator.summarizeNumberRow(NumberRowSupplier.getArrayStaticMethod()));
    }

    @Test
    public void summarizeNumberRowPrivateMethod() throws Exception {
        NumberRowSupplier spy = PowerMockito.spy(new NumberRowSupplier());
        PowerMockito.doReturn(new int[]{100,1,1}).when(spy, "getArrayPrivateMethod");

        int[] array =  Whitebox.invokeMethod(spy, "getArrayPrivateMethod");
        assertEquals(102, calculator.summarizeNumberRow(array));
    }
}