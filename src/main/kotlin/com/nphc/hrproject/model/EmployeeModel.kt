package com.nphc.hrproject.model


import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.jetbrains.annotations.NotNull
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id


@Entity
@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
data class EmployeeMasterData(
    @Id
    var id: String,
    @get:NotNull var login: String,
    @get:NotNull var name: String,
    @get:NotNull var salary: Double,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @get:NotNull val startdate: LocalDate
)

