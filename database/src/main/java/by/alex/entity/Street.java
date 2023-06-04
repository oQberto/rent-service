package by.alex.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Street {
    private Integer id;
    private String name;
    private String zipCode;
}
