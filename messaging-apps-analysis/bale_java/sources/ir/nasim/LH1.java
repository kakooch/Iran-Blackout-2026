package ir.nasim;

/* loaded from: classes2.dex */
public final class LH1 implements InterfaceC18081o32 {
    private final int a;
    private final int b;

    public LH1(int i, int i2) {
        this.a = i;
        this.b = i2;
        if (i >= 0 && i2 >= 0) {
            return;
        }
        N73.a("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i2 + " respectively.");
    }

    @Override // ir.nasim.InterfaceC18081o32
    public void a(M42 m42) {
        int i = this.a;
        int i2 = 0;
        int i3 = 0;
        int iK = 0;
        while (true) {
            if (i3 < i) {
                int i4 = iK + 1;
                if (m42.k() <= i4) {
                    iK = m42.k();
                    break;
                } else {
                    iK = AbstractC18672p32.b(m42.c((m42.k() - i4) + (-1)), m42.c(m42.k() - i4)) ? iK + 2 : i4;
                    i3++;
                }
            } else {
                break;
            }
        }
        int i5 = this.b;
        int iH = 0;
        while (true) {
            if (i2 >= i5) {
                break;
            }
            int i6 = iH + 1;
            if (m42.j() + i6 >= m42.h()) {
                iH = m42.h() - m42.j();
                break;
            } else {
                iH = AbstractC18672p32.b(m42.c((m42.j() + i6) + (-1)), m42.c(m42.j() + i6)) ? iH + 2 : i6;
                i2++;
            }
        }
        m42.b(m42.j(), m42.j() + iH);
        m42.b(m42.k() - iK, m42.k());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LH1)) {
            return false;
        }
        LH1 lh1 = (LH1) obj;
        return this.a == lh1.a && this.b == lh1.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=" + this.a + ", lengthAfterCursor=" + this.b + ')';
    }
}
