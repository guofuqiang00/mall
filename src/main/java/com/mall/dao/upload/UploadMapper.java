package com.mall.dao.upload;

import com.mall.entity.Upload;

import java.util.List;

public interface UploadMapper {
    int insert(Upload record);

    List<Upload> selectAll();


    /**
     *
     * 上传路径到数据库
     *
     * */
     Integer   insertUpload(Upload upload);

}