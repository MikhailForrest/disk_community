package ru.diskcommunity.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "DISKS", schema = "PUBLIC", catalog = "PUBLIC")
public class DisksEntity {
    private int id;
    private String caption;
    private Integer idOwner;
    private UsersEntity holder;
    private Collection<TakenItemEntity> takenItemsById;

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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        DisksEntity disksEntity = (DisksEntity) object;

        if (id != disksEntity.id) return false;
        if (caption != null ? !caption.equals(disksEntity.caption) : disksEntity.caption != null) return false;
        if (idOwner != null ? !idOwner.equals(disksEntity.idOwner) : disksEntity.idOwner != null) return false;

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
    @JoinColumn(name = "HOLDER", referencedColumnName = "ID")
    public UsersEntity getHolder() {
        return holder;
    }

    public void setHolder(UsersEntity holder) {
        this.holder = holder;
    }

    @OneToMany(mappedBy = "disksByIdD")
    public Collection<TakenItemEntity> getTakenItemsById() {
        return takenItemsById;
    }

    public void setTakenItemsById(Collection<TakenItemEntity> takenItemsById) {
        this.takenItemsById = takenItemsById;
    }
}
