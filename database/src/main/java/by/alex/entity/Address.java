package by.alex.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Address {
    private Integer id;
    private Street street;
    private City city;
    private Integer houseNumber;
}
