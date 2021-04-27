package nhom1.model;

public class DecribePhotographer {

	private int photographerID;

	private String describe;

	private String imageFirst;
	private String imageSecond;

	public DecribePhotographer() {
	};

	public DecribePhotographer(int photographerID, String describe, String image1, String image2) {
		super();

		this.photographerID = photographerID;
		this.describe = describe;

		this.imageFirst = image1;
		this.imageSecond = image2;

	}

	public int getPhotographerID() {
		return photographerID;
	}

	public void setPhotographerID(int photographerID) {
		this.photographerID = photographerID;
	}

	public String getImageFirst() {
		return imageFirst;
	}

	public void setImageFirst(String imageFirst) {
		this.imageFirst = imageFirst;
	}

	public String getImageSecond() {
		return imageSecond;
	}

	public void setImageSecond(String imageSecond) {
		this.imageSecond = imageSecond;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

}
