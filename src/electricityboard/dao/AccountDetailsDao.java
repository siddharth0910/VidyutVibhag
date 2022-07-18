package electricityboard.dao;

import electricityboard.config.DbConnectivity;
import electricityboard.model.AccountDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountDetailsDao implements Dao<AccountDetails> {

    public AccountDetails getByCardNumber(long cardNumber) throws SQLException {

        String sql = "Select * from accountDetails where cardNumber = " + cardNumber + "";

        try {
            Connection conn = DbConnectivity.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AccountDetails accountDetails = new AccountDetails();
                accountDetails.setaccountHolderName(rs.getString(6));
                accountDetails.setcardNumber(rs.getLong(2));
                accountDetails.setcvv(rs.getInt(3));
                accountDetails.setpin(rs.getInt(4));
                accountDetails.setbalance(rs.getInt(5));

                return accountDetails;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AccountDetails getById(String Id) throws SQLException {
        return null;
    }

    @Override
        public List<AccountDetails> getAll () throws SQLException {
            return null;
        }

        @Override
        public boolean update (AccountDetails accountDetails) throws SQLException {
            return false;
        }
    }
