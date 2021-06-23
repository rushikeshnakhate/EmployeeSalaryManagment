package com.nphc.hrproject.repository

import com.nphc.hrproject.model.EmployeeMasterData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : JpaRepository<EmployeeMasterData, String>