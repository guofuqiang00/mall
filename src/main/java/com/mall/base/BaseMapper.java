package com.mall.base;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.*;

@RegisterMapper
public interface BaseMapper<T> extends Mapper<T>, IdsMapper<T>,
        tk.mybatis.mapper.common.BaseMapper<T>, MySqlMapper<T>,
        ConditionMapper<T>, ExampleMapper<T>{
}
