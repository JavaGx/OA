package cn.gx.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.gx.oa.base.BaseDaoImpl;
import cn.gx.oa.domain.User;
import cn.gx.oa.service.UserService;
import cn.gx.oa.util.MD5Utils;

@Service
@Transactional
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService {
	
	public User findUserByLoginNameAndPwd(String loginName, String password) {
		if(loginName==null||loginName.trim().equals("")||password==null||password.trim().equals("")){
			return null;
		}else{
			password=MD5Utils.digest(password);
			User user=(User)getSession().createQuery("from User u where u.LoginName=? and u.password=?")
			.setParameter(0,loginName)
			.setParameter(1, password).uniqueResult();
			return user;			
		}
	}

	
}
