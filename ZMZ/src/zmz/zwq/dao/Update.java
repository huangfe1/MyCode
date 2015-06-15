package zmz.zwq.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import zmz.hf.util.HibernateUtil;

/**
 * 更新类
 * @author zwq
 *
 */
public class Update {
	/**
	 * 更新操作
	 * @param hql hql语句
	 * @return 返回影响的行数
	 * @throws Exception
	 */
	public int update(String hql) throws Exception{
		int result = 0 ;
		Session session = null;
		Transaction trans = null;
		Query query = null;
		try {
			session = HibernateUtil.getSession();
			trans = session.beginTransaction();
			query = session.createQuery(hql);
			result = query.executeUpdate();
			trans.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception("在更新类中发生错误");
		} finally {
			if (session != null) {
				session.close();
			}
		}
//		System.out.println("更新完成");
		return result;
	}
}
