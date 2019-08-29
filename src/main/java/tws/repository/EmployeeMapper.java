package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectAll();
   // List<Employee> getEmployees();
    void insertEmpployee(@Param(value = "employee") Employee employee);
    
    void updateEmpployees(@Param(value = "employee") Employee employee);
    
    void deleteEmpployees(@Param(value = "id") int id);
    
    
}
