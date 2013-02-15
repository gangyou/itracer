package com.eric.itracer.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.LockMode;

public interface GenericDao<T extends Serializable, PK extends Serializable> {
	// 根据主键获取实体。如果没有相应的实体，返回 null。
	public T get(PK id);

	// 根据主键获取实体并加锁。如果没有相应的实体，返回 null。
	public T getWithLock(PK id, LockMode lock);

	// 获取全部实体。
	public List<T> loadAll();

	// 存储实体到数据库
	public void save(T entity);

	// 增加或更新实体
	public void saveOrUpdate(T entity);

}
