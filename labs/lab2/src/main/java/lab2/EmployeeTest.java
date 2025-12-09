package lab2;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("Akim", "Hutsul", 1500);
        Employee e2 = new Employee("Nazar", "Baron", 2200);

        System.out.println("Годовая зарплата сотрудника 1: " + e1.getMonthlySalary() * 12);
        System.out.println("Годовая зарплата сотрудника 2: " + e2.getMonthlySalary() * 12);

        e1.setMonthlySalary(e1.getMonthlySalary() * 1.10);
        e2.setMonthlySalary(e2.getMonthlySalary() * 1.10);

        System.out.println("\nПосле повышения:");
        System.out.println("Сотрудник 1: " + e1.getMonthlySalary() * 12);
        System.out.println("Сотрудник 2: " + e2.getMonthlySalary() * 12);
    }
}
