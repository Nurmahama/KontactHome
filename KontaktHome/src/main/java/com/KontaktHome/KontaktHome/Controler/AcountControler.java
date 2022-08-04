package com.KontaktHome.KontaktHome.Controler;

import com.KontaktHome.KontaktHome.Model.Account;
import com.KontaktHome.KontaktHome.Service.AcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController



public class AcountControler {

    @Autowired  AcountService acountService;

    @GetMapping (value = "get")
      public String infomation() {
        return "Xos Gelmisiz KontaktHome";
    }

    @GetMapping (value = "/All")


    public List <Account> findall () {

        List<Account> accounts = acountService.findAll();
            return accounts;
        }
        @GetMapping (value = "/findById{id}")

              public   Account findById(@PathVariable Long id) {

                   Account account = acountService.findById(id);
                return account;
        }
        @PostMapping (value = "/create")

       public  void  creat (@RequestBody Account account){
               acountService.create(account);

        }
        @PutMapping (value = "/update")

    public  void update (@RequestBody Account account,Long id){

        acountService.update(id,account);
        }
        @DeleteMapping (value = "/delet")

         public  void delet (Long id) {
           acountService.delete(id);
        }

    }


