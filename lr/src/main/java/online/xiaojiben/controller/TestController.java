/**
 *
 */
package online.xiaojiben.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: XiaoLi
 * @Create_time: 2019年3月27日 下午4:57:54
 */
@RestController
public class TestController {
	
	@RequestMapping("/hello")
	public String Hello() {
		return "Hello SpringBoot";
	}
}
