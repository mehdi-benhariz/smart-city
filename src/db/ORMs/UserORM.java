package ORMs;

public class UserORM {
    public static Vector<User> getAll() {
        // TODO Auto-generated method stub
        // DBUtils.getData("Colleges");
        // loop through data and create a vector of object
    }

    public static void getById(int id) {
        // TODO Auto-generated method stub
        // res = DBUtils.getData("Colleges");
        // return Obj= res where id = id
    }

    public static void deleteById(int id) {
        // TODO Auto-generated method stub
        // res = DBUtils.getData("Colleges");
        // delete from res
        // DBUtils.saveData("Colleges",res,false)
    }

    public static void update(int id, College newCollege) {
        // TODO Auto-generated method stub
        // res = DBUtils.getData("Colleges");
        // update from res
        // DBUtils.saveData("Colleges",res,false)

    }

    public static void addData(College newCollege) {
        // TODO Auto-generated method stub
        // add newCollege to res
        // DBUtils.saveData("Colleges",res,true)

    }

}
