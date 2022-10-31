package com.qaprosoft.carina.demo.api.apihomework;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@Endpoint(url = "https://www.boredapi.com/api/activity", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/apitesthw/_getActivity/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class GetActivityMethod extends AbstractApiMethodV2 {
    public GetActivityMethod() {

    }

}
