package angular.moviestore.datasource.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;
import java.util.List;

/**
 * @author sdahlberg.
 */
public final class DatabaseUtil {

    private DatabaseUtil() {

    }

    /**
     * Convenience method for quietly closing a database connection and returning it to the pool.
     *
     * @param connection the Connection to close
     * @param stmt the Statement to close
     * @param rs the ResultSet to close
     * @param log the Logger object for logging purposes
     */
    public static void closeQuietly(final Connection connection, final Statement stmt, final ResultSet rs) {
        try {
            try {
                if (rs != null) {
                    rs.close();
                }
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } finally {
                    if (connection != null) {
                        connection.close();
                    }
                }
            }
        } catch (final SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Convenience method to set an array of arguments on the prepared statement.
     *
     * @param stmt Set the arguments on this statement.
     * @param arguments Array of arguments.
     * @throws SQLException If a database access error occurs.
     */
    public static void setArguments(final PreparedStatement stmt, final List<Object> arguments)
            throws SQLException {
        int index = 1;
        for (final Object argument : arguments) {
            setArgument(stmt, argument, index++);
        }
    }

    /**
     * Sets the argument on the prepared statement with the correct type setter.
     *
     * @param stmt Set the argument on this statement.
     * @param argument Argument to set.
     * @param index The position of the argument in the query.
     * @throws SQLException If a database access error occurs.
     */
    private static void setArgument(final PreparedStatement stmt, final Object argument, final int index)
            throws SQLException {
        if (argument == null) {
            stmt.setNull(index, Types.NULL);
        } else if (argument instanceof Integer) {
            stmt.setInt(index, (Integer) argument);
        } else if (argument instanceof Boolean) {
            stmt.setBoolean(index, (Boolean) argument);
        } else if (argument instanceof String) {
            stmt.setString(index, (String) argument);
        } else if (argument instanceof Double) {
            stmt.setDouble(index, (Double) argument);
        } else if (argument instanceof Date) {
            stmt.setTimestamp(index, new java.sql.Timestamp(((Date) argument).getTime()));
        } else if (argument instanceof Long) {
            stmt.setLong(index, (Long) argument);
        } else if (argument instanceof Float) {
            stmt.setFloat(index, (Float) argument);
        } else {
            throw new SQLException("Parameter type '" + argument.getClass() + "' not supported.");
        }
    }
}
