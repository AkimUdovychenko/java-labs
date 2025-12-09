# Lab 2 (меню + тесты)

Запуск через меню:
```
cd labs/lab2/src/main/java
javac -encoding UTF-8 lab2/*.java
java lab2.Lab2Menu
```

Или в VS Code — открыть `Lab2Menu.java` и нажать ▶ Run.

В пункте **Invoice** вводятся все 4 поля (номер, описание, количество, цена), 
после чего выводится сумма счёта. Поля quantity/price валидируются в классе `Invoice`.
