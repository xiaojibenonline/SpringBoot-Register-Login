/**
 *
 */
package online.xiaojiben.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import online.xiaojiben.pojo.Springbootuser;
import online.xiaojiben.service.impl.UserServiceImpl;

/**
 * @author: XiaoLi
 * @Create_time: 2019年3月25日 上午11:52:12
 */
@Controller
public class RegisterController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping("register")
	public String register() {
		return "thymeleaf/register";
	}
	
	@RequestMapping("/doRegister")
	public String doRegister(Springbootuser user, Model model) throws Exception {
		System.out.println("doRegisterController运行");
		String msg = userServiceImpl.selectUser(user);
		if(msg.equals("注册成功！")) {
			model.addAttribute("msg", msg);
			return "redirect:login";
		} else {
			model.addAttribute("msg", msg);
			return "redirect:register";
		}
	}
}
