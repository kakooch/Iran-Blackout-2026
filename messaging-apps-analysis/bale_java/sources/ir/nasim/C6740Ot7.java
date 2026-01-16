package ir.nasim;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.InterfaceC2029g;
import ir.nasim.AbstractC12710f43;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: ir.nasim.Ot7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C6740Ot7 implements InterfaceC2029g {
    public static final C6740Ot7 A;
    private static final String A0;
    public static final C6740Ot7 B;
    private static final String B0;
    private static final String C0;
    private static final String D;
    private static final String D0;
    private static final String E0;
    private static final String F0;
    private static final String G;
    private static final String G0;
    private static final String H;
    private static final String H0;
    private static final String I0;
    private static final String J;
    private static final String J0;
    private static final String K0;
    private static final String L0;
    private static final String M0;
    private static final String N0;
    private static final String O0;
    private static final String P0;
    private static final String Q0;
    private static final String R0;
    private static final String S0;
    public static final InterfaceC2029g.a T0;
    private static final String Y;
    private static final String Z;
    private static final String z0;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final boolean k;
    public final AbstractC12710f43 l;
    public final int m;
    public final AbstractC12710f43 n;
    public final int o;
    public final int p;
    public final int q;
    public final AbstractC12710f43 r;
    public final AbstractC12710f43 s;
    public final int t;
    public final int u;
    public final boolean v;
    public final boolean w;
    public final boolean x;
    public final AbstractC13937h43 y;
    public final AbstractC14535i43 z;

    static {
        C6740Ot7 c6740Ot7A = new a().A();
        A = c6740Ot7A;
        B = c6740Ot7A;
        D = AbstractC9683aN7.r0(1);
        G = AbstractC9683aN7.r0(2);
        H = AbstractC9683aN7.r0(3);
        J = AbstractC9683aN7.r0(4);
        Y = AbstractC9683aN7.r0(5);
        Z = AbstractC9683aN7.r0(6);
        z0 = AbstractC9683aN7.r0(7);
        A0 = AbstractC9683aN7.r0(8);
        B0 = AbstractC9683aN7.r0(9);
        C0 = AbstractC9683aN7.r0(10);
        D0 = AbstractC9683aN7.r0(11);
        E0 = AbstractC9683aN7.r0(12);
        F0 = AbstractC9683aN7.r0(13);
        G0 = AbstractC9683aN7.r0(14);
        H0 = AbstractC9683aN7.r0(15);
        I0 = AbstractC9683aN7.r0(16);
        J0 = AbstractC9683aN7.r0(17);
        K0 = AbstractC9683aN7.r0(18);
        L0 = AbstractC9683aN7.r0(19);
        M0 = AbstractC9683aN7.r0(20);
        N0 = AbstractC9683aN7.r0(21);
        O0 = AbstractC9683aN7.r0(22);
        P0 = AbstractC9683aN7.r0(23);
        Q0 = AbstractC9683aN7.r0(24);
        R0 = AbstractC9683aN7.r0(25);
        S0 = AbstractC9683aN7.r0(26);
        T0 = new InterfaceC2029g.a() { // from class: ir.nasim.Nt7
            @Override // com.google.android.exoplayer2.InterfaceC2029g.a
            public final InterfaceC2029g a(Bundle bundle) {
                return C6740Ot7.C(bundle);
            }
        };
    }

    protected C6740Ot7(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
        this.r = aVar.r;
        this.s = aVar.s;
        this.t = aVar.t;
        this.u = aVar.u;
        this.v = aVar.v;
        this.w = aVar.w;
        this.x = aVar.x;
        this.y = AbstractC13937h43.e(aVar.y);
        this.z = AbstractC14535i43.P(aVar.z);
    }

    public static C6740Ot7 C(Bundle bundle) {
        return new a(bundle).A();
    }

    public a B() {
        return new a(this);
    }

    @Override // com.google.android.exoplayer2.InterfaceC2029g
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(Z, this.a);
        bundle.putInt(z0, this.b);
        bundle.putInt(A0, this.c);
        bundle.putInt(B0, this.d);
        bundle.putInt(C0, this.e);
        bundle.putInt(D0, this.f);
        bundle.putInt(E0, this.g);
        bundle.putInt(F0, this.h);
        bundle.putInt(G0, this.i);
        bundle.putInt(H0, this.j);
        bundle.putBoolean(I0, this.k);
        bundle.putStringArray(J0, (String[]) this.l.toArray(new String[0]));
        bundle.putInt(R0, this.m);
        bundle.putStringArray(D, (String[]) this.n.toArray(new String[0]));
        bundle.putInt(G, this.o);
        bundle.putInt(K0, this.p);
        bundle.putInt(L0, this.q);
        bundle.putStringArray(M0, (String[]) this.r.toArray(new String[0]));
        bundle.putStringArray(H, (String[]) this.s.toArray(new String[0]));
        bundle.putInt(J, this.t);
        bundle.putInt(S0, this.u);
        bundle.putBoolean(Y, this.v);
        bundle.putBoolean(N0, this.w);
        bundle.putBoolean(O0, this.x);
        bundle.putParcelableArrayList(P0, AbstractC3344Am0.d(this.y.values()));
        bundle.putIntArray(Q0, AbstractC8236Vc3.l(this.z));
        return bundle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C6740Ot7 c6740Ot7 = (C6740Ot7) obj;
        return this.a == c6740Ot7.a && this.b == c6740Ot7.b && this.c == c6740Ot7.c && this.d == c6740Ot7.d && this.e == c6740Ot7.e && this.f == c6740Ot7.f && this.g == c6740Ot7.g && this.h == c6740Ot7.h && this.k == c6740Ot7.k && this.i == c6740Ot7.i && this.j == c6740Ot7.j && this.l.equals(c6740Ot7.l) && this.m == c6740Ot7.m && this.n.equals(c6740Ot7.n) && this.o == c6740Ot7.o && this.p == c6740Ot7.p && this.q == c6740Ot7.q && this.r.equals(c6740Ot7.r) && this.s.equals(c6740Ot7.s) && this.t == c6740Ot7.t && this.u == c6740Ot7.u && this.v == c6740Ot7.v && this.w == c6740Ot7.w && this.x == c6740Ot7.x && this.y.equals(c6740Ot7.y) && this.z.equals(c6740Ot7.z);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((this.a + 31) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31) + (this.k ? 1 : 0)) * 31) + this.i) * 31) + this.j) * 31) + this.l.hashCode()) * 31) + this.m) * 31) + this.n.hashCode()) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31) + this.t) * 31) + this.u) * 31) + (this.v ? 1 : 0)) * 31) + (this.w ? 1 : 0)) * 31) + (this.x ? 1 : 0)) * 31) + this.y.hashCode()) * 31) + this.z.hashCode();
    }

    /* renamed from: ir.nasim.Ot7$a */
    public static class a {
        private int a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private boolean k;
        private AbstractC12710f43 l;
        private int m;
        private AbstractC12710f43 n;
        private int o;
        private int p;
        private int q;
        private AbstractC12710f43 r;
        private AbstractC12710f43 s;
        private int t;
        private int u;
        private boolean v;
        private boolean w;
        private boolean x;
        private HashMap y;
        private HashSet z;

        public a() {
            this.a = Integer.MAX_VALUE;
            this.b = Integer.MAX_VALUE;
            this.c = Integer.MAX_VALUE;
            this.d = Integer.MAX_VALUE;
            this.i = Integer.MAX_VALUE;
            this.j = Integer.MAX_VALUE;
            this.k = true;
            this.l = AbstractC12710f43.V();
            this.m = 0;
            this.n = AbstractC12710f43.V();
            this.o = 0;
            this.p = Integer.MAX_VALUE;
            this.q = Integer.MAX_VALUE;
            this.r = AbstractC12710f43.V();
            this.s = AbstractC12710f43.V();
            this.t = 0;
            this.u = 0;
            this.v = false;
            this.w = false;
            this.x = false;
            this.y = new HashMap();
            this.z = new HashSet();
        }

        private void C(C6740Ot7 c6740Ot7) {
            this.a = c6740Ot7.a;
            this.b = c6740Ot7.b;
            this.c = c6740Ot7.c;
            this.d = c6740Ot7.d;
            this.e = c6740Ot7.e;
            this.f = c6740Ot7.f;
            this.g = c6740Ot7.g;
            this.h = c6740Ot7.h;
            this.i = c6740Ot7.i;
            this.j = c6740Ot7.j;
            this.k = c6740Ot7.k;
            this.l = c6740Ot7.l;
            this.m = c6740Ot7.m;
            this.n = c6740Ot7.n;
            this.o = c6740Ot7.o;
            this.p = c6740Ot7.p;
            this.q = c6740Ot7.q;
            this.r = c6740Ot7.r;
            this.s = c6740Ot7.s;
            this.t = c6740Ot7.t;
            this.u = c6740Ot7.u;
            this.v = c6740Ot7.v;
            this.w = c6740Ot7.w;
            this.x = c6740Ot7.x;
            this.z = new HashSet(c6740Ot7.z);
            this.y = new HashMap(c6740Ot7.y);
        }

        private static AbstractC12710f43 D(String[] strArr) {
            AbstractC12710f43.a aVarL = AbstractC12710f43.L();
            for (String str : (String[]) AbstractC20011rK.e(strArr)) {
                aVarL.a(AbstractC9683aN7.D0((String) AbstractC20011rK.e(str)));
            }
            return aVarL.h();
        }

        private void I(Context context) {
            CaptioningManager captioningManager;
            if ((AbstractC9683aN7.a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.t = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.s = AbstractC12710f43.W(AbstractC9683aN7.W(locale));
                }
            }
        }

        public C6740Ot7 A() {
            return new C6740Ot7(this);
        }

        public a B(int i) {
            Iterator it = this.y.values().iterator();
            while (it.hasNext()) {
                if (((C6241Mt7) it.next()).c() == i) {
                    it.remove();
                }
            }
            return this;
        }

        protected a E(C6740Ot7 c6740Ot7) {
            C(c6740Ot7);
            return this;
        }

        public a F(int i) {
            this.u = i;
            return this;
        }

        public a G(C6241Mt7 c6241Mt7) {
            B(c6241Mt7.c());
            this.y.put(c6241Mt7.a, c6241Mt7);
            return this;
        }

        public a H(Context context) {
            if (AbstractC9683aN7.a >= 19) {
                I(context);
            }
            return this;
        }

        public a J(int i, boolean z) {
            if (z) {
                this.z.add(Integer.valueOf(i));
            } else {
                this.z.remove(Integer.valueOf(i));
            }
            return this;
        }

        public a K(int i, int i2, boolean z) {
            this.i = i;
            this.j = i2;
            this.k = z;
            return this;
        }

        public a L(Context context, boolean z) {
            Point pointL = AbstractC9683aN7.L(context);
            return K(pointL.x, pointL.y, z);
        }

        public a(Context context) {
            this();
            H(context);
            L(context, true);
        }

        protected a(C6740Ot7 c6740Ot7) {
            C(c6740Ot7);
        }

        protected a(Bundle bundle) {
            AbstractC12710f43 abstractC12710f43B;
            String str = C6740Ot7.Z;
            C6740Ot7 c6740Ot7 = C6740Ot7.A;
            this.a = bundle.getInt(str, c6740Ot7.a);
            this.b = bundle.getInt(C6740Ot7.z0, c6740Ot7.b);
            this.c = bundle.getInt(C6740Ot7.A0, c6740Ot7.c);
            this.d = bundle.getInt(C6740Ot7.B0, c6740Ot7.d);
            this.e = bundle.getInt(C6740Ot7.C0, c6740Ot7.e);
            this.f = bundle.getInt(C6740Ot7.D0, c6740Ot7.f);
            this.g = bundle.getInt(C6740Ot7.E0, c6740Ot7.g);
            this.h = bundle.getInt(C6740Ot7.F0, c6740Ot7.h);
            this.i = bundle.getInt(C6740Ot7.G0, c6740Ot7.i);
            this.j = bundle.getInt(C6740Ot7.H0, c6740Ot7.j);
            this.k = bundle.getBoolean(C6740Ot7.I0, c6740Ot7.k);
            this.l = AbstractC12710f43.P((String[]) AbstractC8300Vj4.a(bundle.getStringArray(C6740Ot7.J0), new String[0]));
            this.m = bundle.getInt(C6740Ot7.R0, c6740Ot7.m);
            this.n = D((String[]) AbstractC8300Vj4.a(bundle.getStringArray(C6740Ot7.D), new String[0]));
            this.o = bundle.getInt(C6740Ot7.G, c6740Ot7.o);
            this.p = bundle.getInt(C6740Ot7.K0, c6740Ot7.p);
            this.q = bundle.getInt(C6740Ot7.L0, c6740Ot7.q);
            this.r = AbstractC12710f43.P((String[]) AbstractC8300Vj4.a(bundle.getStringArray(C6740Ot7.M0), new String[0]));
            this.s = D((String[]) AbstractC8300Vj4.a(bundle.getStringArray(C6740Ot7.H), new String[0]));
            this.t = bundle.getInt(C6740Ot7.J, c6740Ot7.t);
            this.u = bundle.getInt(C6740Ot7.S0, c6740Ot7.u);
            this.v = bundle.getBoolean(C6740Ot7.Y, c6740Ot7.v);
            this.w = bundle.getBoolean(C6740Ot7.N0, c6740Ot7.w);
            this.x = bundle.getBoolean(C6740Ot7.O0, c6740Ot7.x);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(C6740Ot7.P0);
            if (parcelableArrayList == null) {
                abstractC12710f43B = AbstractC12710f43.V();
            } else {
                abstractC12710f43B = AbstractC3344Am0.b(C6241Mt7.e, parcelableArrayList);
            }
            this.y = new HashMap();
            for (int i = 0; i < abstractC12710f43B.size(); i++) {
                C6241Mt7 c6241Mt7 = (C6241Mt7) abstractC12710f43B.get(i);
                this.y.put(c6241Mt7.a, c6241Mt7);
            }
            int[] iArr = (int[]) AbstractC8300Vj4.a(bundle.getIntArray(C6740Ot7.Q0), new int[0]);
            this.z = new HashSet();
            for (int i2 : iArr) {
                this.z.add(Integer.valueOf(i2));
            }
        }
    }
}
