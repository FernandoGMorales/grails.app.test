package prizypricer

import static org.junit.Assert.*
import org.junit.*

class AddPriceTests {
	def productService

    @Before
    void setUp() {
        def p = new Product(barcode:'1001', name:'onion rings', description:'food').save()
    }

    @After
    void tearDown() {
    }

    @Test
    void testAddPrice() {
        def pc = new PriceController()
		pc.params.barcode = '1001'
		pc.productService = productService
		def m1 = pc.create()
		pc.params.productID = m1.productID
		pc.params.price = 3f
		pc.params.store = 'the store'
		pc.params.notes = 'some notes'
		def model = pc.save()
		def prices = Product.findByBarcode('1001').prices.asList()
		assertEquals 3, prices.get(0).price, 0.001
    }
}
