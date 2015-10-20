package angular.moviestore.dao.factory;

import angular.moviestore.dao.AddressDao;
import angular.moviestore.dao.impl.AddressDaoImpl;

public class AddressDaoFactory {

    public AddressDao getAddressDao() {
        return new AddressDaoImpl();
    }

}
