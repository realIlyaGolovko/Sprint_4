package ru.yandex.praktikum;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import io.qameta.allure.Step;

public class Account {
    private final String name;
    //регулярка для сравнения имени с форматом в требованиях
    private final String USERNAME_REGEX="^(?=.{3,19}$)([А-Я][а-я]{0,16})+\\s([А-Я][а-я]{0,16})";
    public Account(String name) {
        this.name = name;
    }


    @Step("Проверка имени на соотв. формату")
    public boolean checkNameToEmboss() {

         /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */

        Pattern pattern=Pattern.compile(USERNAME_REGEX);
        Matcher matcher=pattern.matcher(name);
        return matcher.matches();
    }
}
