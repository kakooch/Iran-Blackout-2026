package ir.nasim;

/* loaded from: classes2.dex */
final class AV implements InterfaceC23772xV {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    private AV(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
    }

    public static AV c(EW4 ew4) {
        int iS = ew4.s();
        ew4.T(12);
        int iS2 = ew4.s();
        int iS3 = ew4.s();
        int iS4 = ew4.s();
        ew4.T(4);
        int iS5 = ew4.s();
        int iS6 = ew4.s();
        ew4.T(8);
        return new AV(iS, iS2, iS3, iS4, iS5, iS6);
    }

    public long a() {
        return AbstractC9683aN7.N0(this.e, this.c * 1000000, this.d);
    }

    public int b() {
        int i = this.a;
        if (i == 1935960438) {
            return 2;
        }
        if (i == 1935963489) {
            return 1;
        }
        if (i == 1937012852) {
            return 3;
        }
        AbstractC18815pI3.k("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.a));
        return -1;
    }

    @Override // ir.nasim.InterfaceC23772xV
    public int getType() {
        return 1752331379;
    }
}
