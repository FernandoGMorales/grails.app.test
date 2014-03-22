/*
 * In order to modify the calculation of the "ideal price", feel free to customize the function below as required.
 *
 */

def formula(List prices) {
		if(prices.size()>=3) {
			Collections.sort(prices)
			prices.remove(prices.size()-2)
			prices.remove(1)
		}
		def averagePrice = getAveragePrice(prices)		 
		def idealPrice = averagePrice + averagePrice*20/100
		return idealPrice  
    }
    
def getAveragePrice(List prices) {
	return prices.sum()/prices.size() 
}
