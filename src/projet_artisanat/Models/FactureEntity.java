package projet_artisanat.Models;


import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Facture", schema = "DB_Artisanat", catalog = "")
public class FactureEntity {
    private int factid;
    private Date factdate;
    private double facttotal;
    private int cmdid;

    @Id
    @Column(name = "factid", nullable = false)
    public int getFactid() {
        return factid;
    }

    public void setFactid(int factid) {
        this.factid = factid;
    }

    @Basic
    @Column(name = "factdate", nullable = false)
    public Date getFactdate() {
        return factdate;
    }

    public void setFactdate(Date factdate) {
        this.factdate = factdate;
    }

    @Basic
    @Column(name = "facttotal", nullable = false, precision = 0)
    public double getFacttotal() {
        return facttotal;
    }

    public void setFacttotal(double facttotal) {
        this.facttotal = facttotal;
    }
    
    @Basic
    @Column(name = "cmdid", nullable = false)
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
        FactureEntity that = (FactureEntity) o;
        return factid == that.factid &&
                Double.compare(that.facttotal, facttotal) == 0 &&
                Objects.equals(factdate, that.factdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(factid, factdate, facttotal);
    }
}
