package com.github.msu.sdk.request.apiv2.ewallet;

import com.github.msu.sdk.authentication.Authentication;
import com.github.msu.sdk.request.base.ApiRequest;
import com.github.msu.sdk.request.enumerated.ApiAction;
import com.github.msu.sdk.util.ResponseInfo;

@ResponseInfo(
        responseClass = com.github.msu.sdk.response.EWalletIsCardSavableResponse.class
)
public class EWalletIsCardSavableRequest extends ApiRequest {
    private String customer;

    private String cardPan;

    private EWalletIsCardSavableRequest() {
    }

    public static EWalletIsCardSavableRequestBuilder builder() {
        return new EWalletIsCardSavableRequestBuilder();
    }

    @Override
    public void applyRequestParams() {
        addToPayload(com.github.msu.sdk.request.enumerated.Param.CUSTOMER, this.customer);
        addToPayload(com.github.msu.sdk.request.enumerated.Param.CARDPAN, this.cardPan);
    }

    @Override
    public ApiAction apiAction() {
        return ApiAction.EWALLETISCARDSAVABLE;
    }

    public static final class EWalletIsCardSavableRequestBuilder {
        private String customer;

        private String cardPan;

        private Authentication authentication;

        public EWalletIsCardSavableRequestBuilder withAuthentication(Authentication authentication) {
            this.authentication = authentication;
            return this;
        }

        public EWalletIsCardSavableRequestBuilder withCustomer(String customer) {
            this.customer = customer;
            return this;
        }

        public EWalletIsCardSavableRequestBuilder withCardPan(String cardPan) {
            this.cardPan = cardPan;
            return this;
        }

        public EWalletIsCardSavableRequest build() {
            EWalletIsCardSavableRequest request = new EWalletIsCardSavableRequest();
            request.authentication = this.authentication;
            request.customer = this.customer;
            request.cardPan = this.cardPan;
            return request;
        }
    }
}