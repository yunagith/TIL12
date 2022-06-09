package db6;

public class ProductDTO {
	private String prdNo;
	private String prdName;
	private int prdPrice;
	private String prdMaker;
	private String prdColo;
	private String ctgNo;
	
	public ProductDTO(String prdNo, String prdName, int prdPrice, String prdMaker, String prdColo, String ctgNo) {
		this.prdNo = prdNo;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdMaker = prdMaker;
		this.prdColo = prdColo;
		this.ctgNo = ctgNo;
	}

	public String getPrdNo() {
		return prdNo;
	}

	public void setPrdNo(String prdNo) {
		this.prdNo = prdNo;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public int getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}

	public String getPrdMaker() {
		return prdMaker;
	}

	public void setPrdMaker(String prdMaker) {
		this.prdMaker = prdMaker;
	}

	public String getPrdColo() {
		return prdColo;
	}

	public void setPrdColo(String prdColo) {
		this.prdColo = prdColo;
	}

	public String getCtgNo() {
		return ctgNo;
	}

	public void setCtgNo(String ctgNo) {
		this.ctgNo = ctgNo;
	}
	
	
	
}
