package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.mH7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C17037mH7 {
    private long a;
    private InterfaceC9336Zm4 b;

    public C17037mH7(long j, InterfaceC9336Zm4 interfaceC9336Zm4) {
        AbstractC13042fc3.i(interfaceC9336Zm4, "uploadFlow");
        this.a = j;
        this.b = interfaceC9336Zm4;
    }

    public final long a() {
        return this.a;
    }

    public final InterfaceC9336Zm4 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17037mH7)) {
            return false;
        }
        C17037mH7 c17037mH7 = (C17037mH7) obj;
        return this.a == c17037mH7.a && AbstractC13042fc3.d(this.b, c17037mH7.b);
    }

    public int hashCode() {
        return (Long.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UploadProgress(rid=" + this.a + ", uploadFlow=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ C17037mH7(long j, InterfaceC9336Zm4 interfaceC9336Zm4, int i, ED1 ed1) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? AbstractC12281eL6.a(0) : interfaceC9336Zm4);
    }
}
