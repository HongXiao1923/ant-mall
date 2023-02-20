package ryan.ant.mall.service.impl;

import cn.hutool.crypto.SecureUtil;
import org.springframework.stereotype.Service;
import ryan.ant.mall.dao.AdminUserMapper;
import ryan.ant.mall.entity.AdminUser;
import ryan.ant.mall.service.AdminUserService;

import javax.annotation.Resource;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser login(String userName, String password) {
        String passwordMD5 = SecureUtil.md5(password);
        return adminUserMapper.login(userName, passwordMD5);
    }
}
