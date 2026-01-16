package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.G;
import androidx.lifecycle.j;
import ir.nasim.AbstractC20375ru1;
import ir.nasim.C13170fm4;
import ir.nasim.C14819iX7;
import ir.nasim.C7289Rb6;
import ir.nasim.C7523Sb6;
import ir.nasim.InterfaceC15408jX7;
import ir.nasim.InterfaceC7760Tb6;

/* loaded from: classes2.dex */
class B implements androidx.lifecycle.h, InterfaceC7760Tb6, InterfaceC15408jX7 {
    private final Fragment a;
    private final C14819iX7 b;
    private final Runnable c;
    private G.c d;
    private androidx.lifecycle.p e = null;
    private C7523Sb6 f = null;

    B(Fragment fragment, C14819iX7 c14819iX7, Runnable runnable) {
        this.a = fragment;
        this.b = c14819iX7;
        this.c = runnable;
    }

    void a(j.a aVar) {
        this.e.i(aVar);
    }

    void b() {
        if (this.e == null) {
            this.e = new androidx.lifecycle.p(this);
            C7523Sb6 c7523Sb6A = C7523Sb6.a(this);
            this.f = c7523Sb6A;
            c7523Sb6A.c();
            this.c.run();
        }
    }

    boolean c() {
        return this.e != null;
    }

    void d(Bundle bundle) {
        this.f.d(bundle);
    }

    @Override // ir.nasim.InterfaceC15408jX7
    public C14819iX7 d1() {
        b();
        return this.b;
    }

    void e(Bundle bundle) {
        this.f.e(bundle);
    }

    void f(j.b bVar) {
        this.e.n(bVar);
    }

    @Override // ir.nasim.InterfaceC18633oz3
    public androidx.lifecycle.j getLifecycle() {
        b();
        return this.e;
    }

    @Override // androidx.lifecycle.h
    public G.c n3() {
        Application application;
        G.c cVarN3 = this.a.n3();
        if (!cVarN3.equals(this.a.P0)) {
            this.d = cVarN3;
            return cVarN3;
        }
        if (this.d == null) {
            Context applicationContext = this.a.S7().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            Fragment fragment = this.a;
            this.d = new androidx.lifecycle.C(application, fragment, fragment.E5());
        }
        return this.d;
    }

    @Override // androidx.lifecycle.h
    public AbstractC20375ru1 p3() {
        Application application;
        Context applicationContext = this.a.S7().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        C13170fm4 c13170fm4 = new C13170fm4();
        if (application != null) {
            c13170fm4.c(G.a.h, application);
        }
        c13170fm4.c(androidx.lifecycle.B.a, this.a);
        c13170fm4.c(androidx.lifecycle.B.b, this);
        if (this.a.E5() != null) {
            c13170fm4.c(androidx.lifecycle.B.c, this.a.E5());
        }
        return c13170fm4;
    }

    @Override // ir.nasim.InterfaceC7760Tb6
    public C7289Rb6 v1() {
        b();
        return this.f.b();
    }
}
