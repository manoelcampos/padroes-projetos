package com.manoelcampos.people;

/**
 * Representa uma pessoa que seja cliente da empresa.
 * @author Manoel Campos da Silva Filho
 */
public class Customer {
    private String name;
    private String phone;
    private String email;

    public Customer(){
        this.name = "";
        this.phone = "";
        this.email = "";
    }

    public Customer(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
