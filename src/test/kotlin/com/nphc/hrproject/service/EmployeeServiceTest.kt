package com.nphc.hrproject.service

import com.nphc.hrproject.controller.EmployeeController
import com.nphc.hrproject.model.EmployeeMasterData
import junit.framework.Assert.assertEquals
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDate

@RunWith(SpringRunner::class)
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    lateinit var controller: EmployeeController

    @Test
    fun createDelete() {
        val data = EmployeeMasterData("1", "login", "name", 1000.00, LocalDate.now())
        controller.createEmployee(data)
        assertEquals(controller.getEmployee(data.id).id, data.id)
        controller.deleteEmployee(data.id)
        Assertions.assertThat(controller.getEmployee(data.id).id.isEmpty())
    }
}