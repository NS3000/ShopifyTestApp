package org.example.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.SequenceGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.Entity.Address;
import org.example.Entity.Customer;
import org.example.Entity.LineItem;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderRequestDTO {

    private ShippingAddressDTO shippingAddress;
//    private Address billing_address;
    private List<LineItemRequestDTO> lineItems;
    private CustomerRequestDTO customer;

}
