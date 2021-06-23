package com.nphc.hrproject

import com.nphc.hrproject.controller.EmployeeController
import com.nphc.hrproject.model.EmployeeMasterData
import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.postForEntity
import java.time.LocalDate

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HrProjectApplicationTests {
    @Autowired
    lateinit var controller: EmployeeController

    @Test
    fun contextLoads() {
        Assert.assertNotNull(controller)
    }

}
