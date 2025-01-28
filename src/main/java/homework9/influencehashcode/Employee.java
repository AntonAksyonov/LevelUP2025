package homework9.influencehashcode;

public class Employee implements Comparable<Employee> {
    static boolean equalHashCode = false;

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

    public static void offHashCode(boolean equalHashCode) {
        Employee.equalHashCode = equalHashCode;
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
        return (this.fio + this.serviceNumber).compareTo(employee.fio + employee.serviceNumber);
    }

    @Override
    public int hashCode() {
        return equalHashCode ? 1 : super.hashCode();
    }
}
