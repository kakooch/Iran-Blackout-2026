package ir.nasim;

/* renamed from: ir.nasim.gk5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13742gk5 {
    public String a;
    public Long b;

    public C13742gk5(String str, boolean z) {
        this(str, z ? 1L : 0L);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13742gk5)) {
            return false;
        }
        C13742gk5 c13742gk5 = (C13742gk5) obj;
        if (!this.a.equals(c13742gk5.a)) {
            return false;
        }
        Long l = this.b;
        Long l2 = c13742gk5.b;
        return l != null ? l.equals(l2) : l2 == null;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Long l = this.b;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public C13742gk5(String str, long j) {
        this.a = str;
        this.b = Long.valueOf(j);
    }
}
