package com.taihui.springboot.db.repository;

import com.taihui.springboot.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface UserRepository extends JpaRepository<User, Id> {

    @Override
    <S extends User> S save(S s);
}
