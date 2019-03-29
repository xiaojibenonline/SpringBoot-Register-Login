/**
 *
 */
package online.xiaojiben.controller.interceptor;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: XiaoLi
 * @Create_time: 2019年3月25日 下午12:51:23
 */
@Controller
public class MainController {

	@RequestMapping("/main")
	public String main(String usernameString, HttpSession session, Model model) {
		if(session.getAttribute("user") == null) {
			model.addAttribute("msg", "请登录后查看");
			return "redirect:login";
		} else {
			model.addAttribute("msg", session.getAttribute("user"));
			return "thymeleaf/main";
		}
	}
}
