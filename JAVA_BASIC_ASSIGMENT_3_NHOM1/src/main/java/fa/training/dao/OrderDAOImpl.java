package fa.training.dao;

import fa.training.entities.LineItem;
import fa.training.entities.Order;
import fa.training.utils.JDBC_Conetion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public List<LineItem> getAllItemsByOrderId(int orderId) {
        List<LineItem> items = new ArrayList<>();
        try {
            Connection conn = JDBC_Conetion.getConnection();
            String sql = "SELECT * FROM LineItem WHERE order_id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, orderId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                LineItem lineItem = new LineItem();
                lineItem.setOrderId(rs.getInt(1));
                lineItem.setProductId(rs.getInt(2));
                lineItem.setQuantity(rs.getInt(3));
                lineItem.setPrice(rs.getDouble(4));
                items.add(lineItem);
            }
            return items;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public Double computeOrderTotal(int orderId) {
        try {
            Connection conn = JDBC_Conetion.getConnection();
            String sql = "SELECT SUM(price * quantity) AS OrderTotal FROM LineItem WHERE order_id = ? GROUP BY order_id";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, orderId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getDouble("OrderTotal");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addOrder(Order order) {
        try {
            Connection conn = JDBC_Conetion.getConnection();
            String sql = "INSERT INTO Orders (order_date, customer_id, employee_id, total) VALUES (?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, order.getOrderDate());
            stm.setInt(2, order.getEmployeeId());
            stm.setInt(3, order.getCustomerId());
            stm.setDouble(4, order.getTotal());
            int result = stm.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateOrderTotal(int orderId) {
        try {
            Connection conn = JDBC_Conetion.getConnection();
            String sql = "UPDATE Orders SET total = (SELECT SUM(price * quantity) AS OrderTotal FROM LineItem WHERE order_id = ? GROUP BY order_id) WHERE order_id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, orderId);
            stm.setInt(2, orderId);
            int result = stm.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
