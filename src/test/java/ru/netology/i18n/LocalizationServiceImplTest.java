package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {

    @ParameterizedTest
    @CsvSource({
            "RUSSIA, Добро пожаловать",
            "GERMANY, Welcome",
            "USA, Welcome",
            "BRAZIL, Welcome"
    })
    void locale(Country country, String expected) {
        LocalizationService localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(country);
        Assertions.assertEquals(expected, actual);
    }

}