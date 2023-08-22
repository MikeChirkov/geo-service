package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void localeEnglish() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String test = localizationService.locale(Country.BRAZIL);
        assertEquals("Welcome", test);
    }

    @Test
    void localeRussian() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String test = localizationService.locale(Country.RUSSIA);
        assertEquals("Добро пожаловать", test);
    }
}