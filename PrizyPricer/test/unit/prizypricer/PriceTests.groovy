package prizypricer

import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Price)
@Mock(Product)
class PriceTests {

    void testConstraints() {
		def price = new Price(price:3, store:'the store', notes:'some notes', date: new Date(), product: new Product())
		mockForConstraintsTests(Price, [price])
        assert price.validate()
    }
    
    void testConstraintsViolation() {
		def price = new Price(store:'the store', notes:'some notes', date: new Date())
        mockForConstraintsTests(Price, [price])
        assert !price.validate()
    }
}
