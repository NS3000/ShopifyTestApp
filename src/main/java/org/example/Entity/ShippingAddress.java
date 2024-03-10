package org.example.Entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ShippingAddress")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;
    private String address1;
    private String city;
    private String province;
    private String phone;
    private String zip;
    private String firstName;
    private String lastName;
    private String country;

}
