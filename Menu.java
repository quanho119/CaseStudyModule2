import Manager.StaffManager;
import Staff.*;
import java.util.Scanner;

public class Menu {
    private final StaffManager staffManager=StaffManager.getInstance();
    private static Menu instance;
    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }
    private Menu(){}
    public void showMenu() {
        makeChoice();
    }
    private void makeChoice() {
        Scanner in = new Scanner(System.in);
        int choice=-1;
            while (choice != 5) {
                System.out.println("1. Add staff: ");
                System.out.println("2. Update staff: ");
                System.out.println("3. Delete staff: ");
                System.out.println("4. Display staff: ");
                System.out.println("5. Clear all staff: ");
                System.out.println("6. Sort staff by name");
                System.out.println("6. Exit: ");
                choice=Integer.parseInt(in.nextLine());
                switch (choice) {
                    case 1:
                         addStaff();
                        break;
                    case 2:
                        updateStaff();
                        break;
                    case 3:
                        removeStaff();
                        break;
                    case 4:
                        showList();
                        break;
                    case 5:
                        removeAll();
                        break;
                    case 6:
                        sort();
                        break;
                    default:
                        System.out.println("Invalid choice");
            }
        }
    }
    private void removeAll(){
       staffManager.removeAll();
    }

    private void showList() {
        staffManager.showList();
    }

    private void removeStaff() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter staff id: ");
        int id = Integer.parseInt(in.nextLine());
        staffManager.remove(id);
    }

    private void addStaff() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter staff type: ");
        String type = in.nextLine();
        System.out.println("Enter staff id: ");
        int id = Integer.parseInt(in.nextLine());
        System.out.print("Enter staff name: ");
        String name = in.nextLine();
        System.out.print("Enter staff phone: ");
        String phone = in.nextLine();
        System.out.print("Enter staff role: ");
        String role = in.nextLine();
        switch (type) {
            case("StaffOffice"):
                StaffOffice staffOffice = new StaffOffice(id, name, phone, role);
                staffManager.add(staffOffice);
                break;
            case("StaffWorkshop"):
                System.out.println("Enter staff workshop id: ");
                String workshopId = in.nextLine();
                StaffWorkshop staffWorkshop = new StaffWorkshop(id, name, phone, role, workshopId);
                staffManager.add(staffWorkshop);
                break;
            case("StaffShipper"):
                System.out.println("Enter staff car: ");
                String car = in.nextLine();
                StaffShipper staffShipper = new StaffShipper(id, name, phone, role, car);
                staffManager.add(staffShipper);
                break;
            default:
                System.out.println("Invalid type");
        }
    }
    private void updateStaff() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter staff type: ");
        String type = in.nextLine();
        System.out.println("Enter staff id: ");
        int id = Integer.parseInt(in.nextLine());
        System.out.print("Enter staff name: ");
        String name = in.nextLine();
        System.out.print("Enter staff phone: ");
        String phone = in.nextLine();
        System.out.print("Enter staff role: ");
        String role = in.nextLine();
        switch (type) {
            case("StaffOffice"):
                StaffOffice staffOffice = new StaffOffice(id, name, phone, role);
                staffManager.update(id,staffOffice);
            case("StaffWorkshop"):
                System.out.println("Enter staff workshop id: ");
                String workshopId = in.nextLine();
                StaffWorkshop staffWorkshop = new StaffWorkshop(id, name, phone, role, workshopId);
                staffManager.update(id,staffWorkshop);
            case("StaffShipper"):
                System.out.println("Enter staff car: ");
                String car = in.nextLine();
                StaffShipper staffShipper = new StaffShipper(id, name, phone, role, car);
                staffManager.update(id,staffShipper);
            default:
                System.out.println("Invalid type");
        }
    }
    private void sort(){
        staffManager.sortByName();
    }
}
