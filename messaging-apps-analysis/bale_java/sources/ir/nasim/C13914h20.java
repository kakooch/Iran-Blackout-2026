package ir.nasim;

import android.graphics.Bitmap;
import ir.nasim.W10;

/* renamed from: ir.nasim.h20, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13914h20 {
    private final InterfaceC9102Ym4 a;
    private final InterfaceC9102Ym4 b;
    private final InterfaceC9102Ym4 c;
    private final InterfaceC9102Ym4 d;
    private final InterfaceC9102Ym4 e;
    private final C14063hH6 f;

    public C13914h20(V10 v10) {
        AbstractC13042fc3.i(v10, "webContent");
        this.a = AbstractC13472gH6.d(null, null, 2, null);
        this.b = AbstractC13472gH6.d(v10, null, 2, null);
        this.c = AbstractC13472gH6.d(W10.b.a, null, 2, null);
        this.d = AbstractC13472gH6.d(null, null, 2, null);
        this.e = AbstractC13472gH6.d(null, null, 2, null);
        this.f = AbstractC10222bH6.f();
    }

    public final V10 a() {
        return (V10) this.b.getValue();
    }

    public final C14063hH6 b() {
        return this.f;
    }

    public final W10 c() {
        return (W10) this.c.getValue();
    }

    public final void d(V10 v10) {
        AbstractC13042fc3.i(v10, "<set-?>");
        this.b.setValue(v10);
    }

    public final void e(String str) {
        this.a.setValue(str);
    }

    public final void f(W10 w10) {
        AbstractC13042fc3.i(w10, "<set-?>");
        this.c.setValue(w10);
    }

    public final void g(Bitmap bitmap) {
        this.e.setValue(bitmap);
    }

    public final void h(String str) {
        this.d.setValue(str);
    }
}
