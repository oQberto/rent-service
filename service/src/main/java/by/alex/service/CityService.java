package by.alex.service;

import by.alex.dao.CityDao;
import by.alex.dto.CityDto;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CityService {
    private static final CityService INSTANCE = new CityService();
    private final CityDao cityDao = CityDao.getInstance();

    public List<CityDto> findAll() {
        return cityDao.findAll().stream()
                .map(city -> CityDto.builder()
                        .id(city.getId())
                        .name(city.getName())
                        .build())
                .toList();
    }

    public static CityService getInstance() {
        return INSTANCE;
    }
}
