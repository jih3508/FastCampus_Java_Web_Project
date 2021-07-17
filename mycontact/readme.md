## 과제
### 오늘, 내일이 생일인 친구 목록을 반환하는 API 작성
### 지인 중에서 오늘이나 내일 생일은 사람들의 목록을 얻는 API를 만들어서 선물을 하고자 합니다. 요구사항은 아래와 같습니다.
- GET /api/person/birthday-friends
- API 를 호출하는 날자 기준  오늘, 내일이 생일인 사람들의 목록을 반환한다.

### controller
```java
  package com.fastcampus.javaallinon.mycontact.Work;

  import com.fastcampus.javaallinon.mycontact.domain.Person;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RestController;

  import java.util.List;

  @RestController
  @RequestMapping("/api/person")
  public class WorkController {

      @Autowired
      private WorkService workService;

      @GetMapping(value = "/birthday-friends")
      public List <Person> findBirthdayFriends(){
          return workService.findBirthdayFriends();
      }
  }
```

### Service
```java
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
```
### Repository
```java
@Query(value = "select person from Person person where (person.birthday.monthOfBirthday = :todayOfMonth and person.birthday.dayOfBirthday = :todayOfDay) or (person.birthday.monthOfBirthday = :tomorrowOfMonth and person.birthday.dayOfBirthday = :tomorrowOfDay)")
    List<Person> findByBirthdayBetweenTodayAndTomorrow(@Param("todayOfMonth") int todayOfMonth, @Param("todayOfDay") int todayOfDay,
                                                      @Param("tomorrowOfMonth") int tomorrowOfMonth, @Param("tomorrowOfDay") int tomorrowOfDay);

    @Query(value = "select person from Person person where person.birthday.monthOfBirthday = :todayMonthOfBirthday or person.birthday.monthOfBirthday =:tomorrowMonthOfBirthday")
    List<Person> findByMonthOfBirthdays(@Param("todayMonthOfBirthday") int todayMonthOfBirthday, @Param("tomorrowMonthOfBirthday") int tomorrowMonthOfBirthday);
```

### TDD
```java
@SpringBootTest
@Transactional
public class WorkControllerTest {

    @Autowired
    private WorkController workController;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void beforeEach() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .alwaysDo(print())
                .build();
    }

    @Test
    void findBirthdayFriends() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/person/birthday-friends"))
                .andExpect(status().isOk());
    }
}
```
