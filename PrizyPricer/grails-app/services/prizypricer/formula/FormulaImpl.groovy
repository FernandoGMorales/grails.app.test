package prizypricer.formula

class FormulaImpl implements Formula {
	def apply(List prices) {
		if(prices.size()>=3) {
			Collections.sort(prices)
			prices.remove(prices.size()-2)
			prices.remove(1)
		}
		def averagePrice = prices.sum()/prices.size()		 
		def idealPrice = averagePrice + averagePrice*20/100
		return idealPrice
	} 
}
