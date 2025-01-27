package com.ichwan.employee.repository;

import com.ichwan.employee.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Optional<Accounts> findByEmpId(Long empId);

    @Transactional
    @Modifying
    void deleteByEmpId(Long empId);
}
