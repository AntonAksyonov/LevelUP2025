package lesson8;

import java.util.*;

public class ListRunner {
    public static void main(String[] args) {
        List list = List.of(1, "String", new Object());
        List<String> strings = List.of("Hello", "World", "!");
//        List<Integer> = new List<>()
//        List<String> stringOfWords = new ArrayList<>(3);
        List<String> stringOfWords = new ArrayList<>(strings);
        stringOfWords.addAll(strings);
        stringOfWords.add("Test");
        stringOfWords.add("Anton");
        stringOfWords.add("Aksyonov");
        stringOfWords.add("Test123");
        stringOfWords.add(1,"Test123");
        stringOfWords.add(stringOfWords.size(),"Test123");
        stringOfWords.add("Hello");
        System.out.println(stringOfWords);
        System.out.println(stringOfWords.size());
        System.out.println("-----");
        for(int index = 0; index < stringOfWords.size(); index++) {
            if (index % 2 == 0) {
                System.out.println(stringOfWords.get(index));
            }
        }

        String removeWord = "Hello";

        for (int index = 0; index < stringOfWords.size(); index++) {
            String s = stringOfWords.get(index);
            if (removeWord.equals(s)) {
                stringOfWords.remove(index);
            }
        }

        System.out.println(stringOfWords);

//        Iterator<String> iterator = stringOfWords.iterator();
        //        while (iterator.hasNext()) {
        for (String stringOfWord : stringOfWords) {
            System.out.println(stringOfWord);
        }

        List<String> sortedList = new ArrayList<>(stringOfWords);
        sortedList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

//        int count = 0;
//        for (String str : sortedList) {
//            if (count % 2 == 0) {
//                sortedList.remove(count);
//            }
//        }

        System.out.println(sortedList);
        stringOfWords.remove("Anton");
        System.out.println(stringOfWords);

        System.out.println("-----");
        stringOfWords.clear();
        System.out.println(stringOfWords);

        String[] str = {"1", "2", "3"};
        List<String> list1 = new ArrayList<>(Arrays.asList(str));


    }
}
