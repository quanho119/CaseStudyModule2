package Staff;

public class StaffWorkshop extends Staff {
    private String workshopID;
    public StaffWorkshop() {}
    public StaffWorkshop(int id, String name, String phone, String role, String workshopID){
        super(id, name, phone, role);
        this.workshopID = workshopID;
    }
    public String getWorkshopID() {
        return workshopID;
    }
    public void setWorkshopID(String workshopID) {
        this.workshopID = workshopID;
    }

    @Override
    public String getInfo() {
        return "StaffWorkshop,"+super.getInfo()+ "," + workshopID;
    }

    @Override
    public String toString() {
        return "StaffWorkshop{" +
                super.toString() +
                ", workshopID='" + workshopID + '\'' +
                '}';
    }
}
