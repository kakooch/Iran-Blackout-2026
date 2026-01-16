package ir.nasim;

/* renamed from: ir.nasim.eW, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C12373eW {
    private final String a;
    private final C9737aT7 b;
    private final boolean c;

    public C12373eW(String str, C9737aT7 c9737aT7, boolean z) {
        AbstractC13042fc3.i(str, "codec");
        this.a = str;
        this.b = c9737aT7;
        this.c = z;
    }

    public final String a() {
        return this.a;
    }

    public final C9737aT7 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12373eW)) {
            return false;
        }
        C12373eW c12373eW = (C12373eW) obj;
        return AbstractC13042fc3.d(this.a, c12373eW.a) && AbstractC13042fc3.d(this.b, c12373eW.b) && this.c == c12373eW.c;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        C9737aT7 c9737aT7 = this.b;
        return ((iHashCode + (c9737aT7 == null ? 0 : c9737aT7.hashCode())) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "BackupVideoCodec(codec=" + this.a + ", encoding=" + this.b + ", simulcast=" + this.c + ')';
    }

    public /* synthetic */ C12373eW(String str, C9737aT7 c9737aT7, boolean z, int i, ED1 ed1) {
        this((i & 1) != 0 ? "vp8" : str, (i & 2) != 0 ? null : c9737aT7, (i & 4) != 0 ? true : z);
    }
}
