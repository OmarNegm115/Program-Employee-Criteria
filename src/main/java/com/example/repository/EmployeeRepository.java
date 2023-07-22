package com.example.repository;

import com.example.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    @Query(value = "SELECT * FROM hr.employee WHERE (:dId IS NULL OR (department_id = :dId))" +
            " AND " +
            "(:jT IS NULL OR (job_title = :jT)) AND" +
            " (:dM IS NULL OR (direct_manager = :dM)) " +
            "AND (:cTID IS NULL OR (contract_type_id =:cTID)) AND " +
            "(:eCode Is NULL OR (employee_code =:eCode)) AND " +
            "(:eName IS NULL OR (employee_name =:eName))" +
            " AND (:eBD IS NULL OR (employee_birth_date = :eBD)) " +
            " AND (:sT IS NULL OR (status =:sT)) " +
            " AND (:bcID IS NULL OR (birth_city_id =:bcID))",
            nativeQuery = true)
    List<EmployeeEntity> searchEmpEntity(@Param("dId")Long dID, @Param("jT")String jT,
                                         @Param("dM")String dM, @Param("cTID")Long cTID,
                                         @Param("eCode")Integer eCode,
                                         @Param("eName")String eName,
                                         @Param("eBD") LocalDate eBD, @Param("sT")Boolean sT,
                                         @Param("bcID")Long bcID);
}
