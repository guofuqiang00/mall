package com.mall.dao.transaction;

import com.mall.entity.transaction.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TransactionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Transaction record);

    Transaction selectByPrimaryKey(Integer id);

    List<Transaction> selectAll();

    int updateByPrimaryKey(Transaction record);

    List<Transaction> transactionSearchList(String keyword);

    boolean deleteByifdelete(String record);
}