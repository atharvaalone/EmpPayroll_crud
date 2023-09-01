package com.emp.Empcurd.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollDTO
{

//    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee name Invalid")
    public String name;

//    @Min(value = 1000,message = "min salary should be more than 1000")
    public long salary;

//    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
//    @NotNull(message = "startDate should not br Empty")
//    @PastOrPresent(message = "startDate should be past or today's date")
    public LocalDate startDate;

//    @NotBlank(message = "Note cannot be Empty")
    public String note;

//    @NotBlank (message = "profilePic cannot be Empty")
    public String profilePic;

//    @NotNull(message = "department should not br Empty")
//   @NotBlank(message = "departments should not be Empty")
    public List<String> departments;

}
