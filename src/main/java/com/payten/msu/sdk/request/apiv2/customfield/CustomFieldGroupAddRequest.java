package com.payten.msu.sdk.request.apiv2.customfield;

import com.payten.msu.sdk.authentication.Authentication;
import com.payten.msu.sdk.request.base.ApiRequest;
import com.payten.msu.sdk.request.enumerated.ApiAction;
import com.payten.msu.sdk.request.enumerated.CustomFieldGroupBehaviour;
import com.payten.msu.sdk.response.BaseCustomFieldGroupResponse;
import com.payten.msu.sdk.util.ResponseInfo;
import com.payten.msu.sdk.request.enumerated.Param;

@ResponseInfo(
        responseClass = BaseCustomFieldGroupResponse.class
)
public class CustomFieldGroupAddRequest extends ApiRequest {
    private String name;

    private CustomFieldGroupBehaviour behaviour;

    private CustomFieldGroupAddRequest() {
    }

    public static CustomFieldGroupAddRequestBuilder builder() {
        return new CustomFieldGroupAddRequestBuilder();
    }

    @Override
    public void applyRequestParams() {
        addToPayload(Param.NAME, this.name);
        addToPayload(Param.BEHAVIOUR, this.behaviour);
    }

    @Override
    public ApiAction apiAction() {
        return ApiAction.CUSTOMFIELDGROUPADD;
    }

    public static final class CustomFieldGroupAddRequestBuilder {
        private String name;

        private CustomFieldGroupBehaviour behaviour;

        private Authentication authentication;

        public CustomFieldGroupAddRequestBuilder withAuthentication(Authentication authentication) {
            this.authentication = authentication;
            return this;
        }

        public CustomFieldGroupAddRequestBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CustomFieldGroupAddRequestBuilder withBehaviour(CustomFieldGroupBehaviour behaviour) {
            this.behaviour = behaviour;
            return this;
        }

        public CustomFieldGroupAddRequest build() {
            CustomFieldGroupAddRequest request = new CustomFieldGroupAddRequest();
            request.authentication = this.authentication;
            request.name = this.name;
            request.behaviour = this.behaviour;
            return request;
        }
    }
}