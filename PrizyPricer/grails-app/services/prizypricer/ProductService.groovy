package prizypricer

class ProductService {

    List getPrices(Product product) {
		def list = new ArrayList();
		for(price in product.prices) {
			list.add(price.price)
		}
		return list
    }
    
    float getAveragePrice(List prices) {
		return prices.sum()/prices.size() 
    }
    
    /**
     * In order to calculate any particular "ideal price", do the folowing:
     *  a) define the closure to hold the formula for the ideal price
     *  b) from the ProductController.groovy, call getIdealPrice() method with the desired closure/formula as a second parameter
     */
	float getIdealPrice(List prices, Closure formula) {
		formula(prices)
    }
    
    def idealPriceFormula = { prices ->
		Collections.sort(prices)
		prices.remove(prices.size()-2)
		prices.remove(1)
		float averagePrice = getAveragePrice(prices) 
		float idealPrice = averagePrice + averagePrice*20/100
		return idealPrice  
    }
    
}
