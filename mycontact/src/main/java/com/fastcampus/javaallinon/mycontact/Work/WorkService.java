package com.fastcampus.javaallinon.mycontact.Work;

import com.fastcampus.javaallinon.mycontact.domain.Person;
import com.fastcampus.javaallinon.mycontact.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkService {

    @Autowired
    PersonRepository personRepository;

    @Transactional // 방법1: spl로 찾아 내기
    public List<Person> findBirthdayFriends() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate today = LocalDate.now();
        return personRepository.findByBirthdayBetweenTodayAndTomorrow(LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()
        , tomorrow.getMonthValue(), tomorrow.getDayOfMonth());
    }

    @Transactional // 방법2 해당되는 달/월을 불려서 오늘 내일 생일인 사람을 필터링을 한다.
    public List<Person> findBirthdayFriends2() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate today = LocalDate.now();

        List<Person> result = personRepository.findByMonthOfBirthdays(today.getMonthValue(), tomorrow.getDayOfMonth());

        return result.stream().filter(person -> person.getBirthday().getDayOfBirthday() == today.getDayOfMonth()
                                        || person.getBirthday().getDayOfBirthday() == tomorrow.getDayOfMonth()).collect(Collectors.toList());
    }
}
