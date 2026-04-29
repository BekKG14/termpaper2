import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public double averageSalary() {
        int salaries = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                salaries = salaries + employee.getSalary();
                count++;
            }
        }
        return (double) salaries / count;
    }

    public void printEveryone() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public String toString() {
        return Arrays.toString(employees);
    }

    public Boolean addEmployee(Employee employee) {
        if (employee == null) {
            return false;
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                continue;
            } else {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public double taxes(String taxType) {
        double sumTax = 0;
        for (int i = 0; i <employees.length ; i++) {
            if(employees[i] == null){
                break;
            }
            double tax = 0;
            double salary = (double) employees[i].getSalary();
            switch (taxType) {
                case "PROPORTIONAL":
                    tax = salary * 0.13;
                    break;
                case "PROGRESSIVE":
                    if (employees[i].getSalary() <= 150) {
                        tax = salary * 0.13;
                    } else if (salary <= 350) {
                        tax = salary * 0.17;
                    } else {
                        tax = salary * 0.21;
                    }
            }
            System.out.println("Налог сотрудника по цифрой " + employees[i].getId() + ": " + tax);
            sumTax = sumTax + tax;
        }
        return sumTax;
    }

    public void findFirstFromDepartment(int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                employees[i].printShortInfo();
                break;
            }
        }
    }

    public Boolean findBySalary(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(employee)) {
                return true;
            }
        }
        return false;
    }

    public void findEmployeeWithSalary(int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == department && employees[i].getSalary() > salary) {
                employees[i].printShortInfo();
                break;
            }
        }
    }

    public void findEmployeesWithSalaryLower(int wage, int employeeNumber) {
        int found = 0;
        int i = 0;
        while (i < employees.length && found < employeeNumber) {
            if (employees[i] != null && employees[i].getSalary() < wage) {
                System.out.println(employees[i]);
                found++;
            }
            i++;
            if (found >= employeeNumber) {
                break;
            }
        }
        if (found == 0) {
            System.out.println("нет таких");
        }
    }

    public Employee findById(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void raiseSalaryByDepartment(int id, int percentage) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() != id) {
                continue;
            }else {
                employees[i].setSalary((int) (employees[i].getSalary() * percentage) / 100);
            }
        }
    }
}