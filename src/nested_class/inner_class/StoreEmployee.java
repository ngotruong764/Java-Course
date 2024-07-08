package nested_class.inner_class;

import nested_class.static_nested_class.domain.Employee;

import java.util.Comparator;

public class StoreEmployee extends Employee {
    private String store;

    public class StoreComparator<T extends StoreEmployee> implements Comparator<StoreEmployee>{

        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            int result = o1.store.compareTo(o2.store);
            if( result == 0)
                return new Employee.EmployeeComparator<>("yearStarted").compare(o1,o2);
            return result;
        }
    }

    public StoreEmployee(int employeeId, String name, int yearStarted, String store) {
        super(employeeId, name, yearStarted);
        this.store = store;
    }

    @Override
    public String toString() {
        return "%-8s%s".formatted(store, super.toString());
    }
}
