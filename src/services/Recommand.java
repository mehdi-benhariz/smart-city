package services;

import java.util.Vector;

import models.College;
import models.Company;
import models.Hotel;
import models.Job;
import models.User;

public class Recommand {
    // unchecked casting warning was suppredded using the decorator
    public Recommand() {
    }

    // the generic type is secified only for the recommand method
    @SuppressWarnings("unchecked")
    public <T> Vector<T> recommand(T o) {

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
