package homework21;

import homework21.impl.CityJpaDaoImpl;
import homework21.impl.RegionJpaDaoImpl;
import homework21.interfaces.CityDao;
import homework21.interfaces.RegionDao;
import homework21.model.City;
import homework21.model.Region;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class GuideRunner {
    private static final CityDao cityDao = new CityJpaDaoImpl();
    private static final RegionDao regionDao = new RegionJpaDaoImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("В справочнике записи:");
        System.out.println(cityDao.findAll());

        fill(scanner);

        System.out.println("В справочнике записи после добавления:");
        System.out.println(cityDao.findAll());
    }

    private static void fill(Scanner scanner) {
        System.out.println("Заполнение справочника городов.");
        System.out.println("Далее введите последовательно: код города, наименование ru, наименование en, численность проживающих");

        while (true) {

            System.out.println("Введите 'код города'");
            String code = getScannerLine(scanner);

            System.out.println("Введите 'код региона'");
            String regionCode = getScannerLine(scanner);

            System.out.println("Введите 'наименование ru'");
            String name = getScannerLine(scanner);

            System.out.println("Введите 'наименование en'");
            String englishName = getScannerLine(scanner);

            System.out.println("Введите 'численность проживающих'");
            Integer population = Integer.valueOf(getScannerLine(scanner));

            Optional<Region> enteredRegion = regionDao.findByCode(regionCode);
            RegionHolder regionHolder = new RegionHolder();
            enteredRegion.ifPresentOrElse(regionHolder::setValue, () -> {
                System.out.println("Региона с кодом '%s' ещё не существует в базе.".formatted(regionCode));
                System.out.println("Введите 'наименование региона'");
                String regionName = getScannerLine(scanner);
                regionDao.save(new Region(regionCode, regionName));
                regionDao.findByCode(regionCode).ifPresent(regionHolder::setValue);
            });

            Region region = regionHolder.getValue();
            Optional<City> enteredCity = cityDao.findByCode(code);
            enteredCity.ifPresentOrElse(it -> {
                System.out.println(it);
                System.out.println("- город с кодом '%s' уже существует.".formatted(it.getCode()));
                System.out.println("Введите: u(обновить город), d(удалить город), s или другой символ(пропустить)");
                switch (getScannerLine(scanner)) {
                    case "u": {
                        it.setRegion(region);
                        it.setName(name);
                        it.setEnglishName(englishName);
                        it.setPopulation(population);
                        cityDao.save(it);
                        break;
                    }
                    case "d": {
                        cityDao.delete(it);
                        break;
                    }
                }
            }, () -> {
                cityDao.save(new City(code, region, name, englishName, population));
            });

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

    public static class RegionHolder {
        private Region value;

        public void setValue(Region value) {
            this.value = value;
        }

        public Region getValue() {
            return value;
        }
    }
}
