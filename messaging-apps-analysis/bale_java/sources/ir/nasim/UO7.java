package ir.nasim;

/* loaded from: classes.dex */
final class UO7 implements InterfaceC11600dH4 {
    private final InterfaceC11600dH4 b;
    private final int c;
    private final int d;

    public UO7(InterfaceC11600dH4 interfaceC11600dH4, int i, int i2) {
        this.b = interfaceC11600dH4;
        this.c = i;
        this.d = i2;
    }

    @Override // ir.nasim.InterfaceC11600dH4
    public int a(int i) {
        int iA = this.b.a(i);
        if (i >= 0 && i <= this.d) {
            VO7.h(iA, this.c, i);
        }
        return iA;
    }

    @Override // ir.nasim.InterfaceC11600dH4
    public int b(int i) {
        int iB = this.b.b(i);
        if (i >= 0 && i <= this.c) {
            VO7.g(iB, this.d, i);
        }
        return iB;
    }
}
