package lesson20;

import lesson19.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

    List<Employee> findAll();

    Optional<Employee> findById(Integer id);

    void save(Employee employee);

    void delete(Employee employee);
}