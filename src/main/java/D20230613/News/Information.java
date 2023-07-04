package D20230613.News;

public class Information {

    private String title;
    private String content;
    private String author;
    private String game;
    private String user;

    public Information(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Information() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Information{" +
                "title='" + title + '\n' +
                ", content='" + content + '\n' +
                ", author='" + author + '\n' +
                ", game='" + game + '\n' +
                ", user='" + user + '\n' +
                '}';
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
