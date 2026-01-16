package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes2.dex */
public final class C80 {
    private final int a;

    public C80(int i) {
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C80) && this.a == ((C80) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "BannerItemEventModel(sectionId=" + this.a + Separators.RPAREN;
    }
}
