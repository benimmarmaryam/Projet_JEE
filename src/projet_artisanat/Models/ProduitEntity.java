package projet_artisanat.Models;


import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean
@Entity
@Table(name = "Produit", schema = "DB_Artisanat", catalog = "")
public class ProduitEntity {
    private int pdtid;
    private String pdtdesignation;
    private double pdtprix;
    private int qtestock;
    private String pdtimg;
    private String pdtdescription;
    private int catid;

    public ProduitEntity() {
    	
    }
    
    public ProduitEntity(int pdtid, String pdtdesignation, double pdtprix, int qtestock, String pdtimg,
			String pdtdescription) {
		super();
		this.pdtid = pdtid;
		this.pdtdesignation = pdtdesignation;
		this.pdtprix = pdtprix;
		this.qtestock = qtestock;
		this.pdtimg = pdtimg;
		this.pdtdescription = pdtdescription;
	}

	@Id
    @Column(name = "pdtid", nullable = false)
    public int getPdtid() {
        return pdtid;
    }

    public void setPdtid(int pdtid) {
        this.pdtid = pdtid;
    }

    @Basic
    @Column(name = "pdtdesignation", nullable = false, length = 30)
    public String getPdtdesignation() {
        return pdtdesignation;
    }

    public void setPdtdesignation(String pdtdesignation) {
        this.pdtdesignation = pdtdesignation;
    }

    @Basic
    @Column(name = "pdtprix", nullable = false, precision = 0)
    public double getPdtprix() {
        return pdtprix;
    }

    public void setPdtprix(double pdtprix) {
        this.pdtprix = pdtprix;
    }

    @Basic
    @Column(name = "qtestock", nullable = false)
    public int getQtestock() {
        return qtestock;
    }

    public void setQtestock(int qtestock) {
        this.qtestock = qtestock;
    }

    @Basic
    @Column(name = "pdtimg", nullable = false)
    public String getPdtimg() {
        return pdtimg;
    }

    public void setPdtimg(String pdtimg) {
        this.pdtimg = pdtimg;
    }

    @Basic
    @Column(name = "pdtdescription", nullable = false, length = 50)
    public String getPdtdescription() {
        return pdtdescription;
    }

    public void setPdtdescription(String pdtdescription) {
        this.pdtdescription = pdtdescription;
    }

    
    @Basic
    @Column(name = "catid", nullable = false) 
    public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}
	


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProduitEntity that = (ProduitEntity) o;
        return pdtid == that.pdtid &&
                Double.compare(that.pdtprix, pdtprix) == 0 &&
                qtestock == that.qtestock &&
                Objects.equals(pdtdesignation, that.pdtdesignation) &&
                pdtimg.equals(that.pdtimg) &&
                Objects.equals(pdtdescription, that.pdtdescription);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(pdtid, pdtdesignation, pdtprix, qtestock, pdtdescription);
        result = 31 * result + Objects.hashCode(pdtimg);
        return result;
    }
    
    @Override 
    public String toString() {
    	return "{"+pdtid + "," + pdtprix +","+ qtestock +","+ pdtdesignation +","+ pdtdescription +"}";
    }
}
