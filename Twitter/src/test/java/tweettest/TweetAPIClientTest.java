package tweettest;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import tweet.TweetAPIClient;

public class TweetAPIClientTest {
    private TweetAPIClient tweetAPIClient;

    @BeforeClass
    public void setUpTweetAPI() {
        this.tweetAPIClient = new TweetAPIClient();
    }

     @Test @Ignore
    public void testUserCanTweetSuccessfully() {
        // User sent a tweet
        String tweet = "Pakistan is great Country in World";
        ValidatableResponse response = this.tweetAPIClient.createTweet(tweet);
        response.statusCode(200);

    }
    @Test @Ignore
  public void testUserCanTweetSuccessfullyHeader() {
      this.tweetAPIClient.headerValue(tweetAPIClient.GET_USER_TWEET_ENDPOINT);
       String tweet = "Pakistan is great Country in World";
        ValidatableResponse response = this.tweetAPIClient.getUserTimeLineHeaderTweet(tweet);
       response.statusCode(200);

    }
   @Test  @Ignore
    public void testUserTimeLineTweet() {
        this.tweetAPIClient.headerValue(tweetAPIClient.GET_USER_TWEET_ENDPOINT);
        String tweet = "Pakistan is great Country in World";
        ValidatableResponse response = this.tweetAPIClient.checkUserTimeLineTweet(tweet);
        response.statusCode(200);

    }

    @Test @Ignore
    public void testGetUserIdTimeLineTweet(){
        this.tweetAPIClient.getUserIdTimeLineTweet();
        ValidatableResponse response=this.tweetAPIClient.getUserIdTimeLineTweet();
        response.statusCode(200).log().all();
        String expectedResult = "1407083284488667138";
        String actualResult = response.extract().body().path("[0].id_str");
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult, "Text value not match");

    } @Test @Ignore
    public void testGetUserIdTimeLineTweetHeader(){
        this.tweetAPIClient.getUserIdTimeLineTweet();
        ValidatableResponse response=this.tweetAPIClient.getUserIdTimeLineTweetHeader("[0].id_str");
        response.statusCode(200).log().all();
        String expectedResult = "1407789991737106432";
        String actualResult = response.extract().body().path("[0].id_str");
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult, "Text value not match");

    } @Test  @Ignore
    public void testGetUserIdTimeLineTweetTime(){
        this.tweetAPIClient.getUserIdTimeLineTweet();
        ValidatableResponse response=this.tweetAPIClient.getUserIdTimeLineTweetTime("[0].id_str");
        response.statusCode(200).log().all();
        String expectedResult = "1407789991737106432";
        String actualResult = response.extract().body().path("[0].id_str");
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult, "Text value not match");

    }

     //Create: POST
     @Test  @Ignore
    public void testGetUserTimeLineTweet() {
        // Status code should be 200
        this.tweetAPIClient.getUserTimeLineTweet();
        ValidatableResponse response = this.tweetAPIClient.getUserTimeLineTweet();
        // Log All to get Response Details with Response body
        response.statusCode(200).log().all();
        //response.log().all();
        // verify Status code
        response.statusCode(200);
        // To Print response body as Pretty format
        //System.out.println(response.extract().body().asPrettyString());
       // String expectedResult = "We are learning AUTOMATION in nyc";
        String expectedResult = "C0DEED";
       // String expectedResult = "Last week jun 12-18, more than 23 lakh vaccinations were done at a rate of 332,877 per day. This is the highest so… https://t.co/gZQMdt7Upo";
       // String actualResult = response.extract().body().path("[2].id_str");
        String actualResult = response.extract().body().path("[0].user.profile_background_color");
       // String actualResult = response.extract().body().path("[0].user.name");
        //String actualResult = response.extract().body().path("[0].text");
        //boolean actualResult= response.extract().body().asPrettyString().contains("text");
        //Assert.assertEquals(true,actualResult);
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult, "Text value not match");

        // HasItems to check multiple value
        // https://blog.darjan-dzamto.com/working-with-rest-assured-matchers/
        //response.body("[3].text",hasItems("We are learning Rest API Automation and Junaid is the team Lead1"));
        //response.body("[3].text",hasItems("We are learning Rest API Automation and Junaid is the team Lead1","ddd","eee"));
        //response.body("[3].user",hasItem("name"));

    }

    @Test @Ignore
    public void testGetUserMentionTimeLine(){
        this.tweetAPIClient.getUserMentionTimeLine();
        ValidatableResponse response=this.tweetAPIClient.getUserMentionTimeLine();
        response.statusCode(200).log().all();
       // String expectedResult ="";
//        String actualResult=response.extract().body().path();
//        System.out.println(actualResult);
//        Assert.assertEquals(actualResult,expectedResult,"Text value not match");

    }
   @Test @Ignore
    public void testGetUserMentionTimeLineHeader() {
        this.tweetAPIClient.getUserMentionTimeLine();
        ValidatableResponse response = this.tweetAPIClient.getUserMentionTimeLineHeader("endPoint");
        response.statusCode(200).log().all();

    }
    @Test @Ignore
    public void testGetUserMentionTimeLineTime() {
        this.tweetAPIClient.getUserMentionTimeLine();
        ValidatableResponse response = this.tweetAPIClient.getUserMentionTimeLinerTime("endPoint");
        response.statusCode(200).log().all();

    }



    // Delete a tweet from user twitter
//       @Test
//       public void testDeleteTweet() {
//           String tweet = "We are learning AUTOMATION in nyc";
//        ValidatableResponse response=this.tweetAPIClient.deleteTweet(1406285511350796290l);
//        response.log().all();
//        response.log().all();
//           System.out.println(response.extract().body().asPrettyString());
//           // Verify that the tweet is not successful
//           response.statusCode(200);
//           String actualTweet=response.extract().body().path("text");
//           Assert.assertNotEquals(actualTweet,tweet,"Tweet is not match");

   @Test @Ignore
    public void testDeleteTweet() {
        // User sent a tweet
        String tweet = "We are learning Rest API Automation and Junaid is the team Lead1";
        ValidatableResponse response = this.tweetAPIClient.deleteTweet(1406037148902563843l);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        // Verify that the tweet is not successful
        response.statusCode(200);
        String actualTweet= response.extract().body().path("text");
        Assert.assertEquals(actualTweet,tweet,"Tweet is not match");
    }
    @Test @Ignore
    public void testDeleteTweetHeader() {
        // User sent a tweet
        String tweet = "Manhattan is good place to make money";
        ValidatableResponse response = this.tweetAPIClient.deleteTweetHeader(   1407840994742177796L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        // Verify that the tweet is not successful
        response.statusCode(200);
        String actualTweet= response.extract().body().path("text");
        Assert.assertEquals(actualTweet,tweet,"Tweet is not match");
    }
    @Test @Ignore
    public void testDeleteTweetTime() {
        // User sent a tweet
        String tweet = "Manhattan is good place to make money";
        ValidatableResponse response = this.tweetAPIClient.deleteTweetTime(1407840994742177796L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        // Verify that the tweet is not successful
        response.statusCode(200);
        String actualTweet= response.extract().body().path("text");
        Assert.assertEquals(actualTweet,tweet,"Tweet is not match");
    }

   // GET STATUS ID ENDPOINT
    @Test @Ignore
    public void testGetUserStatusId(){
        ValidatableResponse response =  this.tweetAPIClient.getUserStatusId(1407789991737106432L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);

    }
    @Test @Ignore
    public void testGetUserStatusIdHeader(){
        ValidatableResponse response =  this.tweetAPIClient.getUserStatusIdHeader(1407789991737106432L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);

    }
    @Test @Ignore
    public void testGetUserStatusIdTime(){
        ValidatableResponse response =  this.tweetAPIClient.getUserStatusIdTime(1407789991737106432L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     @Test @Ignore
    public void testGetUserStatusesLookup() {
        ValidatableResponse response = this.tweetAPIClient.getUserStatusId(1407856547053674496L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);

    }
    @Test @Ignore
    public void testGetUserStatusesLookupHeader() {
        ValidatableResponse response = this.tweetAPIClient.getUserStatusesLookupHeader(1407856547053674496L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }

    @Test @Ignore
    public void testGetUserStatusesLookupTime(){
        ValidatableResponse response =  this.tweetAPIClient.getUserStatusesLookupTime(1407856547053674496L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);

    }

    @Test  @Ignore
    public void testResponseTime(){
        ValidatableResponse response= this.tweetAPIClient.responseTimeCheck(tweetAPIClient.DELETE_TWEET_ENDPOINT);
    }

    @Test @Ignore
    public void testHeaderValue(){
        this.tweetAPIClient.headerValue(tweetAPIClient.GET_USER_TWEET_ENDPOINT);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      @Test @Ignore
      public void testGetRetweetId() {
        ValidatableResponse response = this.tweetAPIClient.getRetweetId(1407789991737106432L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
       @Test @Ignore
       public void testGetRetweetIdHeader(){
        ValidatableResponse response=this.tweetAPIClient.createRetweetIdHeader(1407083284488667138L,"endPoint");
        response.log().all();
           System.out.println(response.extract().body().asPrettyString());
           response.statusCode(200);
       }
      @Test @Ignore
      public void testGetRetweetIdTime(){
        ValidatableResponse response =  this.tweetAPIClient.createRetweetIdTime(1407083284488667138L,"endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);

    }
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test @Ignore
    public void testUnretweetId() {
        ValidatableResponse response = this.tweetAPIClient.getUnretweetStatusesId(1407856547053674496L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
    @Test @Ignore
    public void testUnretweetIdHeader() {
        ValidatableResponse response = this.tweetAPIClient.createUnretweetIdHeader(1407856547053674496L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
    @Test @Ignore
    public void testUnretweetIdTime() {
        ValidatableResponse response = this.tweetAPIClient.createUnretweetIdTime(1407856547053674496L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
//==============================================================================================================================

    @Test @Ignore
    public void testRetweetId() {
        ValidatableResponse response = this.tweetAPIClient.getRetweetStatusesId(1404176067682787328L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
    @Test @Ignore
    public void testRetweetIdHeader() {  // pass but not return data in array
        ValidatableResponse response = this.tweetAPIClient.createRetweetStatusesIdIdHeader(1404176067682787328L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
    @Test @Ignore
    public void testRetweetIdTime() {
        ValidatableResponse response = this.tweetAPIClient.createRetweetStatusesIdTime(1404176067682787328L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
//============================================================================================================================

    @Test  @Ignore
    public void testGetRetweetStatusesOfMe() {
        ValidatableResponse response = this.tweetAPIClient.getRetweetStatusesOfMe(1404176067682787328L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
    @Test  @Ignore
    public void testGetRetweetStatusesOfMeHeader() {
        ValidatableResponse response = this.tweetAPIClient.createGetRetweetStatusesOfMeHeader(1404176067682787328L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
    @Test   @Ignore
    public void testGetRetweetStatusesOfMeTime() {
        ValidatableResponse response = this.tweetAPIClient.createGetRetweetStatusesOfMeTime(1404176067682787328L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }

//==========================================================================================================================


    @Test  @Ignore
    public void testGetRetweetStatusesIds() {
        ValidatableResponse response = this.tweetAPIClient.getRetweetStatusesIds(1404176067682787328L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
    @Test  @Ignore
    public void testGetRetweetStatusesIdsHeader() {
        ValidatableResponse response = this.tweetAPIClient.createGetRetweetStatusesIdsHeader(1404176067682787328L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
    @Test  @Ignore
    public void testGetRetweetStatusesIdsTime() {
        ValidatableResponse response = this.tweetAPIClient.createGetRetweetStatusesIdsTime(1404176067682787328L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
//============================================================================================================================

    @Test @Ignore
    public void testGetPostFavoriteCreate() {
        ValidatableResponse response = this.tweetAPIClient.getPostFavoriteCreate(1404176067682787328L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
    @Test @Ignore
    public void testGetPostFavoriteCreateHeader() {
        ValidatableResponse response = this.tweetAPIClient.createGetPostFavoriteCreateHeader(1407856547053674496L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
    @Test @Ignore
    public void testGetPostFavoriteCreateTime() {
        ValidatableResponse response = this.tweetAPIClient.createGetPostFavoriteCreateTime(1407856547053674496L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        //response.statusCode(200);
    }

//===============================================================================================================================


    @Test @Ignore                 //not working
    public void testGetPostDestroyCreate() {
        String Name="We will get child credit in next month.";
        ValidatableResponse response = this.tweetAPIClient.getPostFavoriteDestroyCreate(1408802789346664451L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
       // response.statusCode(200);
        String actualTweet=response.extract().body().path("text");
        Assert.assertEquals(actualTweet,Name,"Tweet is not match");


    }
    @Test  @Ignore
    public void testGetPostFavoriteDestroyHeader() {
        ValidatableResponse response = this.tweetAPIClient.createGetPostFavoriteDestroyHeader(1404176067682787328L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
    @Test  @Ignore
    public void testGetPostFavoriteDestroyTime() {
        ValidatableResponse response = this.tweetAPIClient.createGetPostFavoriteDestroyTime(1404176067682787328L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        //response.statusCode(200);
    }


//============================================================================================================================

    @Test   @Ignore
    public void testGetFavoriteListCreate() {
        ValidatableResponse response = this.tweetAPIClient.getFavoriteListCreate(1408802789346664451L);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
    @Test   @Ignore
    public void testGetFavoriteListHeader() {
        ValidatableResponse response = this.tweetAPIClient.createGetFavoriteListHeader(1408802789346664451L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }
    @Test  @Ignore
    public void testGetFavoriteListTime() {
        ValidatableResponse response = this.tweetAPIClient.createGetFavoriteListTime(1408802789346664451L, "endPoint");
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(200);
    }

//================================================================================================================================













}
