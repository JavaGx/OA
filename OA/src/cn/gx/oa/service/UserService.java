package cn.gx.oa.service;

import cn.gx.oa.base.BaseDao;
import cn.gx.oa.domain.User;

public interface UserService extends BaseDao<User> {

	User findUserByLoginNameAndPwd(String loginName, String password);

}
