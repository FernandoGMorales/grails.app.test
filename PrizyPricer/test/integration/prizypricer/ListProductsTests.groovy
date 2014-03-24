package prizypricer

import static org.junit.Assert.*
import org.junit.*

class ListProductsTests {
	def productService
	
    @Before
    void setUp() {
        new Product(barcode:'1000', name:'onion rings', description:'food').save()
        new Product(barcode:'1001', name:'brown rice', description:'food').save()
        new Product(barcode:'1002', name:'lentils', description:'food').save()
    }

    @After
    void tearDown() {
    
    }

    @Test
    void testListProducts() {
        def pc = new ProductController()
        def testParams = [max:ProductController.MAX_RESULTS, sort:'barcode', order:'asc']
		pc.productService = productService
		pc.params.putAll(testParams)
		def model = pc.list()
		assertEquals Product.count(), model.productList.size()
		def list = Product.list(testParams)
		def i = 0
		for(product in model.productList) {
			assertEquals list.get(i).barcode, product.barcode
			assertEquals list.get(i).name, product.name
			assertEquals list.get(i++).description, product.description
		}
    }
}
