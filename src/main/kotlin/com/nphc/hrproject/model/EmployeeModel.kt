package com.nphc.hrproject.model


import java.time.LocalDate


data class EmployeeMasterData(
    var id: String,
    var login: String,
    var name: String,
    var salary: Double,
    val startdate: LocalDate
)

