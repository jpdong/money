package com.dong.money

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@SpringBootApplication
class MoneyApplication

fun main(args: Array<String>) {
	runApplication<MoneyApplication>(*args)
}

@Bean
fun createWebMvcConfigurer(@Autowired interceptors: Array<HandlerInterceptor?>?): WebMvcConfigurer {
	return object : WebMvcConfigurer {
		override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
			// 映射路径`/static/`到classpath路径:
			registry.addResourceHandler("/static/**")
				.addResourceLocations("classpath:/static/")
		}
	}
}

/*@RestController
class MessageController {
	@GetMapping("/")
	fun index(@RequestParam("name") name: String) = "Hello, $name!"

	@GetMapping("/")
	fun index(response:HttpSer) =
}*/

