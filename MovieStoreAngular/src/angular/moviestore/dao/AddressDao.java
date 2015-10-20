package angular.moviestore.dao;

import angular.moviestore.domain.Address;

public interface AddressDao {

    public Address getAddress(String name);

    public boolean addAddress(Address address);

}
