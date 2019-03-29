/**
 *
 */
package online.xiaojiben.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import online.xiaojiben.service.impl.UserServiceImpl;

/**
 * @author: XiaoLi
 * @Create_time: 2019年3月25日 下午12:45:36
 */
@Controller
public class LoginController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("/login")
	public String login() {
		return "thymeleaf/login";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(String username, String pwd, Model model, HttpSession session) {
		String msg = userServiceImpl.selectUserExist(username, pwd);
		if(msg.equals("用户名或密码错误！")) {
			model.addAttribute("msg", msg);
			return "redirect:login";
		} else {
			session.setAttribute("user", msg);
			return "redirect:main";
		}
	}
}
