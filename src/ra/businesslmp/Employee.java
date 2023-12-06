package ra.businesslmp;

import ra.business.IEmployee;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Employee implements IEmployee {
    private String maNV;
    private String tenNV;
    private int year;
    private float rate;
    private float commission;
    private float salary;
    private boolean status;

    public Employee() {
    }

    public Employee(String maNV, String tenNV, int year, float rate, float commission, float salary, boolean status) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.year = year;
        this.rate = rate;
        this.commission = commission;
        this.salary = salary;
        this.status = status;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập mã nhân viên: ");
        this.maNV = scanner.nextLine();
        System.out.println("Nhập tên nhân viên: ");
        this.tenNV = scanner.nextLine();
        System.out.println("Nhập năm sinh viên: ");
        this.year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập hệ số lương: ");
        this.rate = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập hoa hồng của nhân viên: ");
        this.commission = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập trạng thái nhân viên(true/false): ");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    //    @Override
//    public void displayData(Employee[] arrEmployee) {
//        System.out.printf("%2d Mã nhân viên|%10s Tên nhân viên |%2d Năm sinh |%2d Hệ số lương |%3d Hoa hồng |%5s Lương nhân viên |%5s Trạng thái | ");
//        for (Employee employee : arrEmployee ) {
//            System.out.format("%2d |", employee.getMaNV());
//            System.out.format("%10s |", employee.getTenNV());
//            System.out.format("%2d |", employee.getYear());
//            System.out.format("%3d |", employee.getRate());
//            System.out.format("%3d |", employee.getCommission());
//            System.out.format("%5s |", employee.getSalary());
//            System.out.format("%5s |", employee.status);
//        }
//    }
    @Override
    public void displayData() {
        System.out.println("- Thông tin nhân viên:");
        System.out.printf("Mã nhân viên: %s - Tên nhân viên: %s - Năm sinh: %s\n", this.maNV, this.tenNV, this.year);
        System.out.printf("Hệ số lương: %s - Hoa hồng: %s - Lương nhân viên: %s - Trạng thái: %s\n", this.rate, this.commission, (this.salary = this.rate * BASIC_SALARY + this.commission), (this.status == true ? "Đang làm việc" : "Nghỉ việc"));
    }

    public void updateData(Scanner scanner) {
        String newName;
        int newYear;
        float newRate, newCommission;
        boolean newStatus;
        System.out.println("Mời bạn nhập tên nhân viên mới: ");
        newName = scanner.nextLine();
        System.out.println("Mời bạn nhập năm sinh:");
        newYear = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập hệ số lương:");
        newRate = Float.parseFloat(scanner.nextLine());
        System.out.println("Mời bạn nhập hoa hồng: ");
        newCommission = Float.parseFloat(scanner.nextLine());
        System.out.println("Mời bạn nhập trạng thái(true/false): ");
        newStatus = Boolean.parseBoolean(scanner.nextLine());
        System.out.println("- Thông tin nhân viên mới: ");
        System.out.printf("Mã nhân viên: %s - Tên nhân viên: %s - Năm sinh: %s\n", this.maNV, newName, newYear);
        System.out.printf("Hệ số lương: %s - Hoa hồng: %s - Lương nhân viên: %s - Trạng thái: %s\n", newRate, newCommission, (this.salary = newRate * BASIC_SALARY + newCommission), (newStatus == true ? "Đang làm việc" : "Nghỉ việc"));
    }
}
