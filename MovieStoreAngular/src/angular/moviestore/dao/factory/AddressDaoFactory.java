package angular.moviestore.dao.factory;

import angular.moviestore.dao.AddressDao;
import angular.moviestore.dao.impl.AddressDaoDatabaseImpl;
import angular.moviestore.dao.impl.AddressDaoMemoryImpl;
import angular.moviestore.util.Util;

public class AddressDaoFactory {

    public AddressDao getAddressDao() {
        if (Util.DATABASE_ACCESS_MODE.equals("database")) {
            return new AddressDaoDatabaseImpl();
        } else {
            return new AddressDaoMemoryImpl();
        }
    }

}
