## 과제
### 오늘, 내일이 생일인 친구 목록을 반환하는 API 작성
### 지인 중에서 오늘이나 내일 생일은 사람들의 목록을 얻는 API를 만들어서 선물을 하고자 합니다. 요구사항은 아래와 같습니다.
- GET /api/person/birthday-friends
- API 를 호출하는 날자 기준  오늘, 내일이 생일인 사람들의 목록을 반환한다.

- controller
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
