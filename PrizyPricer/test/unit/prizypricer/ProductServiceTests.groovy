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
    
    void testGetProductByID() {
		def product = new Product(barcode:'1000', name:'brown rice', description:'food').save()
		def ps = service.getProductByID(product.id)
		assert ps
		assertEquals ps.id, product.id
	}

	void testGetProductCount() {
		new Product(barcode:'1000', name:'brown rice', description:'food').save()
		new Product(barcode:'1001', name:'sugar', description:'food').save()
		new Product(barcode:'1002', name:'apples', description:'food').save()
		assertEquals 3, service.getProductCount()
	}
	
	void testGetAllProducts() {
		new Product(barcode:'1000', name:'brown rice', description:'food').save()
		new Product(barcode:'1001', name:'sugar', description:'food').save()
		new Product(barcode:'1002', name:'apples', description:'food').save()
		def props = [max:ProductController.MAX_RESULTS, sort:'barcode', order:'asc']
		assertEquals 3, service.getAllProducts(props).size()
	}
	
	void testFindByBarcode() {
		def product = new Product(barcode:'1000', name:'brown rice', description:'food').save()
		assertEquals product, service.findByBarcode('1000') 
	}
	
	void testSaveProduct() {
		def product = new Product(barcode:'1000', name:'brown rice', description:'food').save()
		assertEquals product, service.saveProduct(product) 
	}
    
}
