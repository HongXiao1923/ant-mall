package ryan.ant.mall.dao;

import org.springframework.stereotype.Component;
import ryan.ant.mall.entity.User;
import ryan.ant.mall.util.PageQueryUtil;

import java.util.List;

@Component
public interface UserMapper {
    /* Todo 定义增、删、改、查 */
    List<User> findAllUsers();
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(Integer id);

    /* Todo 返回分页数据列表 */
    List<User> findUsers(PageQueryUtil pageUtil);
    /* Todo 返回数据总数 */
    int getTotalUsers(PageQueryUtil pageUtil);
}
