package com.KontaktHome.KontaktHome.Service.impl;

import com.KontaktHome.KontaktHome.Model.Account;
import com.KontaktHome.KontaktHome.Repositoty.AccountRepository;
import com.KontaktHome.KontaktHome.Service.AcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AcountServicelmpl implements AcountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        Account account = null;
        try {
            account = accountRepository.findById(id).get();

        }
        catch (Exception e){
            System.out.println(e);
        }
        return account;
    }

    @Override
    public void create(Account account) {
         accountRepository.save(account);
    }

    @Override
    public void update(Long id, Account account) {
        Account oldaccount = findById(id);

        oldaccount.setName(account.getName());
        oldaccount.setSurname(account.getSurname());
        oldaccount.setPatronymic(account.getPatronymic());
        oldaccount.setInformation(account.getInformation());
        oldaccount.setTotal_debt(account.getTotal_debt());
        oldaccount.setLoan_paid(account.getLoan_paid());
        oldaccount.setOutstanding_loan_debt(account.getOutstanding_loan_debt());
        oldaccount.setMonthly_loan(account.getMonthly_loan());
        oldaccount.setCredit_penalties(account.getCredit_penalties());
                accountRepository.save(oldaccount);
    }

    @Override
    public void delete(Long id) {
        Account account  = findById(id);
        accountRepository.delete(account);

    }
}


