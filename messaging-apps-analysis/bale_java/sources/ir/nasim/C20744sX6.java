package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.sX6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C20744sX6 {
    private final int a;
    private final long b;
    private final AbstractC11710dT6 c;

    public C20744sX6(int i, long j, AbstractC11710dT6 abstractC11710dT6) {
        AbstractC13042fc3.i(abstractC11710dT6, "reaction");
        this.a = i;
        this.b = j;
        this.c = abstractC11710dT6;
    }

    public final AbstractC11710dT6 a() {
        return this.c;
    }

    public final long b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20744sX6)) {
            return false;
        }
        C20744sX6 c20744sX6 = (C20744sX6) obj;
        return this.a == c20744sX6.a && this.b == c20744sX6.b && AbstractC13042fc3.d(this.c, c20744sX6.c);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "StoryViewerItem(userId=" + this.a + ", reactionDate=" + this.b + ", reaction=" + this.c + Separators.RPAREN;
    }
}
