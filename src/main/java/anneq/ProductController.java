package anneq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class ProductController {

    @Autowired
    private ProductClient productClient;

    /**
     * Find a product by primary key
     *
     * @param id    The id of the product that we want
     * @return      The found product
     */
    @RequestMapping(path = "/products/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") final String id) {
        return new ResponseEntity<Product>(new Product(id), HttpStatus.OK);
    }

    /**
     * This service returns the special offer-of-the-day
     * @return      The product
     */
    @RequestMapping(path = "/dailyoffer")
    public ResponseEntity<Product> getDailyOffer() {
        return new ResponseEntity<Product>(productClient.getById("1"), HttpStatus.OK);
    }

}
