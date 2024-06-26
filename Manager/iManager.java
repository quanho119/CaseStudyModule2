package Manager;
import Staff.*;

import java.io.IOException;
import java.util.List;

public interface iManager {
    void add(Staff staff);
    void update(int id, StaffOffice staffUpadate);
    void update(int id, StaffWorkshop staffUpdate);
    void update(int id, StaffShipper staffUpdate);
    void remove(int id);
    void removeAll();
    void showList();
    void write(Staff staff) throws IOException;
    List<Staff> read()throws IOException;
    void reWrite()throws IOException;
}
