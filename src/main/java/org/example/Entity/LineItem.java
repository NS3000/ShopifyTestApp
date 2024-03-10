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
import org.hibernate.annotations.SecondaryRow;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LineItems")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LineItem {

    @Id
    @Column(name = "LineItem_id")
    private Long id;
    @Column(name = "productId")
    private Long productId;
    @Column(name = "variantId")
    private Long variantId;
    @Column(name = "vendor")
    private String vendor;
    @Column(name = "itemName")
    private String name;
    @Column(name = "price")
    private String price;
    @Column(name = "weightGrams")
    private String grams;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "fulfillmentStatus")
    private String fulfillmentStatus;

}
