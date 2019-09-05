package com.hb.cp.dao.base;

import com.hb.cp.model.base.IBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * ========== 定义每个泛型repository都需要实现的基本操作，spring data JPA实现 ==========
 *
 * @author Mr.huang
 * @version com.hb.cp.dao.base.IBaseJpaRepository.java, v1.0
 * @date 2019年09月05日 10时49分
 */
@NoRepositoryBean
public interface IBaseJpaRepository<T extends IBaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {
}
