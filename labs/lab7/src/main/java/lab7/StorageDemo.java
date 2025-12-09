package lab7;

import java.util.Comparator;

public class StorageDemo {

    static class User {
        String name; int age;
        User(String name, int age) { this.name = name; this.age = age; }
        public String toString() { return name + "(" + age + ")"; }
    }
    static class Product {
        String title; double price;
        Product(String title, double price) { this.title = title; this.price = price; }
        public String toString() { return title + " $" + price; }
    }

    public static void run() {
        // Users
        Storage<User> users = new Storage<>();
        users.add(new User("Akim", 20));
        users.add(new User("Nazar", 22));
        users.add(new User("Kira", 17));
        users.add(new User("Andrei", 19));

        System.out.println("Пользователи (все): " + users.getAll());
        System.out.println("Старше 18: " + users.filter(u -> u.age > 18));
        System.out.println("Отсортировано по возрасту: " + users.sort(Comparator.comparingInt(u -> u.age)));
        System.out.println("Найти по имени 'Kira': " + users.find(u -> u.name.equals("Kira")).orElse(null));

        // Products
        Storage<Product> products = new Storage<>();
        products.add(new Product("Mouse", 15.0));
        products.add(new Product("Keyboard", 45.5));
        products.add(new Product("Monitor", 199.0));
        products.add(new Product("USB Cable", 5.0));

        System.out.println("\nТовары (все): " + products.getAll());
        System.out.println("Дешевле 20: " + products.filter(p -> p.price < 20));
        System.out.println("Отсортировано по цене: " + products.sort(Comparator.comparingDouble(p -> p.price)));
        System.out.println("Удалить дорогие (>100): " + products.remove(p -> p.price > 100));
        System.out.println("После удаления: " + products.getAll());
    }
}
