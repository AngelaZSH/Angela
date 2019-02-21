package gz.ht.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import gz.ht.pojo.User;
/**
 * @author 	���غ�
 * @date	2019��2��15������4:23:46
 * @version �汾��ʶ
 */

public class MybatisFirst {
	
	//��ѯ
	public void find() throws IOException{
		//�����ļ�
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputstream =  Resources.getResourceAsStream(resource);
		//�����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream); 
		//ͨ�������õ�session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ͨ��session�������ݿ�selectList���ض������selectOne��������
		 List<User> list =  sqlSession.selectList("test.username","%�غ�%");
		System.out.println(list);
		sqlSession.close();
	} 
	
	//����
	@Test
	public void add() throws IOException{
		//�����ļ�
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputstream =  Resources.getResourceAsStream(resource);
		//�����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream); 
		//ͨ�������õ�session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setUsername("Anela���غ�123");
		user.setBirthday(new Date());
		user.setSex("Ů");
		user.setAddress("̨��");
		//ͨ��session�������ݿ�
		sqlSession.insert("test.user",user);
		//�ύ����
		sqlSession.commit();
		System.out.println("��ȡ��id"+user.getId());
		sqlSession.close();
	} 
	
	//ɾ��
	@Test
	public void delete() throws IOException{
		//�����ļ�
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputstream =  Resources.getResourceAsStream(resource);
		//�����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream); 
		//ͨ�������õ�session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ͨ��session�������ݿ�
		sqlSession.delete("test.userid",1);
		//�ύ����
		sqlSession.commit();
		sqlSession.close();
	}
	
	//����
	@Test
	public void update() throws IOException{
		//�����ļ�
		String resource = "SqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputstream =  Resources.getResourceAsStream(resource);
		//�����Ự����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream); 
		//ͨ�������õ�session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		user.setId(3);
		user.setUsername("�غ����");
		user.setBirthday(new Date());
		user.setSex("Ů");
		user.setAddress("̨��");
		//ͨ��session�������ݿ�
		sqlSession.update("test.update",user);
		//�ύ����
		sqlSession.commit();
		sqlSession.close();
	} 
}
