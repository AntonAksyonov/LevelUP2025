package lesson3;

public class InfiniteLoop {
    public static void main(String[] args) {
        int i = 1;
        while (true){
            System.out.println(i++);
//            if (i > 1000){
//                break;
//            }
        }

    }
}
