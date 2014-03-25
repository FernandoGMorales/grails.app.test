package prizypricer

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@Mock(Product)
class FormulaImplTests {
	
    void testApply() {
		def formula = new prizypricer.formula.FormulaImpl()
		def p = new Product(barcode:'1000', name:'brown rice', description:'food').save()
		p.addToPrices(new Price(price: '7', store:'the store', notes:'some notes', date:new Date()))
		p.addToPrices(new Price(price: '5', store:'the store', notes:'some notes', date:new Date()))
		p.addToPrices(new Price(price: '5.99', store:'the store', notes:'some notes', date:new Date()))
		p.addToPrices(new Price(price: '4.99', store:'the store', notes:'some notes', date:new Date()))
		p.addToPrices(new Price(price: '6', store:'the store', notes:'some notes', date:new Date()))
		def priceList = this.getPrices(p)
        assertEquals 7.19, formula.apply(priceList), 0.01
    }
    
    List getPrices(Product product) {
		def list = new ArrayList();
		for(price in product.prices) {
			list.add(price.price)
		}
		return list
    }
}
