package lesson20.impl;

import lesson19.Employee;
import lesson20.EmployeeDao;
import lesson20.HibernateHelper;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class EmployeeJpaDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> findAll() {
        try (Session session = HibernateHelper.getSession()) {
            session.beginTransaction();
            List<Employee> result = session.createQuery("select employee from Employee employee").list();
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void delete(Employee employee) {

    }
}