package lab7;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UsersStreamDemo {

    static class User {
        private final String name;
        private final int age;
        private final String city;
        private final List<String> tags;

        public User(String name, int age, String city, List<String> tags) {
            this.name = name;
            this.age = age;
            this.city = city;
            this.tags = List.copyOf(tags);
        }
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getCity() { return city; }
        public List<String> getTags() { return tags; }
        @Override public String toString() {
            return "%s (%d, %s) %s".formatted(name, age, city, tags);
        }
    }

    private static List<User> seed() {
        return List.of(
            new User("Akim", 20, "Chisinau", List.of("gaming", "music", "sport")),
            new User("Nazar", 22, "Berlin", List.of("travel", "sport")),
            new User("Kira", 17, "Kyiv", List.of("art", "music")),
            new User("Andrei", 19, "Berlin", List.of("coding", "sport", "music")),
            new User("Narmin", 16, "Baku", List.of("travel", "music", "reading")),
            new User("Marta", 25, "Warsaw", List.of("fitness", "travel")),
            new User("Ivan", 13, "Lviv", List.of("gaming")),
            new User("Oleh", 31, "Berlin", List.of("sport", "reading")),
            new User("Sofia", 28, "Chisinau", List.of("art", "travel", "music")),
            new User("Daria", 18, "Prague", List.of("music", "sport")),
            new User("Yaroslav", 21, "Kyiv", List.of("coding", "gaming")),
            new User("Maks", 12, "Riga", List.of("lego", "travel"))
        );
    }

    public static void run() {
        List<User> users = seed();

        System.out.println("Изначальный список пользователей:");
        users.forEach(u -> System.out.println("  - " + u));

        System.out.println("\nФильтрации:");
        System.out.println("Старше 18:");
        users.stream().filter(u -> u.getAge() > 18).forEach(u -> System.out.println("  - " + u));

        System.out.println("\nИз города Berlin:");
        users.stream().filter(u -> u.getCity().equalsIgnoreCase("Berlin")).forEach(u -> System.out.println("  - " + u));

        System.out.println("\nС тегом 'sport':");
        users.stream().filter(u -> u.getTags().contains("sport")).forEach(u -> System.out.println("  - " + u));

        System.out.println("\nСортировки:");
        System.out.println("По возрасту:");
        users.stream().sorted(Comparator.comparingInt(User::getAge))
                .forEach(u -> System.out.println("  - " + u));

        System.out.println("\nПо имени:");
        users.stream().sorted(Comparator.comparing(User::getName))
                .forEach(u -> System.out.println("  - " + u));

        System.out.println("\nСначала по городу, затем по имени:");
        users.stream().sorted(Comparator.comparing(User::getCity).thenComparing(User::getName))
                .forEach(u -> System.out.println("  - " + u));

        System.out.println("\nMap-операции:");
        System.out.println("Только имена:");
        List<String> names = users.stream().map(User::getName).toList();
        System.out.println("  " + names);

        System.out.println("Длины имён:");
        List<Integer> nameLengths = users.stream().map(u -> u.getName().length()).toList();
        System.out.println("  " + nameLengths);

        System.out.println("Все уникальные теги (flatMap):");
        Set<String> uniqueTags = users.stream()
                .flatMap(u -> u.getTags().stream())
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("  " + uniqueTags);

        System.out.println("\nГруппировки:");
        System.out.println("По городу:");
        Map<String, List<User>> byCity = users.stream().collect(Collectors.groupingBy(User::getCity));
        byCity.forEach((city, list) -> {
            System.out.println("  " + city + ": " + list.stream().map(User::getName).toList());
        });

        System.out.println("\nПо возрастным категориям:");
        Function<User, String> ageBucket = u -> {
            if (u.getAge() <= 12) return "child";
            if (u.getAge() <= 17) return "teen";
            return "adult";
        };
        Map<String, List<User>> byBucket = users.stream().collect(Collectors.groupingBy(ageBucket));
        byBucket.forEach((bucket, list) -> {
            System.out.println("  " + bucket + ": " + list.stream().map(User::getName).toList());
        });

        System.out.println("\nReduce/summary:");
        int totalAge = users.stream().map(User::getAge).reduce(0, Integer::sum);
        double avgAge = users.stream().mapToInt(User::getAge).average().orElse(0);
        User oldest = users.stream().reduce((a,b) -> a.getAge() >= b.getAge() ? a : b).orElse(null);
        User youngest = users.stream().reduce((a,b) -> a.getAge() <= b.getAge() ? a : b).orElse(null);
        System.out.println("Суммарный возраст: " + totalAge);
        System.out.println("Средний возраст: " + String.format(Locale.US, "%.2f", avgAge));
        System.out.println("Самый старший: " + oldest);
        System.out.println("Самый молодой: " + youngest);
    }
}
