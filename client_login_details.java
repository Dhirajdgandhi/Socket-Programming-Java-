public class client_login_details {
    private String USERNAME = "admin";
    private String PASSWORD = "qwerty";
    private int PORT = 3142;
    private String HOSTNAME = "localhost";

    public String getUsername(){
        return this.USERNAME;
    }

    public String getPassword(){

        return this.PASSWORD;
    }

    public int getPort(){
        return this.PORT;
    }

    public String gethostName(){
        return this.HOSTNAME;
    }
}