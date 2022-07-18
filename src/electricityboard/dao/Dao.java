package electricityboard.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    T getById(String Id) throws SQLException;
//use of below method
    List<T> getAll() throws SQLException;





    boolean update(T t)throws SQLException;
    }

