package net.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView helloWorld() {

		String me = "Hello World, Spring 3.0!";
		// ModelAndView： 包含了试图要实现的模型数据和逻辑视图名
		// message 为数据的名称，在视图中用来引用的名字
		// me 是对应的值
		// hello 是对应视图的名字。
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", me);
		modelAndView.setViewName("index2");
		return modelAndView;

		// 以上4个语句相当于一下一句：
		// return new ModelAndView("hello","message",me);
	}
}
