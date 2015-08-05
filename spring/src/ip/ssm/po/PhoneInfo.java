package ip.ssm.po;

public class PhoneInfo {

	private Integer id;
	private String action;
	private String imei;
	private String imsi;
	private String sc;
	private String custom;
	private String phver;
	private String mocorver;
	private String ct;
	private String cause;
	private String sn1;
	private String sn2;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getPhver() {
		return phver;
	}

	public void setPhver(String phver) {
		this.phver = phver;
	}

	public String getCt() {
		return ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getCustom() {
		return custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}

	public String getMocorver() {
		return mocorver;
	}

	public void setMocorver(String mocorver) {
		this.mocorver = mocorver;
	}

	public String getSn1() {
		return sn1;
	}

	public void setSn1(String sn1) {
		this.sn1 = sn1;
	}

	public String getSn2() {
		return sn2;
	}

	public void setSn2(String sn2) {
		this.sn2 = sn2;
	}

}
