package homework9.phonedirectory;

import homework9.influencehashcode.EmployeeUtils;

import java.util.Set;
import java.util.TreeSet;

public class Runner {
    public static void main(String[] args) {

        int sizeDirectory = 100000;
        int maxListContacts = 50;
        int firstMaxRecords = 5;

        EmployeeUtils.runTimer();
        Set<PhoneDirectory> phoneDirectory = (TreeSet<PhoneDirectory>) PhoneDirectoryUtils.generate(sizeDirectory, maxListContacts);
        EmployeeUtils.stopTimer("Время заполнения справрочника класса %s составило: ".formatted(phoneDirectory.getClass().getName()));

        EmployeeUtils.runTimer();
        PhoneDirectoryUtils.topNumbers(phoneDirectory, firstMaxRecords);
        EmployeeUtils.stopTimer("Время поиска в справрочнике класса %s составило: ".formatted(phoneDirectory.getClass().getName()));

        System.out.println("----");

        EmployeeUtils.runTimer();
        PhoneDirectory[] phoneDirectoryArray = PhoneDirectoryUtils.generateArray(sizeDirectory, maxListContacts);
        EmployeeUtils.stopTimer("Время заполнения справрочника класса %s составило: ".formatted("Array"));

        EmployeeUtils.runTimer();
        PhoneDirectoryUtils.topNumbers(phoneDirectoryArray, firstMaxRecords);
        EmployeeUtils.stopTimer("Время поиска в справрочнике класса %s составило: ".formatted("Array"));
    }
}
