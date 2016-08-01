package com.challenge.usermanagement.domain;

import javax.persistence.*;

/**
 * Created by venkateshr on 31/7/16.
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    long uuid;

    @Column(nullable = false)
    String firstname;

    @Column
    String middlename;

    @Column(nullable = false)
    String lastname;

    @Column
    int age;

    @Enumerated(EnumType.STRING)
    @Column(length = 1, nullable = false)
    Gender gender;

    @Column(length = 10, nullable = false)
    String phone;

    @Column
    String zip;

	public long getUuid() {
		return uuid;
	}

	public void setUuid(long uuid) {
		this.uuid = uuid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
