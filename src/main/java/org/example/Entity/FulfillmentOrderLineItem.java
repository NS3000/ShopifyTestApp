package org.example.Entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FulfillmentOrderLineItem {

    @Id
    private Long id;
    private Long shopId;
    private Long fulfillmentOrderId;
    private Long quantity;
    private Long lineItemId;
    private Long inventoryItemId;
    private Long fulfillableQuantity;
    private Long variantId;

}
