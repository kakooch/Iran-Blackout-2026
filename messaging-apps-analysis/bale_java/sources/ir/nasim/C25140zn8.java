package ir.nasim;

import com.google.android.gms.internal.measurement.C2135n0;
import java.util.concurrent.Callable;

/* renamed from: ir.nasim.zn8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C25140zn8 {
    final Oi8 a;
    final C20322ro8 b;
    final C20322ro8 c;
    final Iq8 d;

    public C25140zn8() {
        Oi8 oi8 = new Oi8();
        this.a = oi8;
        C20322ro8 c20322ro8 = new C20322ro8(null, oi8);
        this.c = c20322ro8;
        this.b = c20322ro8.a();
        Iq8 iq8 = new Iq8();
        this.d = iq8;
        c20322ro8.g("require", new wv8(iq8));
        iq8.a("internal.platform", new Callable() { // from class: ir.nasim.bn8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new Kv8();
            }
        });
        c20322ro8.g("runtime.counter", new Ph8(Double.valueOf(0.0d)));
    }

    public final InterfaceC22720vi8 a(C20322ro8 c20322ro8, C2135n0... c2135n0Arr) {
        InterfaceC22720vi8 interfaceC22720vi8A = InterfaceC22720vi8.r0;
        for (C2135n0 c2135n0 : c2135n0Arr) {
            interfaceC22720vi8A = Yp8.a(c2135n0);
            AbstractC9951ap8.c(this.c);
            if ((interfaceC22720vi8A instanceof C23906xi8) || (interfaceC22720vi8A instanceof C20853si8)) {
                interfaceC22720vi8A = this.a.a(c20322ro8, interfaceC22720vi8A);
            }
        }
        return interfaceC22720vi8A;
    }
}
