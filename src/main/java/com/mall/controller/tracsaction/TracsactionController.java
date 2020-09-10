package com.mall.controller.tracsaction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mall.dao.transaction.TransactionMapper;
import com.mall.entity.T;
import com.mall.entity.User;
import com.mall.entity.transaction.Transaction;
import com.mall.model.Response;
import com.mall.utils.QueryPageHelper;
import com.mall.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tracsaction")
@Api(tags = "2、交易记录")
public class TracsactionController {

    @Autowired
    private TransactionMapper transactionMapper;


    @GetMapping("/list")
    @ApiOperation(value = "2.1 交易记录列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "关键字->客户名称-报价金额-接单"),
            @ApiImplicitParam(name = "pageStart", defaultValue = "1", value = "页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", defaultValue = "2000", value = "页面数量", dataType = "Integer", paramType = "query")
              })
    public Map<String, Object> transactionSearchList(@RequestParam(value = "keyword",defaultValue = "null") String keyword,
                                                     @RequestParam(value = "pageStart",required = false)Integer pageStart,
                                                     @RequestParam(value = "pageSize",required = false)Integer pageSize ){
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(1,1000);
        List<Transaction> transactions = transactionMapper.transactionSearchList(keyword);
        PageInfo<Transaction> pageInfo = new PageInfo<>(transactions);
        map.put("data",pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        map.put("code",200);
        map.put("msg","成功");
        return map;
    }


    @PostMapping("/insert")
    @ApiOperation(value = "2.2 添加交易记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerName", value = "客户名称",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "quotationMoney", value = "报价金额",paramType = "query"),
            @ApiImplicitParam(name = "receivingOrder", value = "接单",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "offerer", value = "报价人",dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "received", value = "接收人",dataType = "String", paramType = "query")
    })
    public  Map<String,Object> insert(@RequestParam("customerName")String customerName, @RequestParam("quotationMoney")BigDecimal quotationMoney,
                                      @RequestParam("receivingOrder")String receivingOrder, @RequestParam("offerer")String offerer,
                                      @RequestParam("receivingOrder")String received
    ){
        Map<String,Object> map = new HashMap<>();
        Transaction transaction = new Transaction(customerName, quotationMoney, receivingOrder, offerer, received, new Date(),0);
        int insert = transactionMapper.insert(transaction);
        if(insert>0){
            map.put("code",200);
            map.put("msg","添加成功");
        }else{
            map.put("code",202);
            map.put("msg","添加失败");
        }
        return map;
    }


    @PostMapping("/delete")
    @ApiOperation(value = "2.4 删除记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerName", value = "客户名称",dataType = "String", paramType = "query"),
    })
    public Map<String,Object> delete(@RequestParam("customerName")String customerName){
        Map<String,Object> map = new HashMap<>();
        boolean b = transactionMapper.deleteByifdelete(customerName);
        if(b){
            map.put("code",200);
            map.put("msg","删除成功");
        }else{
            map.put("code",202);
            map.put("msg","删除失败");
        }

      return map;
    }


}
