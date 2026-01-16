package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public final class EO6 {
    private final C3828Cn2 a;
    private final C14767iS0 b;
    private final RN6 c;
    private final PN6 d;

    public EO6(C3828Cn2 c3828Cn2, C14767iS0 c14767iS0, RN6 rn6, PN6 pn6) {
        AbstractC13042fc3.i(c3828Cn2, "fileStorageState");
        AbstractC13042fc3.i(c14767iS0, "chatsStorageState");
        this.a = c3828Cn2;
        this.b = c14767iS0;
        this.c = rn6;
        this.d = pn6;
    }

    public final PN6 a() {
        return this.d;
    }

    public final C14767iS0 b() {
        return this.b;
    }

    public final RN6 c() {
        return this.c;
    }

    public final C3828Cn2 d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EO6)) {
            return false;
        }
        EO6 eo6 = (EO6) obj;
        return AbstractC13042fc3.d(this.a, eo6.a) && AbstractC13042fc3.d(this.b, eo6.b) && AbstractC13042fc3.d(this.c, eo6.c) && AbstractC13042fc3.d(this.d, eo6.d);
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        RN6 rn6 = this.c;
        int iHashCode2 = (iHashCode + (rn6 == null ? 0 : rn6.hashCode())) * 31;
        PN6 pn6 = this.d;
        return iHashCode2 + (pn6 != null ? pn6.hashCode() : 0);
    }

    public String toString() {
        return "StorageManagerState(fileStorageState=" + this.a + ", chatsStorageState=" + this.b + ", dialogState=" + this.c + ", bottomSheetState=" + this.d + Separators.RPAREN;
    }
}
