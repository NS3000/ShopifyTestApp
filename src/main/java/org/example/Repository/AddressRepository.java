package org.example.Repository;

import org.example.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    @Modifying
    @Query(value = "UPDATE addresses e SET e.is_deleted = true WHERE e.customer_id = ?1",nativeQuery = true)
    void setIsDeletedTrue(long customerId);
    @Modifying
    @Query(value = "DELETE FROM addresses e WHERE e.is_deleted = true",nativeQuery = true)
    void deleteUnused();
}
