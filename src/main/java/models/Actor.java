package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Actor_ID", unique = true, nullable = false)
    int id;

    @NotNull
    String name;

    @NotNull
    String BgImage;

    public String getBgImage() {
        return BgImage;
    }

    public void setBgImage(String bgImage) {
        BgImage = bgImage;
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

}
