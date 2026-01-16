package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class S74 {
    private final J44 a;

    public S74(J44 j44) {
        AbstractC13042fc3.i(j44, "entity");
        this.a = j44;
    }

    public final J44 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof S74) {
            S74 s74 = (S74) obj;
            if (this.a.i() == s74.a.i() && this.a.h() == s74.a.h() && AbstractC13042fc3.d(this.a.F(), s74.a.F())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "MessageUiModel(entity=" + this.a + Separators.RPAREN;
    }
}
