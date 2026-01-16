package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public final class FF6 {
    private final QF6 a;
    private final boolean b;

    public FF6(QF6 qf6, boolean z) {
        AbstractC13042fc3.i(qf6, "selectedSmilesTab");
        this.a = qf6;
        this.b = z;
    }

    public static /* synthetic */ FF6 b(FF6 ff6, QF6 qf6, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            qf6 = ff6.a;
        }
        if ((i & 2) != 0) {
            z = ff6.b;
        }
        return ff6.a(qf6, z);
    }

    public final FF6 a(QF6 qf6, boolean z) {
        AbstractC13042fc3.i(qf6, "selectedSmilesTab");
        return new FF6(qf6, z);
    }

    public final QF6 c() {
        return this.a;
    }

    public final boolean d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FF6)) {
            return false;
        }
        FF6 ff6 = (FF6) obj;
        return this.a == ff6.a && this.b == ff6.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "SmilesPanelState(selectedSmilesTab=" + this.a + ", shouldForcefullyShowEmojiTab=" + this.b + Separators.RPAREN;
    }
}
