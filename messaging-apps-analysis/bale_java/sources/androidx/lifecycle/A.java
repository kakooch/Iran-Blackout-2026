package androidx.lifecycle;

import androidx.lifecycle.j;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C7289Rb6;
import ir.nasim.InterfaceC18633oz3;
import java.io.Closeable;

/* loaded from: classes2.dex */
public final class A implements n, Closeable {
    private final String a;
    private final y b;
    private boolean c;

    public A(String str, y yVar) {
        AbstractC13042fc3.i(str, "key");
        AbstractC13042fc3.i(yVar, "handle");
        this.a = str;
        this.b = yVar;
    }

    public final void a(C7289Rb6 c7289Rb6, j jVar) {
        AbstractC13042fc3.i(c7289Rb6, "registry");
        AbstractC13042fc3.i(jVar, "lifecycle");
        if (!(!this.c)) {
            throw new IllegalStateException("Already attached to lifecycleOwner".toString());
        }
        this.c = true;
        jVar.a(this);
        c7289Rb6.h(this.a, this.b.e());
    }

    public final y b() {
        return this.b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final boolean d() {
        return this.c;
    }

    @Override // androidx.lifecycle.n
    public void s(InterfaceC18633oz3 interfaceC18633oz3, j.a aVar) {
        AbstractC13042fc3.i(interfaceC18633oz3, "source");
        AbstractC13042fc3.i(aVar, "event");
        if (aVar == j.a.ON_DESTROY) {
            this.c = false;
            interfaceC18633oz3.getLifecycle().d(this);
        }
    }
}
