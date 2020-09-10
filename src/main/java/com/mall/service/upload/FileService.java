package com.mall.service.upload;


import com.mall.dao.upload.FileDao;
import com.mall.entity.QiniuUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Service
public class FileService {
 //   private static final Logger logger = LoggerFactory.getLogger(FileService.class);

    @Autowired
    private FileDao fileDao;


    /**
     * 七牛云上传图片
     * @param file
     * @return
     */
    public Map<String, List<String>> uploadImgs(MultipartFile file) {

        Map<String, List<String>> resultMap = new HashMap<>();
        List<String> list = new LinkedList<>();
        String result = null;


            String fileName = file.getOriginalFilename();

            // 创建一个临时目录文件
            String tempFiles = "temp/"+fileName;
            File dest = new File(tempFiles);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }

            BufferedOutputStream out = null;
            QiniuUtil qn = new QiniuUtil();

            try {
                out = new BufferedOutputStream(new FileOutputStream(dest));
                out.write(file.getBytes());
                result = qn.uoloapQiniu(dest,fileName);

                if (StringUtils.isNotBlank(result)) {
                    list.add(result);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e1) {
                e1.getMessage();
            }  finally{
                try {
                    if (null != out) {
                        out.flush();
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (dest.getParentFile().exists()) {
                    dest.delete();
                }
            }
//     logger.info("imagesList == " + list);
        System.out.println("imagesList == " + list);
        if (list.isEmpty()) {
            list.add("error");
        }
        resultMap.put("result",list);
        return resultMap;
    }



    /**
     * 七牛云上传多张图片
     * @param file
     * @return
     */
    public Map<String, List<String>> uploadImgsCanMany(MultipartFile[] file) {

        Map<String, List<String>> resultMap = new HashMap<>();
        List<String> list = new LinkedList<>();
        String result = null;

        for (int i = 0; i < file.length; i++) {
            String fileName = file[i].getOriginalFilename();

            // 创建一个临时目录文件
            String tempFiles = "temp/"+fileName;
            File dest = new File(tempFiles);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }

            BufferedOutputStream out = null;
            QiniuUtil qn = new QiniuUtil();

            try {
                out = new BufferedOutputStream(new FileOutputStream(dest));
                out.write(file[i].getBytes());
                result = qn.uoloapQiniu(dest,fileName);

                if (StringUtils.isNotBlank(result)) {
                    list.add(result);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e1) {
                e1.getMessage();
            }  finally{
                try {
                    if (null != out) {
                        out.flush();
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (dest.getParentFile().exists()) {
                    dest.delete();
                }
            }
        }
//     logger.info("imagesList == " + list);
        System.out.println("imagesList == " + list);
        if (list.isEmpty()) {
            list.add("error");
        }
        resultMap.put("result",list);
        return resultMap;
    }


}
