package com.eric.itracer.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.eric.itracer.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class GenericHibernateDao<T extends Serializable, PK extends Serializable>
		implements GenericDao<T, PK> {

	private Class<T> entityClass;
	protected Session session;
	protected Transaction tx;

	protected void startOperation() {
		session = HibernateUtil.getSession();
		tx = session.beginTransaction();
	}

	protected void endOperation() {
		tx.commit();
		session.flush();
		session.clear();
		session.close();
	}

	protected void rollback() {
		tx.rollback();
	}

	private void handleException(HibernateException e) {
		// TODO loging the log file
		e.printStackTrace();
	}

	@SuppressWarnings({ "rawtypes" })
	public GenericHibernateDao() {
		entityClass = null;
		Class c = getClass();
		Type t = c.getGenericSuperclass();
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			entityClass = (Class<T>) p[0];
		}
	}

	@Override
	public T get(PK id) {
		startOperation();
		T entity = (T) session.get(entityClass, id);
		endOperation();
		return entity;
	}

	@Override
	public T getWithLock(PK id, LockMode lock) {
		startOperation();
		T entity = (T) session.get(entityClass, lock);
		endOperation();
		return entity;
	}

	@Override
	public List<T> loadAll() {
		startOperation();
		Query query = session.createQuery("from " + entityClass.getName());
		List<T> list = (List<T>) query.list();
		return list;
	}

	@Override
	public void save(T entity) {
		try {
			startOperation();
			session.save(entity);
		} catch (HibernateException e) {
			handleException(e);
			rollback();
		} finally {
			endOperation();
		}
	}

	@Override
	public void saveOrUpdate(T entity) {
		try {
			startOperation();
			session.saveOrUpdate(entity);
		} catch (HibernateException e) {
			handleException(e);
			rollback();
		} finally {
			endOperation();
		}
	}

}
