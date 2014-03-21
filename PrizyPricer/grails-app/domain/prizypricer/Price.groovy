package prizypricer

class Price {
	long productBarcode;
	float price;
	String store;
	String notes;
	Date date;
	static belongsTo = [product: Product]

    static constraints = {
		productBarcode blank:false
        price blank:false
        store blank:false
        notes blank:false
        date blank:false
        product bindable:false
    }
    
}
