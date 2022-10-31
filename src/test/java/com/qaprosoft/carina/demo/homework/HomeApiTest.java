package com.qaprosoft.carina.demo.homework;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.api.apihomework.*;
import org.testng.annotations.Test;

public class HomeApiTest implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "Iryna Borshch")
    public void testGetDog() {
        GetDogMethod getDog = new GetDogMethod();
        getDog.callAPIExpectSuccess();
        getDog.validateResponseAgainstSchema("api/apitesthw/_getDog/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "Iryna Borshch")
    public void testGetActivity() {
        GetActivityMethod getActivity = new GetActivityMethod();
        getActivity.callAPIExpectSuccess();
        getActivity.validateResponseAgainstSchema("api/apitesthw/_getActivity/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "Iryna Borshch")
    public void testGetJoke() {
        GetJokeMethod getJoke = new GetJokeMethod();
        getJoke.callAPIExpectSuccess();
        getJoke.validateResponseAgainstSchema("api/apitesthw/_getJoke/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "Iryna Borshch")
    public void testPost() {
        PostMethod post = new PostMethod();
        post.callAPIExpectSuccess();
        post.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "Iryna Borshch")
    public void testDelete() {
        DeleteMethod deleteMethod = new DeleteMethod();
        deleteMethod.callAPIExpectSuccess();
        deleteMethod.validateResponse();
    }


}
