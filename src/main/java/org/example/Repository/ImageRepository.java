package org.example.Repository;

import org.example.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {

    @Modifying
    @Query(value = "UPDATE images e SET e.is_deleted = true WHERE e.product_id = ?1",nativeQuery = true)
    void setIsDeletedTrue(long productId);
    @Modifying
    @Query(value = "DELETE FROM images e WHERE e.is_deleted = true",nativeQuery = true)
    void deleteUnused();
}
