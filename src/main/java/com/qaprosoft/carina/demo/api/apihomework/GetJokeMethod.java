package com.qaprosoft.carina.demo.api.apihomework;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@Endpoint(url = "https://official-joke-api.appspot.com/random_joke", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/apitesthw/_getJoke/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class GetJokeMethod extends AbstractApiMethodV2 {
    public GetJokeMethod() {

    }
}


