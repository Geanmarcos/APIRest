package support;

import io.restassured.response.Response;

public class requestResource {

    apihelper api;

    public static Response responseresource;

    public requestResource() {
        api = new apihelper();
    }

    public void getResources(){
        String url = "https://reqres.in/api/unknown";
        responseresource = api.get(url);
    }

    public void getResource(String id){
        String url = "https://reqres.in/api/unknown/"+id;
        responseresource = api.get(url);
    }

}
