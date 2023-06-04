package by.alex.entity;

import by.alex.entity.enums.LeaseTerm;
import by.alex.entity.enums.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {
    private Integer id;
    private PropertyType propertyType;
    private LocalDateTime yearBuilt;
    private Boolean petFriendly;
    private Boolean furnished;
    private LeaseTerm leaseTerm;
    private List<String> apartment_photo;
}
