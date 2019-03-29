/**
 *
 */
package online.xiaojiben.service;

import online.xiaojiben.pojo.Springbootuser;

/**
 * @author: XiaoLi
 * @Create_time: 2019年3月24日 下午2:12:55
 */
public interface UserService {

	public void saveUser(Springbootuser user) throws Exception;
	
	public String selectUser(Springbootuser user) throws Exception;
	
	public String selectUserExist(String usernameString, String pwdString);
}
