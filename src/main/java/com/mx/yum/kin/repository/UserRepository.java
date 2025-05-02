package com.mx.yum.kin.repository;


import com.mx.yum.kin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
