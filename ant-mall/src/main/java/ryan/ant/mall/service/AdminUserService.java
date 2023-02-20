package ryan.ant.mall.service;

import ryan.ant.mall.entity.AdminUser;

public interface AdminUserService {

    AdminUser login(String name, String password);
}
