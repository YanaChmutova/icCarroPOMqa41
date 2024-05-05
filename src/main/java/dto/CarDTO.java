package dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    String serNumber;
    String manufacture;
    String model;
    String city;
    int price;
    String carClass;
    String fuelType;
    int year;
    int seats;
    String about;
}