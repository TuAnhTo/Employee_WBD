package com.codegym.cms.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int Manv;
    private String sex;
    private int phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Employee(){}

    public Employee(int manv, String name, String sex, int phone, String email) {
        Manv = manv;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
    }
    @Override
    public String toString(){
        return String.format("Employee[id=%d, name='%s',Manv='%d', sex='%s',phone='%d',email='%s']",id,name,Manv,sex,phone,email);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManv() {
        return Manv;
    }

    public void setManv(int manv) {
        Manv = manv;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
