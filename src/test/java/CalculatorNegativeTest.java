import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class CalculatorNegativeTest {
    private Calculator calculator;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void initTest(){
        calculator = new Calculator();
    }

    @Test
    public void divide() {
        exception.expect(ArithmeticException.class);
        calculator.divide(5, 0);
    }

    @Test
    public void sqrt() {
        exception.expect(IllegalArgumentException.class);
        calculator.sqrt(-1);
    }

    @Test
    public void isPrime() {
        exception.expect(IllegalArgumentException.class);
        calculator.isPrime(-10);
    }

    @Test
    public void fibonacci() {
        exception.expect(IllegalArgumentException.class);
        calculator.fibonacci(-10);
    }
}