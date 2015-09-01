package com.varun.angular.moviestore.service;

import java.util.ArrayList;
import java.util.List;

import com.varun.angular.moviestore.domain.Address;
import com.varun.angular.moviestore.domain.User;

public class UserDetailService {

    static User user;

    public User getDummyData() {

        List<Address> addresses = new ArrayList<Address>();
        Address address = new Address();
        address.setAddressName("Varun Aggarwal");
        address.setStreet("Amstelveensweg 25");
        address.setPostcode("1054 MC");
        addresses.add(address);

        User user = new User();
        user.setName("Varun Aggarwal");
        user.setAddresses(addresses);

        return user;
    }

    public User getUserData() {
        if (UserDetailService.user == null) {
            User dummyUser = getDummyData();
            UserDetailService.user = dummyUser;
        }
        return user;
    }

    public void addAddressForUser(Address newAddress) {

        if (UserDetailService.user == null) {
            User dummyUser = getDummyData();
            UserDetailService.user = dummyUser;
        }
        UserDetailService.user.getAddresses().add(newAddress);
    }

}
