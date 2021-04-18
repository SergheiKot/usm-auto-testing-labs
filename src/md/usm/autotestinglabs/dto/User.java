package md.usm.autotestinglabs.dto;

public class User {

    public static final String LOGIN = "login";
    public static final String ID = "id";
    public static final String BLOG = "blog";
    public static final String LOCATION = "location";

    private String login;
    private int id;
    private String blog;
    private String location;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "User: {" +
                "login=\"" + login + "\"" +
                ", id=" + id +
                ", blog=\"" + blog + "\"" +
                ", location=\"" + location + "\"" +
                "}";
    }

}