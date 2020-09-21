package com.gaolei.app.util.htools;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

import java.util.ArrayList;

/**
 * @Author DuebassLei
 * @Date 2020/9/18 18:09
 * @Version 1.0
 * @Description 邮件相关工具类
 */

public class MailServiceUtil {

    public static void main(String[] args) {
        /**
         * 1、发送普通文本邮件，最后一个参数可选是否添加多个附件：
         * */
        MailUtil.send("hutool@foxmail.com", "测试", "邮件来自Cloud-app测试", false);

        /**
         * 2、发送HTML格式的邮件并附带附件，最后一个参数可选是否添加多个附件：
         * */
        MailUtil.send("hutool@foxmail.com", "测试", "<h1>邮件来自Cloud-app测试</h1>", true, FileUtil.file("d:/aaa.xml"));

        /**
         *3、群发邮件，可选HTML或普通文本，可选多个附件：
         * */
        ArrayList<String> tos = CollUtil.newArrayList(
                "person1@bbb.com",
                "person2@bbb.com",
                "person3@bbb.com",
                "person4@bbb.com");

        MailUtil.send(tos, "测试", "邮件来自Cloud-app测试", false);
    }
}
