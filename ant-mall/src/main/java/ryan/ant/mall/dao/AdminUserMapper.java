package ryan.ant.mall.dao;

import org.apache.ibatis.annotations.Param;
import ryan.ant.mall.entity.AdminUser;

public interface AdminUserMapper {

    /* Todo 登录方法*/
    AdminUser login(@Param("user") String userName, @Param("password") String password);
}
