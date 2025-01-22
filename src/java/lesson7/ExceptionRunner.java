package lesson7;

public class ExceptionRunner {
    public static void main(String[] args) {
//        int digit = 0;
        Integer digit = null;
        int result = -1000;
//        try {
//            result = divide(10, digit); // физическое обращение к удаленному серверу
//        } catch (ArithmeticException e) {
//            result = 0;
//        } catch (Exception e) {
//            result = -1;
//        } catch (Throwable e) {
//            result = -100500;
//        }
        System.out.println(wrappedDivide(result, digit));
    }
    private static int wrappedDivide(int result, Integer digit) {
        try {
            result = divide(10, digit); // физическое обращение к удаленному серверу
        } catch (NullPointerException | IllegalArgumentException e) {
            System.err.println("NPE: " + e); // 1
            result = 0;
        } catch (RuntimeException e) {
            System.err.println("В реальности произошла проблема: " + e); // 2
            result = -1;
        } catch (Exception e) {
            System.err.println("В реальности произошла проблема: " + e); // 2
            result = -1;
        } finally {
            System.out.println(result); // 3
        }
        return result;
    }
    private static int divide(Integer a, Integer b) throws Exception {
//        return divide(a, b);
//        try {
        if (a == 11) {
            throw new Exception("Специально сгененированное проверяемое исключение, возникшее при параметрах %d и %d".formatted(a, b));
        } else if (b == 0) {
            throw new ArithmeticException("Случилось деление на 0");
        }
//        }
//        catch (Exception e) {
//
//        }
        return a / b;
    }
}
