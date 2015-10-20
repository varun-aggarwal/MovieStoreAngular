package angular.moviestore.dao.impl;

import java.util.HashMap;
import java.util.Map;

import angular.moviestore.dao.AddressDao;
import angular.moviestore.domain.Address;

public class AddressDaoMemoryImpl implements AddressDao {

    private static Map<String, Address> addresses = new HashMap<>();

    public AddressDaoMemoryImpl() {
        initiateAddressesWithDefaultAddress();
    }

    private void initiateAddressesWithDefaultAddress() {
        Address address = new Address();
        address.setAddressName("Varun Aggarwal");
        address.setPostcode("132001");
        address.setStreet("Sector 7");
        addAddress(address);
    }

    @Override
    public Address getAddress(String name) {
        return addresses.get(name);
    }

    @Override
    public boolean addAddress(Address address) {
        addresses.put(address.getAddressName(), address);
        return true;
    }

}
