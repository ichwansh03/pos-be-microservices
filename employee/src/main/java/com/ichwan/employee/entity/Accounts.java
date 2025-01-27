package com.ichwan.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends AuditEntity {

    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "account_number")
    @Id
    private Long accountNumber;

    private String email;
    private String type;
}
