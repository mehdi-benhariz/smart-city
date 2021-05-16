package services.administration;

import java.io.*;
import java.util.*;

import models.User;

public class Admin extends User {
    protected int admin_id;
    Vector<User> users = new Vector<User>(100);

    public Admin(String name, int age, int id, String email, String pwd) {
        super(age, email, name, id, pwd);
        this.admin_id = id;
    }

    public int getAdminId() {
        return admin_id;
    }

    public void set_Admin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    // khidmt zack!!!
    public void addUser(String name, int age, int id, String email, String pwd) {
        User new_User = new User(name, age, id, email, pwd);

        // Add the new element
        users.add(new_User);
        System.out.println("User Added Successfully");
    }

    private boolean deleteUser(int id) {
        for (int i=0;i<users.size();i++)
        if(users.get(i).getId()==id)
        {  users.remove(i);
            System.out.println("User Removed Successfully");

        }
        else {
            System.out.println("User Not Found Please Verify The Id You've Given ")

        }

        return true;
    }

    public boolean update_user(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Type new e-mail:");
        String mail = scanner.nextLine();
       System.out.println("Type new password:");
        String pwd = scanner.nextLine();
        for(int i=0;i<users.size();i++)
        if(users.get(i).get_id()==id)
        {users.get(i).set_user_email(mail);
          users.get(i).set_User_pwd(pwd);
          System.out.println("information has been updated");       
 
         return true;}
         else {
            System.out.println("This Id doesn't figure in our database please verify the Id you have entered.")
            return false;
        }
    
    }

    public void Get_All_users() {
        for (int i = 0; i < users.size(); i++) {
            users.get(i).toString();
        }
    }

    public User Get_User_By_Id(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).get_id() == id)
                return users.get(i);
            else {
                User Empty_User = new User();
                System.out.println("No user with the given Id is found in our database please verify your entry.");
                return Empty_User;
            }

        }

    }
}