package ir.nasim;

/* renamed from: ir.nasim.Kx1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5804Kx1 implements InterfaceC18336oU7 {
    private final AS7 a;
    private final C9737aT7 b;

    public C5804Kx1(AS7 as7, C9737aT7 c9737aT7) {
        AbstractC13042fc3.i(as7, "capture");
        AbstractC13042fc3.i(c9737aT7, "encoding");
        this.a = as7;
        this.b = c9737aT7;
    }

    @Override // ir.nasim.InterfaceC18336oU7
    public AS7 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5804Kx1)) {
            return false;
        }
        C5804Kx1 c5804Kx1 = (C5804Kx1) obj;
        return AbstractC13042fc3.d(this.a, c5804Kx1.a) && AbstractC13042fc3.d(this.b, c5804Kx1.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    @Override // ir.nasim.InterfaceC18336oU7
    public C9737aT7 j() {
        return this.b;
    }

    public String toString() {
        return "CustomVideoPreset(capture=" + this.a + ", encoding=" + this.b + ')';
    }
}
