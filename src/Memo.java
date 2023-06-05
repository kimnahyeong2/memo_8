import java.util.Date;

public class Memo {
    int number;
    String name;
    String password;
    String content;
    Date date;

    public Memo(String name, String password, String content) {
        number += 1;
        this.name = name;
        this.password = password;
        this.content = content;
        date = new Date();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Memo{" +
                "number=" + number +
                ", password='" + password + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
