import com.dao.iUserDao;
import com.utils.SqlSessionFactoryUtil;
import com.xiaoxu.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {

        // deleteUser();
        findAll();
        findAll();

    }


    public static List<User> findAll() {
        SqlSession sqlsession = SqlSessionFactoryUtil.getSqlSession();
        iUserDao dao = sqlsession.getMapper(iUserDao.class);
        List<User> list = dao.findAll();
        sqlsession.close();
        return list;
    }

    public static User findByid(int id) {
        SqlSession sqlsession = SqlSessionFactoryUtil.getSqlSession();
        iUserDao dao = sqlsession.getMapper(iUserDao.class);
        User user = dao.findByid(id);
        System.out.println(user);
        sqlsession.close();
        return user;
    }

    public static void updateUser() {
        SqlSession sqlsession = SqlSessionFactoryUtil.getSqlSession();
        iUserDao dao = sqlsession.getMapper(iUserDao.class);
        User user = dao.findByid(2);
        user.setUsername("ddddd");
        dao.updateUser(user);
        System.out.println(dao.findByid(1));
        sqlsession.close();
    }

    public static void deleteUser() {
        SqlSession sqlsession = SqlSessionFactoryUtil.getSqlSession();
        iUserDao dao = sqlsession.getMapper(iUserDao.class);
//        List<User> list=findAll();
//       for(int i=0;i<list.size();i++){
//           System.out.println(list.get(i).getId());
//           dao.deleteUser(list.get(i).getId());
//       }
        dao.deleteUser(2);

        sqlsession.close();
    }
}



