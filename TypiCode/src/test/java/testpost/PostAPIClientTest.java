package testpost;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import typicode.PostPojo;
import typicode.PostsAPIClient;



public class PostAPIClientTest {
    private PostsAPIClient postsAPIClient;

    @BeforeClass
    public void setUpPostsAPI() {
        this.postsAPIClient = new PostsAPIClient();
    }

    //{
    //    "userId": 1,
    //    "id": 1,
    //    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    //    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    //}
    //{
    //    "userId": 1,
    //    "id": 1,
    //    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    //    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
    //}
      @Test
     public void testPostDeleteEndPoint(){
         ValidatableResponse response = this.postsAPIClient.postDeleteEndPoint();
          response.statusCode(HttpStatus.SC_OK);
         response.log().all();
         System.out.println(response.extract().body().asPrettyString());
        // response.statusCode(200);
     }


    @Test  @Ignore
    public void testGetEndPoint6() {   //third step
        ValidatableResponse response = this.postsAPIClient.getAllPosts3();
        response.statusCode(HttpStatus.SC_OK);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        System.out.println(response);
    }

    @Test @Ignore
    public void testGetEndPoint5() {   //third step
        ValidatableResponse response = this.postsAPIClient.getEndPoint5();
        response.statusCode(HttpStatus.SC_OK);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        System.out.println(response);
    }
    @Test @Ignore
    public void testGetEndPoint4() {   //third step
        ValidatableResponse response = this.postsAPIClient.getEndPoint4();
        response.statusCode(HttpStatus.SC_OK);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        System.out.println(response);
    }

    @Test @Ignore
    public void testGetEndPoint3() {   //third step
        ValidatableResponse response = this.postsAPIClient.getEndPoint3();
        response.statusCode(HttpStatus.SC_OK);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        System.out.println(response);
    }
    @Test @Ignore
    public void testGetEndPoint2() {   //third step
        ValidatableResponse response = this.postsAPIClient.getEndPoint2();
        response.statusCode(HttpStatus.SC_OK);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        System.out.println(response);
    }


   @Test
    public void testGetEndPoint1() {   //third step
        ValidatableResponse response = this.postsAPIClient.getEndPoint1();
        response.statusCode(HttpStatus.SC_OK);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        System.out.println(response);
    }


    @Test @Ignore
    public void testGetEndPoint(){
        ValidatableResponse response=this.postsAPIClient.getEndPoint();
        response.statusCode(HttpStatus.SC_OK);
        response.log().all();
        System.out.println(response.extract().body().asPrettyString());
        System.out.println(response);
    }



    @Test  @Ignore
    public void testGetAllPosts(){
        ValidatableResponse response=this.postsAPIClient.getAllPosts();
        response.statusCode(HttpStatus.SC_OK);
        response.statusCode(200);
    }
    @Test @Ignore
    // write a test that creates a post
    public void testUserCanCreateAPostUsingPojoSuccessfully() {
        PostPojo obj = new PostPojo(11, 101, "test title", "test body","Akbar");

        ValidatableResponse response = this.postsAPIClient.createPost(obj);
        response.statusCode(HttpStatus.SC_CREATED);
        response.statusCode(201);
    }

    @Test @Ignore
    public void testUserCanCreateAPostSuccessfully() {
        int userId = 11;
        int id   =101;
        String title = "test title";
        String body = "test body";
        String stName = "Akbar";

        JSONObject json = new JSONObject();
        json.put("userId", userId);
        json.put("id", 101);
        json.put("title", title);
        json.put("body", body);
        json.put("stName",stName);

        ValidatableResponse response = this.postsAPIClient.createPost(json);
        System.out.println(response.extract().body().asPrettyString());
        response.statusCode(HttpStatus.SC_CREATED);
        // Verify property
        int actualUserId = response.extract().body().path("userId");
        int actualId = response.extract().body().path("id");
        String actualTitle = response.extract().body().path("title");
        String actualBody = response.extract().body().path("body");
        String actualStName = response.extract().body().path("stName");
        Assert.assertEquals(actualUserId, userId);
        Assert.assertEquals(actualId ,id);
        Assert.assertEquals(actualTitle, title);
        Assert.assertEquals(actualBody, body);
        Assert.assertEquals(actualStName,stName );

    }


    // write a test that creates a post
//    @Test @Ignore
//    public void testUserCanCreateAPostUsingPojoSuccessfully() {
//        PostPojo obj = new PostPojo(11, 101, "test title", "test body");
//
//        ValidatableResponse response = this.postsAPIClient.createPost(obj);
//        response.statusCode(HttpStatus.SC_CREATED);
//        response.statusCode(201);
//    }
    //===================================================================================================================
    @Test  @Ignore
    public void testGetAllComments(){
        ValidatableResponse response=this.postsAPIClient.getAllComments();
        response.statusCode(HttpStatus.SC_OK);
        response.statusCode(200);
        System.out.println(response);
    }

    @Test   @Ignore
    public void testCommentsUsingPoJoSuccessfully(){
        PostPojo akb=new PostPojo(201,101,"Akbar","akbar007@aol.com","Six pack ");
        ValidatableResponse response=this.postsAPIClient.createComments(akb);
        response.statusCode(201);
    }
    @Test  @Ignore
         public void testComments(){
         int postId=201;
         int  id=101;
         String name="Akbar";
         String email="akbar007@aol.com";
         String body="Six pack";
         JSONObject json=new JSONObject();
         json.put("postId",201);
         json.put( "id",101);
         json.put("name","Akbar");
         json.put("email","akbar007@aol.com");
         json.put("body","Six pack");

             ValidatableResponse response = this.postsAPIClient.createComments(json);
             System.out.println(response.extract().body().asPrettyString());
             response.statusCode(HttpStatus.SC_CREATED);
        }
//=========================================================================================================================

//    @Test  @Ignore
//    public void testUserCanCreateAPostSuccessfully() {
//        int userId = 11;
//        String title = "test title";
//        String body = "test body";
//        String stName = "Akbar";
//
//        JSONObject json = new JSONObject();
//        json.put("userId", userId);
//        json.put("id", 101);
//        json.put("title", title);
//        json.put("body", body);
//        json.put("stName",stName);
//
//        ValidatableResponse response = this.postsAPIClient.createPost(json);
//        System.out.println(response.extract().body().asPrettyString());
//        response.statusCode(HttpStatus.SC_CREATED);
//        // Verify property
//        int actualUserId = response.extract().body().path("userId");
//        String actualTitle = response.extract().body().path("title");
//        String actualBody = response.extract().body().path("body");
//        org.testng.Assert.assertEquals(actualUserId, userId);
//        org.testng.Assert.assertEquals(actualTitle, title);
//        Assert.assertEquals(actualBody, body);
//    }

//======================================================================================================================


}



