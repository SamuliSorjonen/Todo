package fi.academy.todo;

public class Tehtava {

    private int id;
    private String tehtava;

    public Tehtava() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTehtava() {
        return tehtava;
    }

    public void setTehtava(String tehtava) {
        this.tehtava = tehtava;
    }

    public Tehtava(int id, String tehtava) {
        this.id = id;
        this.tehtava = tehtava;


    }
}
