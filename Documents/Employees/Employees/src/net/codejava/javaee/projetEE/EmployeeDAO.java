package net.codejava.javaee.projetEE;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public EmployeeDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }


    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }


    public boolean insertEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO Employé (matricule, nom, prénom,département) VALUES (?, ?, ?,?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, employee.getMatricule());
        statement.setString(2, employee.getNom());
        statement.setString(3, employee.getPrénom());
        statement.setInt(4, employee.getDépartement());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<Employee> listAllEmployees() throws SQLException {
        List<Employee> listEmployee = new ArrayList<>();

        String sql = "SELECT * FROM Employé";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int matricule = resultSet.getInt("Matricule");
            String nom = resultSet.getString("Nom");
            String prénom = resultSet.getString("Prénom");
            int département = resultSet.getInt("Département");

            Employee employee = new Employee(matricule, nom, prénom, département);
            listEmployee.add(employee);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listEmployee;
    }

    public boolean deleteEmployee(Employee employee) throws SQLException {
        String sql = "DELETE FROM Employé where Matricule = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, employee.getMatricule());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employee SET Matricule = ?, Nom = ?, Prénom = ? , Département= ?";
        sql += " WHERE Matricule = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, employee.getMatricule());
        statement.setString(2, employee.getNom());
        statement.setString(3, employee.getPrénom());
        statement.setInt(4, employee.getDépartement());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public Employee getEmployee(int matricule) throws SQLException {
        Employee employee = null;
        String sql = "SELECT * FROM Employé WHERE Matricule = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, matricule);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nom = resultSet.getString("Nom");
            String prénom = resultSet.getString("Prénom");
            int département = resultSet.getInt("Département");

            employee = new Employee(matricule, nom, prénom, département);
        }

        resultSet.close();
        statement.close();

        return employee;
    }

}