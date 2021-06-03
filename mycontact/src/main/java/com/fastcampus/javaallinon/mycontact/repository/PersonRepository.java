package com.fastcampus.javaallinon.mycontact.repository;

import com.fastcampus.javaallinon.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
