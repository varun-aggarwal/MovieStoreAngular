package angular.moviestore.datasource.api.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.PoolInitializationException;

import angular.moviestore.datasource.api.DataSource;

public class DataSourceImpl implements DataSource {

    private static final DataSourceImpl INSTANCE = new DataSourceImpl();

    private final String dataSourceClassName = "org.postgresql.ds.PGSimpleDataSource";

    private final String url = "jdbc:postgresql://localhost:5432/movie_store";

    private final String user = "postgres";

    private final String password = "qafe";

    private HikariDataSource postgresDataSource;

    // private constructor
    private DataSourceImpl() {
        init();
        addShutdownHook();
    }

    // public method to get the singleton
    // Runtime initialization
    // By default ThreadSafe
    public static DataSourceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return postgresDataSource.getConnection();
    }

    private void init() {
        try {
            postgresDataSource = new HikariDataSource();
            postgresDataSource.setMaximumPoolSize(70);
            postgresDataSource.setDataSourceClassName(dataSourceClassName);
            postgresDataSource.addDataSourceProperty("url", url);
            postgresDataSource.addDataSourceProperty("user", user);
            postgresDataSource.addDataSourceProperty("password", password);
        } catch (final PoolInitializationException e) {
            final String msg = "Failed to connect to the database. Is the database down?";
        }
    }

    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                postgresDataSource.close();
            }
        });
    }

}
