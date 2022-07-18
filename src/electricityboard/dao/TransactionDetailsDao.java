package electricityboard.dao;

import electricityboard.config.DbConnectivity;
import electricityboard.model.TransactionDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TransactionDetailsDao implements Dao<TransactionDetails> {
    @Override
    public boolean update(TransactionDetails transactionDetails) throws SQLException {
        String sql = "insert into transactionDetails(customerId, transactionId, transactionTime, transactionStatus, amountPaid) values(?,?,?,?,?)  ";

        try {
            Connection conn = DbConnectivity.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, transactionDetails.getCustomerId());
            ps.setString(2, transactionDetails.getTransactionId());
            ps.setString(3, transactionDetails.getTransactionTime());
            ps.setString(4, transactionDetails.getStatus());
            ps.setDouble(5, transactionDetails.getAmountPaid());

            ps.executeUpdate();

        } catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    @Override
    public TransactionDetails getById(String Id) throws SQLException {
        return null;
    }

    @Override
    public List<TransactionDetails> getAll() throws SQLException {
        return null;
    }
}
