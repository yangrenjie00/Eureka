package cn.tedu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //声明一个EurekaServer
public class RunAppEureka {

	public static void main(String[] args) {
	SpringApplication.run(RunAppEureka.class, args);

	}

}
