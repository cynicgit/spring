package ip.ssm.po;

public class KeyWord {
	private Integer id;
	private String provinces;
	private String shieldKey;
	private String uploadKey;
	private String replyKey;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvinces() {
		return provinces;
	}

	public void setProvinces(String provinces) {
		this.provinces = provinces;
	}

	public String getShieldKey() {
		return shieldKey;
	}

	public void setShieldKey(String shieldKey) {
		this.shieldKey = shieldKey;
	}

	public String getUploadKey() {
		return uploadKey;
	}

	public void setUploadKey(String uploadKey) {
		this.uploadKey = uploadKey;
	}

	public String getReplyKey() {
		return replyKey;
	}

	public void setReplyKey(String replyKey) {
		this.replyKey = replyKey;
	}

	public KeyWord(String provinces, String shieldKey, String uploadKey,
			String replyKey) {
		this.provinces = provinces;
		this.shieldKey = shieldKey!=null?shieldKey:"";
		this.uploadKey = uploadKey!=null?uploadKey:"";
		this.replyKey = replyKey!=null?replyKey:"";
	}

	public KeyWord() {
		super();
	}
	
}
