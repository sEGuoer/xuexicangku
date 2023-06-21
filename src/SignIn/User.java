package SignIn;

public class User {

    private String accont;
    private String password;
    private int id;
    private int golden;
    private String name;

    public String getAccont() {
        return accont;
    }

    public void setAccont(String accont) {
        this.accont = accont;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGolden() {
        return golden;
    }

    public void setGolden(int golden) {
        this.golden = golden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String accont, String password, String name) {
        this.accont = accont;
        this.password = password;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "accont='" + accont + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", golden=" + golden +
                ", name='" + name + '\'' +
                '}';
    }
}
