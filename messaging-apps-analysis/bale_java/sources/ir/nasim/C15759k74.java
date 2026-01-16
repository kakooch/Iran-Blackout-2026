package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.k74, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C15759k74 {
    private final String a;
    private final long b;
    private final boolean c;

    public C15759k74(String str, long j, boolean z) {
        AbstractC13042fc3.i(str, "code");
        this.a = str;
        this.b = j;
        this.c = z;
    }

    public final long a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15759k74)) {
            return false;
        }
        C15759k74 c15759k74 = (C15759k74) obj;
        return AbstractC13042fc3.d(this.a, c15759k74.a) && this.b == c15759k74.b && this.c == c15759k74.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "MessageReaction(code=" + this.a + ", cardinality=" + this.b + ", isMe=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ C15759k74(String str, long j, boolean z, int i, ED1 ed1) {
        this(str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? false : z);
    }
}
