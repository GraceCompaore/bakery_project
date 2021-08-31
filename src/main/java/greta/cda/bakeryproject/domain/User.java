package greta.cda.bakeryproject.domain;

public class User {
    private int id;
    private int login;
    private int pwd;

    public User(int id, int login, int pwd) {
        this.id = id;
        this.login = login;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public int getLogin() {
        return login;
    }

    public int getPwd() {
        return pwd;
    }
}
