package fa.training.entities;

public class Order {
    private int orderId;
    private String orderDate;
    private int customerId;
    private int employeeId;
    private double total;

    public Order() {
    }

    public Order(int orderId, double total) {
        this.orderId = orderId;
        this.total = total;
    }

    public Order(int orderId, String orderDate, int employeeId, double total) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.employeeId = employeeId;
        this.total = total;
    }

    public Order(int orderId, String orderDate, int customerId, int employeeId, double total) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String setOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

//    public void input(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter birth date");
//        boolean validBirthDate = false;
//        do{
//            setOrderDate(scanner.nextLine());
//            try{
//                validBirthDate = Validator.isOrderDate(String.valueOf(this.orderDate));
//                if(validBirthDate == false){
//                    System.out.println("Birth date is not valid");
//                }
//            }catch (Exception e){
//                validBirthDate = false;
//            }
//        }while (validBirthDate == false);
//    }
    @Override
    public String toString() {
        return "=====Order=====" +
                "\norderId: " + orderId +
                ", orderDate: " + orderDate +
                ", customerId: " + customerId +
                ", employeeId: " + employeeId +
                ", total: " + total;
    }
}
