package com.company;

import java.awt.*;
import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int DefaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    //receive firstName and lastName
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("Email Created! " + this.firstName + " " + this.lastName);

        this.department = setDepartment();
        //System.out.println("Department = " + this.department);

        //random password
        this.password = randomPassword(DefaultPasswordLength);
        System.out.println("Password is " + this.password);

        //generate Email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
       //System.out.println("Email is: " + email);
    }


    //department
    private String setDepartment() {
        System.out.println("Enter department\n1 for Sales\n2 for develompent\n3 for accounting\n0 for none");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    //Random Password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * password.length);
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //mailBox Capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    //alternative mail

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    //change password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity(){return mailBoxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo(){
        return "Display Name " + firstName+" "+lastName+"\nCompany Email "+email+
                "\nMailbox Capacity "+mailBoxCapacity;
    }
}
