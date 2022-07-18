package electricityboard.dao;

import electricityboard.config.DbConnectivity;
import electricityboard.model.TransactionDetails;
import electricityboard.model.UserDetails;

import java.sql.*;
import java.util.List;

public class UserDetailsDao implements Dao<UserDetails> {


    @Override
    public UserDetails getById(String customerId) throws SQLException {

        String sql = "Select * from userDetails where customerId = " + customerId + " ";
        try {
            Connection conn = DbConnectivity.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                UserDetails userDetails = new UserDetails();
                userDetails.setCustomerId(rs.getString(2));
                userDetails.setCustomerName(rs.getString(3));
                userDetails.setState(rs.getString(4));
                userDetails.setConsumedUnits(rs.getInt(5));
                userDetails.setWalletBalance(rs.getInt(6));

                return userDetails;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserDetails> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean update(UserDetails userDetails) throws SQLException {
        return false;
    }

    public static boolean save(UserDetails userDetails) throws SQLException {

        String sql = "update userDetails set walletBalance = ?, consumedUnits = ? where customerId = ? ";

        try {
            Connection conn = DbConnectivity.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, userDetails.getWalletBalance());
            ps.setInt(2, userDetails.getConsumedUnits());
            ps.setString(3, userDetails.getCustomerId());

            int rs = ps.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }

}

