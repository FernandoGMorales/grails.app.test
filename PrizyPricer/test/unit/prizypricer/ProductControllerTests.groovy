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
		def p = new Product(barcode:'1001', name:'onion rings', description:'food').save()
        p.addToPrices(new Price(price: '3', store:'the store', notes:'some notes', date:new Date()))
        p.addToPrices(new Price(price: '2', store:'the store', notes:'some notes', date:new Date()))
        p.addToPrices(new Price(price: '4', store:'the store', notes:'some notes', date:new Date()))
		p.save()
		params.barcode = '1001'
		def model = controller.show()
		assertEquals '1001', model.barcode
		assertEquals 'onion rings', model.name
		assertEquals 'food', model.description
		assertEquals 3, model.avgPrice, 0.001
		assertEquals 4, model.highestPrice, 0.001
		assertEquals 2, model.lowestPrice, 0.001
		assertEquals 2.4, model.idealPrice, 0.001
		assertEquals 3, model.priceCount
    }
    
    void testShowProductNotFound() {
		def product = new Product(barcode:'1000', name:'brown rice', description:'food')
		params.barcode = '1001'
		def model = controller.show()
		assert response.redirectedUrl == '/product/list'
    }
}
