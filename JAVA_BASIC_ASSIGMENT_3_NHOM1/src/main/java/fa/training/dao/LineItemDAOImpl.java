package fa.training.dao;

import fa.training.entities.LineItem;
import fa.training.utils.JDBC_Conetion;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LineItemDAOImpl implements LineItemDAO {
    public boolean addLineItem(LineItem item) {
        try {
            Connection conn = JDBC_Conetion.getConnection();
            String sql = "INSERT INTO LineItem VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, item.getOrderId());
            ps.setInt(2, item.getProductId());
            ps.setInt(3, item.getQuantity());
            ps.setDouble(4, item.getPrice());

            int result = ps.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return false;
    }
}
