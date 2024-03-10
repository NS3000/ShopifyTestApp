package org.example.DTO.FlfillmentDTOs;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.DTO.FlfillmentDTOs.FulfillmentOrderLineItemDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LineItemsByFulfilmentOrder {

    private Long fulfillmentOrderId;
    private FulfillmentOrderLineItemDTO fulfillmentOrderLineItems;

}
