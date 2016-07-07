/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.hrdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Employee generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`EMPLOYEE`", schema = "PUBLIC")
public class Employee implements Serializable {

    private int eid;
    private String firstname;
    private String lastname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private Date birthdate;
    private String picurl;
    private String jobtitle;
    private String username;
    private String password;
    private String role;
    private Integer tenantid;
    private Department department;
    private Employee employeeByManagerid;
    private List<Employee> employeesForManagerid = new ArrayList<>();
    private List<Vacation> vacations = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`EID`", nullable = false, scale = 0, precision = 10)
    public int getEid() {
        return this.eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    @Column(name = "`FIRSTNAME`", nullable = true, length = 255)
    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "`LASTNAME`", nullable = true, length = 255)
    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "`STREET`", nullable = true, length = 255)
    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "`CITY`", nullable = true, length = 255)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "`STATE`", nullable = true, length = 2)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "`ZIP`", nullable = true, length = 255)
    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`BIRTHDATE`", nullable = true)
    public Date getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Column(name = "`PICURL`", nullable = true, length = 255)
    public String getPicurl() {
        return this.picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    @Column(name = "`JOBTITLE`", nullable = true, length = 40)
    public String getJobtitle() {
        return this.jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    @Column(name = "`USERNAME`", nullable = true, length = 255)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "`PASSWORD`", nullable = true, length = 255)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "`ROLE`", nullable = true, length = 255)
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "`TENANTID`", nullable = true, scale = 0, precision = 10)
    public Integer getTenantid() {
        return this.tenantid;
    }

    public void setTenantid(Integer tenantid) {
        this.tenantid = tenantid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`DEPTID`", referencedColumnName = "`DEPTID`", insertable = true, updatable = true)
    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // ignoring self relation properties to avoid circular loops.
    @JsonIgnoreProperties({"employeeByManagerid", "employeesForManagerid"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`MANAGERID`", referencedColumnName = "`EID`", insertable = true, updatable = true)
    public Employee getEmployeeByManagerid() {
        return this.employeeByManagerid;
    }

    public void setEmployeeByManagerid(Employee employeeByManagerid) {
        this.employeeByManagerid = employeeByManagerid;
    }

    // ignoring self relation properties to avoid circular loops.
    @JsonIgnoreProperties({"employeeByManagerid", "employeesForManagerid"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employeeByManagerid")
    public List<Employee> getEmployeesForManagerid() {
        return this.employeesForManagerid;
    }

    public void setEmployeesForManagerid(List<Employee> employeesForManagerid) {
        this.employeesForManagerid = employeesForManagerid;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    public List<Vacation> getVacations() {
        return this.vacations;
    }

    public void setVacations(List<Vacation> vacations) {
        this.vacations = vacations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        final Employee employee = (Employee) o;
        return Objects.equals(getEid(), employee.getEid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEid());
    }
}

