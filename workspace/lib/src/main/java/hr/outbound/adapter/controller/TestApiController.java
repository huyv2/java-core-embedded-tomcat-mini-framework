package hr.outbound.adapter.controller;

import hr.outbound.common.dto.request.BaseRequestDto;
import hr.outbound.common.dto.request.TestApiRequestDto;
import hr.outbound.common.dto.response.BaseResponseDto;
import hr.outbound.common.dto.response.TestApiResponseDto;

public class TestApiController extends BaseController {
	private static final long serialVersionUID = 1L;

	@Override
	protected BaseResponseDto executePost(BaseRequestDto requestBaseDto) {
		TestApiRequestDto testApiRequestDto = (TestApiRequestDto) requestBaseDto;
		TestApiResponseDto testApiResponseDto = new TestApiResponseDto();
		
		log.debug(testApiRequestDto.getId());
		
		testApiResponseDto.setResponseCode("00");
		testApiResponseDto.setResponseMessage("Success");
		
		return testApiResponseDto;
	}

}
