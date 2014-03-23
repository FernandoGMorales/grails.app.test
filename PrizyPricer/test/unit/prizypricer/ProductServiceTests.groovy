package prizypricer



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ProductService)
@Mock(Product)
class ProductServiceTests {

    void testGetPrices() {
		def product = new Product(barcode:'1000', name:'brown rice', description:'food').save()
		product.addToPrices(new Price())
		product.addToPrices(new Price())
        assertNotNull service.getPrices(product)
        assert !service.getPrices(product).isEmpty()
    }
}
