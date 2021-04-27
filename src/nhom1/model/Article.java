package nhom1.model;

public class Article {
	public String id;
	public String title;
	public String content;
	public String typeId;
	public String author_article;
	public String avatar_article;
	public Article() {
		super();
	}

	
	public Article(String id, String title, String content, String typeId, String author_article,
			String avatar_article) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.typeId = typeId;
		this.author_article = author_article;
		this.avatar_article = avatar_article;
	}


	public String getAuthor_article() {
		return author_article;
	}

	public void setAuthor_article(String author_article) {
		this.author_article = author_article;
	}

	public String getAvatar_article() {
		return avatar_article;
	}

	public void setAvatar_article(String avatar_article) {
		this.avatar_article = avatar_article;
	}
	
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

}
