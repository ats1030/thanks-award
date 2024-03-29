package com.creve_ip.award.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "category")
public class ThanksCategory {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private boolean colleague;  // FIXME: Booleanにする？
    
    private boolean customer;  // FIXME: Booleanにする？
    
    private boolean company;  // FIXME: Booleanにする？
}
