package typicode;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PostsAPIClient extends TypiCodeAPIClient {

    private String POST_ENDPOINT = "/posts";
    private String DELETE_ENDPOINT = "/posts/1";
    private String COMMENTS_ENDPOINT = "/comments";
    private String GET_ENDPOINT = "/posts"; //get method
    private String GET_ENDPOINT1 = "/posts/1"; //get method  first
    private String GET_ENDPOINT3 = "/posts/2"; //get method  first
    private String GET_ENDPOINT2 = "/posts/1/comments"; //get method  first
    private String GET_COMMENT_ENDPOINT2 = "/comments?postId=1"; //get method  first
    private String GET_COMMENT_ENDPOINT3 = "/comments?postId=2"; //get method  first∂
    private String GET_COMMENT_ENDPOINT4 = "/comments?postId=3"; //get method  first∂

    // get Comment method
    public ValidatableResponse postDeleteEndPoint(){
        return when().get(this.baseUrl+DELETE_ENDPOINT).then(); //second step
    }
    // get Comment method
    public ValidatableResponse getEndPoint5(){
        return when().get(this.baseUrl+GET_COMMENT_ENDPOINT4).then(); //second step
    }

    // get Comment method
    public ValidatableResponse getEndPoint4(){
        return when().get(this.baseUrl+GET_COMMENT_ENDPOINT3).then(); //second step
    }

    // get Comment method
    public ValidatableResponse getEndPoint3(){
        return when().get(this.baseUrl+GET_COMMENT_ENDPOINT2).then(); //second step
    }

    // get method
    public ValidatableResponse getEndPoint2(){
        return when().get(this.baseUrl+GET_ENDPOINT2).then(); //second step
    }

    // get method
    public ValidatableResponse getEndPoint(){
        return when().get(this.baseUrl+GET_ENDPOINT).then(); //second step
    }

    public ValidatableResponse getEndPoint1(){
        return when().get(this.baseUrl+GET_ENDPOINT1).then();
    }


    public ValidatableResponse getAllPosts3() {
        return when().get(this.baseUrl +GET_ENDPOINT3).then();
    }

    public ValidatableResponse getAllPosts() {
        return when().get(this.baseUrl + POST_ENDPOINT).then();
    }
    // Payload
    public ValidatableResponse createPost(Object json){
        return given().header("Content-type","application/json").body(json)
                .when().post(this.baseUrl+POST_ENDPOINT).then();
    }

    public ValidatableResponse getAllComments(){
        return when().get(this.baseUrl+COMMENTS_ENDPOINT).then();
    }
    public ValidatableResponse createComments(Object json){
        return given().header("Content-type","application/json").body(json)
                .when().post(this.baseUrl+COMMENTS_ENDPOINT).then();
    }




}
