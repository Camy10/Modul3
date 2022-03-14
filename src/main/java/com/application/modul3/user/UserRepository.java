package com.application.modul3.user;

import org.springframework.data.jpa.repository.JpaRepository;

//se creaza un Repository ptr a interactiona cu users din db
public interface UserRepository extends JpaRepository<User, Integer> {

}
