package ir.nasim;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import ir.nasim.C15937kR;
import ir.nasim.C3520Bf0;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.Cf0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C3754Cf0 extends VW7 {
    private Executor b;
    private C3520Bf0.a c;
    private C3520Bf0.d d;
    private C3520Bf0.c e;
    private C15937kR f;
    private RE0 g;
    private DialogInterface.OnClickListener h;
    private CharSequence i;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private C20298rm4 p;
    private C20298rm4 q;
    private C20298rm4 r;
    private C20298rm4 s;
    private C20298rm4 t;
    private C20298rm4 v;
    private C20298rm4 x;
    private C20298rm4 y;
    private int j = 0;
    private boolean u = true;
    private int w = 0;

    /* renamed from: ir.nasim.Cf0$a */
    class a extends C3520Bf0.a {
        a() {
        }
    }

    /* renamed from: ir.nasim.Cf0$b */
    private static final class b extends C15937kR.d {
        private final WeakReference a;

        b(C3754Cf0 c3754Cf0) {
            this.a = new WeakReference(c3754Cf0);
        }

        @Override // ir.nasim.C15937kR.d
        void a(int i, CharSequence charSequence) {
            if (this.a.get() == null || ((C3754Cf0) this.a.get()).m1() || !((C3754Cf0) this.a.get()).k1()) {
                return;
            }
            ((C3754Cf0) this.a.get()).v1(new C24458yf0(i, charSequence));
        }

        @Override // ir.nasim.C15937kR.d
        void b() {
            if (this.a.get() == null || !((C3754Cf0) this.a.get()).k1()) {
                return;
            }
            ((C3754Cf0) this.a.get()).w1(true);
        }

        @Override // ir.nasim.C15937kR.d
        void c(CharSequence charSequence) {
            if (this.a.get() != null) {
                ((C3754Cf0) this.a.get()).x1(charSequence);
            }
        }

        @Override // ir.nasim.C15937kR.d
        void d(C3520Bf0.b bVar) {
            if (this.a.get() == null || !((C3754Cf0) this.a.get()).k1()) {
                return;
            }
            if (bVar.a() == -1) {
                bVar = new C3520Bf0.b(bVar.b(), ((C3754Cf0) this.a.get()).e1());
            }
            ((C3754Cf0) this.a.get()).y1(bVar);
        }
    }

    /* renamed from: ir.nasim.Cf0$c */
    private static class c implements Executor {
        private final Handler a = new Handler(Looper.getMainLooper());

        c() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }

    /* renamed from: ir.nasim.Cf0$d */
    private static class d implements DialogInterface.OnClickListener {
        private final WeakReference a;

        d(C3754Cf0 c3754Cf0) {
            this.a = new WeakReference(c3754Cf0);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.a.get() != null) {
                ((C3754Cf0) this.a.get()).M1(true);
            }
        }
    }

    private static void Q1(C20298rm4 c20298rm4, Object obj) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            c20298rm4.p(obj);
        } else {
            c20298rm4.n(obj);
        }
    }

    void A1(int i) {
        this.j = i;
    }

    void B1(C3520Bf0.a aVar) {
        this.c = aVar;
    }

    void C1(Executor executor) {
        this.b = executor;
    }

    void D1(boolean z) {
        this.m = z;
    }

    void E1(C3520Bf0.c cVar) {
        this.e = cVar;
    }

    void F1(boolean z) {
        this.n = z;
    }

    void G1(boolean z) {
        if (this.v == null) {
            this.v = new C20298rm4();
        }
        Q1(this.v, Boolean.valueOf(z));
    }

    void H1(boolean z) {
        this.u = z;
    }

    void I1(CharSequence charSequence) {
        if (this.y == null) {
            this.y = new C20298rm4();
        }
        Q1(this.y, charSequence);
    }

    void J1(int i) {
        this.w = i;
    }

    void K1(int i) {
        if (this.x == null) {
            this.x = new C20298rm4();
        }
        Q1(this.x, Integer.valueOf(i));
    }

    void L1(boolean z) {
        this.o = z;
    }

    void M1(boolean z) {
        if (this.t == null) {
            this.t = new C20298rm4();
        }
        Q1(this.t, Boolean.valueOf(z));
    }

    void N1(CharSequence charSequence) {
        this.i = charSequence;
    }

    void O1(C3520Bf0.d dVar) {
        this.d = dVar;
    }

    int P0() {
        C3520Bf0.d dVar = this.d;
        if (dVar != null) {
            return UR.b(dVar, this.e);
        }
        return 0;
    }

    void P1(boolean z) {
        this.k = z;
    }

    C15937kR R0() {
        if (this.f == null) {
            this.f = new C15937kR(new b(this));
        }
        return this.f;
    }

    C20298rm4 S0() {
        if (this.q == null) {
            this.q = new C20298rm4();
        }
        return this.q;
    }

    androidx.lifecycle.r T0() {
        if (this.r == null) {
            this.r = new C20298rm4();
        }
        return this.r;
    }

    androidx.lifecycle.r U0() {
        if (this.p == null) {
            this.p = new C20298rm4();
        }
        return this.p;
    }

    int V0() {
        return this.j;
    }

    RE0 W0() {
        if (this.g == null) {
            this.g = new RE0();
        }
        return this.g;
    }

    C3520Bf0.a X0() {
        if (this.c == null) {
            this.c = new a();
        }
        return this.c;
    }

    Executor Y0() {
        Executor executor = this.b;
        return executor != null ? executor : new c();
    }

    C3520Bf0.c Z0() {
        return this.e;
    }

    CharSequence a1() {
        C3520Bf0.d dVar = this.d;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    androidx.lifecycle.r b1() {
        if (this.y == null) {
            this.y = new C20298rm4();
        }
        return this.y;
    }

    int c1() {
        return this.w;
    }

    androidx.lifecycle.r d1() {
        if (this.x == null) {
            this.x = new C20298rm4();
        }
        return this.x;
    }

    int e1() {
        int iP0 = P0();
        return (!UR.d(iP0) || UR.c(iP0)) ? -1 : 2;
    }

    DialogInterface.OnClickListener f1() {
        if (this.h == null) {
            this.h = new d(this);
        }
        return this.h;
    }

    CharSequence g1() {
        CharSequence charSequence = this.i;
        if (charSequence != null) {
            return charSequence;
        }
        C3520Bf0.d dVar = this.d;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    CharSequence h1() {
        C3520Bf0.d dVar = this.d;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    CharSequence i1() {
        C3520Bf0.d dVar = this.d;
        if (dVar != null) {
            return dVar.e();
        }
        return null;
    }

    androidx.lifecycle.r j1() {
        if (this.s == null) {
            this.s = new C20298rm4();
        }
        return this.s;
    }

    boolean k1() {
        return this.l;
    }

    boolean l1() {
        C3520Bf0.d dVar = this.d;
        return dVar == null || dVar.f();
    }

    boolean m1() {
        return this.m;
    }

    boolean o1() {
        return this.n;
    }

    androidx.lifecycle.r p1() {
        if (this.v == null) {
            this.v = new C20298rm4();
        }
        return this.v;
    }

    boolean q1() {
        return this.u;
    }

    boolean s1() {
        return this.o;
    }

    androidx.lifecycle.r t1() {
        if (this.t == null) {
            this.t = new C20298rm4();
        }
        return this.t;
    }

    boolean u1() {
        return this.k;
    }

    void v1(C24458yf0 c24458yf0) {
        if (this.q == null) {
            this.q = new C20298rm4();
        }
        Q1(this.q, c24458yf0);
    }

    void w1(boolean z) {
        if (this.s == null) {
            this.s = new C20298rm4();
        }
        Q1(this.s, Boolean.valueOf(z));
    }

    void x1(CharSequence charSequence) {
        if (this.r == null) {
            this.r = new C20298rm4();
        }
        Q1(this.r, charSequence);
    }

    void y1(C3520Bf0.b bVar) {
        if (this.p == null) {
            this.p = new C20298rm4();
        }
        Q1(this.p, bVar);
    }

    void z1(boolean z) {
        this.l = z;
    }
}
