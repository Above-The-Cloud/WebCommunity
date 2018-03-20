package wang.yiwangchunyu.community.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import sun.misc.BASE64Decoder;
import wang.yiwangchunyu.community.constance.Urlconstance;

public class Utils {
	public static String imgStr2Image(String imgStr, String path, String user_id, String publish_id) {
        // TODO Auto-generated method stub
        if(imgStr==null){
            return "error:imgStr is null----MyImageServer";
        }
        System.out.println(path);
        File file = new File(path);
        if (!file.exists()) {
        	System.out.println("path not exist");
            file.mkdirs();
        }
        System.out.println("absolute:"+file.getAbsolutePath());
       
        String strName = publish_id+"_"+getRandomFileName()+".jpg";
        String imgPath = path+strName;
        String imgUrl = Urlconstance.IMAGE_URL + user_id +"/" +strName;
        try {
            byte[] bs = new BASE64Decoder().decodeBuffer(imgStr);

            for (int i = 0; i < bs.length; i++) {
                if (bs[i] < 0) {
                    bs[i] += 256;
                }
            }

            OutputStream out = new FileOutputStream(imgPath);
            out.write(bs);
            out.flush();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error:IOException----MyImageServer";
        }

        return imgUrl;

    }
	public static String getRandomFileName() {  
		  
        SimpleDateFormat simpleDateFormat;  
  
        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  
  
        Date date = new Date();  
  
        String str = simpleDateFormat.format(date);  
  
        Random random = new Random();  
        
        int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数  
  
        return str+rannum;// 当前时间  
    }  

}
