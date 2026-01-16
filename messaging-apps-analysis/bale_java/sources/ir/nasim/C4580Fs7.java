package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Fs7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4580Fs7 {
    public static final a d = new a(null);
    private final int a;
    private final long b;
    private final long c;

    /* renamed from: ir.nasim.Fs7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C4580Fs7(int i, long j, long j2) {
        this.a = i;
        this.b = j;
        this.c = j2;
    }

    public final int a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4580Fs7)) {
            return false;
        }
        C4580Fs7 c4580Fs7 = (C4580Fs7) obj;
        return this.a == c4580Fs7.a && this.b == c4580Fs7.b && this.c == c4580Fs7.c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + Long.hashCode(this.c);
    }

    public String toString() {
        return "TopPeerEntity(id=" + this.a + ", peerId=" + this.b + ", score=" + this.c + Separators.RPAREN;
    }

    public /* synthetic */ C4580Fs7(int i, long j, long j2, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 0 : i, j, j2);
    }
}
