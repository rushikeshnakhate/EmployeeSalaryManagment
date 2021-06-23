import com.nphc.hrproject.model.EmployeeMasterData
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import java.time.LocalDate

@Tag("unitTest")
@DisplayName("Perform Crud operation HR Department")
class TestController() {

    var restTemplate = TestRestTemplate()

    @Test
    fun testCreate() {
        val url = "http://localhost:8080/users"
        val data = EmployeeMasterData("1", "login", "name", 1000.00, LocalDate.now())
        val response = restTemplate.postForEntity(url, data, EmployeeMasterData::class.java)
        Assertions.assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
    }

    @Test
    fun testUpdate() {
        val url = "http://localhost:8080/users/{id}"
        val data = EmployeeMasterData("1", "login", "name", 1000.00, LocalDate.now())
        restTemplate.put(url, data, EmployeeMasterData::class.java)
        val response = restTemplate.getForEntity(url, EmployeeMasterData::class.java, 3)
        Assertions.assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
    }

    @Test
    fun testDelete() {
        val url = "http://localhost:8080/users/{id}"
        val data = EmployeeMasterData("1", "login", "name", 1000.00, LocalDate.now())
        restTemplate.delete(url, data, EmployeeMasterData::class.java)
        val response = restTemplate.getForEntity(url, EmployeeMasterData::class.java, 3)
        Assertions.assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
    }
}
