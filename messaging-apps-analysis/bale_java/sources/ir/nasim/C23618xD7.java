package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.xD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23618xD7 extends AbstractC20556sC7 {
    private final C7429Rr2 a;
    private final int b;

    public C23618xD7(C7429Rr2 c7429Rr2, int i) {
        super(null);
        this.a = c7429Rr2;
        this.b = i;
    }

    public final C7429Rr2 a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23618xD7)) {
            return false;
        }
        C23618xD7 c23618xD7 = (C23618xD7) obj;
        return AbstractC13042fc3.d(this.a, c23618xD7.a) && this.b == c23618xD7.b;
    }

    public int hashCode() {
        C7429Rr2 c7429Rr2 = this.a;
        return ((c7429Rr2 == null ? 0 : c7429Rr2.hashCode()) * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "UpdateFolderCreated(folder=" + this.a + ", index=" + this.b + Separators.RPAREN;
    }
}
