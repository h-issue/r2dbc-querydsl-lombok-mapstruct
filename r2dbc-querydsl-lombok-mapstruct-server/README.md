
make r2dbc, querydsl, lombok, mapstruct work together.

#### start app:

```
mvn clean test spring-boot:run
```

#### some testing API:

```
curl localhost:8080/api/user/pendingAUser
curl localhost:8080/api/user/getAllUsers
curl localhost:8080/api/user/getUsersByName/test
```

#### references:

> https://github.com/infobip/infobip-spring-data-querydsl

> https://github.com/infobip/infobip-spring-data-querydsl/issues/55
