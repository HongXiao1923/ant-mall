package ryan.ant.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ryan.ant.mall.dao.UserDao;
import ryan.ant.mall.entity.User;
import ryan.ant.mall.util.PageQueryUtil;
import ryan.ant.mall.util.PageResult;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public PageResult getUserPage(PageQueryUtil pageUtil){
        //当前页码中的数据列表
        List<User> users = userDao.findUsers(pageUtil);
        //数据总条数，用于计算分页数据
        int total = userDao.getTotalUsers(pageUtil);
        /* Todo 分页信息封装: 当前分页的用户列表、全表记录条数、当前页显示条数、当前页码，后台自动计算总页数 */
        PageResult pageResult = new PageResult(users, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }
}
