package com.hb.cp.dao.base;

import com.hb.cp.model.base.IBaseEntity;

/**
 * ========== 操作数据库Repository祖先 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.base.IBaseRepository.java, v1.0
 * @date 2019年09月02日 21时22分
 */
public interface IBaseRepository {

    /**
     * 保存实体
     *
     * @param o 对象
     * @return Object
     */
    Object save(Object o);

}
