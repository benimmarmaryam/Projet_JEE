package projet_artisanat.Models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Utilisateur", schema = "sR8rO73LvU", catalog = "")
public class UtilisateurEntity {
    private int utilid;
    private String utillogin;
    private String utilpass;
    private String utilmail;
    private String utilnom;
    private String utilprenom;
    private String utiltel;

    public UtilisateurEntity(int utilid, String utillogin, String utilpass, String utilmail, String utilnom,
			String utilprenom, String utiltel) {
		super();
		this.utilid = utilid;
		this.utillogin = utillogin;
		this.utilpass = utilpass;
		this.utilmail = utilmail;
		this.utilnom = utilnom;
		this.utilprenom = utilprenom;
		this.utiltel = utiltel;
	}

	public UtilisateurEntity(String utillogin, String utilpass, String utilmail, String utilnom, String utilprenom,
			String utiltel) {
		super();
		this.utillogin = utillogin;
		this.utilpass = utilpass;
		this.utilmail = utilmail;
		this.utilnom = utilnom;
		this.utilprenom = utilprenom;
		this.utiltel = utiltel;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilid", nullable = false)
    public int getUtilid() {
        return utilid;
    }

    public void setUtilid(int utilid) {
        this.utilid = utilid;
    }

    @Basic
    @Column(name = "utillogin", nullable = false, length = 30)
    public String getUtillogin() {
        return utillogin;
    }

    public void setUtillogin(String utillogin) {
        this.utillogin = utillogin;
    }

    @Basic
    @Column(name = "utilpass", nullable = false, length = 30)
    public String getUtilpass() {
        return utilpass;
    }

    public void setUtilpass(String utilpass) {
        this.utilpass = utilpass;
    }

    @Basic
    @Column(name = "utilmail", nullable = false, length = 30)
    public String getUtilmail() {
        return utilmail;
    }

    public void setUtilmail(String utilmail) {
        this.utilmail = utilmail;
    }

    @Basic
    @Column(name = "utilnom", nullable = false, length = 30)
    public String getUtilnom() {
        return utilnom;
    }

    public void setUtilnom(String utilnom) {
        this.utilnom = utilnom;
    }

    @Basic
    @Column(name = "utilprenom", nullable = false, length = 30)
    public String getUtilprenom() {
        return utilprenom;
    }

    public void setUtilprenom(String utilprenom) {
        this.utilprenom = utilprenom;
    }

    @Basic
    @Column(name = "utiltel", nullable = false, length = 20)
    public String getUtiltel() {
        return utiltel;
    }

    public void setUtiltel(String utiltel) {
        this.utiltel = utiltel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilisateurEntity that = (UtilisateurEntity) o;
        return utilid == that.utilid &&
                Objects.equals(utillogin, that.utillogin) &&
                Objects.equals(utilpass, that.utilpass) &&
                Objects.equals(utilmail, that.utilmail) &&
                Objects.equals(utilnom, that.utilnom) &&
                Objects.equals(utilprenom, that.utilprenom) &&
                Objects.equals(utiltel, that.utiltel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilid, utillogin, utilpass, utilmail, utilnom, utilprenom, utiltel);
    }
}
