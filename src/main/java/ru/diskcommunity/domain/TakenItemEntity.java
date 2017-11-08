package ru.diskcommunity.domain;

import javax.persistence.*;

@Entity
@Table(name = "TAKENITEM", schema = "PUBLIC", catalog = "PUBLIC")
public class TakenItemEntity {
    private int id;
    private DisksEntity disks;
    private UsersEntity users;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        TakenItemEntity that = (TakenItemEntity) object;

        if (id != that.id) return false;
        if (disks != null ? !disks.equals(that.disks) : that.disks != null) return false;
        if (users != null ? !users.equals(that.users) : that.users != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (disks != null ? disks.hashCode() : 0);
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ID_DISK", referencedColumnName = "ID")
    public DisksEntity getDisksByIdD() {
        return disks;
    }

    public void setDisksByIdD(DisksEntity disksByIdD) {
        this.disks = disksByIdD;
    }

    @ManyToOne
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID")
    public UsersEntity getUsersByIdU() {
        return users;
    }

    public void setUsersByIdU(UsersEntity usersByIdU) {
        this.users = usersByIdU;
    }
}
