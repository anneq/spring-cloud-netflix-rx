package anneq;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="localhost:8089/products", decode404 = true)
public interface ProductClient {
    @RequestMapping(value="/{id}")
    Product getById(@PathVariable("id") String id);
}
