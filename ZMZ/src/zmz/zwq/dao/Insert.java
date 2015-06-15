package zmz.zwq.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import zmz.hf.util.HibernateUtil;

/**
 * 插入类
 * @author zwq
 *
 */
public class Insert {
	/**
	 * 插入方法，通过Hibernate里面的save方法进行插入(HQL里面没有insert语句 只能面向对象)
	 * 
	 * @param obj
	 *            实例化对象
	 * @return 返回一个boolean值 判断是否插入成功
	 */
	public boolean insert(Object obj) throws Exception {
		boolean flag = true;
		Session session = null;
		Transaction trans = null;
		try {
			session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			if (session.save(obj) == null) {
				flag = false;
			} else {
				trans.commit();
			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
			throw new Exception("在插入类中发生错误");
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return flag;
	}
}
