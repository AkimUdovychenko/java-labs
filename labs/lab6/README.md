# Lab 6 (меню + три задания)

Запуск:
```
cd labs/lab6/src/main/java
javac -encoding UTF-8 lab6/*.java
java lab6.Lab6Menu
```

1) **Иерархия четырехугольников**  
`Quadrilateral` → `Trapezoid` → `Parallelogram` → `Rectangle` → `Square` (глубокая).  
`Point` хранит координаты. Площадь считается по формуле «шнурка» в подклассах.

2) **CarbonFootprint (полиморфизм)**  
Интерфейс `CarbonFootprint` реализован в `Building`, `Car`, `Airplane`. Демонстрация через список.

3) **Библиотека с исключениями**  
`Book`, `User`, `Library` + свои исключения: `BookAlreadyBorrowedException`, `BookNotBorrowedException`,  
`UserNotFoundException`, `MaxBooksLimitException`, `BookNotFoundException`.  
Консольные команды: `lend <book> <user>`, `return <book> <user>`, `show`, `exit`.
