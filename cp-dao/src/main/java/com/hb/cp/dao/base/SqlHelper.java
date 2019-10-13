package com.hb.cp.dao.base;

import com.hb.cp.model.enumutil.RecordStateEnum;

import java.util.Map;

/**
 * ========== 拼装sql辅助类 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.base.SqlHelper.java, v1.0
 * @date 2019年10月12日 14时19分
 */
public class SqlHelper {

    private static final String RECORDSTATUS = "recordStatus";

    public static String buildSelectSelectiveSql(String tableName, Map<String, Object> conditions, String sort, Integer startRow, Integer pageNum) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeSelectBase(tableName));
        if (conditions != null && !conditions.isEmpty()) {
            for (Map.Entry<String, Object> entry : conditions.entrySet()) {
                sb.append(makeSelectCondition(entry.getKey(), entry.getValue()));
            }
        }
        sb.append(makeSelectSort(sort));
        sb.append(makePages(startRow, pageNum));
        return sb.toString();
    }

    private static String makeSelectCondition(String key, Object value) {
        if (value != null) {
            return " and " + key + "=" + "#{params." + key + "}";
        }
        return "";
    }

    private static String makeSelectBase(String tableName) {
        return "select * from " + tableName + " where " + RECORDSTATUS + "=" + RecordStateEnum.VALID.getValue();
    }

    private static String makeSelectSort(String sort) {
        if (sort != null && !"".equals(sort)) {
            return " order by " + sort;
        }
        return "";
    }

    private static String makePages(Integer startRow, Integer pageNum) {
        if (startRow != null && pageNum != null) {
            return " limit #{startRow},#{pageNum} ";
        }
        return "";
    }

    public static String buildInsertSelectiveSql(String tableName, Map<String, Object> property) {
        StringBuilder sb = new StringBuilder("insert into " + tableName);
        StringBuilder cloumSb = new StringBuilder(" (");
        StringBuilder propertySb = new StringBuilder(" values (");
        for (Map.Entry<String, Object> entry : property.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                continue;
            }
            cloumSb.append(key).append(",");
            propertySb.append("#{params." + key + "}").append(",");
        }
        String cloumnSql = cloumSb.toString().substring(0, cloumSb.toString().length() - 1) + ")";
        String propertySql = propertySb.toString().substring(0, propertySb.toString().length() - 1) + ")";
        sb.append(cloumnSql).append(propertySql);
        return sb.toString();
    }

    public static String buildUpdateSelectiveSql(String tableName, Map<String, Object> property, Map<String, Object> conditions) {
        StringBuilder sb = new StringBuilder("update " + tableName + " set ");
        StringBuilder cloumSb = new StringBuilder();
        for (Map.Entry<String, Object> entry : property.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                continue;
            }
            cloumSb.append(key).append("=").append("#{cloumns.").append(key).append("}").append(",");
        }
        StringBuilder whereSb = new StringBuilder(" where 1=1");
        for (Map.Entry<String, Object> entry : conditions.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                continue;
            }
            whereSb.append(" and ").append(key).append("=").append("#{params.").append(key).append("}");
        }
        String cloumnSql = cloumSb.toString().substring(0, cloumSb.toString().length() - 1);
        sb.append(cloumnSql).append(whereSb.toString());
        return sb.toString();
    }

    public static String buildDeleteSelectiveSql(String tableName, Map<String, Object> conditions) {
        StringBuilder sb = new StringBuilder("update " + tableName + " set " + RECORDSTATUS + "=" + RecordStateEnum.INVALID.getValue());
        StringBuilder whereSb = new StringBuilder(" where 1=1");
        for (Map.Entry<String, Object> entry : conditions.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                continue;
            }
            whereSb.append(" and ").append(key).append("=").append("#{params.").append(key).append("}");
        }
        sb.append(whereSb.toString());
        return sb.toString();
    }

    public static String buildSelectCountSelectiveSql(String tableName, Map<String, Object> conditions) {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(*) from " + tableName + " where " + RECORDSTATUS + "=" + RecordStateEnum.VALID.getValue());
        if (conditions != null && !conditions.isEmpty()) {
            for (Map.Entry<String, Object> entry : conditions.entrySet()) {
                sb.append(makeSelectCondition(entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }

}
