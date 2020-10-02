package com.payten.msu.sdk.request.apiv2.invoice;

import com.payten.msu.sdk.authentication.Authentication;
import com.payten.msu.sdk.request.base.ApiRequest;
import com.payten.msu.sdk.request.enumerated.ApiAction;
import com.payten.msu.sdk.util.ResponseInfo;
import com.payten.msu.sdk.request.enumerated.Param;
import com.payten.msu.sdk.response.InvoiceDeleteAllResponse;

@ResponseInfo(
        responseClass = InvoiceDeleteAllResponse.class
)
public class InvoiceDeleteAllRequest extends ApiRequest {
    private String dealerCode;

    private InvoiceDeleteAllRequest() {
    }

    public static InvoiceDeleteAllRequestBuilder builder() {
        return new InvoiceDeleteAllRequestBuilder();
    }

    @Override
    public void applyRequestParams() {
        addToPayload(Param.DEALERCODE, this.dealerCode);
    }

    @Override
    public ApiAction apiAction() {
        return ApiAction.INVOICEDELETEALL;
    }

    public static final class InvoiceDeleteAllRequestBuilder {
        private String dealerCode;

        private Authentication authentication;

        public InvoiceDeleteAllRequestBuilder withAuthentication(Authentication authentication) {
            this.authentication = authentication;
            return this;
        }

        public InvoiceDeleteAllRequestBuilder withDealerCode(String dealerCode) {
            this.dealerCode = dealerCode;
            return this;
        }

        public InvoiceDeleteAllRequest build() {
            InvoiceDeleteAllRequest request = new InvoiceDeleteAllRequest();
            request.authentication = this.authentication;
            request.dealerCode = this.dealerCode;
            return request;
        }
    }
}