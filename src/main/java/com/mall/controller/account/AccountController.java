package com.mall.controller.account;

import com.mall.dao.account.AccountMapper;
import com.mall.entity.Account;
import com.mall.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;


    @RequestMapping("/outMoney")
    @Transactional(propagation = Propagation.REQUIRED)
    public R outMoney(String name,String na,Double money){
        int out = accountMapper.outMoney(name,money);
        int in = accountMapper.inMoney(na, money);
        R r = new R();
        r.ok().put("out",out);

        String str=null;

        if(str.equals("")){
            System.out.println("异常 ");
        }


        return R.ok().put("out",out);

    }

    @RequestMapping("/select1")
    public R inMoney(String name,Double money){
        List<Account> accounts = accountMapper.selectAll();
        return R.ok().put("data",accounts);

    }


}
