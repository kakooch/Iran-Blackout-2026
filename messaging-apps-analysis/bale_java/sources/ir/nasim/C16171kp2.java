package ir.nasim;

/* renamed from: ir.nasim.kp2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C16171kp2 implements A98 {
    private final float b;
    private final float c;
    private final float d;
    private final float e;

    public /* synthetic */ C16171kp2(float f, float f2, float f3, float f4, ED1 ed1) {
        this(f, f2, f3, f4);
    }

    @Override // ir.nasim.A98
    public int a(WH1 wh1) {
        return wh1.B0(this.c);
    }

    @Override // ir.nasim.A98
    public int b(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        return wh1.B0(this.b);
    }

    @Override // ir.nasim.A98
    public int c(WH1 wh1) {
        return wh1.B0(this.e);
    }

    @Override // ir.nasim.A98
    public int d(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        return wh1.B0(this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16171kp2)) {
            return false;
        }
        C16171kp2 c16171kp2 = (C16171kp2) obj;
        return C17784nZ1.s(this.b, c16171kp2.b) && C17784nZ1.s(this.c, c16171kp2.c) && C17784nZ1.s(this.d, c16171kp2.d) && C17784nZ1.s(this.e, c16171kp2.e);
    }

    public int hashCode() {
        return (((((C17784nZ1.t(this.b) * 31) + C17784nZ1.t(this.c)) * 31) + C17784nZ1.t(this.d)) * 31) + C17784nZ1.t(this.e);
    }

    public String toString() {
        return "Insets(left=" + ((Object) C17784nZ1.u(this.b)) + ", top=" + ((Object) C17784nZ1.u(this.c)) + ", right=" + ((Object) C17784nZ1.u(this.d)) + ", bottom=" + ((Object) C17784nZ1.u(this.e)) + ')';
    }

    private C16171kp2(float f, float f2, float f3, float f4) {
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
    }
}
