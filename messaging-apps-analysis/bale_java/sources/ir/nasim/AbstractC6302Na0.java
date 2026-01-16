package ir.nasim;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.util.Map;

/* renamed from: ir.nasim.Na0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC6302Na0 implements Cloneable {
    private int a;
    private Drawable e;
    private int f;
    private Drawable g;
    private int h;
    private boolean m;
    private Drawable o;
    private int p;
    private boolean t;
    private Resources.Theme u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean z;
    private float b = 1.0f;
    private AbstractC23175wU1 c = AbstractC23175wU1.e;
    private EnumC6212Mq5 d = EnumC6212Mq5.NORMAL;
    private boolean i = true;
    private int j = -1;
    private int k = -1;
    private InterfaceC14373ho3 l = H72.c();
    private boolean n = true;
    private HL4 q = new HL4();
    private Map r = new C8620Wt0();
    private Class s = Object.class;
    private boolean y = true;

    private boolean N(int i) {
        return O(this.a, i);
    }

    private static boolean O(int i, int i2) {
        return (i & i2) != 0;
    }

    private AbstractC6302Na0 a0(AbstractC14220hZ1 abstractC14220hZ1, InterfaceC15645jv7 interfaceC15645jv7) {
        return j0(abstractC14220hZ1, interfaceC15645jv7, false);
    }

    private AbstractC6302Na0 i0(AbstractC14220hZ1 abstractC14220hZ1, InterfaceC15645jv7 interfaceC15645jv7) {
        return j0(abstractC14220hZ1, interfaceC15645jv7, true);
    }

    private AbstractC6302Na0 j0(AbstractC14220hZ1 abstractC14220hZ1, InterfaceC15645jv7 interfaceC15645jv7, boolean z) {
        AbstractC6302Na0 abstractC6302Na0T0 = z ? t0(abstractC14220hZ1, interfaceC15645jv7) : b0(abstractC14220hZ1, interfaceC15645jv7);
        abstractC6302Na0T0.y = true;
        return abstractC6302Na0T0;
    }

    public final Class A() {
        return this.s;
    }

    public final InterfaceC14373ho3 B() {
        return this.l;
    }

    public final float C() {
        return this.b;
    }

    public final Resources.Theme D() {
        return this.u;
    }

    public final Map E() {
        return this.r;
    }

    public final boolean F() {
        return this.z;
    }

    public final boolean G() {
        return this.w;
    }

    protected final boolean H() {
        return this.v;
    }

    public final boolean I() {
        return N(4);
    }

    public final boolean J(AbstractC6302Na0 abstractC6302Na0) {
        return Float.compare(abstractC6302Na0.b, this.b) == 0 && this.f == abstractC6302Na0.f && YM7.e(this.e, abstractC6302Na0.e) && this.h == abstractC6302Na0.h && YM7.e(this.g, abstractC6302Na0.g) && this.p == abstractC6302Na0.p && YM7.e(this.o, abstractC6302Na0.o) && this.i == abstractC6302Na0.i && this.j == abstractC6302Na0.j && this.k == abstractC6302Na0.k && this.m == abstractC6302Na0.m && this.n == abstractC6302Na0.n && this.w == abstractC6302Na0.w && this.x == abstractC6302Na0.x && this.c.equals(abstractC6302Na0.c) && this.d == abstractC6302Na0.d && this.q.equals(abstractC6302Na0.q) && this.r.equals(abstractC6302Na0.r) && this.s.equals(abstractC6302Na0.s) && YM7.e(this.l, abstractC6302Na0.l) && YM7.e(this.u, abstractC6302Na0.u);
    }

    public final boolean K() {
        return this.i;
    }

    public final boolean L() {
        return N(8);
    }

    boolean M() {
        return this.y;
    }

    public final boolean Q() {
        return N(256);
    }

    public final boolean R() {
        return this.n;
    }

    public final boolean T() {
        return this.m;
    }

    public final boolean U() {
        return N(2048);
    }

    public final boolean V() {
        return YM7.v(this.k, this.j);
    }

    public AbstractC6302Na0 W() {
        this.t = true;
        return k0();
    }

    public AbstractC6302Na0 X() {
        return b0(AbstractC14220hZ1.e, new LH0());
    }

    public AbstractC6302Na0 Y() {
        return a0(AbstractC14220hZ1.d, new MH0());
    }

    public AbstractC6302Na0 Z() {
        return a0(AbstractC14220hZ1.c, new C13789gp2());
    }

    public AbstractC6302Na0 b(AbstractC6302Na0 abstractC6302Na0) {
        if (this.v) {
            return clone().b(abstractC6302Na0);
        }
        if (O(abstractC6302Na0.a, 2)) {
            this.b = abstractC6302Na0.b;
        }
        if (O(abstractC6302Na0.a, 262144)) {
            this.w = abstractC6302Na0.w;
        }
        if (O(abstractC6302Na0.a, 1048576)) {
            this.z = abstractC6302Na0.z;
        }
        if (O(abstractC6302Na0.a, 4)) {
            this.c = abstractC6302Na0.c;
        }
        if (O(abstractC6302Na0.a, 8)) {
            this.d = abstractC6302Na0.d;
        }
        if (O(abstractC6302Na0.a, 16)) {
            this.e = abstractC6302Na0.e;
            this.f = 0;
            this.a &= -33;
        }
        if (O(abstractC6302Na0.a, 32)) {
            this.f = abstractC6302Na0.f;
            this.e = null;
            this.a &= -17;
        }
        if (O(abstractC6302Na0.a, 64)) {
            this.g = abstractC6302Na0.g;
            this.h = 0;
            this.a &= -129;
        }
        if (O(abstractC6302Na0.a, 128)) {
            this.h = abstractC6302Na0.h;
            this.g = null;
            this.a &= -65;
        }
        if (O(abstractC6302Na0.a, 256)) {
            this.i = abstractC6302Na0.i;
        }
        if (O(abstractC6302Na0.a, 512)) {
            this.k = abstractC6302Na0.k;
            this.j = abstractC6302Na0.j;
        }
        if (O(abstractC6302Na0.a, 1024)) {
            this.l = abstractC6302Na0.l;
        }
        if (O(abstractC6302Na0.a, 4096)) {
            this.s = abstractC6302Na0.s;
        }
        if (O(abstractC6302Na0.a, 8192)) {
            this.o = abstractC6302Na0.o;
            this.p = 0;
            this.a &= -16385;
        }
        if (O(abstractC6302Na0.a, 16384)) {
            this.p = abstractC6302Na0.p;
            this.o = null;
            this.a &= -8193;
        }
        if (O(abstractC6302Na0.a, 32768)) {
            this.u = abstractC6302Na0.u;
        }
        if (O(abstractC6302Na0.a, 65536)) {
            this.n = abstractC6302Na0.n;
        }
        if (O(abstractC6302Na0.a, 131072)) {
            this.m = abstractC6302Na0.m;
        }
        if (O(abstractC6302Na0.a, 2048)) {
            this.r.putAll(abstractC6302Na0.r);
            this.y = abstractC6302Na0.y;
        }
        if (O(abstractC6302Na0.a, 524288)) {
            this.x = abstractC6302Na0.x;
        }
        if (!this.n) {
            this.r.clear();
            int i = this.a;
            this.m = false;
            this.a = i & (-133121);
            this.y = true;
        }
        this.a |= abstractC6302Na0.a;
        this.q.d(abstractC6302Na0.q);
        return l0();
    }

    final AbstractC6302Na0 b0(AbstractC14220hZ1 abstractC14220hZ1, InterfaceC15645jv7 interfaceC15645jv7) {
        if (this.v) {
            return clone().b0(abstractC14220hZ1, interfaceC15645jv7);
        }
        k(abstractC14220hZ1);
        return v0(interfaceC15645jv7, false);
    }

    public AbstractC6302Na0 c() {
        if (this.t && !this.v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.v = true;
        return W();
    }

    public AbstractC6302Na0 c0(int i, int i2) {
        if (this.v) {
            return clone().c0(i, i2);
        }
        this.k = i;
        this.j = i2;
        this.a |= 512;
        return l0();
    }

    public AbstractC6302Na0 d() {
        return t0(AbstractC14220hZ1.e, new LH0());
    }

    public AbstractC6302Na0 e() {
        return t0(AbstractC14220hZ1.d, new C9739aU0());
    }

    public AbstractC6302Na0 e0(int i) {
        if (this.v) {
            return clone().e0(i);
        }
        this.h = i;
        int i2 = this.a | 128;
        this.g = null;
        this.a = i2 & (-65);
        return l0();
    }

    public boolean equals(Object obj) {
        if (obj instanceof AbstractC6302Na0) {
            return J((AbstractC6302Na0) obj);
        }
        return false;
    }

    @Override // 
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public AbstractC6302Na0 clone() {
        try {
            AbstractC6302Na0 abstractC6302Na0 = (AbstractC6302Na0) super.clone();
            HL4 hl4 = new HL4();
            abstractC6302Na0.q = hl4;
            hl4.d(this.q);
            C8620Wt0 c8620Wt0 = new C8620Wt0();
            abstractC6302Na0.r = c8620Wt0;
            c8620Wt0.putAll(this.r);
            abstractC6302Na0.t = false;
            abstractC6302Na0.v = false;
            return abstractC6302Na0;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public AbstractC6302Na0 f0(Drawable drawable) {
        if (this.v) {
            return clone().f0(drawable);
        }
        this.g = drawable;
        int i = this.a | 64;
        this.h = 0;
        this.a = i & (-129);
        return l0();
    }

    public AbstractC6302Na0 g0(EnumC6212Mq5 enumC6212Mq5) {
        if (this.v) {
            return clone().g0(enumC6212Mq5);
        }
        this.d = (EnumC6212Mq5) AbstractC3322Aj5.d(enumC6212Mq5);
        this.a |= 8;
        return l0();
    }

    public AbstractC6302Na0 h(Class cls) {
        if (this.v) {
            return clone().h(cls);
        }
        this.s = (Class) AbstractC3322Aj5.d(cls);
        this.a |= 4096;
        return l0();
    }

    AbstractC6302Na0 h0(C23097wL4 c23097wL4) {
        if (this.v) {
            return clone().h0(c23097wL4);
        }
        this.q.e(c23097wL4);
        return l0();
    }

    public int hashCode() {
        return YM7.q(this.u, YM7.q(this.l, YM7.q(this.s, YM7.q(this.r, YM7.q(this.q, YM7.q(this.d, YM7.q(this.c, YM7.r(this.x, YM7.r(this.w, YM7.r(this.n, YM7.r(this.m, YM7.p(this.k, YM7.p(this.j, YM7.r(this.i, YM7.q(this.o, YM7.p(this.p, YM7.q(this.g, YM7.p(this.h, YM7.q(this.e, YM7.p(this.f, YM7.m(this.b)))))))))))))))))))));
    }

    public AbstractC6302Na0 i(AbstractC23175wU1 abstractC23175wU1) {
        if (this.v) {
            return clone().i(abstractC23175wU1);
        }
        this.c = (AbstractC23175wU1) AbstractC3322Aj5.d(abstractC23175wU1);
        this.a |= 4;
        return l0();
    }

    public AbstractC6302Na0 k(AbstractC14220hZ1 abstractC14220hZ1) {
        return m0(AbstractC14220hZ1.h, (AbstractC14220hZ1) AbstractC3322Aj5.d(abstractC14220hZ1));
    }

    public AbstractC6302Na0 l(Drawable drawable) {
        if (this.v) {
            return clone().l(drawable);
        }
        this.e = drawable;
        int i = this.a | 16;
        this.f = 0;
        this.a = i & (-33);
        return l0();
    }

    protected final AbstractC6302Na0 l0() {
        if (this.t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return k0();
    }

    public AbstractC6302Na0 m() {
        return i0(AbstractC14220hZ1.c, new C13789gp2());
    }

    public AbstractC6302Na0 m0(C23097wL4 c23097wL4, Object obj) {
        if (this.v) {
            return clone().m0(c23097wL4, obj);
        }
        AbstractC3322Aj5.d(c23097wL4);
        AbstractC3322Aj5.d(obj);
        this.q.f(c23097wL4, obj);
        return l0();
    }

    public AbstractC6302Na0 n(long j) {
        return m0(PS7.d, Long.valueOf(j));
    }

    public AbstractC6302Na0 n0(InterfaceC14373ho3 interfaceC14373ho3) {
        if (this.v) {
            return clone().n0(interfaceC14373ho3);
        }
        this.l = (InterfaceC14373ho3) AbstractC3322Aj5.d(interfaceC14373ho3);
        this.a |= 1024;
        return l0();
    }

    public final AbstractC23175wU1 o() {
        return this.c;
    }

    public AbstractC6302Na0 o0(float f) {
        if (this.v) {
            return clone().o0(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.b = f;
        this.a |= 2;
        return l0();
    }

    public final int p() {
        return this.f;
    }

    public AbstractC6302Na0 p0(boolean z) {
        if (this.v) {
            return clone().p0(true);
        }
        this.i = !z;
        this.a |= 256;
        return l0();
    }

    public final Drawable q() {
        return this.e;
    }

    public AbstractC6302Na0 q0(Resources.Theme theme) {
        if (this.v) {
            return clone().q0(theme);
        }
        this.u = theme;
        if (theme != null) {
            this.a |= 32768;
            return m0(JW5.b, theme);
        }
        this.a &= -32769;
        return h0(JW5.b);
    }

    public final Drawable r() {
        return this.o;
    }

    public AbstractC6302Na0 r0(int i) {
        return m0(C17194mZ2.b, Integer.valueOf(i));
    }

    public final int s() {
        return this.p;
    }

    public final boolean t() {
        return this.x;
    }

    final AbstractC6302Na0 t0(AbstractC14220hZ1 abstractC14220hZ1, InterfaceC15645jv7 interfaceC15645jv7) {
        if (this.v) {
            return clone().t0(abstractC14220hZ1, interfaceC15645jv7);
        }
        k(abstractC14220hZ1);
        return u0(interfaceC15645jv7);
    }

    public final HL4 u() {
        return this.q;
    }

    public AbstractC6302Na0 u0(InterfaceC15645jv7 interfaceC15645jv7) {
        return v0(interfaceC15645jv7, true);
    }

    public final int v() {
        return this.j;
    }

    AbstractC6302Na0 v0(InterfaceC15645jv7 interfaceC15645jv7, boolean z) {
        if (this.v) {
            return clone().v0(interfaceC15645jv7, z);
        }
        G02 g02 = new G02(interfaceC15645jv7, z);
        w0(Bitmap.class, interfaceC15645jv7, z);
        w0(Drawable.class, g02, z);
        w0(BitmapDrawable.class, g02.c(), z);
        w0(C11598dH2.class, new C14059hH2(interfaceC15645jv7), z);
        return l0();
    }

    public final int w() {
        return this.k;
    }

    AbstractC6302Na0 w0(Class cls, InterfaceC15645jv7 interfaceC15645jv7, boolean z) {
        if (this.v) {
            return clone().w0(cls, interfaceC15645jv7, z);
        }
        AbstractC3322Aj5.d(cls);
        AbstractC3322Aj5.d(interfaceC15645jv7);
        this.r.put(cls, interfaceC15645jv7);
        int i = this.a;
        this.n = true;
        this.a = 67584 | i;
        this.y = false;
        if (z) {
            this.a = i | 198656;
            this.m = true;
        }
        return l0();
    }

    public final Drawable x() {
        return this.g;
    }

    public final int y() {
        return this.h;
    }

    public AbstractC6302Na0 y0(InterfaceC15645jv7... interfaceC15645jv7Arr) {
        return interfaceC15645jv7Arr.length > 1 ? v0(new C6166Ml4(interfaceC15645jv7Arr), true) : interfaceC15645jv7Arr.length == 1 ? u0(interfaceC15645jv7Arr[0]) : l0();
    }

    public final EnumC6212Mq5 z() {
        return this.d;
    }

    public AbstractC6302Na0 z0(boolean z) {
        if (this.v) {
            return clone().z0(z);
        }
        this.z = z;
        this.a |= 1048576;
        return l0();
    }

    private AbstractC6302Na0 k0() {
        return this;
    }
}
