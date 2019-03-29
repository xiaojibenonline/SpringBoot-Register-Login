/**
 *
 */
package online.xiaojiben.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: XiaoLi
 * @Create_time: 2019年3月27日 下午2:37:06
 */
@Controller
public class LogoutController {
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.removeAttribute("user");
		model.addAttribute("msg", "退出成功！");
		return "redirect:login";
	}
}
