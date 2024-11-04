package bankada;

import lombok.Getter;

@Getter
public class Employee {
    private static final Employee instance = new Employee();
    private String name;

    private Employee() {
        this.name = EmployeeConstants.FIRST_NAME + " " + EmployeeConstants.LAST_NAME;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Employee getInstance() {
        return instance;
    }
}
