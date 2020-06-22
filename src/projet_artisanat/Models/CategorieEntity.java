package projet_artisanat.Models;



import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Categorie", schema = "DB_Artisanat", catalog = "")
public class CategorieEntity {
    private int catid;
    private String catlib;

    @Id
    @Column(name = "catid", nullable = false)
    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    @Basic
    @Column(name = "catlib", nullable = false, length = 20)
    public String getCatlib() {
        return catlib;
    }

    public void setCatlib(String catlib) {
        this.catlib = catlib;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieEntity that = (CategorieEntity) o;
        return catid == that.catid &&
                Objects.equals(catlib, that.catlib);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catid, catlib);
    }
    
    @Override
    public String toString() {
    	return "catid : "+catid+", catlib : "+catlib;
    }
}
