package org.kms;

import org.kms.client.EmployeeConsumerClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(ConsumerApplication.class, args);
		System.out.println("Employee Details \n");
		ctx.getBean(EmployeeConsumerClient.class).getAllEmp();;
	}
	@Bean
	public EmployeeConsumerClient getEmployeeConsumerClient(){
			return new EmployeeConsumerClient();
	}
}
