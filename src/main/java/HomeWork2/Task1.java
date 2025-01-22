package HomeWork2;

public class Task1 {
    public static void main(String[] args) {

        float f = 12.523F;
        int i = (int) f;
        int d = ((int)(f * 10) % 10);
        int o = i + (d >= 5? 1 : 0);
        System.out.println(("Число до округления = " + f + "\n" +
                "Дробная часть для округления = " + d + "\n" +
                "Число после округления до целого значения = " + o));
    }
}
