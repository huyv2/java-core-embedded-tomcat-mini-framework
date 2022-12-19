package hr.ewallet.adapter.in.api.momo;

import hr.ewallet.adapter.in.api.BaseApi;
import hr.ewallet.adapter.in.api.dto.request.BaseRequestDto;
import hr.ewallet.adapter.in.api.dto.request.momo.TopupRequestDto;
import hr.ewallet.adapter.in.api.dto.response.BaseResponseDto;
import hr.ewallet.adapter.in.api.dto.response.momo.TopupResponseDto;
import hr.ewallet.application.port.in.command.request.momo.money.TopupRequestCommand;
import hr.ewallet.application.port.in.command.response.momo.money.TopupResponseCommand;
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
		
		TopupRequestCommand topupRequestCommand = new TopupRequestCommand();
		topupRequestCommand.setToken(topupRequestDto.getToken());
		topupRequestCommand.setAmount(topupRequestDto.getAmount());
		topupRequestCommand.setType(topupRequestDto.getType());
		
		TopupResponseCommand topupResponseCommand = topupUseCase.topup(topupRequestCommand);
		
		if (topupResponseCommand.isResult()) {
			topupResponseDto.setResponseCode("00");
			topupResponseDto.setResponseMessage("Success");
		}
		
		return topupResponseDto;
	}

}
