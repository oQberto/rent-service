package by.alex.dto;

import by.alex.entity.Address;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ApartmentDto {
        Integer id;
        String propertyType;
        LocalDateTime yearBuilt;
        Boolean petFriendly;
        Boolean furnished;
        String leaseTerm;
        Address address;
}