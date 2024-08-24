import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

class Employee {
    int empId;
    String empName;
    long mobileNo;
    int salary;
    String address;

    // getter methods
    public int getempId() {
        return empId;
    }

    public String getempName() {
        return empName;
    }

    public long getmobileNo() {
        return mobileNo;
    }

    public int getsalary() {
        return salary;
    }

    public String getaddress() {
        return address;
    }

    //toString() method
    public String toString() {
        return empId + " " + empName + " " + mobileNo + " " + salary + " " + address;
    }

    //parameterized (Field constructor)
    public Employee(int empId, String empName, long mobileNo, int salary, String address) {
        this.empId = empId;
        this.empName = empName;
        this.mobileNo = mobileNo;
        this.salary = salary;
        this.address = address;
    }
}

public class EmployeeData {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner strSc = new Scanner(System.in);

        ArrayList<Employee> list = new ArrayList<Employee>();
        int ch;

        System.out.println("|**|*****************************************************************************|**|");
        System.out.println("|**|                        Employee Management System                           |**|");
        System.out.println("|**|                                                                             |**|");
        System.out.println("*************************************************************************************");

        do {
            System.out.println("\n");
            System.out.println("**********************Enter your choice : ****************************");
            System.out.println("                          1.Insert                                    ");
            System.out.println("                          2.Display                                   ");
            System.out.println("                          3.Search                                    ");
            System.out.println("                          4.Delete                                    ");
            System.out.println("                          5.Update                                    ");
            System.out.println("**********************************************************************");
            System.out.println("\n");

            ch = sc.nextInt();
            sc.nextLine();

            boolean isFound = false;

            switch (ch) {
                //Insert 
                case 1:
                    System.out.println("Enter Employee Id : ");
                    int empId = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Employee Name : ");
                    String empName = strSc.nextLine();

                    System.out.println("Enter Mobile Number : ");
                    long mobileNo = sc.nextLong();
                    sc.nextLine();

                    System.out.println("Enter Salary : ");
                    int salary = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter employee address : ");
                    String address = strSc.nextLine();

                    System.out.println("**********Employee Details**********\n");
                    list.add(new Employee(empId, empName, mobileNo, salary, address));

                    break;
                
                //Display
                case 2:
                    for (Employee emp : list) {
                        System.out.println(emp);
                    }
                    break;

                //Search
                case 3:
                    System.out.println("Enter employee Id for search : ");
                    empId = sc.nextInt();
                    for (Employee emp : list) {
                        if (emp.getempId() == empId) {
                            isFound = true;
                            System.out.println("************Searched Employee Details************\n");
                            System.out.println(emp);
                        }

                    }
                    if (!isFound) {
                        System.out.println("Employee not found incorrect Employee Id");
                    }
                    break;
                
                //remove
                case 4:
                    System.out.println("Enter eployee Id for remove the employee");
                    empId = sc.nextInt();

                    Iterator<Employee> i = list.iterator();

                    while (i.hasNext()) {
                        Employee emp = i.next();
                        if (emp.getempId() == empId) {
                            isFound = true;
                            i.remove();
                            break;
                        }

                        if (!isFound) {
                            System.out.println("Employee not found incorrect Employee Id");
                        } else {
                            System.out.println("Employee deleted successfully");
                        }
                    }
                    break;
                
                //update
                case 5:
                    System.out.println("Enter Employee Id to update the employee data : ");
                    empId = sc.nextInt();
                    ListIterator<Employee> li = list.listIterator();
                    while (li.hasNext()) {
                        Employee e = li.next();
                        if (e.getempId() == empId) {
                            System.out.println("Enter new Employee Id : ");
                            empId = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter new employee name : ");
                            empName = strSc.nextLine();
                            System.out.println("Enter new mobile number : ");
                            mobileNo = sc.nextLong();
                            sc.nextLine();
                            System.out.println("Enter new salary : ");
                            salary = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter new address : ");
                            address = strSc.nextLine();

                            isFound = true;
                            li.set(new Employee(empId, empName, mobileNo, salary, address));

                        }
                    }
                    if (!isFound) {
                        System.out.println("Employee not found incorrect Employee Id");
                    } else {
                        System.out.println("Data updated successfully");
                    }
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }

        } while (ch != 0);
        sc.close();
        strSc.close();
    }
}
