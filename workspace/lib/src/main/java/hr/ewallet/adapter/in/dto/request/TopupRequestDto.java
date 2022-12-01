package hr.ewallet.adapter.in.dto.request;

import com.google.gson.annotations.SerializedName;

public class TopupRequestDto extends BaseRequestDto {
	@SerializedName("token")
	private String token;
	@SerializedName("amount")
	private Long amount;
	@SerializedName("type")
	private String type;

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
