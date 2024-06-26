package Manager;

import Staff.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StaffManager implements iManager{
    private StaffManager(){}
    private static StaffManager instance;

    public static StaffManager getInstance() {
        if (instance == null) {
            instance = new StaffManager();
        }
        return instance;
    }

    private List<Staff> staffList;
    @Override
    public void add(Staff staff) {
        try{
            write(staff);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void showList() {
        try{
            this.staffList=read();
            for(Staff staff:staffList){
                System.out.println(staff.getInfo());
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void write(Staff staff) throws IOException {
        FileWriter fileWriter=new FileWriter("./src/data/data.csv",true);
        BufferedWriter bw=new BufferedWriter(fileWriter);
        String info=staff.getInfo()+"\n";
        bw.write(info);
        bw.close();
        fileWriter.close();
    }

    @Override
    public List<Staff> read() throws IOException{
        FileReader fileReader=new FileReader("./src/data/data.csv");
        BufferedReader br=new BufferedReader(fileReader);
        List<Staff> staffListRead=new ArrayList<>();
        String content;
        while((content=br.readLine())!=null&&!content.isEmpty()){
            String[] info=content.split(",");
            String type=info[0];
            int id=Integer.parseInt(info[1]);
            String name=info[2];
            String phone=info[3];
            String role=info[4];
            switch(type){
                case "StaffOffice":
                    StaffOffice staffOffice=new StaffOffice(id,name,phone,role);
                    staffListRead.add(staffOffice);
                    break;
                case "StaffWorkshop":
                    String workshopID=info[5];
                    StaffWorkshop staffWorkshop=new StaffWorkshop(id,name,phone,role,workshopID);
                    staffListRead.add(staffWorkshop);
                    break;
                case "StaffShipper":
                    String car=info[6];
                    StaffShipper staffShipper=new StaffShipper(id,name,phone,role,car);
                    staffListRead.add(staffShipper);
                    break;
                default:
                    System.out.println("Not found");
            }
        }
        br.close();
        fileReader.close();
        return staffListRead;
    }

    @Override
    public void remove(int id) {
        try {
            this.staffList=read();
            staffList.removeIf(staff -> staff.getId() == id);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeAll(){
        try {
            FileWriter fileWriter = new FileWriter("./src/data/data.csv");
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write("");
            bw.close();
            fileWriter.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(int id, StaffOffice staffUpdate) {
        try{
            this.staffList=read();
            for(Staff staff :staffList){
                if(staff.getId()==id){
                    StaffOffice staffOffice=(StaffOffice)staff;
                    staffOffice.setName(staffUpdate.getName());
                    staffOffice.setPhone(staffUpdate.getPhone());
                    staffOffice.setRole(staffUpdate.getRole());
                }
            }
            reWrite();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void reWrite() throws IOException {
        FileWriter fileWriter=new FileWriter("./src/data/data.csv");
        BufferedWriter bw=new BufferedWriter(fileWriter);
        for(Staff staff :staffList){
            String info=staff.getInfo()+"\n";
            bw.write(info);
        }
        bw.close();
        fileWriter.close();
    }

    @Override
    public void update(int id, StaffWorkshop staffUpdate) {
        try{
            this.staffList=read();
            for(Staff staff :staffList){
                if(staff.getId()==id){
                    StaffWorkshop staffWorkshop =(StaffWorkshop) staff;
                    staffWorkshop.setName(staffUpdate.getName());
                    staffWorkshop.setPhone(staffUpdate.getPhone());
                    staffWorkshop.setRole(staffUpdate.getRole());
                    staffWorkshop.setWorkshopID(staffUpdate.getWorkshopID());
                }
            }
            reWrite();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(int id, StaffShipper staffUpdate) {
        try{
            this.staffList=read();
            for(Staff staff :staffList){
                if(staff.getId()==id){
                    StaffShipper staffShipper=(StaffShipper)staff;
                    staffShipper.setName(staffUpdate.getName());
                    staffShipper.setPhone(staffUpdate.getPhone());
                    staffShipper.setRole(staffUpdate.getRole());
                    staffShipper.setCar(staffUpdate.getCar());
                }
            }
            reWrite();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void sortByName(){
        try {
            this.staffList=read();
            this.staffList.sort(Comparator.comparing(Staff::getName));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

