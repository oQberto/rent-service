package by.alex.dto;

import by.alex.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Value
@Builder
@AllArgsConstructor
public record ApartmentDto(
        String id,
        String propertyType,
        LocalDateTime yearBuilt,
        Boolean petFriendly,
        Boolean furnished,
        String leaseTerm,
        Address address) {
}
