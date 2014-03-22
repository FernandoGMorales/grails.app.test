package prizypricer

class ProductController {
	static final int MAX_RESULTS = 5
	ProductService productService
    static scaffold = false
    static Script script = new GroovyShell().parse(new File("scripts/formula.groovy"))
    
    def index() {
		redirect(action:"list")
	}
	
	def list() {
		params.max = ProductController.MAX_RESULTS
		params.sort = "barcode"
		params.order = "asc"
		def productCount = Product.count()
		def productList = Product.list(params) 
		[productList:productList, productCount:productCount]
	}
    
    def search() {
	}
	
	def show() {
		def product = Product.findByBarcode(params.barcode)
		log.error(product)
		if(product!=null) {
			def avgPrice = 0
			def highestPrice = 0
			def lowestPrice = 0
			def priceCount = 0
			def idealPrice = 0
			def priceList = productService.getPrices(product);
			if(priceList!=null && !priceList.isEmpty()) {
				avgPrice = productService.getAveragePrice(priceList)
				highestPrice = priceList.max()
				lowestPrice = priceList.min()
				priceCount = priceList.size()
				idealPrice = script.with{formula(priceList)}
			}
			def model = [name:product.name, barcode:product.barcode, description:product.description, avgPrice:avgPrice, 
					highestPrice:highestPrice, lowestPrice:lowestPrice, priceCount:priceCount, idealPrice:idealPrice]
			return model
		}
		else redirect action: 'list'
	}
    
}
