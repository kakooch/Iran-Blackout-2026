package ir.nasim;

/* renamed from: ir.nasim.xu6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24024xu6 implements InterfaceC18081o32 {
    private final int a;
    private final int b;

    public C24024xu6(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // ir.nasim.InterfaceC18081o32
    public void a(M42 m42) {
        int iM = AbstractC23053wG5.m(this.a, 0, m42.h());
        int iM2 = AbstractC23053wG5.m(this.b, 0, m42.h());
        if (iM < iM2) {
            m42.p(iM, iM2);
        } else {
            m42.p(iM2, iM);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24024xu6)) {
            return false;
        }
        C24024xu6 c24024xu6 = (C24024xu6) obj;
        return this.a == c24024xu6.a && this.b == c24024xu6.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "SetSelectionCommand(start=" + this.a + ", end=" + this.b + ')';
    }
}
