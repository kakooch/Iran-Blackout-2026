package ir.nasim;

/* loaded from: classes.dex */
public final class US4 implements TS4 {
    private final float a;
    private final float b;
    private final float c;
    private final float d;

    public /* synthetic */ US4(float f, float f2, float f3, float f4, ED1 ed1) {
        this(f, f2, f3, f4);
    }

    @Override // ir.nasim.TS4
    public float a() {
        return this.d;
    }

    @Override // ir.nasim.TS4
    public float b(EnumC12613eu3 enumC12613eu3) {
        return enumC12613eu3 == EnumC12613eu3.a ? this.c : this.a;
    }

    @Override // ir.nasim.TS4
    public float c() {
        return this.b;
    }

    @Override // ir.nasim.TS4
    public float d(EnumC12613eu3 enumC12613eu3) {
        return enumC12613eu3 == EnumC12613eu3.a ? this.a : this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof US4)) {
            return false;
        }
        US4 us4 = (US4) obj;
        return C17784nZ1.s(this.a, us4.a) && C17784nZ1.s(this.b, us4.b) && C17784nZ1.s(this.c, us4.c) && C17784nZ1.s(this.d, us4.d);
    }

    public int hashCode() {
        return (((((C17784nZ1.t(this.a) * 31) + C17784nZ1.t(this.b)) * 31) + C17784nZ1.t(this.c)) * 31) + C17784nZ1.t(this.d);
    }

    public String toString() {
        return "PaddingValues(start=" + ((Object) C17784nZ1.u(this.a)) + ", top=" + ((Object) C17784nZ1.u(this.b)) + ", end=" + ((Object) C17784nZ1.u(this.c)) + ", bottom=" + ((Object) C17784nZ1.u(this.d)) + ')';
    }

    private US4(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        if (!((f >= 0.0f) & (f2 >= 0.0f) & (f3 >= 0.0f)) || !(f4 >= 0.0f)) {
            K73.a("Padding must be non-negative");
        }
    }
}
