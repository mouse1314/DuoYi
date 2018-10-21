package com.duoyi.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 *   描述: 文本字符串检验与处理 工具类
 *        1. 检验文本字符串是否含有特殊字符
 *        2. 检验文本字符串是否全为数字
 *        3. 将"&""<"">""\"与空格进行转义
 * </p>
 * @author Kanarien 
 * @version 1.0
 * @date 2017年11月15日 下午9:34:41
 */
public class TextUtils {
    
    /**
     * 将文本的特殊字符进行转义
     * @param text
     * @return
     */
    public static String doTransfer(String text){
        text = text.replaceAll("\n", "");
        text = text.replaceAll("\t", "");
        text = text.replaceAll("\r", "");
        text = text.replaceAll("&", "&amp;");
        text = text.replaceAll("<", "&lt;");
        text = text.replaceAll(">", "&gt;");
        text = text.replaceAll("\"", "&quot;");
        return text;
    }
    
    /**
     * 字符串是否包含特殊字符判断(包括空格)
     * @param password
     * @return
     */
    private final static String SPECAIL_CHARACTER_REGEX = "[ `~!@#$%^&*()+=|{}':;',\"\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
    private final static Pattern p = Pattern.compile(SPECAIL_CHARACTER_REGEX);
    public static boolean hasSpecialChar(String s){
        Matcher m = p.matcher(s);
        return m.find();
    }
    
    /**
     * 判断字符串是否全为数字
     * @param str
     * @return
     */
    private final static String NUMERIC_REGEX = "[0-9]*";
    public static boolean isNumeric(String str){ 
        Pattern pattern = Pattern.compile(NUMERIC_REGEX); 
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false; 
        } 
        return true; 
     }
}
