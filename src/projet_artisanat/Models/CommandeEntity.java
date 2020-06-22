package projet_artisanat.Models;


import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Commande", schema = "DB_Artisanat")
public class CommandeEntity {
    private int cmdid;
    private Date cmddate;
    private int cmdetat;
    private int utilid;

    public CommandeEntity() {
    	
    }
    
    public CommandeEntity(int cmdid, int cmdetat, int utilid) {
		super();
		this.cmdid = cmdid;
		this.cmdetat = cmdetat;
		this.utilid = utilid;
	}

	@Id
    @Column(name = "cmdid", nullable = false)
    public int getCmdid() {
        return cmdid;
    }

    public void setCmdid(int cmdid) {
        this.cmdid = cmdid;
    }

   
    @Column(name = "cmddate", insertable=false)
    public Date getCmddate() {
        return cmddate;
    }

    public void setCmddate(Date cmddate) {
        this.cmddate = cmddate;
    }

    @Basic
    @Column(name = "cmdetat", nullable = false)
    public int getCmdetat() {
        return cmdetat;
    }

    public void setCmdetat(int cmdetat) {
        this.cmdetat = cmdetat;
    }
    
    @Basic
    @Column(name = "utilid", nullable = false)
    public int getUtilid() {
		return utilid;
	}

	public void setUtilid(int utilid) {
		this.utilid = utilid;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandeEntity that = (CommandeEntity) o;
        return cmdid == that.cmdid &&
                cmdetat == that.cmdetat &&
                Objects.equals(cmddate, that.cmddate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cmdid, cmddate, cmdetat);
    }
}
