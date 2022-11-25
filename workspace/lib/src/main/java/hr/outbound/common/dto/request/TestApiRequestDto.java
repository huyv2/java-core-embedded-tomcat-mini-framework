package hr.outbound.common.dto.request;

import com.google.gson.annotations.SerializedName;

public class TestApiRequestDto extends BaseRequestDto {
	@SerializedName("id")
	private String id;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
