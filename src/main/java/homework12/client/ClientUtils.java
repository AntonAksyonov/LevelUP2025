package homework12.client;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

public class ClientUtils {

    private static Client setFildsClient(Client client, String name, String inn) throws IllegalAccessException {
        Class<?> cClass = Client.class;

        for (Field field : cClass.getDeclaredFields()) {
            field.setAccessible(true);
            switch (field.getName()) {
                case "name": {
                    field.set(client, name);
                    break;
                }
                case "inn": {
                    field.set(client, inn);
                    break;
                }
            }
        }
        return client;
    }

    public static Personal createPersonal(String name, String inn, LocalDateTime birthdate, String passportSeries, String passportNumber) throws InstantiationException, IllegalAccessException {
        Class<?> pClass = Personal.class;
        Personal personal = (Personal) pClass.newInstance();
        personal = (Personal) setFildsClient(personal, name, inn);

        for (Field field : pClass.getDeclaredFields()) {
            field.setAccessible(true);
            switch (field.getName()) {
                case "birthdate": {
                    field.set(personal, birthdate);
                    break;
                }
                case "passportSeries": {
                    field.set(personal, passportSeries);
                    break;
                }
                case "passportNumber": {
                    field.set(personal, passportNumber);
                    break;
                }
            }
        }

        return personal;
    }

    public static Company createCompany(String name, String inn, String fullName, String ogrn, String okved) throws InstantiationException, IllegalAccessException {
        Class<?> cClass = Company.class;
        Company company = (Company) cClass.newInstance();
        company = (Company) setFildsClient(company, name, inn);

        for (Field field : cClass.getDeclaredFields()) {
            field.setAccessible(true);
            switch (field.getName()) {
                case "fullName": {
                    field.set(company, fullName);
                    break;
                }
                case "ogrn": {
                    field.set(company, ogrn);
                    break;
                }
                case "okved": {
                    field.set(company, okved);
                    break;
                }
            }
        }

        return company;
    }

    public static String printing(Client client) throws IllegalAccessException {
        String result = "{";
        Class<?> cClass = client.getClass();
        Class<?> sClass = cClass.getSuperclass();

        for (Field field : sClass.getDeclaredFields()) {
            field.setAccessible(true);
            result += (result.length() != 1 ? "; " : "") + field.getName() + "=" + field.get(client);
        }

        for (Field field : cClass.getDeclaredFields()) {
            field.setAccessible(true);
            result += (result.length() != 1 ? "; " : "") + field.getName() + "=" + field.get(client);
        }

        return result + "}";
    }
}
