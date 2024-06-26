package Staff;

public class StaffShipper extends Staff {
    private String car;
    public StaffShipper() {}
    public StaffShipper(int id, String name, String phone, String role, String car) {
        super(id, name, phone, role);
        this.car = car;
    }
    public String getCar() {
        return car;
    }
    public void setCar(String car) {
        this.car = car;
    }
    @Override
    public String getInfo() {
        return "StaffShipper,"+super.getInfo()+ "," + car;
    }

    @Override
    public String toString() {
        return "StaffShipper{" +
                super.toString() +
                ", car='" + car + '\'' +
                '}';
    }
}
