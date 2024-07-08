package nested_class.static_nested_class;

import nested_class.static_nested_class.domain.Employee;
import nested_class.static_nested_class.domain.EmployeeComparator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(new Employee(10001, "Ralph", 2015),
                                                            new Employee(10005, "Carole", 2021),
                                                            new Employee(10023, "Jane", 2013),
                                                            new Employee(100012, "Laura", 2020),
                                                            new Employee(102323, "Jim", 2018)));
//        var comparator = new EmployeeComparator<>();
//        employees.sort(comparator);
        employees.sort(new Employee.EmployeeComparator<>("yearStarted"));
        for(Employee e: employees){
            System.out.println(e);
        }
    }
}
