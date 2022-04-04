package ru.yandex.praktikum;
import static org.junit.Assert.assertEquals;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountTest {
    //поля класса
    private final String actualName;
    private final boolean expectedResult;
    //конструктор для параметризации
    public AccountTest(String actualName, boolean expectedResult){
        this.actualName=actualName;
        this.expectedResult=expectedResult;
    }
    //генерация тестовых данных
    @Parameterized.Parameters
    public static Object[][] getNameData(){
        return new Object[][]
                {
                        // пустая строка
                        {"",false},
                        //1 символ
                        {"П",false},
                        // 2 символа
                        {"ПЯ",false},
                        // 3 символа
                        {"П Я",true},
                        // 4 символа
                        {"П Ян",true},
                        // 15 символов
                        {"Константин Бугай",true},
                        // 18 символов
                        {"Александр Фердинанд",true},
                        // 19 символов
                        {"Иван Бурмистровский",true},
                        // 20 символов
                        {"Кондрат Кондратевский",false},
                        //25 символов
                        {"Владимиразер Деларамабурри",false},
                        //Пробел в начале
                        {" КонстантинБугай",false},
                        //Пробел в конце
                        {"КонстантинБугай ",false},
                        // 0 пробелов
                        {"КонстантинБугай",false},
                        //2 пробела
                        {"Констант Ин Бугай",false},
                        //Сдвоенный пробел
                        {"Константин  Бугай",false}
                };
    }

    @Test
    @DisplayName("Параметризированная проверка соответствия подаваемого имени формату")
    @Description("метод checkNameToEmboss класса Account")
    public void  checkNameToEmbossParametrizedReturnTrueOrFalse(){
        Account account=new Account(actualName);
        boolean actualResult=account.checkNameToEmboss();
        assertEquals("Name incorrect",expectedResult, actualResult);
        //вывод информации по тестовым данным в отчет, для упрощения анализа результатов тестов
        Allure.addAttachment("Имя для проверки",actualName);
        Allure.addAttachment("Ожидаемый результат от проверки", String.valueOf(expectedResult));
        Allure.addAttachment("Фактический результат проверки", String.valueOf(actualResult));
    }

}
