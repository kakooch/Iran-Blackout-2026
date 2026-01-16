package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import ir.nasim.AbstractC23175wU1;
import ir.nasim.AbstractC6037Lx1;
import ir.nasim.C11598dH2;
import ir.nasim.C20107rU5;
import ir.nasim.C3563Bj7;
import ir.nasim.EnumC6212Mq5;
import ir.nasim.InterfaceC11426cz3;
import ir.nasim.InterfaceC12970fU5;
import ir.nasim.InterfaceC17451mz3;
import ir.nasim.InterfaceC21549tj7;
import ir.nasim.InterfaceC22855vv7;
import ir.nasim.InterfaceC4439Fd1;
import ir.nasim.InterfaceC4688Gd1;
import ir.nasim.PV5;
import ir.nasim.RP5;
import ir.nasim.YM7;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class h implements ComponentCallbacks2, InterfaceC17451mz3 {
    private static final C20107rU5 m = (C20107rU5) C20107rU5.D0(Bitmap.class).W();
    private static final C20107rU5 n = (C20107rU5) C20107rU5.D0(C11598dH2.class).W();
    private static final C20107rU5 o = (C20107rU5) ((C20107rU5) C20107rU5.E0(AbstractC23175wU1.c).g0(EnumC6212Mq5.LOW)).p0(true);
    protected final com.bumptech.glide.b a;
    protected final Context b;
    final InterfaceC11426cz3 c;
    private final PV5 d;
    private final InterfaceC12970fU5 e;
    private final C3563Bj7 f;
    private final Runnable g;
    private final InterfaceC4439Fd1 h;
    private final CopyOnWriteArrayList i;
    private C20107rU5 j;
    private boolean k;
    private boolean l;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.c.a(hVar);
        }
    }

    private class c implements InterfaceC4439Fd1.a {
        private final PV5 a;

        c(PV5 pv5) {
            this.a = pv5;
        }

        @Override // ir.nasim.InterfaceC4439Fd1.a
        public void a(boolean z) {
            if (z) {
                synchronized (h.this) {
                    this.a.e();
                }
            }
        }
    }

    public h(com.bumptech.glide.b bVar, InterfaceC11426cz3 interfaceC11426cz3, InterfaceC12970fU5 interfaceC12970fU5, Context context) {
        this(bVar, interfaceC11426cz3, interfaceC12970fU5, new PV5(), bVar.g(), context);
    }

    private void H(InterfaceC21549tj7 interfaceC21549tj7) {
        boolean zG = G(interfaceC21549tj7);
        RP5 request = interfaceC21549tj7.getRequest();
        if (zG || this.a.p(interfaceC21549tj7) || request == null) {
            return;
        }
        interfaceC21549tj7.l(null);
        request.clear();
    }

    private synchronized void p() {
        try {
            Iterator it = this.f.d().iterator();
            while (it.hasNext()) {
                o((InterfaceC21549tj7) it.next());
            }
            this.f.b();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void A() {
        this.d.c();
    }

    public synchronized void B() {
        A();
        Iterator it = this.e.a().iterator();
        while (it.hasNext()) {
            ((h) it.next()).A();
        }
    }

    public synchronized void C() {
        this.d.d();
    }

    public synchronized void D() {
        this.d.f();
    }

    protected synchronized void E(C20107rU5 c20107rU5) {
        this.j = (C20107rU5) ((C20107rU5) c20107rU5.clone()).c();
    }

    synchronized void F(InterfaceC21549tj7 interfaceC21549tj7, RP5 rp5) {
        this.f.j(interfaceC21549tj7);
        this.d.g(rp5);
    }

    synchronized boolean G(InterfaceC21549tj7 interfaceC21549tj7) {
        RP5 request = interfaceC21549tj7.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.d.a(request)) {
            return false;
        }
        this.f.m(interfaceC21549tj7);
        interfaceC21549tj7.l(null);
        return true;
    }

    public g b(Class cls) {
        return new g(this.a, this, cls, this.b);
    }

    public g d() {
        return b(Bitmap.class).b(m);
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public synchronized void f() {
        D();
        this.f.f();
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public synchronized void i() {
        try {
            this.f.i();
            if (this.l) {
                p();
            } else {
                C();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public g j() {
        return b(Drawable.class);
    }

    public g m() {
        return b(C11598dH2.class).b(n);
    }

    public void n(View view) {
        o(new b(view));
    }

    public void o(InterfaceC21549tj7 interfaceC21549tj7) {
        if (interfaceC21549tj7 == null) {
            return;
        }
        H(interfaceC21549tj7);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // ir.nasim.InterfaceC17451mz3
    public synchronized void onDestroy() {
        this.f.onDestroy();
        p();
        this.d.b();
        this.c.b(this);
        this.c.b(this.h);
        YM7.x(this.g);
        this.a.s(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.k) {
            B();
        }
    }

    List q() {
        return this.i;
    }

    synchronized C20107rU5 r() {
        return this.j;
    }

    i s(Class cls) {
        return this.a.i().e(cls);
    }

    public g t(Bitmap bitmap) {
        return j().T0(bitmap);
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.d + ", treeNode=" + this.e + "}";
    }

    public g u(Drawable drawable) {
        return j().U0(drawable);
    }

    public g v(Uri uri) {
        return j().V0(uri);
    }

    public g w(Integer num) {
        return j().W0(num);
    }

    public g x(Object obj) {
        return j().Y0(obj);
    }

    public g y(String str) {
        return j().Z0(str);
    }

    public g z(byte[] bArr) {
        return j().b1(bArr);
    }

    h(com.bumptech.glide.b bVar, InterfaceC11426cz3 interfaceC11426cz3, InterfaceC12970fU5 interfaceC12970fU5, PV5 pv5, InterfaceC4688Gd1 interfaceC4688Gd1, Context context) {
        this.f = new C3563Bj7();
        a aVar = new a();
        this.g = aVar;
        this.a = bVar;
        this.c = interfaceC11426cz3;
        this.e = interfaceC12970fU5;
        this.d = pv5;
        this.b = context;
        InterfaceC4439Fd1 interfaceC4439Fd1A = interfaceC4688Gd1.a(context.getApplicationContext(), new c(pv5));
        this.h = interfaceC4439Fd1A;
        bVar.o(this);
        if (YM7.s()) {
            YM7.w(aVar);
        } else {
            interfaceC11426cz3.a(this);
        }
        interfaceC11426cz3.a(interfaceC4439Fd1A);
        this.i = new CopyOnWriteArrayList(bVar.i().c());
        E(bVar.i().d());
    }

    private static class b extends AbstractC6037Lx1 {
        b(View view) {
            super(view);
        }

        @Override // ir.nasim.InterfaceC21549tj7
        public void k(Drawable drawable) {
        }

        @Override // ir.nasim.AbstractC6037Lx1
        protected void m(Drawable drawable) {
        }

        @Override // ir.nasim.InterfaceC21549tj7
        public void a(Object obj, InterfaceC22855vv7 interfaceC22855vv7) {
        }
    }
}
