package Funds.test.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Description: [数字数据处理工具类]</p>
 * Copyright (c) 2017 北京柯莱特科技有限公司
 * Created on: 2017/12/1
 *
 * @author <a href="mailto: dengjiang@camelotchina.com">邓江</a>
 * @version 1.0
 */
public class MathUtil {
    public static String parseFundScale(String str) {
        String regEx_commons = "\\(.*?\\)";

        Pattern p_commons = Pattern.compile(regEx_commons, Pattern.CASE_INSENSITIVE);
        Matcher m_commons = p_commons.matcher(str);
        str = m_commons.replaceAll(""); //过滤()

        str = str.replace("元","");
        str = str.replace(",","");
        return str;
    }


}
