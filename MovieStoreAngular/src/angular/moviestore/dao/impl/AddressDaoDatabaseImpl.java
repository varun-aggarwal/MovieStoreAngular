package angular.moviestore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import angular.moviestore.dao.AddressDao;
import angular.moviestore.datasource.api.DataSource;
import angular.moviestore.datasource.api.factory.DataSourceFactory;
import angular.moviestore.datasource.util.DatabaseUtil;
import angular.moviestore.domain.Address;

public class AddressDaoDatabaseImpl implements AddressDao {

    private DataSource dataSource = (new DataSourceFactory()).getDataSource();

    private static final String ADDRESS_BY_NAME_QUERY =
        "select street, postcode from address where addressname = ?";

    private static final String CREATE_ADDRESS_QUERY = "insert into address values (?, ?, ? )";

    @Override
    public Address getAddress(String name) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Address address = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(ADDRESS_BY_NAME_QUERY);
            final List<Object> arguments = new ArrayList<>();
            arguments.add(name);
            DatabaseUtil.setArguments(stmt, arguments);
            rs = stmt.executeQuery();
            while (rs.next()) {
                address = new Address();
                address.setAddressName(name);
                address.setStreet(rs.getString("street"));
                address.setPostcode(rs.getString("postcode"));
            }

        } catch (final SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DatabaseUtil.closeQuietly(conn, stmt, rs);
        }
        return address;
    }

    @Override
    public boolean addAddress(Address address) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(CREATE_ADDRESS_QUERY);
            final List<Object> arguments = new ArrayList<>();
            arguments.add(address.getAddressName());
            arguments.add(address.getStreet());
            arguments.add(address.getPostcode());
            DatabaseUtil.setArguments(stmt, arguments);
            final int rowCount = stmt.executeUpdate();
            return rowCount > 0;
        } catch (final SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DatabaseUtil.closeQuietly(conn, stmt, null);
        }
        return false;
    }

}
