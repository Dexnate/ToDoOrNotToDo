package mk.fr.todoornottodo;

/**
 * Created by Formation on 11/01/2018.
 */

public class Tache {

    private Long id;
    private String name;
    private Integer checked;

    public Tache() {
    }

    public Tache(Long id, String name, Integer checked) {
        this.id = id;
        this.name = name;
        this.checked = checked;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getChecked() {
        return checked;
    }




    public Tache setId(Long id) {
        this.id = id;
        return this;
    }

    public Tache setName(String name) {
        this.name = name;
        return this;
    }

    public Tache setChecked(Integer checked) {
        this.checked = checked;
        return this;
    }

}
