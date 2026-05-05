void main() {
    EmployeeBook employeeBook = new EmployeeBook();
    Employee bob = new Employee("bob", 12, 1222);
    Employee lee = new Employee("Lee", 2, 12313123);
    Employee notLee = new Employee("Lee", 2, 12313123);
    employeeBook.addEmployee(bob);
    System.out.println(employeeBook.toString());
    employeeBook.addEmployee(lee);
    employeeBook.addEmployee(notLee);
    System.out.println(employeeBook);
    employeeBook.printEveryone();
    System.out.println(employeeBook.averageSalary());
    employeeBook.findFirstFromDepartment(2);
    System.out.println(employeeBook.findBySalary(bob));
    employeeBook.taxes("PROPORTIONAL");

}