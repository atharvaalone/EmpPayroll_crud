package com.emp.Empcurd.service;;

import com.emp.Empcurd.dto.EmployeePayrollDTO;
import com.emp.Empcurd.entity.EmployeePayrollData;
import com.emp.Empcurd.exceptions.EmployeePayrollException;
import com.emp.Empcurd.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

//    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollRepository
                .findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee with Found!!" + empId + "does not exists"));
    }

    @Override
    public List<EmployeePayrollData> getEmployeesByDepartment(String department)
    {
        return employeePayrollRepository.findEmployeesByDepartment(department);
    }
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empPayrollDTO);
        log.debug("Emp Data: "+empData.toString());
//        employeePayrollList.add(employeePayrollData);
        return employeePayrollRepository.save(empData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayrollData(empPayrollDTO);
        return employeePayrollRepository.save(empData);
    }

   @Override
    public void deleteEmployeePayrollData(int empId) {

        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(empData);
    }
}
