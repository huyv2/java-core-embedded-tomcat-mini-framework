package hr.outbound.common.dto.request;

import com.google.gson.annotations.SerializedName;

public abstract class BaseRequestDto {
	@SerializedName("source")
	private String source;
	@SerializedName("request_signature")
	private String requestSignature;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getRequestSignature() {
		return requestSignature;
	}
	public void setRequestSignature(String requestSignature) {
		this.requestSignature = requestSignature;
	}
}
