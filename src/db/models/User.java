package models;

import java.util.Vector;

import Utils.DBUtils;

public class User implements Model {
    private int age;
    private String email;
    private int id;
    private String name;
    private String pwd;

    public User(int id, String name, int age, String email, String pwd) {
        this.setAge(age);
        this.setEmail(email);
        this.setId(id);
        this.setName(name);
        this.setPwd(pwd);
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static User convertStringToObject(String[] row) {
        int id = Integer.parseInt(row[0]);
        int age = Integer.parseInt(row[1]);
        String email = row[2];
        String name = row[3];
        String pwd = row[4];
        return new User(id, name, age, email, pwd);
    }

    public static User find(String username, String password) {
        Vector<User> users = getAll();
        for (User user : users)
            if ((user.getName() == username && user.getPwd() == password))
                return user;

        return null;
    }

    public static User auth(String username, String password) {
        try {
            User user = find(username, password);
            if (user != null)
                return user;

            System.out.println("login failed");
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static User register(int age, String email, String name, String pwd) {
        int len = DBUtils.getData("Users").size();
        int idOfLastUser = Integer.parseInt(DBUtils.getData("Users").get(len - 1)[0]);
        User newUser = new User(idOfLastUser + 1, name, age, email, pwd);
        newUser.save();
        return newUser;
    }

    public static Vector<User> getAll() {

        Vector<String[]> tableOfDB = DBUtils.getData("Users");
        Vector<User> tableOfUsers = new Vector<User>();
        for (String[] row : tableOfDB)
            tableOfUsers.add(convertStringToObject(row));

        return tableOfUsers;
    }

    public static User getById(int id) {

        Vector<String[]> tableOfDB = DBUtils.getData("User");
        for (String[] user : tableOfDB)
            if (Integer.parseInt((user[0])) == id)
                return convertStringToObject(user);

        return null;
    }

    public static void deleteById(int id) {

        Vector<String[]> tableOfDB = DBUtils.getData("Users");

        for (String[] user : tableOfDB) {
            if (Integer.parseInt((user[0])) == id) {
                tableOfDB.remove(user);
                break;
            }
        }
        DBUtils.saveData("Users", tableOfDB, false);
    }

    public static void update(int id, User newUser) {
        // res = DBUtils.getData("Users");
        // update from res
        // DBUtils.saveData("Users",res,false)
        Vector<String[]> tableOfDB = DBUtils.getData("Users");
        for (int i = 0; i < tableOfDB.size(); i++)
            // id is in the first case
            if (Integer.parseInt((tableOfDB.get(i)[0])) == id) {
                tableOfDB.get(i)[1] = Integer.toString(newUser.getAge());
                tableOfDB.get(i)[2] = newUser.getEmail();
                tableOfDB.get(i)[3] = newUser.getPwd();
                tableOfDB.get(i)[4] = newUser.getName();
                break;
            }

        DBUtils.saveData("Users", tableOfDB, false);
    }

    @Override
    public void save() {
        // create a String[] from "this" data
        // write to db;

        Vector<String[]> tableOfDB = new Vector<String[]>();
        String[] row = new String[4];
        row[1] = Integer.toString(getAge());
        row[2] = getEmail();
        row[3] = getPwd();
        row[4] = getName();
        tableOfDB.add(row);
        DBUtils.saveData("Users", tableOfDB, true);
    }
}