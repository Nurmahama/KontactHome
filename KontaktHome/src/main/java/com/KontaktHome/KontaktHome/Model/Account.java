package com.KontaktHome.KontaktHome.Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "WorldTelecom")
@JsonAutoDetect (fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Account {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    private Long id;
    private  String name;
    private String surname;
    private String  patronymic;
    private String  Information;
    private  String  total_debt;
    private  String loan_paid;
    private String outstanding_loan_debt;
    private String Monthly_loan;
    private String Credit_penalties;
    private  String role;
    private String password;




}

