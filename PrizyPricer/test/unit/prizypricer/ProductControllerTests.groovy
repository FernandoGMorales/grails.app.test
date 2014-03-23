package prizypricer



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ProductController)
@Mock([Product, ProductService])
class ProductControllerTests {

    void testList() {
		new Product(barcode:'1000', name:'brown rice', description:'food').save()
		new Product(barcode:'1001', name:'onion rings', description:'food').save()
		def model = controller.list()
		assertNotNull model.productList
		assert !model.productList?.isEmpty()
		assertEquals model.productList?.size(), Product.count()
    }
    
    void testShow() {
		def product = new Product(barcode:'1000', name:'brown rice', description:'food')
		product.addToPrices(new Price())
		product.addToPrices(new Price())
		product.addToPrices(new Price())
		product.save()
		params.barcode = 1000
		def model = controller.show()
		assertNotNull model.name
		assertNotNull model.barcode
		assertNotNull model.description
		assertNotNull model.avgPrice	
		assertNotNull model.highestPrice	
		assertNotNull model.lowestPrice
		assertNotNull model.idealPrice
		assertNotNull model.priceCount
    }
    
    void testShowProductNotFound() {
		def product = new Product(barcode:'1000', name:'brown rice', description:'food')
		params.barcode = 1001
		def model = controller.show()
		assert response.redirectedUrl == '/product/list'
    }
}
