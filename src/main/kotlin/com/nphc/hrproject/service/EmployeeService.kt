package com.nphc.hrproject.service


import com.nphc.hrproject.exception.InvalidInputException
import com.nphc.hrproject.model.EmployeeMasterData
import com.nphc.hrproject.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.sqlite.SQLiteException


@Component
class EmployeeService {

    @Autowired
    lateinit var db: EmployeeRepository

    fun createEmployee(employeeMasterData: EmployeeMasterData): ResponseEntity<String> {
        return try {
            db.save(employeeMasterData)
            return ResponseEntity("Data Created/Uploaded", HttpHeaders(), HttpStatus.CREATED)
        } catch (ex: SQLiteException) {
            throw InvalidInputException(" $employeeMasterData already exists")
        } catch (ex: Exception) {
            throw InvalidInputException("invalid data=$employeeMasterData")
        }
    }

    fun getEmployee(id: String): EmployeeMasterData {
        val found = db.findById(id)
        if (found.isPresent) {
            ResponseEntity("no such employee=${id}", HttpHeaders(), HttpStatus.BAD_REQUEST)
        }
        return EmployeeMasterData(
            found.get().id,
            found.get().login,
            found.get().name,
            found.get().salary,
            found.get().startdate
        )
    }

    fun getEmployees(minSalary: Double = MIN_SALARY, maxSalary: Double = MAX_SALARY): List<EmployeeMasterData> {
        return db.findAll()
            .filter { it.salary >= minSalary }
            .filter { it.salary <= maxSalary }
    }

    fun getAllEmployees(): MutableList<EmployeeMasterData> = db.findAll()

    fun update(id: String, employeeMasterData: EmployeeMasterData): ResponseEntity<String> {
        return if (db.findById(id).isPresent) {
            db.save(employeeMasterData)
            ResponseEntity("Successfully updated", HttpHeaders(), HttpStatus.CREATED)
        } else
            ResponseEntity("no such employee=${employeeMasterData}", HttpHeaders(), HttpStatus.BAD_REQUEST)
    }


    fun deleteEmployee(id: String): ResponseEntity<String> {
        return if (db.findById(id).isPresent) {
            db.deleteById(id)
            ResponseEntity("Successfully deleted", HttpHeaders(), HttpStatus.CREATED)
        } else {
            ResponseEntity("no such employee=${id}", HttpHeaders(), HttpStatus.BAD_REQUEST)
        }
    }

    companion object {
        const val MIN_SALARY = 0.0
        const val MAX_SALARY = 4000.00
    }
}