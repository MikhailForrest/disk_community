package ru.diskcommunity.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "DISKS", schema = "PUBLIC", catalog = "PUBLIC")
public class DisksEntity {
    private int id;
    private String caption;
    private Integer idOwner;
    private UsersEntity usersByIdOwner;
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
    @Column(name = "CAPTION")
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Basic
    @Column(name = "ID_OWNER")
    public Integer getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Integer idOwner) {
        this.idOwner = idOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DisksEntity that = (DisksEntity) o;

        if (id != that.id) return false;
        if (caption != null ? !caption.equals(that.caption) : that.caption != null) return false;
        if (idOwner != null ? !idOwner.equals(that.idOwner) : that.idOwner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (caption != null ? caption.hashCode() : 0);
        result = 31 * result + (idOwner != null ? idOwner.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ID_OWNER", referencedColumnName = "ID")
    public UsersEntity getUsersByIdOwner() {
        return usersByIdOwner;
    }

    public void setUsersByIdOwner(UsersEntity usersByIdOwner) {
        this.usersByIdOwner = usersByIdOwner;
    }

    @OneToMany(mappedBy = "disksByIdD")
    public Collection<TakenitemEntity> getTakenitemsById() {
        return takenitemsById;
    }

    public void setTakenitemsById(Collection<TakenitemEntity> takenitemsById) {
        this.takenitemsById = takenitemsById;
    }
}
