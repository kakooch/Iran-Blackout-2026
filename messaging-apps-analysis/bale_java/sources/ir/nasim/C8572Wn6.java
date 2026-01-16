package ir.nasim;

import androidx.compose.ui.semantics.SemanticsConfiguration;

/* renamed from: ir.nasim.Wn6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8572Wn6 {
    private final C3419Au3 a;
    private final E72 b;
    private final AbstractC20768sa3 c;
    private final C3587Bm4 d = new C3587Bm4(2);

    public C8572Wn6(C3419Au3 c3419Au3, E72 e72, AbstractC20768sa3 abstractC20768sa3) {
        this.a = c3419Au3;
        this.b = e72;
        this.c = abstractC20768sa3;
    }

    public final InterfaceC5953Ln6 a(int i) {
        return (InterfaceC5953Ln6) this.c.b(i);
    }

    public final C3587Bm4 b() {
        return this.d;
    }

    public final InterfaceC5953Ln6 c() {
        return this.a;
    }

    public final C7631Sn6 d() {
        return new C7631Sn6(this.b, false, this.a, new SemanticsConfiguration());
    }

    public final void e(InterfaceC5953Ln6 interfaceC5953Ln6, SemanticsConfiguration semanticsConfiguration) {
        C3587Bm4 c3587Bm4 = this.d;
        Object[] objArr = c3587Bm4.a;
        int i = c3587Bm4.b;
        for (int i2 = 0; i2 < i; i2++) {
            ((InterfaceC6425Nn6) objArr[i2]).a(interfaceC5953Ln6, semanticsConfiguration);
        }
    }
}
