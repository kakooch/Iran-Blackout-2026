package ir.nasim;

/* renamed from: ir.nasim.hs, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14409hs implements A98 {
    private final int b;
    private final String c;
    private final InterfaceC9102Ym4 d = AbstractC13472gH6.d(L93.e, null, 2, null);
    private final InterfaceC9102Ym4 e = AbstractC13472gH6.d(Boolean.TRUE, null, 2, null);

    public C14409hs(int i, String str) {
        this.b = i;
        this.c = str;
    }

    private final void h(boolean z) {
        this.e.setValue(Boolean.valueOf(z));
    }

    @Override // ir.nasim.A98
    public int a(WH1 wh1) {
        return e().b;
    }

    @Override // ir.nasim.A98
    public int b(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        return e().a;
    }

    @Override // ir.nasim.A98
    public int c(WH1 wh1) {
        return e().d;
    }

    @Override // ir.nasim.A98
    public int d(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        return e().c;
    }

    public final L93 e() {
        return (L93) this.d.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C14409hs) && this.b == ((C14409hs) obj).b;
    }

    public final boolean f() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    public final void g(L93 l93) {
        this.d.setValue(l93);
    }

    public int hashCode() {
        return this.b;
    }

    public final void i(O98 o98, int i) {
        if (i == 0 || (i & this.b) != 0) {
            g(o98.f(this.b));
            h(o98.s(this.b));
        }
    }

    public String toString() {
        return this.c + '(' + e().a + ", " + e().b + ", " + e().c + ", " + e().d + ')';
    }
}
