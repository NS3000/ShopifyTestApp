package org.example.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Products")
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Product{
    @Id
    @Column(name = "productId")
    Long id;
    @Column(name = "title")
    String title;
    @Column(name="body_html")
    String bodyHtml;
    @Column(name = "status")
    String status;
    @Column(name = "product_type")
    String productType;
    @Column(name = "created_at")
    String createdAt;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Product_id")
    List<Image> images;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    List<ProductVariants> variants;

}
