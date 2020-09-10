package com.mall.controller;

import com.mall.dao.upload.UploadMapper;
import com.mall.dao.user.CustomerMapper;
import com.mall.entity.Customer;
import com.mall.entity.Upload;
import com.mall.service.upload.FileService;
import com.mall.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private FileService fileService;
    @Autowired
    private UploadMapper uploadMapper;



    @RequestMapping("/insert")
    public R insertCustomer(@RequestBody Customer customer){

        System.out.println("start");
        System.out.println(customer);


        return null;

    }

    @RequestMapping(value="/imgs", method = RequestMethod.POST)
    public String uploadImg(@RequestParam("file") MultipartFile[] files) {

        Map<String, List<String>> map = new HashMap<>();

        // 验证非空
        if (StringUtils.isBlank(files[0].getOriginalFilename())) {
            System.out.println("为空");
        } else {

            map = fileService.uploadImgsCanMany(files);

            List<String> resultList = map.get("result");
            System.out.println("result");
            for(String str:resultList){
                System.out.println(str);
            }
            String path="http://ps41mp8hu.bkt.clouddn.com/"+resultList;
            String pathUrl=path.replace("[","").replace("]","");
            Upload upload=new Upload();
            upload.setPath(pathUrl);
//            Date date = new Date();//获得系统时间.
//            SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd " );
//            String nowTime = sdf.format(date);
//            upload.setCreateTime(nowTime);
            Integer integer = uploadMapper.insertUpload(upload);
            if(integer>0){
//                logger.info("上传成功");
                System.out.println("上传成功");
                return  "redirect:/showImg";
            }else{
                System.out.println("上传失败");
//                logger.info("上传失败");
            }
            // logger.info("图片上传返回结果:"+resultList);
            System.out.println("图片上传返回结果:"+resultList);

            return  "redirect:/showImg";
        }
        return  "redirect:/showImg";
    }








}
