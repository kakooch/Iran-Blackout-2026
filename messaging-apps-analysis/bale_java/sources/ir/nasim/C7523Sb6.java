package ir.nasim;

import android.os.Bundle;
import androidx.lifecycle.j;

/* renamed from: ir.nasim.Sb6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7523Sb6 {
    public static final a d = new a(null);
    private final InterfaceC7760Tb6 a;
    private final C7289Rb6 b;
    private boolean c;

    /* renamed from: ir.nasim.Sb6$a */
    public static final class a {
        private a() {
        }

        public final C7523Sb6 a(InterfaceC7760Tb6 interfaceC7760Tb6) {
            AbstractC13042fc3.i(interfaceC7760Tb6, "owner");
            return new C7523Sb6(interfaceC7760Tb6, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C7523Sb6(InterfaceC7760Tb6 interfaceC7760Tb6, ED1 ed1) {
        this(interfaceC7760Tb6);
    }

    public static final C7523Sb6 a(InterfaceC7760Tb6 interfaceC7760Tb6) {
        return d.a(interfaceC7760Tb6);
    }

    public final C7289Rb6 b() {
        return this.b;
    }

    public final void c() {
        androidx.lifecycle.j lifecycle = this.a.getLifecycle();
        if (lifecycle.b() != j.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        lifecycle.a(new BK5(this.a));
        this.b.e(lifecycle);
        this.c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.c) {
            c();
        }
        androidx.lifecycle.j lifecycle = this.a.getLifecycle();
        if (!lifecycle.b().j(j.b.STARTED)) {
            this.b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle bundle) {
        AbstractC13042fc3.i(bundle, "outBundle");
        this.b.g(bundle);
    }

    private C7523Sb6(InterfaceC7760Tb6 interfaceC7760Tb6) {
        this.a = interfaceC7760Tb6;
        this.b = new C7289Rb6();
    }
}
