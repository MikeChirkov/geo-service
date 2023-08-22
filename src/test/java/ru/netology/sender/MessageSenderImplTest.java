package ru.netology.sender;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;


@ExtendWith(MockitoExtension.class)
public class MessageSenderImplTest {

    @Test
    public void sendRussian() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(Mockito.<String>any())).thenReturn(
                new Location("Moscow", Country.RUSSIA, null, 0)
        );

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Mockito.<Country>any())).thenReturn(
                "Добро пожаловать"
        );
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String test = messageSender.send(new HashMap<String, String>());
        Mockito.verify(geoService, Mockito.atLeastOnce()).byIp(Mockito.anyString());
        Assertions.assertEquals("Добро пожаловать", test);
    }

    @Test
    public void sendEnglish() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(Mockito.<String>any())).thenReturn(
                new Location("New York", Country.USA, null,  0)
        );

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Mockito.<Country>any())).thenReturn(
                "Welcome"
        );
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String test = messageSender.send(new HashMap<String, String>());
        Mockito.verify(geoService, Mockito.atLeastOnce()).byIp(Mockito.anyString());
        Assertions.assertEquals("Welcome", test);
    }

}