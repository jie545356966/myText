package com.fujie.uitls;


import java.io.ByteArrayInputStream;  
import java.io.UnsupportedEncodingException;  
import java.sql.Blob;  
import java.sql.CallableStatement;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
import org.apache.ibatis.type.BaseTypeHandler;  
import org.apache.ibatis.type.JdbcType;  
  
/**
 *  
 * <p>ClassName: MyBlobTypeHandler </P>
 * <p>Description: 处理blob字段的乱码问题</P>
 * <p>Company:湖南省运联物流产业园有限公司 </P>
 * <p>Copyright (c) 2016, wwwzengqi@126.com All Rights Reserved.</P>   
 * 
 * @author zengqi 
 * @version  
 * @date: 2016年5月26日 下午4:42:06 
 * @since JDK 1.7
 */
public class MyBlobTypeHandler extends BaseTypeHandler<String> {    
    //###指定字符集    
    private static final String DEFAULT_CHARSET = "utf-8";    
	//private static final String DEFAULT_CHARSET = "gbk"; 
	
    @Override    
    public void setNonNullParameter(PreparedStatement ps, int i,    
            String parameter, JdbcType jdbcType) throws SQLException {    
        ByteArrayInputStream bis;    
        try {    
            //###把String转化成byte流    
            bis = new ByteArrayInputStream(parameter.getBytes(DEFAULT_CHARSET));    
        } catch (UnsupportedEncodingException e) {    
            throw new RuntimeException("Blob Encoding Error!");    
        }       
        ps.setBinaryStream(i, bis, parameter.length());    
    }    
    
    @Override    
    public String getNullableResult(ResultSet rs, String columnName)    
            throws SQLException {    
        Blob blob = rs.getBlob(columnName);    
        byte[] returnValue = null;    
        if (null != blob) {    
            returnValue = blob.getBytes(1, (int) blob.length());    
        }    
        try {    
            //###把byte转化成string    
        	if(null==returnValue){
        		return "";
        	}
            return new String(returnValue, DEFAULT_CHARSET);    
        } catch (UnsupportedEncodingException e) {    
            throw new RuntimeException("Blob Encoding Error!");    
        }    
    }    
    
    @Override    
    public String getNullableResult(CallableStatement cs, int columnIndex)    
            throws SQLException {    
        Blob blob = cs.getBlob(columnIndex);    
        byte[] returnValue = null;    
        if (null != blob) {    
            returnValue = blob.getBytes(1, (int) blob.length());    
        }    
        try {
        	if(null==returnValue){
        		return "";
        	}
            return new String(returnValue, DEFAULT_CHARSET);    
        } catch (UnsupportedEncodingException e) {    
            throw new RuntimeException("Blob Encoding Error!");    
        }    
    }  
  
    public String getNullableResult(ResultSet arg0, int arg1)  
            throws SQLException {  
  
        return null;  
    }    
    
    public static void main(String[] args) throws UnsupportedEncodingException {
    	byte[] byteStr = new byte[]{123, 34, 106, 111, 98, 78, 97, 109, 101, 34, 58, 34, -48, -24, -57, -13, -73, -42, -50, -10, -54, -90, 34, 44, 34, 100, 101, 112, 116, 78, 97, 109, 101, 34, 58, 34, -48, -59, -49, -94, -42, -48, -48, -60, 34, 44, 34, 101, 109, 112, 95, 99, 111, 100, 101, 34, 58, 34, 49, 53, 48, 57, 49, 53, 48, 50, 34, 44, 34, 97, 112, 112, 114, 111, 118, 101, 95, 115, 116, 97, 116, 117, 115, 34, 58, 34, 34, 44, 34, 99, 111, 109, 112, 97, 110, 121, 78, 97, 109, 101, 34, 58, 34, -70, -2, -60, -49, -54, -95, -44, -53, -63, -86, -50, -17, -63, -9, -78, -6, -46, -75, -44, -80, -45, -48, -49, -34, -71, -85, -53, -66, 34, 44, 34, 97, 112, 112, 114, 111, 118, 101, 95, 111, 112, 105, 110, 105, 111, 110, 34, 58, 34, 34, 44, 34, 114, 101, 109, 97, 114, 107, 34, 58, 34, 49, 50, 34, 44, 34, 99, 114, 101, 97, 116, 101, 85, 115, 101, 114, 78, 97, 109, 101, 34, 58, 34, -49, -75, -51, -77, -71, -36, -64, -19, -44, -79, 34, 44, 34, 99, 114, 101, 100, 105, 116, 95, 99, 97, 114, 100, 95, 116, 121, 112, 101, 34, 58, 34, -49, -62, -80, -32, 34, 44, 34, 99, 114, 101, 97, 116, 101, 84, 105, 109, 101, 34, 58, 34, 50, 48, 49, 54, 48, 52, 50, 48, 34, 44, 34, 100, 97, 116, 97, 76, 105, 115, 116, 34, 58, 34, 56, 54, 56, 51, 102, 54, 57, 51, 45, 48, 102, 101, 56, 45, 52, 51, 51, 101, 45, 98, 54, 100, 55, 45, 100, 101, 48, 102, 53, 55, 50, 55, 55, 102, 49, 99, 34, 44, 34, 110, 97, 109, 101, 34, 58, 34, -42, -20, -26, -61, 34, 44, 34, 97, 112, 112, 108, 105, 99, 97, 116, 105, 111, 110, 95, 100, 97, 116, 101, 34, 58, 34, 50, 48, 49, 54, 45, 48, 52, 45, 50, 52, 34, 44, 34, 116, 97, 115, 107, 78, 97, 109, 101, 34, 58, 34, -78, -71, -53, -94, -65, -88, 34, 44, 34, 98, 117, 115, 105, 110, 101, 115, 115, 95, 105, 100, 34, 58, 34, 34, 44, 34, 110, 111, 116, 95, 99, 104, 97, 114, 103, 101, 95, 114, 101, 97, 115, 111, 110, 34, 58, 34, -51, -4, -76, -14, -65, -88, 34, 44, 34, 99, 114, 101, 100, 105, 116, 95, 99, 97, 114, 100, 95, 100, 97, 116, 101, 34, 58, 34, 50, 48, 49, 54, 45, 48, 52, 45, 50, 49, 34, 44, 34, 114, 101, 102, 101, 114, 101, 110, 99, 101, 115, 95, 112, 101, 114, 115, 111, 110, 34, 58, 34, -63, -11, -56, -15, 49, 34, 125};
    	String str = new String(byteStr, "gbk");
    	System.out.println(str);
	}
}   
