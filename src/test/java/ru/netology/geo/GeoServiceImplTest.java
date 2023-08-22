package ru.netology.geo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @ParameterizedTest
    @ValueSource(strings = {"172.0.32.11", "172.1.2.3"})
    void byIpRussian(String input) {
        GeoServiceImpl geoService = new GeoServiceImpl();
        assertEquals(Country.RUSSIA, geoService.byIp(input).getCountry());
    }

    @ParameterizedTest
    @ValueSource(strings = {"96.0.32.11", "96.1.2.3"})
    void byIpEnglish(String input) {
        GeoServiceImpl geoService = new GeoServiceImpl();
        assertEquals(Country.USA, geoService.byIp(input).getCountry());
    }

    @Test
    void byCoordinates() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> geoService.byCoordinates(1, 2)
        );
        assertEquals("Not implemented", thrown.getMessage());
    }
}