package com.gaolei.app.util.msg;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
/**
 * 腾讯通工具类封装
 *
 * @author  DuebassLei
 * @version 1.0
 * @date 2020-09-21
 */
public class RtxMsgUtil {
    /** 状态码 {@value} */
    private  static final int SUCCESS_CODE =200;
    /** 字符集编码 {@value} */
    private  static final String CHARSET = "gbk";
    /**
     * 发送腾讯通消息
     *
     * @param title 标题
     * @param  msg 消息内容
     * @param receivers 接收消息人
     * @return 发送成功或失败
     * */
    public static boolean sendRtxNotify(String title, String msg, String[] receivers)
    {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        String result = null;

        try
        {
            String baseUrl = "http://10.172.30.120:8012/sendnotify.cgi";
            String params = "";
            params += "?title=" + URLEncoder.encode(title, CHARSET);
            params += "&msg=" + URLEncoder.encode(msg, CHARSET);
            // params += "&receiver=13344";
            StringBuilder receiver = new StringBuilder();
            for (String item : receivers) {
                if(!receiver.toString().equals(""))
                {
                    receiver.append(",");
                }
                receiver.append(item);
            }

            params += "&receiver=" + receiver;


            baseUrl = baseUrl + params;

            URL url = new URL(baseUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "text/html;charset=gbk");
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(60000);

            connection.connect();

            if(connection.getResponseCode() == SUCCESS_CODE) {
                inputStream = connection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, CHARSET));
                StringBuilder stringBuffer = new StringBuilder();
                String temp;
                while ((temp = bufferedReader.readLine()) != null) {
                    stringBuffer.append(temp);
                    stringBuffer.append("\r\n");
                }

                result = stringBuffer.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != connection) {
                connection.disconnect();
            }
        }


        return result != null && result.contains("操作成功");
    }
}