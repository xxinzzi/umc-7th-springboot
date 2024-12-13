package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.domain.Restaurant;

public class RestaurantHandler extends GeneralException {
    public RestaurantHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
