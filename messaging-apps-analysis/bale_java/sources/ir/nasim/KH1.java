package ir.nasim;

/* loaded from: classes2.dex */
public final class KH1 implements InterfaceC18081o32 {
    private final int a;
    private final int b;

    public KH1(int i, int i2) {
        this.a = i;
        this.b = i2;
        if (i >= 0 && i2 >= 0) {
            return;
        }
        N73.a("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.");
    }

    @Override // ir.nasim.InterfaceC18081o32
    public void a(M42 m42) {
        int iJ = m42.j();
        int i = this.b;
        int iH = iJ + i;
        if (((iJ ^ iH) & (i ^ iH)) < 0) {
            iH = m42.h();
        }
        m42.b(m42.j(), Math.min(iH, m42.h()));
        int iK = m42.k();
        int i2 = this.a;
        int i3 = iK - i2;
        if (((iK ^ i3) & (i2 ^ iK)) < 0) {
            i3 = 0;
        }
        m42.b(Math.max(0, i3), m42.k());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KH1)) {
            return false;
        }
        KH1 kh1 = (KH1) obj;
        return this.a == kh1.a && this.b == kh1.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "DeleteSurroundingTextCommand(lengthBeforeCursor=" + this.a + ", lengthAfterCursor=" + this.b + ')';
    }
}
