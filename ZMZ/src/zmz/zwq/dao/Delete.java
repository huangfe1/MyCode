package zmz.zwq.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import zmz.hf.util.HibernateUtil;

/**
 * 删除类
 * @author zwq
 *
 */
public class Delete {
	/**
	 * 删除方法，该方法与更新方法一样，但是为了清晰代码结构，将其列出
	 * @param hql hql语句
	 * @return 返回被影响的行数
	 * @throws Exception 错误异常
	 */
	public int delete(String hql) throws Exception{
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
			throw new Exception("在删除类中发生错误");
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
		
	}
}
