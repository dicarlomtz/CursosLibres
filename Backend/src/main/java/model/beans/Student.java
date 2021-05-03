package model.beans;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "student")
public class Student extends GenericUser {

   public Student(int id, UserAccountData accData, String lastName1, String lastName2, String name, int telephoneNumber, String email) {
        super(id, accData, lastName1,lastName2, name, telephoneNumber, email);
    }

    public Student() {
    }



}