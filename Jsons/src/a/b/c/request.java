package a.b.c;



public class request {

	private String id;
	private String title;
	private String imgurl;
	private String date;
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
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "request [id=" + id + ", title=" + title + ", imgurl=" + imgurl
				+ ", date=" + date + "]";
	}
	
	
    
}
