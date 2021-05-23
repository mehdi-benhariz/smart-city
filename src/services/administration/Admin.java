package services.administration;

import java.io.*;
import java.util.*;

import Utils.DBUtils;
import models.User;

public class Admin extends User {

    Vector<User> users = new Vector<User>(100);

    public Admin(String name, int age, int id, String email, String pwd) {
        super(id, name, age, email, pwd);

    }

    /*
     * public static Vector<Admin> getAll() { Vector<String[]> tableOfDB =
     * DBUtils.getData("Users"); Vector<Admin> tableOfUsers = new Vector<Admin>();
     * for (String[] row : tableOfDB) tableOfUsers.add((Admin)
     * convertStringToObject(row));
     * 
     * return tableOfUsers; }
     * 
     * public static User getById(int id) {
     * 
     * Vector<String[]> tableOfDB = DBUtils.getData("User"); for (String[] user :
     * tableOfDB) if (Integer.parseInt((user[0])) == id) return
     * convertStringToObject(user);
     * 
     * return null; }
     * 
     * public static void deleteById(int id) {
     * 
     * Vector<String[]> tableOfDB = DBUtils.getData("Users");
     * 
     * for (String[] user : tableOfDB) { if (Integer.parseInt((user[0])) == id) {
     * tableOfDB.remove(user); break; } } DBUtils.saveData("Users", tableOfDB,
     * false); }
     * 
     * public static void update(int id, User newUser) { // res =
     * DBUtils.getData("Users"); // update from res //
     * DBUtils.saveData("Users",res,false) Vector<String[]> tableOfDB =
     * DBUtils.getData("Users"); for (int i = 0; i < tableOfDB.size(); i++) // id is
     * in the first case if (Integer.parseInt((tableOfDB.get(i)[0])) == id) {
     * tableOfDB.get(i)[1] = Integer.toString(newUser.getAge()); tableOfDB.get(i)[2]
     * = newUser.getEmail(); tableOfDB.get(i)[3] = newUser.getPwd();
     * tableOfDB.get(i)[4] = newUser.getName(); break; }
     * 
     * DBUtils.saveData("Users", tableOfDB, false); }
     * 
     * @Override public void save() { // create a String[] from "this" data // write
     * to db;
     * 
     * Vector<String[]> tableOfDB = new Vector<String[]>(); String[] row = new
     * String[4]; row[1] = Integer.toString(getAge()); row[2] = getEmail(); row[3] =
     * getPwd(); row[4] = getName(); tableOfDB.add(row); DBUtils.saveData("Users",
     * tableOfDB, true); }
     */
}