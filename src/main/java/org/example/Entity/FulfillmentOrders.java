package org.example.Entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.sound.sampled.Line;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FulfillmentOrders {

    @Id
    @Column(name = "fulfillmentOrder_id")
    private Long id;
    @Column(name = "status")
    private String status;
    @Column(name = "requestStatus")
    private String requestStatus;
    @Column(name = "shopId")
    private Long shopId;
    @Column(name = "orderId")
    private Long orderId;
    @Column(name = "assignedLocationId")
    private Long assignedLocationId;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address destination;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fulfillmentOrder_id" )
    private List<FulfillmentOrderLineItem> lineItems;

}
