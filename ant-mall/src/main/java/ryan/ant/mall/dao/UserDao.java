package ryan.ant.mall.dao;

import ryan.ant.mall.entity.User;

import java.util.List;

public interface UserDao {
    /* Todo 定义增、删、改、查 */
    List<User> findAllUsers();
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(Integer id);
}
