
package com.mall.controller;


import com.mall.dao.upload.UploadMapper;
import com.mall.entity.Upload;
import com.mall.service.upload.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class UploadQINiuController {

//private static final Logger logger = Logger.getLogger(UploadQINiuController.class);

    @Resource
    private FileService fileService;
    @Resource
    private UploadMapper uploadMapper;

    /**
     * 上传图片文件七牛云
     * @param files
     * @return
     */
    @RequestMapping(value="/imgs", method = RequestMethod.POST)
    public String uploadImg(@RequestParam("file") MultipartFile[] files) {


        System.out.println(files);

        Map<String,List<String>> map = new HashMap<>();

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
            Date date = new Date();//获得系统时间.
            SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd " );
            String nowTime = sdf.format(date);
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