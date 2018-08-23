package customer;
/**
 * @author RammohanCHV
 * @purpose This class will act as a service consumer which will consume the product-list service.
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class CustomerConsumerController {

	/**
	 * Hard coded baseURL : http://localhost:8888/products.
	 * To avoid the hard coding the producer URL, use Discovery client
	 * and make use of the Request mapping of API which we want to access from the producer.
	 */
	@Autowired
	private DiscoveryClient client;
	
	public void getProducts() {
		
		ServiceInstance instance=this.getServiceInstance();
		
		String baseURL=instance.getUri().toString();
		
		baseURL=baseURL+"/products";
		System.out.println("PRODUCTSS :-> Initial base URL = "+baseURL);
		RestTemplate template=new RestTemplate();
		ResponseEntity<String> response=null;
		try {
			response=template.exchange(baseURL,HttpMethod.GET,getHeaders(),String.class);
		}catch(RestClientException e) {
			e.printStackTrace();
		}
		System.out.println("Products = "+response.getBody());
	}

	private HttpEntity getHeaders() {
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	public void getProduct(int id) {
		ServiceInstance instance=this.getServiceInstance();
		String baseURL=instance.getUri().toString();
		baseURL=baseURL+"/product/"+id;
		System.out.println("SINGLE PRODUCT -> base URL = "+baseURL);
		RestTemplate template=new RestTemplate();
		ResponseEntity<String> response=null;
		try {
			response=template.exchange(baseURL,HttpMethod.GET,getHeaders(),String.class);
		}catch(RestClientException e) {
			e.printStackTrace();
		}
		System.out.println("\n\nProduct with id = "+id+" = "+response.getBody()+"\n\n");
	}

	private ServiceInstance getServiceInstance() {
		List<ServiceInstance> instances=client.getInstances("product-list");
		System.out.println("Total instances = "+instances.size());
		instances.forEach(instance->System.out.println(instance));
		ServiceInstance instance=instances.get(0);
		System.out.println("Our insatnce = "+instance);
		return instance;
	}
}
