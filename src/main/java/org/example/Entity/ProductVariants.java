package org.example.Entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ProductVariants")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductVariants {
    @Id
    @Column(name = "variantId")
    long id;
    @Column(name = "createdAt")
    String createdAt;
    @Column(name = "price")
    String price;
    @Column(name = "isDeleted", columnDefinition = "boolean default false")
    private Boolean isDel=false;

}
