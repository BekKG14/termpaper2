import java.lang.ref.PhantomReference;
import java.util.Objects;

public class Employee {
    private String name;
    private int department;
    private int salary;
    private int id;

    public static int nextId = 1;

    public Employee(String name, int department, int salary) {
        this.name = name;
        if (department > 5){
            this.department = 5;
        }else {
            this.department = department;
        }
        this.salary = salary;
        this.id = nextId++;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department=" + department +
                ", salary=" + salary + ", id= " +id +'}';
    }

    public void printShortInfo() {
        System.out.println("Name: " +name + ". Salary: " + salary);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getId(){
        return id;
    }
}
