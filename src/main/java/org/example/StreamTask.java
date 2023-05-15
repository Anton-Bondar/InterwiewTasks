package org.example;

import org.example.model.Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTask {

    public static void main(String[] args) {
        List<Employee> employees = List.of(Employee.builder()
                        .id(1L)
                        .firstName("Alex")
                        .lastName("Kost")
                        .department(1L)
                        .build(),
                Employee.builder()
                        .id(2L)
                        .firstName("Bill")
                        .lastName("Myrey")
                        .department(1L)
                        .build()
        );

        List<String> names = employees.stream()
                .map(e -> String.join(" ", e.getFirstName(), e.getLastName()))
                .collect(Collectors.toList());

        System.out.format("names %s", names);

        Map<Long, List<Employee>> grouped = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Function.identity(), Collectors.toList())));

        Comparator<Employee> comparator = Comparator.comparing(Employee::getFirstName);

        grouped.values()
                .stream()
                .forEach(empl -> Collections.sort(empl, comparator));

        System.out.println("grouped empl: " + grouped);
    }
}
