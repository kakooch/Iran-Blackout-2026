package ir.nasim;

/* renamed from: ir.nasim.hu6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14436hu6 implements InterfaceC18081o32 {
    private final int a;
    private final int b;

    public C14436hu6(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // ir.nasim.InterfaceC18081o32
    public void a(M42 m42) {
        if (m42.l()) {
            m42.a();
        }
        int iM = AbstractC23053wG5.m(this.a, 0, m42.h());
        int iM2 = AbstractC23053wG5.m(this.b, 0, m42.h());
        if (iM != iM2) {
            if (iM < iM2) {
                m42.n(iM, iM2);
            } else {
                m42.n(iM2, iM);
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14436hu6)) {
            return false;
        }
        C14436hu6 c14436hu6 = (C14436hu6) obj;
        return this.a == c14436hu6.a && this.b == c14436hu6.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "SetComposingRegionCommand(start=" + this.a + ", end=" + this.b + ')';
    }
}
