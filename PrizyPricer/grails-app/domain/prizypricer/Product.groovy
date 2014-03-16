package prizypricer

class Product {
    String name;
	String description;
	String barcode;
	/*
	float averagePrice;
	float highestPrice;
	float lowestPrice;
	float idealPrice;
	List<Price> priceList;
	*/

    static constraints = {
		name(blank: false)
        description(blank: false)
        barcode(blank: false)
    }
    
    // static transients = ['averagePrice,highestPrice,lowestPrice,idealPrice']
    
    //TODO add methods for prices calculation
}
