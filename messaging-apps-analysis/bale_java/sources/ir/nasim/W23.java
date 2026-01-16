package ir.nasim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import coil.memory.MemoryCache;
import ir.nasim.C19533qW4;
import ir.nasim.C6010Lu1;
import ir.nasim.CB1;
import ir.nasim.InterfaceC22259uv7;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;

/* loaded from: classes2.dex */
public final class W23 {
    private final androidx.lifecycle.j A;
    private final ZD6 B;
    private final EnumC14254hc6 C;
    private final C19533qW4 D;
    private final MemoryCache.Key E;
    private final Integer F;
    private final Drawable G;
    private final Integer H;
    private final Drawable I;
    private final Integer J;
    private final Drawable K;
    private final CG1 L;
    private final NE1 M;
    private final Context a;
    private final Object b;
    private final InterfaceC22139uj7 c;
    private final b d;
    private final MemoryCache.Key e;
    private final String f;
    private final Bitmap.Config g;
    private final ColorSpace h;
    private final EnumC18478oj5 i;
    private final XV4 j;
    private final CB1.a k;
    private final List l;
    private final InterfaceC22259uv7.a m;
    private final Headers n;
    private final C16116kj7 o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final EnumC16760lp0 t;
    private final EnumC16760lp0 u;
    private final EnumC16760lp0 v;
    private final AbstractC13778go1 w;
    private final AbstractC13778go1 x;
    private final AbstractC13778go1 y;
    private final AbstractC13778go1 z;

    public interface b {
        void a(W23 w23);

        void b(W23 w23);

        void c(W23 w23, I07 i07);

        void d(W23 w23, C12412ea2 c12412ea2);
    }

    public /* synthetic */ W23(Context context, Object obj, InterfaceC22139uj7 interfaceC22139uj7, b bVar, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace, EnumC18478oj5 enumC18478oj5, XV4 xv4, CB1.a aVar, List list, InterfaceC22259uv7.a aVar2, Headers headers, C16116kj7 c16116kj7, boolean z, boolean z2, boolean z3, boolean z4, EnumC16760lp0 enumC16760lp0, EnumC16760lp0 enumC16760lp02, EnumC16760lp0 enumC16760lp03, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, AbstractC13778go1 abstractC13778go13, AbstractC13778go1 abstractC13778go14, androidx.lifecycle.j jVar, ZD6 zd6, EnumC14254hc6 enumC14254hc6, C19533qW4 c19533qW4, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, CG1 cg1, NE1 ne1, ED1 ed1) {
        this(context, obj, interfaceC22139uj7, bVar, key, str, config, colorSpace, enumC18478oj5, xv4, aVar, list, aVar2, headers, c16116kj7, z, z2, z3, z4, enumC16760lp0, enumC16760lp02, enumC16760lp03, abstractC13778go1, abstractC13778go12, abstractC13778go13, abstractC13778go14, jVar, zd6, enumC14254hc6, c19533qW4, key2, num, drawable, num2, drawable2, num3, drawable3, cg1, ne1);
    }

    public static /* synthetic */ a R(W23 w23, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = w23.a;
        }
        return w23.Q(context);
    }

    public final b A() {
        return this.d;
    }

    public final MemoryCache.Key B() {
        return this.e;
    }

    public final EnumC16760lp0 C() {
        return this.t;
    }

    public final EnumC16760lp0 D() {
        return this.v;
    }

    public final C19533qW4 E() {
        return this.D;
    }

    public final Drawable F() {
        return AbstractC16865m.c(this, this.G, this.F, this.M.n());
    }

    public final MemoryCache.Key G() {
        return this.E;
    }

    public final EnumC18478oj5 H() {
        return this.i;
    }

    public final boolean I() {
        return this.s;
    }

    public final EnumC14254hc6 J() {
        return this.C;
    }

    public final ZD6 K() {
        return this.B;
    }

    public final C16116kj7 L() {
        return this.o;
    }

    public final InterfaceC22139uj7 M() {
        return this.c;
    }

    public final AbstractC13778go1 N() {
        return this.z;
    }

    public final List O() {
        return this.l;
    }

    public final InterfaceC22259uv7.a P() {
        return this.m;
    }

    public final a Q(Context context) {
        return new a(this, context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof W23) {
            W23 w23 = (W23) obj;
            if (AbstractC13042fc3.d(this.a, w23.a) && AbstractC13042fc3.d(this.b, w23.b) && AbstractC13042fc3.d(this.c, w23.c) && AbstractC13042fc3.d(this.d, w23.d) && AbstractC13042fc3.d(this.e, w23.e) && AbstractC13042fc3.d(this.f, w23.f) && this.g == w23.g && ((Build.VERSION.SDK_INT < 26 || AbstractC13042fc3.d(this.h, w23.h)) && this.i == w23.i && AbstractC13042fc3.d(this.j, w23.j) && AbstractC13042fc3.d(this.k, w23.k) && AbstractC13042fc3.d(this.l, w23.l) && AbstractC13042fc3.d(this.m, w23.m) && AbstractC13042fc3.d(this.n, w23.n) && AbstractC13042fc3.d(this.o, w23.o) && this.p == w23.p && this.q == w23.q && this.r == w23.r && this.s == w23.s && this.t == w23.t && this.u == w23.u && this.v == w23.v && AbstractC13042fc3.d(this.w, w23.w) && AbstractC13042fc3.d(this.x, w23.x) && AbstractC13042fc3.d(this.y, w23.y) && AbstractC13042fc3.d(this.z, w23.z) && AbstractC13042fc3.d(this.E, w23.E) && AbstractC13042fc3.d(this.F, w23.F) && AbstractC13042fc3.d(this.G, w23.G) && AbstractC13042fc3.d(this.H, w23.H) && AbstractC13042fc3.d(this.I, w23.I) && AbstractC13042fc3.d(this.J, w23.J) && AbstractC13042fc3.d(this.K, w23.K) && AbstractC13042fc3.d(this.A, w23.A) && AbstractC13042fc3.d(this.B, w23.B) && this.C == w23.C && AbstractC13042fc3.d(this.D, w23.D) && AbstractC13042fc3.d(this.L, w23.L) && AbstractC13042fc3.d(this.M, w23.M))) {
                return true;
            }
        }
        return false;
    }

    public final boolean g() {
        return this.p;
    }

    public final boolean h() {
        return this.q;
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        InterfaceC22139uj7 interfaceC22139uj7 = this.c;
        int iHashCode2 = (iHashCode + (interfaceC22139uj7 != null ? interfaceC22139uj7.hashCode() : 0)) * 31;
        b bVar = this.d;
        int iHashCode3 = (iHashCode2 + (bVar != null ? bVar.hashCode() : 0)) * 31;
        MemoryCache.Key key = this.e;
        int iHashCode4 = (iHashCode3 + (key != null ? key.hashCode() : 0)) * 31;
        String str = this.f;
        int iHashCode5 = (((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.g.hashCode()) * 31;
        ColorSpace colorSpace = this.h;
        int iHashCode6 = (((iHashCode5 + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31) + this.i.hashCode()) * 31;
        XV4 xv4 = this.j;
        int iHashCode7 = (iHashCode6 + (xv4 != null ? xv4.hashCode() : 0)) * 31;
        CB1.a aVar = this.k;
        int iHashCode8 = (((((((((((((((((((((((((((((((((((((((iHashCode7 + (aVar != null ? aVar.hashCode() : 0)) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + Boolean.hashCode(this.p)) * 31) + Boolean.hashCode(this.q)) * 31) + Boolean.hashCode(this.r)) * 31) + Boolean.hashCode(this.s)) * 31) + this.t.hashCode()) * 31) + this.u.hashCode()) * 31) + this.v.hashCode()) * 31) + this.w.hashCode()) * 31) + this.x.hashCode()) * 31) + this.y.hashCode()) * 31) + this.z.hashCode()) * 31) + this.A.hashCode()) * 31) + this.B.hashCode()) * 31) + this.C.hashCode()) * 31) + this.D.hashCode()) * 31;
        MemoryCache.Key key2 = this.E;
        int iHashCode9 = (iHashCode8 + (key2 != null ? key2.hashCode() : 0)) * 31;
        Integer num = this.F;
        int iHashCode10 = (iHashCode9 + (num != null ? num.hashCode() : 0)) * 31;
        Drawable drawable = this.G;
        int iHashCode11 = (iHashCode10 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Integer num2 = this.H;
        int iHashCode12 = (iHashCode11 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Drawable drawable2 = this.I;
        int iHashCode13 = (iHashCode12 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
        Integer num3 = this.J;
        int iHashCode14 = (iHashCode13 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Drawable drawable3 = this.K;
        return ((((iHashCode14 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31) + this.L.hashCode()) * 31) + this.M.hashCode();
    }

    public final boolean i() {
        return this.r;
    }

    public final Bitmap.Config j() {
        return this.g;
    }

    public final ColorSpace k() {
        return this.h;
    }

    public final Context l() {
        return this.a;
    }

    public final Object m() {
        return this.b;
    }

    public final AbstractC13778go1 n() {
        return this.y;
    }

    public final CB1.a o() {
        return this.k;
    }

    public final NE1 p() {
        return this.M;
    }

    public final CG1 q() {
        return this.L;
    }

    public final String r() {
        return this.f;
    }

    public final EnumC16760lp0 s() {
        return this.u;
    }

    public final Drawable t() {
        return AbstractC16865m.c(this, this.I, this.H, this.M.h());
    }

    public final Drawable u() {
        return AbstractC16865m.c(this, this.K, this.J, this.M.i());
    }

    public final AbstractC13778go1 v() {
        return this.x;
    }

    public final XV4 w() {
        return this.j;
    }

    public final Headers x() {
        return this.n;
    }

    public final AbstractC13778go1 y() {
        return this.w;
    }

    public final androidx.lifecycle.j z() {
        return this.A;
    }

    private W23(Context context, Object obj, InterfaceC22139uj7 interfaceC22139uj7, b bVar, MemoryCache.Key key, String str, Bitmap.Config config, ColorSpace colorSpace, EnumC18478oj5 enumC18478oj5, XV4 xv4, CB1.a aVar, List list, InterfaceC22259uv7.a aVar2, Headers headers, C16116kj7 c16116kj7, boolean z, boolean z2, boolean z3, boolean z4, EnumC16760lp0 enumC16760lp0, EnumC16760lp0 enumC16760lp02, EnumC16760lp0 enumC16760lp03, AbstractC13778go1 abstractC13778go1, AbstractC13778go1 abstractC13778go12, AbstractC13778go1 abstractC13778go13, AbstractC13778go1 abstractC13778go14, androidx.lifecycle.j jVar, ZD6 zd6, EnumC14254hc6 enumC14254hc6, C19533qW4 c19533qW4, MemoryCache.Key key2, Integer num, Drawable drawable, Integer num2, Drawable drawable2, Integer num3, Drawable drawable3, CG1 cg1, NE1 ne1) {
        this.a = context;
        this.b = obj;
        this.c = interfaceC22139uj7;
        this.d = bVar;
        this.e = key;
        this.f = str;
        this.g = config;
        this.h = colorSpace;
        this.i = enumC18478oj5;
        this.j = xv4;
        this.k = aVar;
        this.l = list;
        this.m = aVar2;
        this.n = headers;
        this.o = c16116kj7;
        this.p = z;
        this.q = z2;
        this.r = z3;
        this.s = z4;
        this.t = enumC16760lp0;
        this.u = enumC16760lp02;
        this.v = enumC16760lp03;
        this.w = abstractC13778go1;
        this.x = abstractC13778go12;
        this.y = abstractC13778go13;
        this.z = abstractC13778go14;
        this.A = jVar;
        this.B = zd6;
        this.C = enumC14254hc6;
        this.D = c19533qW4;
        this.E = key2;
        this.F = num;
        this.G = drawable;
        this.H = num2;
        this.I = drawable2;
        this.J = num3;
        this.K = drawable3;
        this.L = cg1;
        this.M = ne1;
    }

    public static final class a {
        private AbstractC13778go1 A;
        private C19533qW4.a B;
        private MemoryCache.Key C;
        private Integer D;
        private Drawable E;
        private Integer F;
        private Drawable G;
        private Integer H;
        private Drawable I;
        private androidx.lifecycle.j J;
        private ZD6 K;
        private EnumC14254hc6 L;
        private androidx.lifecycle.j M;
        private ZD6 N;
        private EnumC14254hc6 O;
        private final Context a;
        private NE1 b;
        private Object c;
        private InterfaceC22139uj7 d;
        private b e;
        private MemoryCache.Key f;
        private String g;
        private Bitmap.Config h;
        private ColorSpace i;
        private EnumC18478oj5 j;
        private XV4 k;
        private CB1.a l;
        private List m;
        private InterfaceC22259uv7.a n;
        private Headers.Builder o;
        private Map p;
        private boolean q;
        private Boolean r;
        private Boolean s;
        private boolean t;
        private EnumC16760lp0 u;
        private EnumC16760lp0 v;
        private EnumC16760lp0 w;
        private AbstractC13778go1 x;
        private AbstractC13778go1 y;
        private AbstractC13778go1 z;

        public a(Context context) {
            this.a = context;
            this.b = AbstractC16865m.b();
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            if (Build.VERSION.SDK_INT >= 26) {
                this.i = null;
            }
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = AbstractC10360bX0.m();
            this.n = null;
            this.o = null;
            this.p = null;
            this.q = true;
            this.r = null;
            this.s = null;
            this.t = true;
            this.u = null;
            this.v = null;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z = null;
            this.A = null;
            this.B = null;
            this.C = null;
            this.D = null;
            this.E = null;
            this.F = null;
            this.G = null;
            this.H = null;
            this.I = null;
            this.J = null;
            this.K = null;
            this.L = null;
            this.M = null;
            this.N = null;
            this.O = null;
        }

        private final void i() {
            this.O = null;
        }

        private final void j() {
            this.M = null;
            this.N = null;
            this.O = null;
        }

        private final androidx.lifecycle.j k() {
            androidx.lifecycle.j jVarC = AbstractC12665f.c(this.a);
            return jVarC == null ? C14679iJ2.b : jVarC;
        }

        private final EnumC14254hc6 l() {
            View view;
            ZD6 zd6 = this.K;
            View view2 = null;
            FX7 fx7 = zd6 instanceof FX7 ? (FX7) zd6 : null;
            if (fx7 != null && (view = fx7.getView()) != null) {
                view2 = view;
            }
            return view2 instanceof ImageView ? AbstractC18638p.n((ImageView) view2) : EnumC14254hc6.b;
        }

        private final ZD6 m() {
            return new DV1(this.a);
        }

        public final W23 a() {
            Context context = this.a;
            Object obj = this.c;
            if (obj == null) {
                obj = C11582dF4.a;
            }
            Object obj2 = obj;
            InterfaceC22139uj7 interfaceC22139uj7 = this.d;
            b bVar = this.e;
            MemoryCache.Key key = this.f;
            String str = this.g;
            Bitmap.Config configE = this.h;
            if (configE == null) {
                configE = this.b.e();
            }
            Bitmap.Config config = configE;
            ColorSpace colorSpace = this.i;
            EnumC18478oj5 enumC18478oj5O = this.j;
            if (enumC18478oj5O == null) {
                enumC18478oj5O = this.b.o();
            }
            EnumC18478oj5 enumC18478oj5 = enumC18478oj5O;
            XV4 xv4 = this.k;
            CB1.a aVar = this.l;
            List list = this.m;
            InterfaceC22259uv7.a aVarQ = this.n;
            if (aVarQ == null) {
                aVarQ = this.b.q();
            }
            InterfaceC22259uv7.a aVar2 = aVarQ;
            Headers.Builder builder = this.o;
            Headers headersX = AbstractC18638p.x(builder != null ? builder.build() : null);
            Map map = this.p;
            C16116kj7 c16116kj7W = AbstractC18638p.w(map != null ? C16116kj7.b.a(map) : null);
            boolean z = this.q;
            Boolean bool = this.r;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : this.b.c();
            Boolean bool2 = this.s;
            boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : this.b.d();
            boolean z2 = this.t;
            EnumC16760lp0 enumC16760lp0L = this.u;
            if (enumC16760lp0L == null) {
                enumC16760lp0L = this.b.l();
            }
            EnumC16760lp0 enumC16760lp0 = enumC16760lp0L;
            EnumC16760lp0 enumC16760lp0G = this.v;
            if (enumC16760lp0G == null) {
                enumC16760lp0G = this.b.g();
            }
            EnumC16760lp0 enumC16760lp02 = enumC16760lp0G;
            EnumC16760lp0 enumC16760lp0M = this.w;
            if (enumC16760lp0M == null) {
                enumC16760lp0M = this.b.m();
            }
            EnumC16760lp0 enumC16760lp03 = enumC16760lp0M;
            AbstractC13778go1 abstractC13778go1K = this.x;
            if (abstractC13778go1K == null) {
                abstractC13778go1K = this.b.k();
            }
            AbstractC13778go1 abstractC13778go1 = abstractC13778go1K;
            AbstractC13778go1 abstractC13778go1J = this.y;
            if (abstractC13778go1J == null) {
                abstractC13778go1J = this.b.j();
            }
            AbstractC13778go1 abstractC13778go12 = abstractC13778go1J;
            AbstractC13778go1 abstractC13778go1F = this.z;
            if (abstractC13778go1F == null) {
                abstractC13778go1F = this.b.f();
            }
            AbstractC13778go1 abstractC13778go13 = abstractC13778go1F;
            AbstractC13778go1 abstractC13778go1P = this.A;
            if (abstractC13778go1P == null) {
                abstractC13778go1P = this.b.p();
            }
            AbstractC13778go1 abstractC13778go14 = abstractC13778go1P;
            androidx.lifecycle.j jVarK = this.J;
            if (jVarK == null && (jVarK = this.M) == null) {
                jVarK = k();
            }
            androidx.lifecycle.j jVar = jVarK;
            ZD6 zd6M = this.K;
            if (zd6M == null && (zd6M = this.N) == null) {
                zd6M = m();
            }
            ZD6 zd6 = zd6M;
            EnumC14254hc6 enumC14254hc6L = this.L;
            if (enumC14254hc6L == null && (enumC14254hc6L = this.O) == null) {
                enumC14254hc6L = l();
            }
            EnumC14254hc6 enumC14254hc6 = enumC14254hc6L;
            C19533qW4.a aVar3 = this.B;
            return new W23(context, obj2, interfaceC22139uj7, bVar, key, str, config, colorSpace, enumC18478oj5, xv4, aVar, list, aVar2, headersX, c16116kj7W, z, zBooleanValue, zBooleanValue2, z2, enumC16760lp0, enumC16760lp02, enumC16760lp03, abstractC13778go1, abstractC13778go12, abstractC13778go13, abstractC13778go14, jVar, zd6, enumC14254hc6, AbstractC18638p.v(aVar3 != null ? aVar3.a() : null), this.C, this.D, this.E, this.F, this.G, this.H, this.I, new CG1(this.J, this.K, this.L, this.x, this.y, this.z, this.A, this.n, this.j, this.h, this.r, this.s, this.u, this.v, this.w), this.b, null);
        }

        public final a b(int i) {
            InterfaceC22259uv7.a aVar;
            if (i > 0) {
                aVar = new C6010Lu1.a(i, false, 2, null);
            } else {
                aVar = InterfaceC22259uv7.a.b;
            }
            q(aVar);
            return this;
        }

        public final a c(boolean z) {
            return b(z ? 100 : 0);
        }

        public final a d(Object obj) {
            this.c = obj;
            return this;
        }

        public final a e(CB1.a aVar) {
            this.l = aVar;
            return this;
        }

        public final a f(NE1 ne1) {
            this.b = ne1;
            i();
            return this;
        }

        public final a g(b bVar) {
            this.e = bVar;
            return this;
        }

        public final a h(EnumC18478oj5 enumC18478oj5) {
            this.j = enumC18478oj5;
            return this;
        }

        public final a n(EnumC14254hc6 enumC14254hc6) {
            this.L = enumC14254hc6;
            return this;
        }

        public final a o(ZD6 zd6) {
            this.K = zd6;
            j();
            return this;
        }

        public final a p(InterfaceC22139uj7 interfaceC22139uj7) {
            this.d = interfaceC22139uj7;
            j();
            return this;
        }

        public final a q(InterfaceC22259uv7.a aVar) {
            this.n = aVar;
            return this;
        }

        public a(W23 w23, Context context) {
            this.a = context;
            this.b = w23.p();
            this.c = w23.m();
            this.d = w23.M();
            this.e = w23.A();
            this.f = w23.B();
            this.g = w23.r();
            this.h = w23.q().c();
            if (Build.VERSION.SDK_INT >= 26) {
                this.i = w23.k();
            }
            this.j = w23.q().k();
            this.k = w23.w();
            this.l = w23.o();
            this.m = w23.O();
            this.n = w23.q().o();
            this.o = w23.x().newBuilder();
            this.p = AbstractC20051rO3.A(w23.L().a());
            this.q = w23.g();
            this.r = w23.q().a();
            this.s = w23.q().b();
            this.t = w23.I();
            this.u = w23.q().i();
            this.v = w23.q().e();
            this.w = w23.q().j();
            this.x = w23.q().g();
            this.y = w23.q().f();
            this.z = w23.q().d();
            this.A = w23.q().n();
            this.B = w23.E().i();
            this.C = w23.G();
            this.D = w23.F;
            this.E = w23.G;
            this.F = w23.H;
            this.G = w23.I;
            this.H = w23.J;
            this.I = w23.K;
            this.J = w23.q().h();
            this.K = w23.q().m();
            this.L = w23.q().l();
            if (w23.l() == context) {
                this.M = w23.z();
                this.N = w23.K();
                this.O = w23.J();
            } else {
                this.M = null;
                this.N = null;
                this.O = null;
            }
        }
    }
}
