package projet_artisanat.Models;


import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class LigneCommandeEntityPK implements Serializable {
    /**
	 * 
	 */
	

	private static final long serialVersionUID = 1L;
	private int prodid;
    private int cmdid;	
    
	public LigneCommandeEntityPK() {
		
	}
	
	public LigneCommandeEntityPK(int prodid, int cmdid) {
		super();
		this.prodid = prodid;
		this.cmdid = cmdid;
	}


    @Column(name = "prodid", nullable = false)
    @Id
    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    @Column(name = "cmdid", nullable = false)
    @Id
    public int getCmdid() {
        return cmdid;
    }

    public void setCmdid(int cmdid) {
        this.cmdid = cmdid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneCommandeEntityPK that = (LigneCommandeEntityPK) o;
        return prodid == that.prodid &&
                cmdid == that.cmdid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodid, cmdid);
    }
}
