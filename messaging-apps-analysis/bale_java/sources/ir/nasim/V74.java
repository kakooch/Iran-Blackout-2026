package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.database.dailogLists.DialogEntity;
import java.util.List;

/* loaded from: classes5.dex */
public final class V74 {
    private final J44 a;

    public V74(J44 j44) {
        AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
        this.a = j44;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof V74)) {
            return false;
        }
        J44 j44 = ((V74) obj).a;
        return j44.i() == this.a.i() && j44.W() == this.a.W() && j44.h() == this.a.h() && j44.U() == this.a.U() && AbstractC13042fc3.d(j44.F(), this.a.F()) && AbstractC13042fc3.d(j44.P(), this.a.P()) && AbstractC13042fc3.d(j44.R(), this.a.R()) && j44.G() == this.a.G() && AbstractC13042fc3.d(j44.Q(), this.a.Q()) && AbstractC13042fc3.d(j44.S(), this.a.S()) && j44.V() == this.a.V() && AbstractC13042fc3.d(j44.J(), this.a.J()) && AbstractC13042fc3.d(j44.Y(), this.a.Y()) && j44.K() == this.a.K() && AbstractC18123o74.a(j44.T(), this.a.T());
    }

    public int hashCode() {
        int iHashCode = ((((((((Long.hashCode(this.a.i()) * 31) + Long.hashCode(this.a.W())) * 31) + Long.hashCode(this.a.h())) * 31) + Integer.hashCode(this.a.U())) * 31) + this.a.F().hashCode()) * 31;
        AbstractC17457n0 abstractC17457n0P = this.a.P();
        int iHashCode2 = (iHashCode + (abstractC17457n0P != null ? abstractC17457n0P.hashCode() : 0)) * 31;
        C3460Az c3460AzO = this.a.O();
        int iHashCode3 = (iHashCode2 + (c3460AzO != null ? c3460AzO.hashCode() : 0)) * 31;
        C3460Az c3460AzN = this.a.N();
        int iHashCode4 = (((((iHashCode3 + (c3460AzN != null ? c3460AzN.hashCode() : 0)) * 31) + this.a.R().hashCode()) * 31) + this.a.G()) * 31;
        C8445Vz5 c8445Vz5Q = this.a.Q();
        int iHashCode5 = (iHashCode4 + (c8445Vz5Q != null ? c8445Vz5Q.hashCode() : 0)) * 31;
        List listS = this.a.S();
        int iHashCode6 = (((iHashCode5 + (listS != null ? listS.hashCode() : 0)) * 31) + Boolean.hashCode(this.a.V())) * 31;
        Long lJ = this.a.J();
        int iHashCode7 = (iHashCode6 + (lJ != null ? lJ.hashCode() : 0)) * 31;
        CI7 ci7Y = this.a.Y();
        int iHashCode8 = (iHashCode7 + (ci7Y != null ? ci7Y.hashCode() : 0)) * 31;
        C17532n74 c17532n74T = this.a.T();
        return ((iHashCode8 + (c17532n74T != null ? c17532n74T.hashCode() : 0)) * 31) + Boolean.hashCode(this.a.K());
    }

    public String toString() {
        return "MessageWrapper(message=" + this.a + Separators.RPAREN;
    }
}
