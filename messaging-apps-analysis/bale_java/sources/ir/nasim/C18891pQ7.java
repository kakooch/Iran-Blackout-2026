package ir.nasim;

/* renamed from: ir.nasim.pQ7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C18891pQ7 implements A98 {
    private final String b;
    private final InterfaceC9102Ym4 c;

    public C18891pQ7(P93 p93, String str) {
        this.b = str;
        this.c = AbstractC13472gH6.d(p93, null, 2, null);
    }

    @Override // ir.nasim.A98
    public int a(WH1 wh1) {
        return e().d();
    }

    @Override // ir.nasim.A98
    public int b(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        return e().b();
    }

    @Override // ir.nasim.A98
    public int c(WH1 wh1) {
        return e().a();
    }

    @Override // ir.nasim.A98
    public int d(WH1 wh1, EnumC12613eu3 enumC12613eu3) {
        return e().c();
    }

    public final P93 e() {
        return (P93) this.c.getValue();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C18891pQ7) {
            return AbstractC13042fc3.d(e(), ((C18891pQ7) obj).e());
        }
        return false;
    }

    public final void f(P93 p93) {
        this.c.setValue(p93);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return this.b + "(left=" + e().b() + ", top=" + e().d() + ", right=" + e().c() + ", bottom=" + e().a() + ')';
    }
}
