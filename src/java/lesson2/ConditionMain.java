package lesson2;

public class ConditionMain {

    public static void main(String[] args) {
        int account = -1000;
        if (account == 0) {
            account += 1000;
            System.out.println("Текущий баланс (но исходно был нулевой) : " + account);
        } else if (account > 0) {
            account -= 100;
            System.out.println("Текущий баланс : " + account);

        } else if (account == -1000) {
            System.out.println("Минусовой баланс при -1000: " + account);
        } else {
            System.out.println("Минусовой баланс : " + account);
        }
        System.out.println("Текущий баланс при наличия средств : " + account);

        double one = -100;
        double two = -200;
        System.out.println("min(%1$,.2f, %2$,.2f) = %3$,.2f".formatted(one, two, min(one, two)));
        System.out.println("max(%1$,.2f, %2$,.2f) = %3$,.2f".formatted(one, two, max(one, two)));
        System.out.println("avg(%1$,.2f, %2$,.2f) = %3$,.2f".formatted(one, two, avg(one, two)));

        String color = "white";

        switch (color) {
            case "green" : {
                System.out.println("Пожалуйста пройдите");
                break;
            }
            case "yellow" : {
                System.out.println("Внимательно");
                break;
            }
            case "red" : {
                System.out.println("Проход запрещён");
                break;
            }
            default:
                System.out.println("Неправильно передан цвет");
        }

        int amountInCurrency = 100;
        String currency = "dollar";
        int result = switch (currency) {
            case "dollar" -> amountInCurrency * 100;
            case "euro" -> amountInCurrency * 110;
            default ->  amountInCurrency;

        };
        System.out.println("%d USD = %d RUBLES".formatted(amountInCurrency, result));
    }

    public static double min(double a, double b) {
//        if (a > b)
//        {
//            return b;
//        }
//        return a;
        return a > b ? b : a;
    }

    public static double max(double a, double b) {
//        if (a > b)
//        {
//            return b;
//        }
//        return a;
        return a < b ? b : a;
    }

    public static double avg(double a, double b) {
//        if (a > b)
//        {
//            return b;
//        }
//        return a;
        return (a + b) / 2;
    }
}
