package fa.training.dao;

import fa.training.entities.Customer;
import fa.training.entities.Order;
import fa.training.utils.JDBC_Conetion;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomerDAOImpl implements CustomerDAO {
    Scanner sc = new Scanner(System.in);

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection conn = JDBC_Conetion.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Customer";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Customer customer = new Customer();
                int customerId = rs.getInt(1);
                String customerName = rs.getString(2);
                customer.setCustomerId(customerId);
                customer.setCustomerName(customerName);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public List<Order> getAllOrdersByCustomerId(int customerId) {

        try {
            Connection conn = JDBC_Conetion.getConnection();
            String sql = "SELECT * FROM Orders WHERE customer_id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, customerId);

            ResultSet rs = stm.executeQuery();
            List<Order> orders = new ArrayList<>();
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                String orderDate = rs.getString("order_date");
                int employeeId = rs.getInt("employee_id");
                int total = rs.getInt("total");
                orders.add(new Order(orderId, orderDate, customerId, employeeId, total));
            }
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        try {
            Connection conn = JDBC_Conetion.getConnection();
            String sql = "INSERT INTO Customer (customer_name) VALUES (?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, customer.getCustomerName());
            int result = stm.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        try {
            Connection conn = JDBC_Conetion.getConnection();
            String sql = "DELETE FROM Customer WHERE customer_id =?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, customerId);
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
    public boolean updateCustomer(Customer customer) {
        try {
            Connection conn = JDBC_Conetion.getConnection();
            String sql = "UPDATE Customer SET customer_name = ? WHERE customer_id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, customer.getCustomerName());
            stm.setInt(2, customer.getCustomerId());
            int result = stm.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
