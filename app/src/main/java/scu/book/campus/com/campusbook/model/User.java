package scu.book.campus.com.campusbook.model;


/**
 * Created by kushahuja on 5/23/16.
 */
public class User {
    String name;
    String email;
    String phoneNumber;

    public User(){}
    public User(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber= phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email= email;
    }




}
