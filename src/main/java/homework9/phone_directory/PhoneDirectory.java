package homework9.phone_directory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PhoneDirectory implements Comparable<PhoneDirectory> {
    private final String fio;
    private String number;
    private Set<String> listContacts;
    private String[] listContactsArray;

    public PhoneDirectory(String fio, String number) {
        this.fio = fio;
        this.number = number;
    }

    @Override
    public int compareTo(PhoneDirectory o) {
        return this.number.compareTo(o.number);
    }

    public String getFio() {

        return fio;
    }

    public String getNumber() {

        return number;
    }

    public Set<String> getListContacts() {

        return listContacts;
    }

    public void setListContacts(Set<String> listContacts) {

        this.listContacts = listContacts;
    }

    public String[] getListContactsArray() {
        return listContactsArray;
    }

    public void setListContactsArray(String[] listContactsArray) {
        this.listContactsArray = listContactsArray;
    }

    @Override
    public String toString() {
        String listContactsString = "";
        int index = 0;
        if (listContacts != null) {
            for (Iterator<String> iterator = listContacts.iterator(); iterator.hasNext(); ) {
                listContactsString += (index != 0 ? ", " : "") + iterator.next();
                index++;
            }
        }
        return "PhoneDirectory{" +
                "fio='" + fio + '\'' +
                ", number='" + number + '\'' +
                ", listContacts=" + listContactsString +
                '}';
    }
}
