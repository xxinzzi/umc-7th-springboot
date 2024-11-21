package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class MenuCategoryHandler extends GeneralException {
    public MenuCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
