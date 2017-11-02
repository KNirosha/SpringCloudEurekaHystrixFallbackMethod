package org.kms.client;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
public class EmployeeConsumerClient {
	
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	public void getAllEmp(){
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<String> entity=null;
		String serviceURI="/api/getAllEmployes";
		try {
			ServiceInstance serviceInstance=loadBalancer.choose("employee-producer");
			String baseUrl=serviceInstance.getUri().toString();
			serviceURI=baseUrl+serviceURI;
			entity=restTemplate.exchange(serviceURI,
					HttpMethod.GET, getHeaders(),String.class);
			System.out.println(entity.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	
	
}
