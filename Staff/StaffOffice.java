package Staff;

public class StaffOffice extends Staff {
    public StaffOffice() {}
    public StaffOffice(int id, String name, String phone, String role) {
        super(id, name, phone, role);
    }

    @Override
    public String getInfo() {
        return "StaffOffice," + super.getInfo();
    }

    @Override
    public String toString() {
        return "StaffOffice{" +
                super.toString() +
                "}";
    }
}
