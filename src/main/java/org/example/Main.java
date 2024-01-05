package org.example;

import org.example.model.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//        List<Student> students = Arrays.asList(new Student("1", "jerin", 23, "jerin@123", "tharavilai", "ECE", 7, Arrays.asList("345", "1234")),
//                new Student("1", "jerin", 23, "jerin@123", "tharavilai", "ECE", 7, Arrays.asList("345", "1234")),
//                new Student("1", "jerin", 23, "jerin@123", "tharavilai", "ECE", 7, Arrays.asList("345", "1234")));
        List<Student> studentsList = Stream.of(new Student("1", "jerin", 23, "jerin@123", "Kanniyakumari", "ECE", 7, Arrays.asList("345", "1234")),
                new Student("1", "sujith", 23, "sujith@123", "Theni", "civil", 5, Arrays.asList("345", "1234")),
                new Student("2", "bala", 23, "bala@123", "Kanniyakumari", "cse", 3, Arrays.asList("345", "1234")),
                new Student("3", "raja", 23, "raja@123", "kerala", "mech", 2, Arrays.asList("345", "1234")),
                new Student("4", "karthick", 23, "karthick@123", "Tirunelveli", "ECE", 1, Arrays.asList("345", "1234")),
                new Student("5", "david", 23, "david@123", "kerala", "civil", 8, Arrays.asList("345", "1234")),
                new Student("6", "anto", 23, "anto@123", "Chennai", "cse", 3, Arrays.asList("345", "1234"))).collect(Collectors.toList());


//find kk students by reverse sorting
        List<Student> studentss = studentsList.stream()
                .filter(student -> student.getDistrict().equals("Kanniyakumari"))
                .sorted(Comparator.comparing(Student ::getName,Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println("1"+studentss);

// get all unique districts by students
        List<String> district = studentsList.stream()
                .map(Student::getDistrict)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("DISTRICTS"+district);

        // get all contact number
        List<List<String>> contacts = studentsList.stream()
                .map(Student::getPhNumber)
                .collect(Collectors.toList());
        System.out.println("2"+contacts);

        //one to one = map   (ex -name)
        //one to many = flatmap  (ex - phNumber)

        List<String> phnumber = studentsList.stream()
                .flatMap(student -> student.getPhNumber().stream())
                .collect(Collectors.toList());
        System.out.println("3"+phnumber);


        //group the student by depart
        Map<String, List<Student>> studentMap = studentsList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment));
        System.out.println("4"+studentMap);


        Map.Entry<String, Long> stringLongEntry = studentsList.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get();

        System.out.println("5"+stringLongEntry);



        Map<String, Double> collect = studentsList.stream().
                collect(Collectors
                        .groupingBy(Student::getDepartment, Collectors.averagingInt(Student::getAge)));
        System.out.println(collect);


        // find students minrank by individual departmant
        Map<String, Optional<Student>> collect1 = studentsList.stream()
                .collect(Collectors
                        .groupingBy(Student::getDepartment, Collectors
                                .minBy(Comparator
                                        .comparing(Student::getRank))));
        System.out.println("&&&"+collect1);

        // find the first rank student
        Student sorted = studentsList.stream().sorted(Comparator.comparing(Student::getRank))
                .findFirst().get();
        System.out.println(sorted);


        String[] states = {"Kanniyakumari","Chennai","Tirunelveli","Theni","kerala"};
        Random random = new Random();
        // Generate a random index to pick a state name
        int randomIndex = random.nextInt(states.length);

        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Student student1 = new Student(
                    String.valueOf(i + 1),
                    "Student" + (i + 1),
                    20 + i % 5,  // Varying age for diversity
                    "student" + (i + 1) + "@gmail.com",
                    states[randomIndex],
                    "Department" + (i % 3 + 1),
                     random.nextInt(10),  // Varying grade
                    Arrays.asList("87654343" + i , "345678" + i)
            );
            studentList.add(student1);
        }
        System.out.println(studentList.size());

        List<Student> students = studentList.stream()
                .filter(student -> student.getRank() >= 1 && student.getRank() <= 3)
                .collect(Collectors.toList());
        System.out.println(students.size());
        System.out.println(students);


    }
}