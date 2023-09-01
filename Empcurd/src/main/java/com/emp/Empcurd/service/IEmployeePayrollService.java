package com.emp.Empcurd.service;;


import com.emp.Empcurd.dto.EmployeePayrollDTO;
import com.emp.Empcurd.entity.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollData();
    EmployeePayrollData getEmployeePayrollDataById(int empId);
    List<EmployeePayrollData> getEmployeesByDepartment(String Department);
    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);
    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO);
    void deleteEmployeePayrollData(int empId);
}
