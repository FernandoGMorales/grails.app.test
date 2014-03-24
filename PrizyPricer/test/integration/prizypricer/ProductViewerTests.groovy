package prizypricer

import static org.junit.Assert.*
import org.junit.*

class ProductViewerTests {
	def productService

    @Before
    void setUp() {
        def p = new Product(barcode:'1001', name:'onion rings', description:'food').save()
        p.addToPrices(new Price(price: '3', store:'the store', notes:'some notes', date:new Date()))
        p.addToPrices(new Price(price: '2', store:'the store', notes:'some notes', date:new Date()))
        p.addToPrices(new Price(price: '4', store:'the store', notes:'some notes', date:new Date()))
    }

    @After
    void tearDown() {
        
    }

    @Test
    void testShow() {
		def pc = new ProductController()
		pc.params.barcode = '1001'
		pc.productService = productService
		def model = pc.show()
		assertEquals '1001', model.barcode
		assertEquals 'onion rings', model.name
		assertEquals 'food', model.description
		assertEquals 3, model.avgPrice, 0.001
		assertEquals 4, model.highestPrice, 0.001
		assertEquals 2, model.lowestPrice, 0.001
		assertEquals 2.4, model.idealPrice, 0.001
		assertEquals 3, model.priceCount       
    }
    
}
