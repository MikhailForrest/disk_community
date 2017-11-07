package ru.diskexchange.domain;

import javax.persistence.*;

@Entity
@Table(name = "TAKENITEM", schema = "PUBLIC", catalog = "PUBLIC")
public class TakenitemEntity {
    private int id;
    private Integer idD;
    private Integer idU;
    private DisksEntity disksByIdD;
    private UsersEntity usersByIdU;

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
    @Column(name = "ID_D")
    public Integer getIdD() {
        return idD;
    }

    public void setIdD(Integer idD) {
        this.idD = idD;
    }

    @Basic
    @Column(name = "ID_U")
    public Integer getIdU() {
        return idU;
    }

    public void setIdU(Integer idU) {
        this.idU = idU;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TakenitemEntity that = (TakenitemEntity) o;

        if (id != that.id) return false;
        if (idD != null ? !idD.equals(that.idD) : that.idD != null) return false;
        if (idU != null ? !idU.equals(that.idU) : that.idU != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idD != null ? idD.hashCode() : 0);
        result = 31 * result + (idU != null ? idU.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ID_D", referencedColumnName = "ID")
    public DisksEntity getDisksByIdD() {
        return disksByIdD;
    }

    public void setDisksByIdD(DisksEntity disksByIdD) {
        this.disksByIdD = disksByIdD;
    }

    @ManyToOne
    @JoinColumn(name = "ID_U", referencedColumnName = "ID")
    public UsersEntity getUsersByIdU() {
        return usersByIdU;
    }

    public void setUsersByIdU(UsersEntity usersByIdU) {
        this.usersByIdU = usersByIdU;
    }
}
