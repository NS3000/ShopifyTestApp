package org.example.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Entity.Address;
import org.example.Repository.AddressRepository;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CustomerRequestDTO {

    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private String passwordConfirmation;
    private List<AddressRequestDTO> addresses;
}
