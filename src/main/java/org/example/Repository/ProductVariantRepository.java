package org.example.Repository;

import org.example.Entity.ProductVariants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariants,Long> {


    @Modifying
    @Query(value = "UPDATE product_variants e SET e.is_deleted = true WHERE e.product_id = ?1",nativeQuery = true)
    void setIsDeletedTrue(long productId);
    @Modifying
    @Query(value = "DELETE FROM product_variants e WHERE e.is_deleted = true",nativeQuery = true)
    void deleteUnused();
}
