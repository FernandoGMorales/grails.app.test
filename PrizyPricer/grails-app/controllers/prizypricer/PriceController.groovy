package prizypricer

class PriceController {
	final int MAX_RESULTS = 5
	static scaffold = true
	
	def index() {
		redirect(action:"list")
	}
	
	def list() {
		params.max = MAX_RESULTS
		def productCount = Product.count()
		def productList = Product.list(params) 
		[productList:productList, productCount:productCount]
	}
	
	def search() {
	}
	
	def create() {
		def product = Product.findByBarcode(params.barcode)
		log.error(product)
		if(product!=null) 
			[name:product.name, barcode:product.barcode, description:product.description]
		else redirect action: 'list'	
	}
	
}
