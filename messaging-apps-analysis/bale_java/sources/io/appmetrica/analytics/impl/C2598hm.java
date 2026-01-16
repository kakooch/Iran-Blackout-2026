package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.hm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2598hm implements InterfaceC2905uj {
    public final InterfaceC2992ya a;
    public final Object b = new Object();
    public boolean c = false;
    public final Jk d;

    public C2598hm(InterfaceC2992ya interfaceC2992ya, Jk jk) {
        this.a = interfaceC2992ya;
        this.d = jk;
    }

    public void a() {
    }

    public final void b() {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    e();
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final InterfaceC2992ya c() {
        return this.a;
    }

    public final Jk d() {
        return this.d;
    }

    public final void e() {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f() {
        this.d.a();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2905uj
    public final void onCreate() {
        synchronized (this.b) {
            try {
                if (this.c) {
                    this.c = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2905uj
    public final void onDestroy() {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    a();
                    this.c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
