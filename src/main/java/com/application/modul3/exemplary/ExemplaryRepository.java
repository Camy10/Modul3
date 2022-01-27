package com.application.modul3.exemplary;

import org.springframework.data.jpa.repository.JpaRepository;

//Repostory este o interfata ce are rol de a stoca, de a accesa datele din db
public interface ExemplaryRepository extends JpaRepository<Exemplary, Integer> {

}
