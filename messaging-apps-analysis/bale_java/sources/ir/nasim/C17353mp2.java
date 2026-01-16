package ir.nasim;

/* renamed from: ir.nasim.mp2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C17353mp2 implements A98 {
    private final int b;
    private final int c;
    private final int d;
    private final int e;

    public C17353mp2(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    @Override // ir.nasim.A98
    public int a(WH1 wh1) {
        return this.c;
    }

    @Override // ir.nasim.A98
    public int b(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        return this.b;
    }

    @Override // ir.nasim.A98
    public int c(WH1 wh1) {
        return this.e;
    }

    @Override // ir.nasim.A98
    public int d(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17353mp2)) {
            return false;
        }
        C17353mp2 c17353mp2 = (C17353mp2) obj;
        return this.b == c17353mp2.b && this.c == c17353mp2.c && this.d == c17353mp2.d && this.e == c17353mp2.e;
    }

    public int hashCode() {
        return (((((this.b * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        return "Insets(left=" + this.b + ", top=" + this.c + ", right=" + this.d + ", bottom=" + this.e + ')';
    }
}
