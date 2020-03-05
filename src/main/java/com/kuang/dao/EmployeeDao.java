package com.kuang.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// 模拟数据库
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;
    
    @Autowired
    private DepartmentDao departmentDao;
    
    static{
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
        employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
        employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
        employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
        employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));
    }
    
    private static Integer initId = 1006;

    // 新增员工实时 id 自增
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }
        
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    // 获得全部的员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    // 通过id获取员工
    public Employee get(Integer id){
        return employees.get(id);
    }

    // 通过id删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}