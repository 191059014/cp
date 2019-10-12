package com.hb.cp.dao.base;

import java.util.Map;

/**
 * ========== 拼装sql辅助类 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.base.SqlHelper.java, v1.0
 * @date 2019年10月12日 14时19分
 */
public class SqlHelper {

    public static String buildSelectiveSql(String tableName, Map<String, Object> conditions) {
        StringBuilder sb = new StringBuilder("select * from " + tableName + " where 1=1 ");
        if (conditions != null && !conditions.isEmpty()) {
            for (Map.Entry<String, Object> entry : conditions.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    sb.append(" and ").append(key).append("=").append("#{params.").append(key).append("}");
                }
            }
        }
        return sb.toString();
    }

}
