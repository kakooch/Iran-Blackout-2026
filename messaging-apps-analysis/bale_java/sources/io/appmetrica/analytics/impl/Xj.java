package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.impl.EnumC2694m;

/* loaded from: classes3.dex */
public final class Xj {
    public final C2766p a;
    public final C2772p5 b;
    public final InterfaceC2718n c;
    public final InterfaceC2718n d;
    public final r e;
    public final C2670l f;
    public boolean g;

    public Xj(C2766p c2766p, C2670l c2670l) {
        this(c2766p, c2670l, new C2772p5(), new r());
    }

    public final void a(final Activity activity, EnumC2694m enumC2694m) {
        synchronized (this) {
            try {
                if (this.g) {
                    C2772p5 c2772p5 = this.b;
                    InterfaceC2851sd interfaceC2851sd = new InterfaceC2851sd() { // from class: ir.nasim.nc8
                        @Override // io.appmetrica.analytics.impl.InterfaceC2851sd
                        public final void consume(Object obj) {
                            this.a.a(activity, (io.appmetrica.analytics.impl.Ub) obj);
                        }
                    };
                    c2772p5.getClass();
                    C2747o4.g().c.a().execute(new RunnableC2748o5(c2772p5, interfaceC2851sd));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(final Activity activity, EnumC2694m enumC2694m) {
        synchronized (this) {
            try {
                if (this.g) {
                    C2772p5 c2772p5 = this.b;
                    InterfaceC2851sd interfaceC2851sd = new InterfaceC2851sd() { // from class: ir.nasim.oc8
                        @Override // io.appmetrica.analytics.impl.InterfaceC2851sd
                        public final void consume(Object obj) {
                            this.a.b(activity, (io.appmetrica.analytics.impl.Ub) obj);
                        }
                    };
                    c2772p5.getClass();
                    C2747o4.g().c.a().execute(new RunnableC2748o5(c2772p5, interfaceC2851sd));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Xj(C2766p c2766p, C2670l c2670l, C2772p5 c2772p5, r rVar) {
        this.g = false;
        this.a = c2766p;
        this.f = c2670l;
        this.b = c2772p5;
        this.e = rVar;
        this.c = new InterfaceC2718n() { // from class: ir.nasim.lc8
            @Override // io.appmetrica.analytics.impl.InterfaceC2718n
            public final void a(Activity activity, EnumC2694m enumC2694m) {
                this.a.a(activity, enumC2694m);
            }
        };
        this.d = new InterfaceC2718n() { // from class: ir.nasim.mc8
            @Override // io.appmetrica.analytics.impl.InterfaceC2718n
            public final void a(Activity activity, EnumC2694m enumC2694m) {
                this.a.b(activity, enumC2694m);
            }
        };
    }

    public final synchronized EnumC2742o a() {
        try {
            if (!this.g) {
                this.a.a(this.c, EnumC2694m.RESUMED);
                this.a.a(this.d, EnumC2694m.PAUSED);
                this.g = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.a.b;
    }

    public final void b(Activity activity, Ub ub) {
        if (this.e.a(activity, EnumC2790q.PAUSED)) {
            ub.b(activity);
        }
    }

    public final void a(Activity activity, Ub ub) {
        if (this.e.a(activity, EnumC2790q.RESUMED)) {
            ub.a(activity);
        }
    }
}
