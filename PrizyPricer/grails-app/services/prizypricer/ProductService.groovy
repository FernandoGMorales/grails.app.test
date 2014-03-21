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
    
}
