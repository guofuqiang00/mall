package com.mall.entity;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.File;

/**
 * @author 创建人:< Chenmq>
 * @project 项目:<>
 * @date 创建时间:< 2017/8/30>
 * @comments: 说明:< //七牛云图片配置 >
 */
public class QiniuUtil {

   // private static final Logger logger = Logger.getLogger(QiniuUtil.class);



    //设置好账号的ACCESS_KEY和SECRET_KEY
    final String ACCESS_KEY = "w0RPD5fTnktQy52ttMGjYGDX9l8H53JYsKDiLz_T";
    final String SECRET_KEY = "4l-hZUitfKuH5Oy9iO3ADAjMjcRfbcYpgdGq32dy";
    //要上传的空间
    final String BUCKET_NAME = "my_data_object";

    /**
     * 七牛云上传图片
     * @param localFilePath
     * @return
     */
    public String uoloapQiniu (File localFilePath,String fileName){
        System.out.println("localFilePath"+localFilePath);
        //构造一个带指定Zone对象的配置类
        Configuration cfg;
        cfg = new Configuration(Zone.zone0());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = ACCESS_KEY;
        String secretKey = SECRET_KEY;
        String bucket = BUCKET_NAME;
        //如果是Windows情况下，格式是 D:\23912475_130759767000_2.jpg
//        String localFilePath = "D:\\23912475_130759767000_2.jpg";
        //        String localFilePath = "/home/qiniu/test.png";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
//        String key = "images/"+fileName+"%25tId="+System.currentTimeMillis();
        String key = "images/"+fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        String result = null;

        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

          //  logger.info("{七牛图片上传key: "+ putRet.key+",七牛图片上传hash: "+ putRet.hash+"}");
            System.out.println("{七牛图片上传key: "+ putRet.key+",七牛图片上传hash: "+ putRet.hash+"}");
            result = putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
            result = null;
        }
        return result;
    }

    /**
     * 七牛刪除功能
     * @param key
     * @param bucjet
     * @throws Exception
     */
    public  void  delteQiNiu(String key,String bucjet) throws  Exception{
     try{
         Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
         Configuration configuration = new Configuration(Zone.autoZone());
         BucketManager bucketManager = new BucketManager(auth,configuration);
         bucketManager.delete(bucjet,key);
     }catch (Exception e){
         e.printStackTrace();
         throw e;
     }
    }

}