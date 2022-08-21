package com.polymer.db.base;

/*
基本的常量定义
 */
public interface IConstant {
    //统一的字符编码
    public static final String CHAR_SET="UTF-8";
    //空值
    public static final String STR_EMPTY_VALUE ="";
    public static final int INT_DEFAULT_VALUE=0;
    //常量小写字母
    public static final String LOWER_ABC_STR="abcdefghijklmnopqrstuvwxyz";
    //常量大写字母
    public static final String UPPER_ABC_STR="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //常量符号
    public static final String SYMBOL_STR="+-*/%+!~,.|#@&()[]{}^`<>?$";
    //常量数字
    public static final String NUMBER_STR = "0123456789abcdef";
    //最小操作数
    public static final int MIN_OPERAND=1;
    //最大操作数
    public static final int MAX_OPERAND=2056;

    //---------------------通用返回结果集定义---------------------------
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    //-------------------JSON相关定义--------------------------
    public static final String JSON_OBJECT_EMPTY="{}";
    public static final String JSON_ARRAY_EMPTY="[]";
    //-----------------常见的文件格式-------------------
    public static final String[] FILE_TYPE_VIDEO={
            "MP4","MOV","WMV","FLV","AVI","AVCHD","WebM","MKV","MPEG4","M4V"
    };
    public static final String[] FILE_TYPE_IMG={
            "JPEG","PNG","GIF","SVG","PSD","TIF","TGA","BMP","DDS",
            "HDR","RAW","EXR","AFPHOTO","EPS","ICO","JFF","JIF"
    };
    public static final String[] FILE_TYPE_TEXT={
            "TXT","DOC","DOCX","XLS","XLSX","RTF","PPT","PPTX","PDF",
            "CLASS","JAVA","ZIP","JAR","RAR","HTML","EXE","SQL","JSON",
            "JS","JSP","LOG","MD","PY","PYC","TAZ","XLT"
    };

}