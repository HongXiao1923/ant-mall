package ryan.ant.mall.service;

import ryan.ant.mall.util.PageQueryUtil;
import ryan.ant.mall.util.PageResult;

public interface UserService {

    public PageResult getUserPage(PageQueryUtil pageUtil);
}
