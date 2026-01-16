package ir.nasim;

/* renamed from: ir.nasim.zV, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C24956zV implements InterfaceC23772xV {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    private C24956zV(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static C24956zV b(EW4 ew4) {
        int iS = ew4.s();
        ew4.T(8);
        int iS2 = ew4.s();
        int iS3 = ew4.s();
        ew4.T(4);
        int iS4 = ew4.s();
        ew4.T(12);
        return new C24956zV(iS, iS2, iS3, iS4);
    }

    public boolean a() {
        return (this.b & 16) == 16;
    }

    @Override // ir.nasim.InterfaceC23772xV
    public int getType() {
        return 1751742049;
    }
}
