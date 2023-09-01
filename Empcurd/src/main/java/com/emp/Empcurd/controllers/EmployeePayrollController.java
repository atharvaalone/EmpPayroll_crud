package com.emp.Empcurd.controllers;

import com.emp.Empcurd.dto.EmployeePayrollDTO;
import com.emp.Empcurd.dto.ResponseDTO;
import com.emp.Empcurd.entity.EmployeePayrollData;
import com.emp.Empcurd.service.EmployeePayrollService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeePayrollController
{
    @Autowired
    private EmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData()
    {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get call Success", empDataList);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
    {
        EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call Success for id:", employeePayrollData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("department") String department){
        List<EmployeePayrollData> employeePayrollDataList = null;
        employeePayrollDataList = employeePayrollService.getEmployeesByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("Get call for Id sucessful",employeePayrollDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(
            @Valid @RequestBody EmployeePayrollDTO empPayrollDTO)
    {
        EmployeePayrollData employeePayrollData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Data Successfully", employeePayrollData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                @RequestBody EmployeePayrollDTO empPayrollDTO)
    {
        EmployeePayrollData employeePayrollData = employeePayrollService.updateEmployeePayrollData(empId,empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully",employeePayrollData);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Delete Id : " +empId);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }

}
