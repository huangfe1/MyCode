package zmz.zwq.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import zmz.hf.util.HibernateUtil;

/**
 * 查询类
 * @author zwq
 *
 */
public class Select {
	/**
	 * 查询类
	 * 
	 * @param sql
	 *            查询语句
	 * @return 返回一个list
	 * @throws Exception
	 */
	public List<?> select(String hql) throws Exception {
		List<?> list = null;
		Session session = null;
		Transaction trans = null;
		Query query = null;
		try {
			session = HibernateUtil.getSession();
			trans = session.beginTransaction();
//			System.out.println(hql);
			query = session.createQuery(hql);
			list = query.list();
			trans.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception("查找类中发生错误");
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	/**
	 * 获取表中记录的总数
	 * 
	 * @param sql
	 *            查询语句
	 * @return 记录总数
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Long getTotal(String hql) throws Exception {
		Long total;
		List<Long> list = (List<Long>) select(hql);
		if (list.size() > 0) {
			total = list.get(0);
		} else {
			total = (long) 0;
		}
		return total;
	}

	/**
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<?> selectSort(String hql,int start,int end) throws Exception {
		List<?> list = null;
		Session session = null;
		Transaction trans = null;
		Query query = null;
		try {
			session = HibernateUtil.getSession();
			trans = session.beginTransaction();
//			System.out.println(hql);
			query = session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(end);
			list = query.list();
			trans.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception("查找类中发生错误");
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}
}
