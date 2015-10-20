package angular.moviestore.domain.impl;

import java.util.List;

import angular.moviestore.domain.Address;
import angular.moviestore.domain.User;
import angular.moviestore.domain.factory.UserFactory;

/**
 * @author vaggarwal
 *
 */
public class MovieStoreUser implements User {

    private User user;

    private List<Address> addresses;

    public MovieStoreUser() {
        UserFactory userFactory = new UserFactory();
        this.user = userFactory.getUser();
    }

    /**
     * @return the name
     */
    public String getName() {
        return user.getName();
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.user.setName(name);
    }

    /**
     * @return the addresses
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.user.getEmail();
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.user.setEmail(email);
    }

    @Override
    public String toString() {
        return "User [name=" + user.getEmail() + ", addresses=" + addresses + "]";
    }

}
