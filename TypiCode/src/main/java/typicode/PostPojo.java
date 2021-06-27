package typicode;

public class PostPojo {  //pojo mean in it model


   private int postId;
    private int  id;
    private  String name;
    private  String email;
    private  String body;

    public PostPojo(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
       this.body = body;
   }
    //==========================================================================================================================

//    private int userId;
//    private int id;
//    private String title;
//    private String body;
//
//
//    public PostPojo(int userId, int id, String title, String body) {
//        this.userId = userId;
//        this.id = id;
//        this.title = title;
//        this.body = body;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    private int userId;
//    private  int id;
//    private String title;
//    private String body;
//    private String stName;
//
//    public PostPojo(int userId,int id,String title,String body,String stName){
//        this.userId=userId;
//        this.id=id;
//        this.title=title;
//        this.body =body;
//        this.stName=stName;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public PostPojo(String stName) {
//        this.stName = stName;
//    }
//
//    public String getStName() {
//        return stName;
//    }
//
//    public void setStName(String stName) {
//        this.stName = stName;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
  //  }
}


