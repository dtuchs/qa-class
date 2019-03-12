# Devclub.eu 28.02.2019 demo
Демонстрация поведения JUnit5 Extension, Converter, Resolver при многопоточном выполнении.
[Запись доклада.](https://www.youtube.com/watch?v=LuLBL-DHTAQ&t=1s)

#### Запуск в один поток:
```
$ mvn test -Dtest=SelenideTest
```

#### Запуск в три потока:
```
$ mvn test -Dtest=SelenideTest -Djupiter.parallel=true
```