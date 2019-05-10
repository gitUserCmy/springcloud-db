package com.taihui.springboot.db.repository;

import com.taihui.springboot.db.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
@Repository
public interface RoleRepository extends JpaRepository<Role, Id> {
}
