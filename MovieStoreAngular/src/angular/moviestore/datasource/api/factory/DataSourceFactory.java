package angular.moviestore.datasource.api.factory;

import angular.moviestore.datasource.api.DataSource;
import angular.moviestore.datasource.api.impl.DataSourceImpl;

public class DataSourceFactory {

    public DataSource getDataSource() {
        return DataSourceImpl.getInstance();
    }

}
