package dcu;

import javax.persistence.*;

/**
 * Created by Sean on 08/03/2016.
 */

@Entity
@Table(name = "Claim")
public class Claim {

    @Id
    @Column(name = "claimId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int claimId;

    @Column(name = "claimReference")
    private String claimReference;

    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    public String getClaimReference() {
        return claimReference;
    }

    public void setClaimReference(String claimReference) {
        this.claimReference = claimReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Claim that = (Claim) o;

        if (claimId != that.claimId) return false;
        if (claimReference != null ? !claimReference.equals(that.claimReference) : that.claimReference != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = claimId;
        result = 31 * result + (claimReference != null ? claimReference.hashCode() : 0);
        return result;
    }
}
