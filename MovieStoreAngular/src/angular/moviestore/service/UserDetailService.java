package angular.moviestore.service;

import java.util.ArrayList;
import java.util.List;

import angular.moviestore.domain.Address;
import angular.moviestore.domain.impl.MovieStoreUser;

public class UserDetailService {

    static MovieStoreUser user;

    private AddressService addressService = new AddressService();

    public MovieStoreUser getDummyData() {
        MovieStoreUser user = new MovieStoreUser();
        user.setName("Varun Aggarwal");

        List<Address> addresses = new ArrayList<Address>();
        Address address = addressService.getAddressByName(user.getName());
        addresses.add(address);

        user.setAddresses(addresses);
        return user;
    }

    public MovieStoreUser getUserData() {
        if (UserDetailService.user == null) {
            MovieStoreUser dummyUser = getDummyData();
            UserDetailService.user = dummyUser;
        }
        return user;
    }

    public void addAddressForUser(Address newAddress) {

        if (UserDetailService.user == null) {
            MovieStoreUser dummyUser = getDummyData();
            UserDetailService.user = dummyUser;
        }
        UserDetailService.user.getAddresses().add(newAddress);
    }

}
