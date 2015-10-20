package angular.moviestore.domain.factory;

import angular.moviestore.domain.User;
import angular.moviestore.domain.impl.UserImpl;

public class UserFactory {

    public User getUser() {
        return new UserImpl();
    }

}
