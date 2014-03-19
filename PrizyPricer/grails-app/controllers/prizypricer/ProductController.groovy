package prizypricer

class ProductController {
	ProductService productService
    static scaffold = true
    
    def show() {
        def product = Product.get(params.id)
        log.error(product)
        def priceList = productService.getPrices(product);
        def avgPrice = productService.getAveragePrice(priceList)
        def highestPrice = priceList.max()
        def lowestPrice = priceList.min()
        def priceCount = priceList.size()
        def idealPrice = productService.getIdealPrice(priceList,productService.idealPriceFormula)
        def model = [name:product.name, barcode:product.barcode, description:product.description, 
			avgPrice:avgPrice, highestPrice:highestPrice, lowestPrice:lowestPrice, priceCount:priceCount, idealPrice:idealPrice]
        render model
    }
    
}
