package services;

import java.util.Vector;

import models.College;
import models.Company;
import models.Hotel;
import models.Job;
import models.User;

public class Recommand<T> {
    // unchecked casting warning was suppredded using the decorator
    @SuppressWarnings("unchecked")
    public Vector<T> recommand(T o) {

        if (o instanceof Hotel)
            return (Vector<T>) Hotel.getAll();
        if (o instanceof User)
            return (Vector<T>) User.getAll();
        if (o instanceof Company)
            return (Vector<T>) Company.getAll();
        if (o instanceof College)
            return (Vector<T>) College.getAll();
        return (Vector<T>) Job.getAll();

    }
}
