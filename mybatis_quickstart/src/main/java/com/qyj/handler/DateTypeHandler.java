package com.qyj.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

public class DateTypeHandler extends BaseTypeHandler<Date> {

    //将java类型转换成数据库需要的类型
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        ps.setLong(i,time);
    }

    //将数据库中类型转换为java类型
    //columnName数据库表中要转换的字段名称
    //rs查询结果集
    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        //将结果集中的数据转换成Date类型并返回
        long aLong = rs.getLong(columnName);
        Date date = new Date(aLong);
        return date;
    }

    //将数据库中类型转换为java类型
    //columnIndex字段的位置
    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        long aLong = rs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }

    //将数据库中类型转换为java类型
    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        long aLong = cs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }
}
