package org.example.Entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Fulfillment {
    @Id
    @Column(name = "fulfillmentId")
    private Long id;
//    @Column(name = "orderId")
//    private Long order_id;
    @Column(name = "status")
    private String status;
    @Column(name = "createdAt")
    private String createdAt;
    @Column(name = "service")
    private String service;
    @Column(name = "shipmentStatus")
    private String shipmentStatus;
    @Column(name = "trackingCompany")
    private String trackingCompany;
    @Column(name = "trackingNumber")
    private String trackingNumber;
    @Column(name = "trackingUrl")
    private String trackingUrl;

}
