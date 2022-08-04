package com.KontaktHome.KontaktHome.Service;

import com.KontaktHome.KontaktHome.Model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AcountService {

    List<Account> findAll();
    Account findById(Long id);
    void create (Account account);
    void update (Long id,Account account);
    void delete (Long id);

}
