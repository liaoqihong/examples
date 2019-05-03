package zuul.filter;

public enum FilterType {
	PRE("pre"),POST("post"),ROUTE("route"),ERROR("error");
	FilterType(String type){
		this.type = type;
	}
	private String type;
	public String getType() {
		return type;
	}
}
