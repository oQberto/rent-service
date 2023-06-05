package by.alex.service;

import by.alex.dao.ApartmentDao;
import by.alex.dto.ApartmentDto;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ApartmentService {
    private static final ApartmentService INSTANCE = new ApartmentService();
    private final ApartmentDao apartmentDao = ApartmentDao.getInstance();

    public List<ApartmentDto> findByCityId(Integer id) {
        return apartmentDao.findByCityId(id).stream()
                .map(apartment -> ApartmentDto.builder()
                        .id(apartment.getId())
                        .propertyType(apartment.getPropertyType().name())
                        .yearBuilt(apartment.getYearBuilt())
                        .petFriendly(apartment.getPetFriendly())
                        .furnished(apartment.getFurnished())
                        .leaseTerm(apartment.getLeaseTerm().name())
                        .address(apartment.getAddress())
                        .build())
                .toList();
    }

    public List<ApartmentDto> findAll() {
        return apartmentDao.findAll().stream()
                .map(apartment -> ApartmentDto.builder()
                        .id(apartment.getId())
                        .propertyType(apartment.getPropertyType().name())
                        .yearBuilt(apartment.getYearBuilt())
                        .petFriendly(apartment.getPetFriendly())
                        .furnished(apartment.getFurnished())
                        .leaseTerm(apartment.getLeaseTerm().name())
                        .address(apartment.getAddress())
                        .build())
                .toList();
    }

    public static ApartmentService getInstance() {
        return INSTANCE;
    }
}
