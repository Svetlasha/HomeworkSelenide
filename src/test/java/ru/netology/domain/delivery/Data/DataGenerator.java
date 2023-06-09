package ru.netology.domain.delivery.Data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;



public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays ( shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }



    public static String generateCity(String locale) {

        var cities = new String[]{"Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Владикавказ", "Горно-Алтайск",
                "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Краснодар", "Магадан", "Магас", "Махачкала", "Нарьян-Мар",
                "Петропавловск-Камчатский", "Салехард", "Самара", "Саранск", "Саратов", "Хабаровск", "Ханты-Мансийск",
                "Южно-Сахалинск", "Белгород", "Великий Новгород", "Владивосток", "Волгоград",
                "Вологда", "Воронеж", "Горно-Алтайск", "Иваново", "Йошкар-Ола", "Кемерово",
                "Кострома", "Нижний Новгород", "Новосибирск", "Петрозаводск", "Ростов-на-Дону",
                "Севастополь", "Симферополь", "Ставрополь", "Майкоп", "Уфа", "Улан-Удэ", "Нальчик", "Якутск",
                "Элиста", "Черкесск", "Сыктывкар", "Кызыл", "Ижевск", "Грозный", "Чебоксары", "Чита", "Красноярск",
                "Пермь", "Благовещенск", "Брянск", "Владимир", "Орёл", "Иркутск", "Киров", "Курган", "Курск", "Санкт-Петербург",
                "Липецк", "Москва", "Мурманск", "Омск", "Оренбург", "Пенза", "Псков", "Рязань", "Екатеринбург", "Смоленск",
                "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Ульяновск", "Челябинск", "Ярославль", "Биробиджан"};

        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        Locale localeRu = new Locale("ru");
        Faker faker = new Faker(localeRu);
        String phone = faker.phoneNumber().phoneNumber().replace("(","").replace(")","").replace("-","");
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale), generateName(locale),generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}