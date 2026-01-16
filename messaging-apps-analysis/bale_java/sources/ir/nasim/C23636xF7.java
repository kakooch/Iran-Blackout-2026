package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.xF7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23636xF7 extends AbstractC20556sC7 {
    private final boolean a;

    public /* synthetic */ C23636xF7(boolean z, int i, ED1 ed1) {
        this((i & 1) != 0 ? true : z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C23636xF7) && this.a == ((C23636xF7) obj).a;
    }

    public int hashCode() {
        return Boolean.hashCode(this.a);
    }

    public String toString() {
        return "UpdateSavedGifsChanged(placeholder=" + this.a + Separators.RPAREN;
    }

    public C23636xF7(boolean z) {
        super(null);
        this.a = z;
    }
}
