package org.example.Entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.DTO.ShippingAddressDTO;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Order {

    @Id
    @Column(name = "order_id")
    private Long id;

    @Column(name = "CreatedAt")
    private String createdAt;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private ShippingAddress shippingAddress;

    @Column(name = "CancelledAt")
    private String cancelledAt;

    @Column(name = "ClosedAt")
    private String closedAt;

    @Column(name = "fulfillmentStatus")
    private String fulfillmentStatus;

    @Column(name = "note")
    private String note;

    @Column(name = "totalPrice")
    private String totalPrice;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "Currency")
    private String currency;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private List<LineItem> lineItems;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<Fulfillment> fulfillments;


}
