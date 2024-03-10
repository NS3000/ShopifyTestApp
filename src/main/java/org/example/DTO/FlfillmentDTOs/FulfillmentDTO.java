package org.example.DTO.FlfillmentDTOs;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FulfillmentDTO {

    private TrackingInfoDTO trackingInfo;
    private List<LineItemsByFulfilmentOrder> lineItemsByFulfillmentOrder;

}
