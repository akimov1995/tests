import org.apache.log4j.Logger;

import java.text.MessageFormat;
import java.util.Arrays;

public class Calculator {

    private static Logger logger = Logger.getLogger(Calculator.class);

    public Calculator() {
    }

    public int sum(int a, int b){
        int result = a+b;
        logger.info(MessageFormat.format("Выполнен метод sum параметры a = {0}," +
                " b = {1}, результат = {2}",a,b,result));
        return result;
    }

    public int divide(int a, int b){
        if(b == 0){
            logger.error("Ошибка: в методе divide параметр b = 0");
            throw new ArithmeticException("Ошибка: нельзя выполнить деление на 0");
        }

        int result = a/b;
        logger.info(MessageFormat.format("Выполнен метод divide параметры a = {0}," +
                " b = {1}, результат = {2}",a,b,result));
        return result;
    }

    public int multiple(int a, int b){
        int result = a*b;
        logger.info(MessageFormat.format("Выполнен метод multiple параметры a = {0}," +
                " b = {1}, результат = {2}",a,b,result));
        return result;
    }

    public int subtraction(int a, int b){
        int result = a-b;
        logger.info(MessageFormat.format("Выполнен метод subtraction параметры a = {0}," +
                " b = {1}, результат = {2}",a,b,result));
        return result;
    }

    public double sqrt(int a){
        if(a<0){
            logger.error("Ошибка: в методе sqrt параметр a < 0");
            throw new IllegalArgumentException("Ошибка: нельзя извлечь корень из отрицательного числа");
        }
        double result = Math.sqrt(a);
        logger.info(MessageFormat.format("Выполнен метод sqrt параметры a = {0}," +
                " результат = {1}",a,result));
        return result;
    }

    public boolean isPrime(int a) {
        boolean isPrime = true;
        if(a<1){
            logger.error("Ошибка: в методе isPrime параметр a < 1");
            throw new IllegalArgumentException("Ошибка: число должно быть натуральным");
        }
        if(a==1) {
            isPrime = false;
        }
        else {
            for (int i = 2; i <= a-1; i++) {
                double temp = a % i;
                if (temp == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        logger.info(MessageFormat.format("Выполнен метод isPrime параметры a = {0}," +
                " результат = {1}",a,isPrime));
        return isPrime;
    }

    public int fibonacci(int n) {
        if(n < 0){
            logger.error("Ошибка: в методе fibonacci параметр n < 0");
            throw new IllegalArgumentException("Ошибка: число должно быть натуральным");
        }
        else {
            if (n <= 1) return n;

            int previous = 0;
            int next = 1;
            int sum;

            for (int i = 2; i <= n; i++) {
                sum = previous;
                previous = next;
                next = sum + previous;
            }

            logger.info(MessageFormat.format("Выполнен метод fibonacci параметры n = {0}," +
                    " результат = {1}",n,next));
            return next;
        }
    }

    public int summarizeNumberRow(int[] row){
        int sum = 0;
        for(int i = 0;i < row.length; i++){
            sum += row[i];
        }
        logger.info(MessageFormat.format("Выполнен метод summarizeNumberRow параметры row = {0}," +
                " результат = {1}", Arrays.toString(row),sum));
        return sum;
    }
}
