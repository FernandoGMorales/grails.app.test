package prizypricer

class Price {
	long productBarcode;
	float price;
	String store;
	String notes;
	Date date;

    static constraints = {
		productBarcode(blank: false)
        price(blank: false)
        store(blank: false)
        notes(blank: false)
        date(blank: false)
    }
}
