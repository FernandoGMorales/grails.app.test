package prizypricer

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PriceController)
@Mock([Product,ProductService])
class PriceControllerTests {

    void testList() {
		new Product(barcode:'1000', name:'brown rice', description:'food').save()
		new Product(barcode:'1001', name:'onion rings', description:'food').save()
		def model = controller.list()
		assertNotNull model.productList
		assert !model.productList?.isEmpty()
		assertEquals model.productList?.size(), Product.count()
    }
    
    void testListFiltered() {
		new Product(barcode:'1001', name:'onion rings', description:'food').save()
		params.barcode = '1001'
		controller.listFiltered()
		assert model.productList
		assert 1, model.productCount
    }
    
    void testListFilteredFail() {
		new Product(barcode:'1000', name:'brown rice', description:'food').save()
		params.barcode = '1001'
		controller.listFiltered()
		assert response.redirectedUrl == '/price/list'
    }
    
    void testCreate() {
        def product = new Product(barcode:'1000', name:'brown rice', description:'food').save()
        params.barcode = '1000'
        def model = controller.create()
        assertNotNull model.productID
        assertNotNull model.name
		assertNotNull model.barcode
		assertNotNull model.description
    }
    
    void testCreateFail() {
		def model = controller.create()
		assert response.redirectedUrl == '/price/list'
    }
    
    void testSave() {
		def product = new Product(barcode:'1000', name:'brown rice', description:'food').save()
		params.productID = product.getId()
        params.price = 3
        params.store = 'the store'
        params.notes = 'some notes'
        def model = controller.save()
        assertNotNull Product.findByBarcode(1000).getPrices()
    }
    
}
