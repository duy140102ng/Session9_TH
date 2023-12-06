import ra.businesslmp.Employee;

import java.util.*;

public class Main {
    Employee[] arrEmployee = new Employee[100];
    int currentIndex = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        Main main = new Main();
        do {
            System.out.println("********************MENU*********************\n" +
                    "1. Nhập thông tin cho n nhân viên\n" +
                    "2. Hiển thị thông tin nhân viên\n" +
                    "3. Tìm kiếm nhân viên theo tên nhân viên\n" +
                    "4. Cập nhật thông tin nhân viên\n" +
                    "5. Xóa nhân viên theo mã nhân viên\n" +
                    "6. Sắp xếp nhân viên theo lương tăng dần (Comparable)\n" +
                    "7. Sắp xếp nhân viên theo tên nhân viên giảm dần (Comparator)\n" +
                    "8. Sắp xếp nhân vên theo năm sinh tăng dần (Comparator)\n" +
                    "9. Thoát\n");
            System.out.println("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    main.inputMenu(scanner);
                    break;
                case 2:
                    main.displayMenu();
                    break;
                case 3:
                    main.searchNV(scanner);
                    break;
                case 4:
                    main.updateNV(scanner);
                    break;
                case 5:
                    main.deleteEmployee(scanner);
                    break;
                case 6:
                    main.sortBySalary();
                    break;
                case 7:
                    main.sortByName();
                    break;
                case 8:
                    main.sortByYear();
                    break;
                case 9:
                    break;
                default:
                    System.err.println("Mời lựa chọn từ 1-9");
                    break;
            }
        }while (choice!=9);
    }
    public void inputMenu(Scanner scanner){
        System.out.println("Nhập số nhân viên: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            arrEmployee[currentIndex] = new Employee();
            arrEmployee[currentIndex].inputData(scanner);
            currentIndex++;
            System.out.println("\n--------------------------");
        }
    }
    public void displayMenu(){
        for (int i = 0; i < currentIndex; i++) {
            arrEmployee[i].displayData();
        }
    }
    public void searchNV(Scanner scanner){
        System.out.println("Nhập tên nhân viên cần tìm: ");
        String name = scanner.nextLine();
        for (Employee employee: arrEmployee) {
            if (name.equals(employee.getTenNV())){
                employee.displayData();
            }
        }
    }
    public int getIndexById(String newId){
        for (int i = 0; i < currentIndex; i++) {
            if (arrEmployee[i].getMaNV() == newId){
                return i;
            }
        }
        return -1;
    }
    public void updateNV(Scanner scanner){
        System.out.println("Nhập mã nhân viên cần cập nhật: ");
        String newId = scanner.nextLine();
        int indexUpdate = getIndexById(newId);
        if (indexUpdate >= 0){
            arrEmployee[indexUpdate].updateData(scanner);
        }
    }
    public void deleteEmployee(Scanner scanner){
        System.out.println("Nhập mã nhân viên cần xóa: ");
        String newId = scanner.nextLine();
        int indexDelete = getIndexById(newId);
        for (int i = indexDelete; i < currentIndex; i++) {
            arrEmployee[i] = arrEmployee[i+1];
        }
        arrEmployee[currentIndex-1] = null;
        currentIndex--;
    }
    public void sortBySalary(){
        Arrays.sort(arrEmployee, Comparator.comparing(Employee::getSalary));
    }
    public void sortByName(){
        Arrays.sort(arrEmployee, Comparator.comparing(Employee::getTenNV).reversed());
    }
    public void sortByYear(){
        Arrays.sort(arrEmployee, Comparator.comparing(Employee::getYear));
    }
}