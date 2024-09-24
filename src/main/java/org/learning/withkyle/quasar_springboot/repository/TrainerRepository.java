package org.learning.withkyle.quasar_springboot.repository;

import java.util.Optional;

import org.learning.withkyle.quasar_springboot.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long>{
    @Query("SELECT password " 
        + "FROM Trainer t "
        + "WHERE t.userName=:userName"
    )
    Optional<String> checkUserName(@Param("userName") String userName);
    
}
