package org.example.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Student {

    private String id;

    private String name;

    private int age;

    private String mailId;

    private String district;

    private String department;

    private int rank;

    private List<String> phNumber;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String address) {
        this.district = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public List<String> getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(List<String> phNumber) {
        this.phNumber = phNumber;
    }


    public Student(String id, String name, int age, String mailId, String district, String department, int rank, List<String> phNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mailId = mailId;
        this.district = district;
        this.department = department;
        this.rank = rank;
        this.phNumber = phNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name,age,mailId,district,department,rank,phNumber);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mailId='" + mailId + '\'' +
                ", address='" + district + '\'' +
                ", department='" + department + '\'' +
                ", rank=" + rank +
                ", phNumber=" + phNumber +
                '}';
    }
}
