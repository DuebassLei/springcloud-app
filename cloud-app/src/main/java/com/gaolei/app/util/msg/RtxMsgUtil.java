package com.gaolei.app.util.msg;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
/**
 * 腾讯通工具类
 *
 * @author  DuebassLei
 * @version 1.0
 * @date  2020/9/21 19:20
 *
 */
public class RtxMsgUtil {
    /** 字符集编码 {@value} */
    private static final String CHARSET = "GBK";
    /** 状态码 {@value} */
    private static final int HTTP_CODE = 200;
    /** http请求方式 {@value} */
    private static final String HTTP_METHOD = "POST";


    private static final CloseableHttpClient httpClient;

    static {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }
    /**
     * 发送腾讯通消息 单人
     *
     * @param title 标题
     * @param msg 消息内容
     * @param  receiver 接受消息人
     * @param  delaytime 消息提醒框的停留时间（毫秒），0表示不自动消失。
     * @return
     * */
    public static void sendRtxNotify(String title,String msg,String receiver,String delaytime){
        try {
            HttpRequestBase http = null;
            String url = "http://10.172.30.120:8012/sendnotify.cgi";
            StringBuffer params = new StringBuffer("");
            if (receiver != null) {
                params.append("receiver=" + URLEncoder.encode(receiver, CHARSET));
            }
            if (msg != null) {
                params.append("&msg=" +URLEncoder.encode(msg,CHARSET));
            }
            if (title != null) {
                params.append("&title=" +URLEncoder.encode(title,CHARSET) );
            }
            if(delaytime != null){
                params.append("&delaytime=" +URLEncoder.encode(delaytime,CHARSET) );
            }
            http = new HttpGet(url+"?" + params.toString());
            String result = exeUrl(http,CHARSET);
            System.out.println(result);
        }catch (Exception e){
            System.out.println(e);
        }
    }


    /**
     * 发送腾讯通消息 多人
     *
     * @param title 标题
     * @param msg 消息内容
     * @param  receivers 接受消息人
     * @param  delaytime 消息提醒框的停留时间（毫秒），0表示不自动消失。
     * @param type 请求方式
     * @return
     * */
    public static String sendRtxNotifyBatch(String title, String msg, String[] receivers,String delaytime,String type) {

        String receiver = "";

        for (int i = 0; i < receivers.length; ++i) {
            if (receiver.equals("")) {
                receiver = receivers[i];
            } else {
                receiver +=","+receivers[i];
            }
        }

        try {
            //如果内容不为空时，拼接内容
            String url = "http://10.172.30.120:8012/sendnotify.cgi";
            HttpRequestBase http = null;
            if(HTTP_METHOD.equals(type)){
                http = new HttpPost(url);
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                nvps.add(new BasicNameValuePair("msg", URLEncoder.encode(msg==null?"":msg,CHARSET)));
                nvps.add(new BasicNameValuePair("title", URLEncoder.encode(title==null?"":title,CHARSET)));
                nvps.add(new BasicNameValuePair("receiver", URLEncoder.encode(receiver,CHARSET)));
                nvps.add(new BasicNameValuePair("delaytime", URLEncoder.encode(delaytime==null?"9000":delaytime,CHARSET)));

                ((HttpPost)http).setEntity(new UrlEncodedFormEntity(nvps));
            }else{
                StringBuffer params = new StringBuffer("");
                //拼接接收人
                params.append("receiver=" + URLEncoder.encode(receiver,CHARSET));

                if (StringUtils.isNotBlank(msg)) {
                    params.append("&msg=" +URLEncoder.encode(msg,CHARSET));
                }
                //如果内容不为空时，拼接标题
                if (StringUtils.isNotBlank(title)) {
                    params.append("&title=" +URLEncoder.encode(title,CHARSET) );
                }
                if (StringUtils.isNotBlank(delaytime)) {
                    params.append("&delaytime=" +URLEncoder.encode(delaytime,CHARSET) );
                }
                http = new HttpGet(url+"?" +params.toString());
            }
            String result = exeUrl(http,CHARSET);
            return result;

        } catch (Exception e) {
            System.out.println("------------------------出错了。-----------------------------");
            e.printStackTrace();
        }

        return null;
    }

    public static String exeUrl(HttpRequestBase httpGet, String r) throws IOException {
        CloseableHttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HTTP_CODE) {
            httpGet.abort();
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        if (entity != null) {
            result = EntityUtils.toString(entity, r);
        }
        EntityUtils.consume(entity);
        response.close();
        return result;
    }

    public static void main(String[] args) {
        //单人发送
        sendRtxNotify("测试","您有未办理的流程","安全管理业务信息化","9000");
        //多人发送
        sendRtxNotifyBatch("测试","您有未办理的流程",new String[]{"安全管理业务信息化","基层标准化管理平台"},"9000","GET");
    }
}
