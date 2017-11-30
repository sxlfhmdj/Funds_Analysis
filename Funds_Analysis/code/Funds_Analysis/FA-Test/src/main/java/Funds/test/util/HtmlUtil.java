package Funds.test.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Description: [Html工具类]</p>
 * Copyright (c) 2017 北京柯莱特科技有限公司
 * Created on: 2017/11/30
 *
 * @author <a href="mailto: dengjiang@camelotchina.com">邓江</a>
 * @version 1.0
 */
public class HtmlUtil {


    /**
     * <p>Discription: [去掉HTML标签与HTML注释] </p>
     * Created on: 2017/11/30 17:45
     *
     * @param
     * @return
     * @author [邓江]
     */
    public static String rmHTMLTag(String htmlStr) {
        String regEx_space ="&nbsp;";
        String regEx_commons = "<!--.*?-->"; //定义html_commons的正则表达式
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_commons = Pattern.compile(regEx_commons, Pattern.CASE_INSENSITIVE);
        Matcher m_commons = p_commons.matcher(htmlStr);
        htmlStr = m_commons.replaceAll(""); //过滤html_commons标签

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); //过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); //过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); //过滤html标签

        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); //过滤html_commons标签

        return htmlStr.trim(); //返回文本字符串
    }


}
