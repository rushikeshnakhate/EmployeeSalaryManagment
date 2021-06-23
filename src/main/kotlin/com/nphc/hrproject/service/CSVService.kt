package com.nphc.hrproject.service


import com.nphc.hrproject.exception.InvalidCSVDataException
import com.nphc.hrproject.exception.InvalidInputException
import com.nphc.hrproject.model.EmployeeMasterData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Service
class CSVService {
    @Autowired
    lateinit var employeeService: EmployeeService


    companion object {
        const val TYPE = "text/csv"
        val HEADERs = arrayOf("id", "login", "name", "salary", "startdate")
        const val NUMBER_OF_COLUMNS = 5
    }

    fun hasCSVFormat(file: MultipartFile): Boolean {
        return TYPE == file.contentType
    }

    fun uploadCsvFile(file: MultipartFile) {
        var fileReader: BufferedReader? = null
        try {
            throwIfInvalidFile(file)
            fileReader = BufferedReader(InputStreamReader(file.inputStream, "UTF-8"))
            readFileAsLinesUsingReadLines(fileReader).forEach { it ->
                it.split(",").let {
                    if (it.count() == NUMBER_OF_COLUMNS) {
                        employeeService.createEmployee(
                            EmployeeMasterData(
                                it[0],
                                it[1],
                                it[2],
                                it[3].toDouble(),
                                LocalDate.parse(it[4], DateTimeFormatter.ISO_DATE)
                            )
                        )
                    }
                }
            }
        } catch (ex: InvalidInputException) {
            throw InvalidInputException("Error in csv file=${file}")
        } catch (ex: Exception) {
            throw InvalidCSVDataException("Error in csv file=${file}")
        } finally {
            closeFileReader(fileReader)
        }
    }

    fun readFileAsLinesUsingReadLines(fileReader: BufferedReader): List<String> = fileReader.readLines()


    private fun closeFileReader(fileReader: BufferedReader?) {
        try {
            fileReader?.close()
        } catch (ex: IOException) {
            throw InvalidCSVDataException("Error during csv import")
        }
    }

    private fun throwIfInvalidFile(file: MultipartFile) {
        if (file.isEmpty) {
            throw InvalidCSVDataException("file=$file provided is empty")
        } else if (!hasCSVFormat(file))
            throw InvalidCSVDataException("unexpected input format for file=$file,expected ${TYPE}, found ${file.contentType}")
    }

}
