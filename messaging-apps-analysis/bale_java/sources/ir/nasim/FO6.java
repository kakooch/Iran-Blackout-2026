package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public final class FO6 {
    private final C4062Dn2 a;
    private final C15356jS0 b;
    private final SN6 c;
    private final QN6 d;

    public FO6(C4062Dn2 c4062Dn2, C15356jS0 c15356jS0, SN6 sn6, QN6 qn6) {
        AbstractC13042fc3.i(c4062Dn2, "fileStorageState");
        AbstractC13042fc3.i(c15356jS0, "chatsStorageState");
        this.a = c4062Dn2;
        this.b = c15356jS0;
        this.c = sn6;
        this.d = qn6;
    }

    public final QN6 a() {
        return this.d;
    }

    public final C15356jS0 b() {
        return this.b;
    }

    public final SN6 c() {
        return this.c;
    }

    public final C4062Dn2 d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FO6)) {
            return false;
        }
        FO6 fo6 = (FO6) obj;
        return AbstractC13042fc3.d(this.a, fo6.a) && AbstractC13042fc3.d(this.b, fo6.b) && AbstractC13042fc3.d(this.c, fo6.c) && AbstractC13042fc3.d(this.d, fo6.d);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        SN6 sn6 = this.c;
        int iHashCode2 = (iHashCode + (sn6 == null ? 0 : sn6.hashCode())) * 31;
        QN6 qn6 = this.d;
        return iHashCode2 + (qn6 != null ? qn6.hashCode() : 0);
    }

    public String toString() {
        return "StorageManagerUiState(fileStorageState=" + this.a + ", chatsStorageState=" + this.b + ", dialogState=" + this.c + ", bottomSheetState=" + this.d + Separators.RPAREN;
    }
}
