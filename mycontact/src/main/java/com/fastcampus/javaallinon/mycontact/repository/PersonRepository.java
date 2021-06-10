package com.fastcampus.javaallinon.mycontact.repository;

import com.fastcampus.javaallinon.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);

    //List<Person> findByBlockIsNull();

    //List<Person> findByBloodType(String bloodType);

//    List<Person> findByBirthdayBetween(LocalDate startDate, LocalDate endDate);

    @Query(value = "select person from Person person where person.birthday.monthOfBirthday = :monthOfBirthday")
    List<Person> findByMonthOfBirthday(@Param("monthOfBirthday") int monthOfBirthday);

//    Person findByBloodType(String bloodType);

    @Query(value = "select person from Person person where person.deleted = true")
    List<Person> findPeopleDeleted();
}
