package ra.business;

import ra.businesslmp.Employee;

import java.util.Scanner;

public interface IEmployee {
    public static final int BASIC_SALARY = 1300000;
    void inputData(Scanner scanner);
    void displayData();
}
