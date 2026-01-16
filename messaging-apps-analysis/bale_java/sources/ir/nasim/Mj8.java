package ir.nasim;

/* loaded from: classes3.dex */
final class Mj8 implements Rj8 {
    private final C20322ro8 a;
    private final String b;

    public Mj8(C20322ro8 c20322ro8, String str) {
        this.a = c20322ro8;
        this.b = str;
    }

    @Override // ir.nasim.Rj8
    public final C20322ro8 a(InterfaceC22720vi8 interfaceC22720vi8) {
        C20322ro8 c20322ro8A = this.a.a();
        c20322ro8A.e(this.b, interfaceC22720vi8);
        return c20322ro8A;
    }
}
