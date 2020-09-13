package com.mall.dao.account;

import com.mall.entity.Account;
import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    Account selectByPrimaryKey(Integer id);

    List<Account> selectAll();

    int updateByPrimaryKey(Account record);

    int outMoney(String name,Double money);

    int inMoney(String name,Double money);
}