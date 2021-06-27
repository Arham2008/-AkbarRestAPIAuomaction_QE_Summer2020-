package tweet;

import base.RestAPI;
import io.restassured.response.ValidatableResponse;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class TweetAPIClient extends RestAPI {
    // https://developer.twitter.com/en/docs/twitter-api/v1/tweets/timelines/api-reference/get-statuses-home_timeline
    //GET statuses/home_timeline
    public final String GET_USER_TWEET_ENDPOINT = "/statuses/home_timeline.json";
    private final String GET_USER_ID_ENDPOINT = "/statuses/user_timeline.json";

    //https://developer.twitter.com/en/docs/twitter-api/v1/tweets/timelines/api-reference/get-statuses-mentions_timeline
    private final String GET_USER_MENTION_ENDPOINT = "/statuses/mentions_timeline.json";

    // https://developer.twitter.com/en/docs/twitter-api/v1/tweets/post-and-engage/api-reference/post-statuses-destroy-id
    // DELETE / Destroy : Delete or Post
    public final String DELETE_TWEET_ENDPOINT = "/statuses/destroy.json";

    // https://developer.twitter.com/en/docs/twitter-api/v1/tweets/post-and-engage/api-reference/post-statuses-update
    // Create: POST
    private final String CREATE_TWEET_ENDPOINT = "/statuses/update.json";

    private final String GET_STATUS_ID_ENDPOINT ="/statuses/show.json";

    private final String GET_STATUSES_LOOKUP_ENDPOINT ="/statuses/lookup.json";

    private final String POST_STATUSES_RETWEET_ID_ENDPOINT ="/statuses/retweet.json";


    private final String POST_STATUSES_UNRETWEET_ID_ENDPOINT ="/statuses/unretweet.json";

    private final String GET_STATUSES_RETWEET_ID_ENDPOINT ="/statuses/retweets.json";

    private final String GET_STATUSES_RETWEET_OF_ME_ENDPOINT ="/statuses/retweets_of_me.json";

    private final String GET_STATUSES_RETWEETER_IDS_ENDPOINT ="/statuses/retweeters/ids.json";

    private final String POST_FAVORITE_CREATE_ENDPOINT ="/favorites/create.json";

    private final String POST_FAVORITE_DESTROY_ENDPOINT ="/favorites/destroy.json";

    private final String GET_FAVORITE_LIST_ENDPOINT ="/favorites/list.json";


    // GET STATUS ID ENDPOINT
    public  ValidatableResponse getUserStatusId(Long tweetId){
      return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
              .queryParam("id", tweetId)
        .when().get(this.baseUrl+this.GET_STATUS_ID_ENDPOINT).then().statusCode(200);

    }
   public  ValidatableResponse getUserStatusIdHeader(Long tweetId,String endPoint) {
       System.out.println(given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
               .when().get(this.baseUrl + endPoint).then().extract().headers());
       return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
               .queryParam("id", tweetId)
               .when().get(this.baseUrl + this.GET_STATUS_ID_ENDPOINT).then().statusCode(200);

   }

    public  ValidatableResponse getUserStatusIdTime(Long tweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
      return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
              .queryParam("id", tweetId)
        .when().get(this.baseUrl+this.GET_STATUS_ID_ENDPOINT).then().statusCode(200);

    }
///////////////////////////////////////////////////////////////////////////////////////////////////////

      public ValidatableResponse getStatusesLookup(Long tweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
             .queryParam("id",tweetId)
         .when().get(this.baseUrl+this.GET_STATUSES_LOOKUP_ENDPOINT).then().statusCode(200);

      }


    public  ValidatableResponse getUserStatusesLookupHeader(Long tweetId,String endPoint) {
        System.out.println(given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .when().get(this.baseUrl + endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().get(this.baseUrl + this.GET_STATUS_ID_ENDPOINT).then().statusCode(200);

    }

    public  ValidatableResponse getUserStatusesLookupTime(Long tweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().get(this.baseUrl+this.GET_STATUS_ID_ENDPOINT).then().statusCode(200);

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////



    // GET All Tweet Information
    public ValidatableResponse getUserTimeLineTweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT).then().statusCode(200);
    }


    public ValidatableResponse getUserTimeLineHeaderTweet(String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT).then().statusCode(200);
    }

      public ValidatableResponse checkUserTimeLineTweet(String endPoint){    //
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_TWEET_ENDPOINT).then();

    }



    public ValidatableResponse  getUserIdTimeLineTweet(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_ID_ENDPOINT).then().statusCode(200);
    }


    public ValidatableResponse  getUserIdTimeLineTweetHeader(String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_ID_ENDPOINT).then().statusCode(200);
    }

    public ValidatableResponse  getUserIdTimeLineTweetTime(String endPoint){
//        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
//                .when().get(this.baseUrl+endPoint).then().extract().headers());
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+this.GET_USER_ID_ENDPOINT).then().statusCode(200);

    }


    public ValidatableResponse  getUserMentionTimeLine(){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
        .when().get(this.baseUrl+this.GET_USER_MENTION_ENDPOINT).then();
    }

    public ValidatableResponse  getUserMentionTimeLineHeader(String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
        .when().get(this.baseUrl+this.GET_USER_MENTION_ENDPOINT).then();
    }

 public ValidatableResponse  getUserMentionTimeLinerTime(String endPoint){
     System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
             .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
        .when().get(this.baseUrl+this.GET_USER_MENTION_ENDPOINT).then();
    }


    // Delete a tweet from user twitter
    public ValidatableResponse deleteTweet (Long tweetId){
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().post(this.baseUrl + this.DELETE_TWEET_ENDPOINT).then();
    }
      public ValidatableResponse deleteTweetHeader (Long tweetId,String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().post(this.baseUrl + this.DELETE_TWEET_ENDPOINT).then();
    }

   public ValidatableResponse deleteTweetTime (Long tweetId,String endPoint){
       System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
               .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().post(this.baseUrl + this.DELETE_TWEET_ENDPOINT).then();
    }

    //////////////////////////////////////////////////////////////////////////////////////


    // Create a Tweet from user twitter
    public ValidatableResponse createTweet(String tweet) {
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl + this.CREATE_TWEET_ENDPOINT).then();

   }
    public ValidatableResponse createTweetHeader(String tweet) {
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+tweet).then().extract().headers());
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .param("status", tweet)
                .when().post(this.baseUrl + this.CREATE_TWEET_ENDPOINT).then();

   }
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      public ValidatableResponse getRetweetId(Long reTweetId){
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
             .queryParam("id",reTweetId)
             .when().post(this.baseUrl+this.POST_STATUSES_RETWEET_ID_ENDPOINT).then().statusCode(200);
      }

     public ValidatableResponse createRetweetIdHeader(Long retweet,String endPoint){
         System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
        .when().get(this.baseUrl+endPoint).then().extract().headers());
      return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                 .param("id",retweet)
              .when().post(this.baseUrl+this.POST_STATUSES_RETWEET_ID_ENDPOINT).then();
     }
    public ValidatableResponse createRetweetIdTime (Long tweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().post(this.baseUrl + this.DELETE_TWEET_ENDPOINT).then();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ValidatableResponse getUnretweetStatusesId(Long unRetweet) {
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",unRetweet)
                .when().post(this.baseUrl+this.POST_STATUSES_UNRETWEET_ID_ENDPOINT).then().statusCode(200);
    }


    public ValidatableResponse createUnretweetIdHeader(Long retweet,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .param("id",retweet)
                .when().post(this.baseUrl+this.POST_STATUSES_UNRETWEET_ID_ENDPOINT).then();
    }


    public ValidatableResponse createUnretweetIdTime (Long tweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", tweetId)
                .when().post(this.baseUrl + this.POST_STATUSES_UNRETWEET_ID_ENDPOINT).then();
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ValidatableResponse getRetweetStatusesId(Long retweetId) {
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",retweetId)
                .when().get(this.baseUrl+this.GET_STATUSES_RETWEET_ID_ENDPOINT).then().statusCode(200);
    }

    public ValidatableResponse createRetweetStatusesIdIdHeader(Long retweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .param("id",retweetId)
                .when().get(this.baseUrl+this.GET_STATUSES_RETWEET_ID_ENDPOINT).then();
    }


    public ValidatableResponse createRetweetStatusesIdTime (Long retweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", retweetId)
                .when().get(this.baseUrl + this.GET_STATUSES_RETWEET_ID_ENDPOINT).then();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public ValidatableResponse getRetweetStatusesOfMe(Long retweetId) {
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("Name",retweetId)
                .when().get(this.baseUrl+this.GET_STATUSES_RETWEET_OF_ME_ENDPOINT).then().statusCode(200);
    }

    public ValidatableResponse createGetRetweetStatusesOfMeHeader(Long retweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .param("Name",retweetId)
                .when().get(this.baseUrl+this.GET_STATUSES_RETWEET_OF_ME_ENDPOINT).then();
    }


    public ValidatableResponse createGetRetweetStatusesOfMeTime (Long retweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("Name", retweetId)
                .when().get(this.baseUrl + this.GET_STATUSES_RETWEET_OF_ME_ENDPOINT).then();
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




    public ValidatableResponse getRetweetStatusesIds(Long retweetId) {
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",retweetId)
                .when().get(this.baseUrl+this.GET_STATUSES_RETWEETER_IDS_ENDPOINT).then().statusCode(200);
    }

    public ValidatableResponse createGetRetweetStatusesIdsHeader(Long retweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .param("id",retweetId)
                .when().get(this.baseUrl+this.GET_STATUSES_RETWEETER_IDS_ENDPOINT).then();
    }


    public ValidatableResponse createGetRetweetStatusesIdsTime (Long retweetId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", retweetId)
                .when().get(this.baseUrl + this.GET_STATUSES_RETWEETER_IDS_ENDPOINT).then();
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public ValidatableResponse getPostFavoriteCreate(Long postCreateId) {
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",postCreateId)
                .when().post(this.baseUrl+this.POST_FAVORITE_CREATE_ENDPOINT).then().statusCode(200);
    }

    public ValidatableResponse createGetPostFavoriteCreateHeader(Long postCreateId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .param("id",postCreateId)
                .when().post(this.baseUrl+this.POST_FAVORITE_CREATE_ENDPOINT).then();
    }


    public ValidatableResponse createGetPostFavoriteCreateTime (Long postCreateId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", postCreateId)
                .when().post(this.baseUrl + this.POST_FAVORITE_CREATE_ENDPOINT).then();
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  // not working
    public ValidatableResponse getPostFavoriteDestroyCreate(Long postDestroyId) {
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("id",postDestroyId)
                .when().post(this.baseUrl+this.POST_FAVORITE_DESTROY_ENDPOINT).then();
    }

    public ValidatableResponse createGetPostFavoriteDestroyHeader(Long postDestroyId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .param("id",postDestroyId)
                .when().post(this.baseUrl+this.POST_FAVORITE_DESTROY_ENDPOINT).then();
    }


    public ValidatableResponse createGetPostFavoriteDestroyTime (Long postDestroyId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("id", postDestroyId)
                .when().post(this.baseUrl + this.POST_FAVORITE_DESTROY_ENDPOINT).then();
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ValidatableResponse getFavoriteListCreate(Long getFavoriteListId) {
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .queryParam("Name",getFavoriteListId)
                .when().get(this.baseUrl+this.GET_FAVORITE_LIST_ENDPOINT).then().statusCode(200);
    }

    public ValidatableResponse createGetFavoriteListHeader(Long getFavoriteListId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .param("Name",getFavoriteListId)
                .when().get(this.baseUrl+this.GET_FAVORITE_LIST_ENDPOINT).then();
    }


    public ValidatableResponse createGetFavoriteListTime (Long getFavoriteListId,String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey, this.apiSecretKey, this.accessToken, this.accessTokenSecret)
                .queryParam("Name", getFavoriteListId)
                .when().get(this.baseUrl + this.GET_FAVORITE_LIST_ENDPOINT).then();
    }


////////////////////////////////////////////////////////////////////////////////////////////

    //Header Value
    public void headerValue(String endPoint){
        System.out.println( given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then().extract().headers());
    }
    // Response Time Check
    public ValidatableResponse responseTimeCheck(String endPoint){
        System.out.println(given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).timeIn(TimeUnit.MILLISECONDS));
        return given().auth().oauth(this.apiKey,this.apiSecretKey,this.accessToken,this.accessTokenSecret)
                .when().get(this.baseUrl+endPoint).then();
    }

}


