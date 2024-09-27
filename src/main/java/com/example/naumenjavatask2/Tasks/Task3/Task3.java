package com.example.naumenjavatask2.Tasks.Task3;


import java.util.ArrayList;
import java.util.Comparator;

public class Task3 {
    ArrayList<Employee> list=new ArrayList<Employee>();

    public Task3() {

        list.add(new Employee("John Young", 20, "Busyness", 10000));
        list.add(new Employee("Marta Glorka", 30, "Marketing", 900000));
        list.add(new Employee("Victor Oldinov", 65, "Busyness", 20000));
        list.add(new Employee("Kris Tafer", 40, "Worker", 30000));
        list.add(new Employee("Bilguna Viktorov", 50, "Busyness", 40000));


        showInfoAndResult();

    }
    private void showInfoAndResult() {
        System.out.println("Name - department");
        list.stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .map(e-> e.getFullName() + " - " + e.getDepartment())
                .forEach(System.out::println);

    }

    public static void main(String[] args) {
        new Task3();
    }
}

