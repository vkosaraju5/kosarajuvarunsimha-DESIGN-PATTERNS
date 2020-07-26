package org.example.behavioral;

interface OfficeNetAccess{
    public void grantNetAccess();
}

class RealNetAccess implements OfficeNetAccess{
    private String employeeName;

    public RealNetAccess(String empName){
        this.employeeName = empName;
    }

    @Override
    public void grantNetAccess() {
        System.out.println("Access granted "+employeeName+"can enter");
    }
}

class ProxyNetAccess implements OfficeNetAccess{
    private String employeeName;
    private RealNetAccess realNetAccess;

    public ProxyNetAccess(String employeeName){
        this.employeeName=employeeName;
    }

    public int getRole(String empName){
        return empName.length();
    }

    @Override
    public void grantNetAccess() {
        if(getRole(employeeName) > 6){
            realNetAccess = new RealNetAccess(employeeName);
            realNetAccess.grantNetAccess();
        }
        else
            System.out.println("Access Denied. Your job level is under 7");
    }
}
public class Proxy {
    public static void main(String args[]){
        OfficeNetAccess officeNetAccess = new ProxyNetAccess("Varun");
        officeNetAccess.grantNetAccess();
    }
}
