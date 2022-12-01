package hr.ewallet.adapter.in.api.momo;

import hr.ewallet.adapter.in.api.BaseApi;
import hr.ewallet.adapter.in.dto.request.BaseRequestDto;
import hr.ewallet.adapter.in.dto.request.TopupRequestDto;
import hr.ewallet.adapter.in.dto.response.BaseResponseDto;
import hr.ewallet.adapter.in.dto.response.TopupResponseDto;
import hr.ewallet.application.port.in.momo.money.TopupUseCase;
import hr.ewallet.driver.init.bean.BeanInit;

public class TopupApi extends BaseApi {
	private static final long serialVersionUID = 1L;
	
	TopupUseCase topupUseCase;

	@Override
	protected BaseResponseDto executePost(BaseRequestDto requestBaseDto) {
		TopupRequestDto topupRequestDto = (TopupRequestDto) requestBaseDto;
		TopupResponseDto topupResponseDto = new TopupResponseDto();
		
		log.debug(topupRequestDto.getToken());
		
		topupUseCase = (TopupUseCase) BeanInit.getInstanceByClassName(TopupUseCase.class.getName());
		topupUseCase.topup(topupRequestDto.getToken(), topupRequestDto.getAmount(), topupRequestDto.getType());
		
		topupResponseDto.setResponseCode("00");
		topupResponseDto.setResponseMessage("Success");
		
		return topupResponseDto;
	}

}
