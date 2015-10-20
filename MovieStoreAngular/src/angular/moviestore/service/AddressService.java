package angular.moviestore.service;

import angular.moviestore.dao.AddressDao;
import angular.moviestore.dao.factory.AddressDaoFactory;
import angular.moviestore.domain.Address;

public class AddressService {

    private AddressDao addressDao = (new AddressDaoFactory()).getAddressDao();

    public Address getAddressByName(String name) {
        return addressDao.getAddress(name);
    }

}
