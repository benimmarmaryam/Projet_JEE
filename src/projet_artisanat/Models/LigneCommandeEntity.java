package projet_artisanat.Models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Ligne_commande", schema = "DB_Artisanat", catalog = "")
@IdClass(LigneCommandeEntityPK.class)
public class LigneCommandeEntity {
	
	private int prodid;
    private int cmdid;
    private int qte;
    
	public LigneCommandeEntity() {
		
	}
	
	
	
    public LigneCommandeEntity(int prodid, int cmdid, int qte) {
		super();
		this.prodid = prodid;
		this.cmdid = cmdid;
		this.qte = qte;
	}

    @Id
    @Column(name = "prodid", nullable = false)
    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    @Id
    @Column(name = "cmdid", nullable = false)
    public int getCmdid() {
        return cmdid;
    }

    public void setCmdid(int cmdid) {
        this.cmdid = cmdid;
    }

    @Basic
    @Column(name = "qte", nullable = false)
    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneCommandeEntity that = (LigneCommandeEntity) o;
        return prodid == that.prodid &&
                cmdid == that.cmdid &&
                qte == that.qte;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodid, cmdid, qte);
    }
    
    @Override
    public String toString() {
    	return prodid+" :" +cmdid + ":" +qte;
    }
}

