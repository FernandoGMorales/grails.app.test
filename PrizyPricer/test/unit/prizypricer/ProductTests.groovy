package prizypricer



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Product)
class ProductTests {

    void testConstraints() {
		def product = new Product(name:'Rice', description:'food', barcode:'1000')
        mockForConstraintsTests(Product, [product])
        assert product.validate()
    }
    
    void testConstraintsViolation() {
		def product = new Product(description:'food', barcode:'1000')
        mockForConstraintsTests(Product, [product])
        assert !product.validate()
    }
        
}
