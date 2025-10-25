package com.hostlund.snus.repositories;

import com.hostlund.snus.model.Snus;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnusRepository extends JpaRepository<Snus, UUID> {

}
