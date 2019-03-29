/**
 *
 */
package online.xiaojiben.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import online.xiaojiben.mapper.SpringbootuserMapper;
import online.xiaojiben.mapper.SpringbootuserMapperCustom;
import online.xiaojiben.pojo.Springbootuser;
import online.xiaojiben.service.UserService;
import online.xiaojiben.utils.Encrypt;

/**
 * @author: XiaoLi
 * @Create_time: 2019年3月24日 下午2:12:11
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private SpringbootuserMapper userMapper;
	
	@Autowired
	private SpringbootuserMapperCustom userMapperCustom;
	
	/* (non-Javadoc)
	 * @see com.example.service.UserService#saveUser(com.example.pojo.Springbootuser)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveUser(Springbootuser user) throws Exception {
		// TODO Auto-generated method stub
		user.setPwd(Encrypt.getStrMD5(user.getPwd()));
		userMapper.insert(user);
	}

	/* (non-Javadoc)
	 * @see com.example.service.UserService#selectUser(java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public String selectUser(Springbootuser user) throws Exception {
		// TODO Auto-generated method stub
		Springbootuser userExist = userMapper.selectByPrimaryKey(user.getUsername());
		if (userExist != null) {
			return "用户已存在！";
		} else {
			this.saveUser(user);
			return "注册成功！";
		}
	}

	/* (non-Javadoc)
	 * @see com.example.service.UserService#selectUserExist(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public String selectUserExist(String username, String pwd) {
		// TODO Auto-generated method stub
		String userString = userMapperCustom.queryByIdAndName(username, Encrypt.getStrMD5(pwd));
		if (userString != null) {
			return userString;
		}
		
		return "用户名或密码错误！";
	}

}
