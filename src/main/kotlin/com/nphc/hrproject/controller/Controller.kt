package com.nphc.hrproject.controller

import com.nphc.hrproject.model.EmployeeMasterData
import com.nphc.hrproject.service.CSVService
import com.nphc.hrproject.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class EmployeeController {
    @Autowired
    lateinit var csvService: CSVService

    @Autowired
    lateinit var empService: EmployeeService

    @PostMapping("/users")
    fun createEmployee(@Validated @RequestBody employeeMasterData: EmployeeMasterData) =
        empService.createEmployee(employeeMasterData)

    //CSV upload
    @PostMapping("upload/file")
    fun uploadCsvFIle(@Validated @RequestParam("file") file: MultipartFile) = csvService.uploadCsvFile(file)

    //Update Employee
    @PutMapping("/users/{id}")
    fun updateEmployee(
        @Validated
        @PathVariable("id") id: String,
        @RequestBody employeeMasterData: EmployeeMasterData
    ) = empService.update(id, employeeMasterData)


    //Get Employee Data based on Filter
    @GetMapping("/users")
    fun getEmployees(
        @Validated
        @RequestParam("minSalary", required = false) minSalary: Double,
        @RequestParam("maxSalary", required = false) maxSalary: Double
    ) = empService.getEmployees(minSalary, maxSalary)

    //Get Employee All Employees
    @GetMapping("/users-all")
    fun getAllEmployees() = empService.getAllEmployees()

    //Get data for specific employee
    @GetMapping("/users/{id}")
    fun getEmployee(@Validated @PathVariable("id") id: String) = empService.getEmployee(id)

    //Delete Record
    @DeleteMapping("/users/{id}")
    fun deleteEmployee(@Validated @PathVariable("id") id: String) = empService.deleteEmployee(id)
}
