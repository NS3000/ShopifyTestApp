package org.example.Entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Address {

    @Id
    @Column(name = "address_id")
    private Long id;
    @Column(name = "address1")
    private String address1;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String province;
    @Column(name = "phone")
    private String phone;
    @Column(name = "zip")
    private String zip;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "country")
    private String country;

    @Column(name = "isDeleted", columnDefinition = "boolean default false")
    private Boolean isDel=false;

}
