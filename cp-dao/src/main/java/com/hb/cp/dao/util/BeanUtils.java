package com.hb.cp.dao.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ========== bean工具类 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.util.BeanUtils.java, v1.0
 * @date 2019年10月12日 16时46分
 */
public class BeanUtils {

    /**
     * 将对象装换为map
     *
     * @param bean bean
     * @return Map
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        if (bean == null) {
            return null;
        }
        try {
            Map<String, Object> map = new HashMap<>();
            Field[] declaredFields = bean.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(bean));
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将map装换为javabean对象
     *
     * @param map       map
     * @param beanClass beanClass
     * @return T
     */
    public static <T> T mapToBean(Map<String, Object> map, Class<T> beanClass) {
        if (map == null) {
            return null;
        }
        try {
            T obj = beanClass.newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将List<T>转换为List<Map<String, Object>>
     *
     * @param objList list集合
     * @return List
     */
    public static <T> List<Map<String, Object>> beansToMaps(List<T> objList) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (objList != null && objList.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0, size = objList.size(); i < size; i++) {
                bean = objList.get(i);
                map = beanToMap(bean);
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 将List<Map<String,Object>>转换为List<T>
     *
     * @param maps  map集合list
     * @param clazz bean
     * @return List<T>
     */
    public static <T> List<T> mapsToBeans(List<Map<String, Object>> maps, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        if (maps != null && maps.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0, size = maps.size(); i < size; i++) {
                map = maps.get(i);
                bean = mapToBean(map, clazz);
                list.add(bean);
            }
        }
        return list;
    }

}
