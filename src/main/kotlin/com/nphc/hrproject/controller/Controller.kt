package com.nphc.hrproject.controller

import com.nphc.hrproject.model.EmployeeMasterData
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class EmployeeController {

    @PostMapping("/users")
    fun createEmployee(@Validated @RequestBody employeeMasterData: EmployeeMasterData) =
        TODO()


    @PostMapping("upload/file")
    fun uploadCsvFIle(@Validated @RequestParam("file") file: MultipartFile) = TODO()

    //Update Employee
    @PutMapping("/users/{id}")
    fun updateEmployee(
        @Validated
        @PathVariable("id") id: String,
        @RequestBody employeeMasterData: EmployeeMasterData
    ) = TODO()


    //Get Employee Data based on Filter
    @GetMapping("/users")
    fun getEmployees(
        @Validated
        @RequestParam("minSalary") minSalary: Double,
        @RequestParam("maxSalary") maxSalary: Double
    ) = TODO()

    //Get Employee All Employees
    @GetMapping("/users-all")
    fun getAllEmployees() = TODO()

    //Get data for specific employee
    @GetMapping("/users/{id}")
    fun getEmployee(@Validated @PathVariable("id") id: String) = TODO()

    //Delete Record
    @DeleteMapping("/users/{id}")
    fun deleteEmployee(@Validated @PathVariable("id") id: String) = TODO()
}
