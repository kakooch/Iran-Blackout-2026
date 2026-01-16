package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.iQ6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14755iQ6 {
    private final C11458d25 a;
    private final boolean b;

    public C14755iQ6(C11458d25 c11458d25, boolean z) {
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = c11458d25;
        this.b = z;
    }

    public final C11458d25 a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14755iQ6)) {
            return false;
        }
        C14755iQ6 c14755iQ6 = (C14755iQ6) obj;
        return AbstractC13042fc3.d(this.a, c14755iQ6.a) && this.b == c14755iQ6.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "StoryDialogEntity(peer=" + this.a + ", isViewed=" + this.b + Separators.RPAREN;
    }
}
