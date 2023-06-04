package fa.training.entities;

public class Employee {
    private int employeeId;
    private String employee_Name;
    private double salary;
    private int supervisor_Id;

    public Employee() {
    }

    public Employee(int employeeId, String employee_Name, double salary, int supervisor_Id) {
        this.employeeId = employeeId;
        this.employee_Name = employee_Name;
        this.salary = salary;
        this.supervisor_Id = supervisor_Id;
    }

    public int getEmployeeId() {

        return employeeId;
    }

    public void setEmployeeId(int employeeId) {

        this.employeeId = employeeId;
    }

    public String getEmployeeName() {

        return employee_Name;
    }

    public void setEmployeeName(String employee_Name) {

        this.employee_Name = employee_Name;
    }

    public double getSalary() {

        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSpvrId() {

        return supervisor_Id;
    }

    public void setSpvrId(int supervisor_Id) {

        this.supervisor_Id = supervisor_Id;
    }

    @Override
    public String toString() {
        return "=====Employee=====" +
                "\nemployeeId: " + employeeId +
                ", employeeName: " + employee_Name +
                ", salary: " + salary +
                ", spvrId: " + supervisor_Id;
    }
}
