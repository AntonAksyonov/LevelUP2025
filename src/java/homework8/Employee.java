package homework8;

public class Employee implements Comparable<Employee> {
    private final String fio;
    private String serviceNumber;
    private int workExperience;

    public Employee(String fio, String serviceNumber, int workExperience) {
        this.fio = fio;
        this.serviceNumber = serviceNumber;
        this.workExperience = workExperience;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public String getFio() {
        return fio;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fio='" + fio + '\'' +
                ", serviceNumber='" + serviceNumber + '\'' +
                ", workExperience=" + workExperience +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {
        return this.fio.compareTo(employee.fio);
    }
}
