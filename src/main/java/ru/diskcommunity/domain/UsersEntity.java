package ru.diskcommunity.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "USERS", schema = "PUBLIC", catalog = "PUBLIC")
public class UsersEntity {
    private int id;
    private String name;
    private Collection<DisksEntity> disksById;
    private Collection<TakenitemEntity> takenitemsById;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByIdOwner")
    public Collection<DisksEntity> getDisksById() {
        return disksById;
    }

    public void setDisksById(Collection<DisksEntity> disksById) {
        this.disksById = disksById;
    }

    @OneToMany(mappedBy = "usersByIdU")
    public Collection<TakenitemEntity> getTakenitemsById() {
        return takenitemsById;
    }

    public void setTakenitemsById(Collection<TakenitemEntity> takenitemsById) {
        this.takenitemsById = takenitemsById;
    }
}
