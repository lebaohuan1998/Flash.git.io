package nhom1.model;

public class Images {
	private String id;
	private String imageName;
	private String albumId;
	private String coverImage;
	public Images() {
		super();
	}
	
	public Images(String imageName, String albumId, String coverImage) {
		super();
		this.imageName = imageName;
		this.albumId = albumId;
		this.coverImage = coverImage;
	}

	public Images(String id, String imageName, String albumId, String coverImage) {
		super();
		this.id = id;
		this.imageName = imageName;
		this.albumId = albumId;
		this.coverImage = coverImage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	

}
