package com.ymsl.viralnova;

public class Article {

	private String title;
	private String url;
	private String date;
	private String category;
	private String imageUrl;
	private String entryContent;
	private String content;

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getEntryContent() {
		return entryContent;
	}

	public void setEntryContent(String entryContent) {
		this.entryContent = entryContent;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Article [title=" + title + ", url=" + url + ", date=" + date
				+ ", category=" + category + ", imageUrl=" + imageUrl
				+ ", entryContent=" + entryContent + ", content=" + content
				+ "]";
	}
	
}
