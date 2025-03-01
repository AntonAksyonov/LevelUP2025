package homework19;

import homework19.util.DbGuideHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DbGuideRunner {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<City> forAddedCities = new ArrayList<>();

        fill(forAddedCities, scanner);

        String sqlSelect = """
                select city.id, city.code, city.name, city.english_name, city.population
                from cities city
                where city.code = ? or ? is null;
                """;
        String sqlInsert = """
                insert into cities (code, name, english_name, population)
                values (?, ?, ?, ?);
                """;
        String sqlUpdate = """
                update cities set name = ?, english_name = ?, population = ?
                where code = ?;
                """;
        String sqlDelete = """
                delete from cities
                where code = ?;
                """;
        try (PreparedStatement statementSelect = DbGuideHelper.createPreparedStatement(sqlSelect)
        ) {
            ResultSet resultSet = null;
            for (int i = 0; i < forAddedCities.size(); i++) {
                City city = forAddedCities.get(i);
                statementSelect.setString(1, city.getCode());
                statementSelect.setString(2, city.getCode());

                resultSet = statementSelect.executeQuery();
                if (resultSet.next()) {
                    System.out.println(city);
                    System.out.println("- город с кодом '%s' уже существует.".formatted(city.getCode()));
                    System.out.println("Введите: u(обновить город), d(удалить город), s или другой символ(пропустить)");
                    switch (getScannerLine(scanner)) {
                        case "u": {
                            PreparedStatement statementUpdate = DbGuideHelper.createPreparedStatement(sqlUpdate);
                            statementUpdate.setString(1, city.getName());
                            statementUpdate.setString(2, city.getEnglishName());
                            statementUpdate.setInt(3, city.getPopulation());
                            statementUpdate.setString(4, city.getCode());
                            statementUpdate.executeUpdate();
                            break;
                        }
                        case "d": {
                            PreparedStatement statementDelete = DbGuideHelper.createPreparedStatement(sqlDelete);
                            statementDelete.setString(1, city.getCode());
                            statementDelete.executeUpdate();
                            break;
                        }
                    }
                } else {
                    PreparedStatement statementInsert = DbGuideHelper.createPreparedStatement(sqlInsert);
                    statementInsert.setString(1, city.getCode());
                    statementInsert.setString(2, city.getName());
                    statementInsert.setString(3, city.getEnglishName());
                    statementInsert.setInt(4, city.getPopulation());
                    statementInsert.executeUpdate();
                }
            }
            statementSelect.getConnection().commit();

            forAddedCities.clear();
            statementSelect.setString(1, null);
            statementSelect.setString(2, null);
            resultSet = statementSelect.executeQuery();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                String englishName = resultSet.getString("english_name");
                Integer population = DbGuideHelper.getInteger(resultSet, "population");
                forAddedCities.add(new City(code, name, englishName, population));
            }

            System.out.println(forAddedCities);
        }
    }

    private static void fill(List<City> forAddedCities, Scanner scanner) {
        System.out.println("Заполнение справочника городов.");
        System.out.println("Далее введите последовательно: код города, наименование ru, наименование en, численность проживающих");

        while (true) {

            System.out.println("Введите 'код города'");
            String code = getScannerLine(scanner);

            System.out.println("Введите 'наименование ru'");
            String name = getScannerLine(scanner);

            System.out.println("Введите 'наименование en'");
            String englishName = getScannerLine(scanner);

            System.out.println("Введите 'численность проживающих'");
            Integer population = Integer.valueOf(getScannerLine(scanner));

            forAddedCities.add(new City(code, name, englishName, population));

            System.out.println("Для добавления следующего города введите 'y', для выхода любой другой символ");
            if (!Objects.equals(getScannerLine(scanner), "y")) {
                break;
            }
        }
    }

    private static String getScannerLine(Scanner scanner) {
        String ret = null;
        if (scanner.hasNextLine()) {
            ret = scanner.nextLine();
        }
        return ret;
    }
}