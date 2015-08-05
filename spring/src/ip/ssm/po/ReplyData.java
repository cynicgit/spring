package ip.ssm.po;

public class ReplyData {
	private int type;
	private String address;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ReplyData(int type, String address) {
		super();
		this.type = type;
		this.address = address;
	}
	public ReplyData(){}
	
}
