package com.google.crypto.tink.internal;

import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.internal.c;
import ir.nasim.AbstractC14981io3;
import ir.nasim.AbstractC20124rW4;
import ir.nasim.AbstractC21353tW4;
import ir.nasim.AbstractC22010uW4;
import ir.nasim.AbstractC4789Go3;
import ir.nasim.C19060pi6;
import ir.nasim.C19799qx5;
import ir.nasim.C22275ux5;
import ir.nasim.C6048Ly3;
import ir.nasim.C6282My3;
import ir.nasim.C9882aj;
import ir.nasim.InterfaceC20931sq6;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class b {
    private static final b b = (b) TinkBugException.a(new TinkBugException.a() { // from class: ir.nasim.Tm4
        @Override // com.google.crypto.tink.internal.TinkBugException.a
        public final Object get() {
            return com.google.crypto.tink.internal.b.b();
        }
    });
    private final AtomicReference a = new AtomicReference(new c.b().e());

    /* JADX INFO: Access modifiers changed from: private */
    public static b b() {
        b bVar = new b();
        bVar.k(a.a(new C9882aj(), C6048Ly3.class, C19799qx5.class));
        return bVar;
    }

    public static b c() {
        return b;
    }

    public boolean d(InterfaceC20931sq6 interfaceC20931sq6) {
        return ((c) this.a.get()).e(interfaceC20931sq6);
    }

    public boolean e(InterfaceC20931sq6 interfaceC20931sq6) {
        return ((c) this.a.get()).f(interfaceC20931sq6);
    }

    public AbstractC14981io3 f(InterfaceC20931sq6 interfaceC20931sq6, C19060pi6 c19060pi6) {
        return ((c) this.a.get()).g(interfaceC20931sq6, c19060pi6);
    }

    public AbstractC14981io3 g(C19799qx5 c19799qx5, C19060pi6 c19060pi6) {
        return !d(c19799qx5) ? new C6048Ly3(c19799qx5, c19060pi6) : f(c19799qx5, c19060pi6);
    }

    public AbstractC20124rW4 h(InterfaceC20931sq6 interfaceC20931sq6) {
        return ((c) this.a.get()).h(interfaceC20931sq6);
    }

    public AbstractC20124rW4 i(C22275ux5 c22275ux5) {
        return !e(c22275ux5) ? new C6282My3(c22275ux5) : h(c22275ux5);
    }

    public synchronized void j(AbstractC4789Go3 abstractC4789Go3) {
        this.a.set(new c.b((c) this.a.get()).f(abstractC4789Go3).e());
    }

    public synchronized void k(a aVar) {
        this.a.set(new c.b((c) this.a.get()).g(aVar).e());
    }

    public synchronized void l(AbstractC21353tW4 abstractC21353tW4) {
        this.a.set(new c.b((c) this.a.get()).h(abstractC21353tW4).e());
    }

    public synchronized void m(AbstractC22010uW4 abstractC22010uW4) {
        this.a.set(new c.b((c) this.a.get()).i(abstractC22010uW4).e());
    }

    public InterfaceC20931sq6 n(AbstractC20124rW4 abstractC20124rW4, Class cls) {
        return ((c) this.a.get()).i(abstractC20124rW4, cls);
    }
}
