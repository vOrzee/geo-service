package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GeoServiceImplTest {

    @ParameterizedTest
    @CsvSource(value = {
            "127.0.0.1, , , , 0",
            "172.0.32.11, Moscow, RUSSIA, Lenina, 15",
            "96.44.183.149, New York, USA, ' 10th Avenue', 32",
            "172.16.254.1, Moscow, RUSSIA, , 0",
            "96.158.1.89, New York, USA, , 0",
    })
    void byIp(String ip, String city, Country country, String street, int builing) {
        GeoService geoService = new GeoServiceImpl();
        Location actual = geoService.byIp(ip);
        Location expected = new Location(city, country, street, builing);
        Assertions.assertEquals(expected, actual);
    }
}