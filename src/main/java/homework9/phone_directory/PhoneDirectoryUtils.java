package homework9.phone_directory;

import homework9.influence_hash_code.EmployeeUtils;

import java.util.*;

public class PhoneDirectoryUtils {
    private static String generateNumber() {
        String number = "+7(9";
        for (int index = 1; index <= 9; index++) {
            int digit = (int) (Math.random() * 9);
            number += digit + ((index == 2) ? ")" : ((index == 5 || index == 7) ? "-" : ""));
        }
        return number;
    }

    public static Collection<PhoneDirectory> generate(int sizeDirectory, int maxListContacts) throws RuntimeException {
        if (sizeDirectory <= 0) {
            throw new RuntimeException("Размер коллекции должен быть больше 0");
        }
        if (maxListContacts <= 0) {
            throw new RuntimeException("Максимальный список контактов должен быть больше 0");
        }
        if (maxListContacts > sizeDirectory) {
            throw new RuntimeException("Максимальный список контактов не должен быть больше размера коллекции");
        }

        Set<PhoneDirectory> phoneDirectorySet = new TreeSet<>();
        while (phoneDirectorySet.size() < sizeDirectory) {
            phoneDirectorySet.add(new PhoneDirectory(EmployeeUtils.generateFio(), generateNumber()));
        }

        List<PhoneDirectory> phoneDirectoryArrayList = new ArrayList<>(phoneDirectorySet);
        for (int index = 0; index < sizeDirectory; index++) {

            TreeSet<String> listContacts = new TreeSet<>();
            int sizeListContacts = (int) (Math.random() * (maxListContacts - 1) + 1);
            while (listContacts.size() < sizeListContacts) {
                int indexForListContacts = (int) (Math.random() * (sizeDirectory - 1));
                if (indexForListContacts != index) {
                    PhoneDirectory phoneDirectory = phoneDirectoryArrayList.get(indexForListContacts);
                    listContacts.add(phoneDirectory.getNumber());
                }
            }
            phoneDirectoryArrayList.get(index).setListContacts(listContacts);
        }

        return phoneDirectorySet;
    }

    public static PhoneDirectory[] generateArray(int sizeDirectory, int maxListContacts) throws RuntimeException {
        if (sizeDirectory <= 0) {
            throw new RuntimeException("Размер телефонного справочника должен быть больше 0");
        }
        if (maxListContacts <= 0) {
            throw new RuntimeException("Максимальный список контактов должен быть больше 0");
        }
        if (maxListContacts > sizeDirectory) {
            throw new RuntimeException("Максимальный список контактов не должен быть больше размера телефонного справочника");
        }

        PhoneDirectory[] phoneDirectoryArray = new PhoneDirectory[sizeDirectory];
        for (int index = 0; index < phoneDirectoryArray.length; index++) {

            boolean add = false;
            while (!add) {
                PhoneDirectory phoneDirectory = new PhoneDirectory(EmployeeUtils.generateFio(), generateNumber());
                boolean found = false;
                for (int indexFound = 0; indexFound < index; indexFound++) {
                    if (phoneDirectory.getNumber() == phoneDirectoryArray[indexFound].getNumber()) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    phoneDirectoryArray[index] = phoneDirectory;
                    add = true;
                }
            }
        }

        for (int index = 0; index < sizeDirectory; index++) {

            int sizeListContacts = (int) (Math.random() * (maxListContacts - 1) + 1);
            String[] listContactsArray = new String[sizeListContacts];

            int indexListContacts = 0;
            while (indexListContacts < sizeListContacts) {
                int indexForListContacts = (int) (Math.random() * (sizeDirectory - 1));
                if (indexForListContacts != index) {
                    PhoneDirectory phoneDirectory = phoneDirectoryArray[indexForListContacts];
                    listContactsArray[indexListContacts] = (phoneDirectory.getNumber());
                    indexListContacts++;
                }
            }
            phoneDirectoryArray[index].setListContactsArray(listContactsArray);
        }

        return phoneDirectoryArray;
    }

    public static void topNumbers(Collection<PhoneDirectory> phoneDirectory, int firstRecords) {

        Map<String, Integer> topNumbersMap = new TreeMap<>();
        List<PhoneDirectory> phoneDirectoryLinkedList = new LinkedList<>(phoneDirectory);

        for (ListIterator<PhoneDirectory> listIterator = phoneDirectoryLinkedList.listIterator(phoneDirectoryLinkedList.size());
             listIterator.hasPrevious(); ) {
            for (String listContact : listIterator.previous().getListContacts()) {
                Integer count = topNumbersMap.putIfAbsent(listContact, 1);
                if (count != null) {
                    topNumbersMap.put(listContact, count + 1);
                }
            }
        }

        Set<TopNumber> topNumbers = new TreeSet<>();
        for (Map.Entry<String, Integer> entry : topNumbersMap.entrySet()) {
            topNumbers.add(new TopNumber(entry.getKey(), entry.getValue()));
        }
        int index = 0;
        for (Iterator<TopNumber> iterator = topNumbers.iterator(); index < firstRecords && iterator.hasNext(); index++) {

            System.out.println(iterator.next());
        }
    }

    public static void topNumbers(PhoneDirectory[] phoneDirectory, int firstRecords) {
        String[] topNumber = new String[phoneDirectory.length];
        int[] topNumberCount = new int[phoneDirectory.length];
        int sizeTopNumber = 0;

        for (int index = 0; index < phoneDirectory.length; index++) {

            String[] listContacts = phoneDirectory[index].getListContactsArray();
            for (int indexListContact = 0; indexListContact < listContacts.length; indexListContact++) {

                for (int indexTopNumber = 0; indexTopNumber <= sizeTopNumber; indexTopNumber++) {

                    if (topNumber[indexTopNumber] == listContacts[indexListContact]) {
                        topNumberCount[indexTopNumber]++;
                        break;
                    }
                    if (indexTopNumber == sizeTopNumber) {
                        topNumber[indexTopNumber] = listContacts[indexListContact];
                        topNumberCount[indexTopNumber] = 1;
                        sizeTopNumber++;
                        break;
                    }
                }
            }
        }

        int tmpInt;
        String tmpString;

        for (int i = 0; i < sizeTopNumber - 1 && i <= firstRecords; i++) {
            for (int j = sizeTopNumber - 2; j >= i; j--) {
                if (topNumberCount[j] < topNumberCount[j + 1]) {
                    tmpInt = topNumberCount[j];
                    tmpString = topNumber[j];
                    topNumberCount[j] = topNumberCount[j + 1];
                    topNumber[j] = topNumber[j + 1];
                    topNumberCount[j + 1] = tmpInt;
                    topNumber[j + 1] = tmpString;
                }
            }
        }

        for (int index = 0; index < firstRecords && index < sizeTopNumber; index++) {
            System.out.println("number=%s, count=%d".formatted(topNumber[index], topNumberCount[index]));
        }
    }
}