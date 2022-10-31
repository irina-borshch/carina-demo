package com.qaprosoft.carina.demo.api.apihomework;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;


@Endpoint(url = "https://dog.ceo/api/breeds/image/random", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/apihomework/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

        public class GetDogMethod extends AbstractApiMethodV2{
        public GetDogMethod(){

        }
}
