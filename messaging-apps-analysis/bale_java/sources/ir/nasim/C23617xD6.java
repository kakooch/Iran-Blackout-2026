package ir.nasim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.j;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.xD6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23617xD6 implements RP5, YD6, FW5 {
    private static final boolean E = Log.isLoggable("GlideRequest", 2);
    private int A;
    private int B;
    private boolean C;
    private RuntimeException D;
    private int a;
    private final String b;
    private final AbstractC18254oL6 c;
    private final Object d;
    private final IT5 e;
    private final CQ5 f;
    private final Context g;
    private final com.bumptech.glide.d h;
    private final Object i;
    private final Class j;
    private final AbstractC6302Na0 k;
    private final int l;
    private final int m;
    private final EnumC6212Mq5 n;
    private final InterfaceC21549tj7 o;
    private final List p;
    private final InterfaceC3905Cv7 q;
    private final Executor r;
    private DW5 s;
    private j.d t;
    private long u;
    private volatile com.bumptech.glide.load.engine.j v;
    private a w;
    private Drawable x;
    private Drawable y;
    private Drawable z;

    /* renamed from: ir.nasim.xD6$a */
    private enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private C23617xD6(Context context, com.bumptech.glide.d dVar, Object obj, Object obj2, Class cls, AbstractC6302Na0 abstractC6302Na0, int i, int i2, EnumC6212Mq5 enumC6212Mq5, InterfaceC21549tj7 interfaceC21549tj7, IT5 it5, List list, CQ5 cq5, com.bumptech.glide.load.engine.j jVar, InterfaceC3905Cv7 interfaceC3905Cv7, Executor executor) {
        this.b = E ? String.valueOf(super.hashCode()) : null;
        this.c = AbstractC18254oL6.a();
        this.d = obj;
        this.g = context;
        this.h = dVar;
        this.i = obj2;
        this.j = cls;
        this.k = abstractC6302Na0;
        this.l = i;
        this.m = i2;
        this.n = enumC6212Mq5;
        this.o = interfaceC21549tj7;
        this.e = it5;
        this.p = list;
        this.f = cq5;
        this.v = jVar;
        this.q = interfaceC3905Cv7;
        this.r = executor;
        this.w = a.PENDING;
        if (this.D == null && dVar.g().a(c.C0144c.class)) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    private void A(GlideException glideException, int i) {
        boolean zD;
        this.c.c();
        synchronized (this.d) {
            try {
                glideException.m(this.D);
                int iH = this.h.h();
                if (iH <= i) {
                    Log.w("Glide", "Load failed for [" + this.i + "] with dimensions [" + this.A + "x" + this.B + "]", glideException);
                    if (iH <= 4) {
                        glideException.g("Glide");
                    }
                }
                this.t = null;
                this.w = a.FAILED;
                x();
                boolean z = true;
                this.C = true;
                try {
                    List list = this.p;
                    if (list != null) {
                        Iterator it = list.iterator();
                        zD = false;
                        while (it.hasNext()) {
                            zD |= ((IT5) it.next()).d(glideException, this.i, this.o, t());
                        }
                    } else {
                        zD = false;
                    }
                    IT5 it5 = this.e;
                    if (it5 == null || !it5.d(glideException, this.i, this.o, t())) {
                        z = false;
                    }
                    if (!(zD | z)) {
                        C();
                    }
                    this.C = false;
                    XI2.f("GlideRequest", this.a);
                } catch (Throwable th) {
                    this.C = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void B(DW5 dw5, Object obj, EnumC21012sz1 enumC21012sz1, boolean z) {
        boolean zB;
        boolean zT = t();
        this.w = a.COMPLETE;
        this.s = dw5;
        if (this.h.h() <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + enumC21012sz1 + " for " + this.i + " with size [" + this.A + "x" + this.B + "] in " + EI3.a(this.u) + " ms");
        }
        y();
        boolean z2 = true;
        this.C = true;
        try {
            List list = this.p;
            if (list != null) {
                Iterator it = list.iterator();
                zB = false;
                while (it.hasNext()) {
                    zB |= ((IT5) it.next()).b(obj, this.i, this.o, enumC21012sz1, zT);
                }
            } else {
                zB = false;
            }
            IT5 it5 = this.e;
            if (it5 == null || !it5.b(obj, this.i, this.o, enumC21012sz1, zT)) {
                z2 = false;
            }
            if (!(z2 | zB)) {
                this.o.a(obj, this.q.a(enumC21012sz1, zT));
            }
            this.C = false;
            XI2.f("GlideRequest", this.a);
        } catch (Throwable th) {
            this.C = false;
            throw th;
        }
    }

    private void C() {
        if (m()) {
            Drawable drawableR = this.i == null ? r() : null;
            if (drawableR == null) {
                drawableR = q();
            }
            if (drawableR == null) {
                drawableR = s();
            }
            this.o.k(drawableR);
        }
    }

    private void k() {
        if (this.C) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean l() {
        CQ5 cq5 = this.f;
        return cq5 == null || cq5.d(this);
    }

    private boolean m() {
        CQ5 cq5 = this.f;
        return cq5 == null || cq5.f(this);
    }

    private boolean n() {
        CQ5 cq5 = this.f;
        return cq5 == null || cq5.c(this);
    }

    private void o() {
        k();
        this.c.c();
        this.o.c(this);
        j.d dVar = this.t;
        if (dVar != null) {
            dVar.a();
            this.t = null;
        }
    }

    private void p(Object obj) {
        List<IT5> list = this.p;
        if (list == null) {
            return;
        }
        for (IT5 it5 : list) {
        }
    }

    private Drawable q() {
        if (this.x == null) {
            Drawable drawableQ = this.k.q();
            this.x = drawableQ;
            if (drawableQ == null && this.k.p() > 0) {
                this.x = u(this.k.p());
            }
        }
        return this.x;
    }

    private Drawable r() {
        if (this.z == null) {
            Drawable drawableR = this.k.r();
            this.z = drawableR;
            if (drawableR == null && this.k.s() > 0) {
                this.z = u(this.k.s());
            }
        }
        return this.z;
    }

    private Drawable s() {
        if (this.y == null) {
            Drawable drawableX = this.k.x();
            this.y = drawableX;
            if (drawableX == null && this.k.y() > 0) {
                this.y = u(this.k.y());
            }
        }
        return this.y;
    }

    private boolean t() {
        CQ5 cq5 = this.f;
        return cq5 == null || !cq5.getRoot().a();
    }

    private Drawable u(int i) {
        return AbstractC23486x02.a(this.g, i, this.k.D() != null ? this.k.D() : this.g.getTheme());
    }

    private void v(String str) {
        Log.v("GlideRequest", str + " this: " + this.b);
    }

    private static int w(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    private void x() {
        CQ5 cq5 = this.f;
        if (cq5 != null) {
            cq5.k(this);
        }
    }

    private void y() {
        CQ5 cq5 = this.f;
        if (cq5 != null) {
            cq5.b(this);
        }
    }

    public static C23617xD6 z(Context context, com.bumptech.glide.d dVar, Object obj, Object obj2, Class cls, AbstractC6302Na0 abstractC6302Na0, int i, int i2, EnumC6212Mq5 enumC6212Mq5, InterfaceC21549tj7 interfaceC21549tj7, IT5 it5, List list, CQ5 cq5, com.bumptech.glide.load.engine.j jVar, InterfaceC3905Cv7 interfaceC3905Cv7, Executor executor) {
        return new C23617xD6(context, dVar, obj, obj2, cls, abstractC6302Na0, i, i2, enumC6212Mq5, interfaceC21549tj7, it5, list, cq5, jVar, interfaceC3905Cv7, executor);
    }

    @Override // ir.nasim.RP5
    public boolean a() {
        boolean z;
        synchronized (this.d) {
            z = this.w == a.COMPLETE;
        }
        return z;
    }

    @Override // ir.nasim.FW5
    public void b(DW5 dw5, EnumC21012sz1 enumC21012sz1, boolean z) {
        this.c.c();
        DW5 dw52 = null;
        try {
            synchronized (this.d) {
                try {
                    this.t = null;
                    if (dw5 == null) {
                        c(new GlideException("Expected to receive a Resource<R> with an object of " + this.j + " inside, but instead got null."));
                        return;
                    }
                    Object obj = dw5.get();
                    try {
                        if (obj != null && this.j.isAssignableFrom(obj.getClass())) {
                            if (n()) {
                                B(dw5, obj, enumC21012sz1, z);
                                return;
                            }
                            this.s = null;
                            this.w = a.COMPLETE;
                            XI2.f("GlideRequest", this.a);
                            this.v.k(dw5);
                            return;
                        }
                        this.s = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.j);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(dw5);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        c(new GlideException(sb.toString()));
                        this.v.k(dw5);
                    } catch (Throwable th) {
                        dw52 = dw5;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (dw52 != null) {
                this.v.k(dw52);
            }
            throw th3;
        }
    }

    @Override // ir.nasim.FW5
    public void c(GlideException glideException) {
        A(glideException, 5);
    }

    @Override // ir.nasim.RP5
    public void clear() {
        synchronized (this.d) {
            try {
                k();
                this.c.c();
                a aVar = this.w;
                a aVar2 = a.CLEARED;
                if (aVar == aVar2) {
                    return;
                }
                o();
                DW5 dw5 = this.s;
                if (dw5 != null) {
                    this.s = null;
                } else {
                    dw5 = null;
                }
                if (l()) {
                    this.o.g(s());
                }
                XI2.f("GlideRequest", this.a);
                this.w = aVar2;
                if (dw5 != null) {
                    this.v.k(dw5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.YD6
    public void d(int i, int i2) throws Throwable {
        Object obj;
        this.c.c();
        Object obj2 = this.d;
        synchronized (obj2) {
            try {
                try {
                    boolean z = E;
                    if (z) {
                        v("Got onSizeReady in " + EI3.a(this.u));
                    }
                    if (this.w == a.WAITING_FOR_SIZE) {
                        a aVar = a.RUNNING;
                        this.w = aVar;
                        float fC = this.k.C();
                        this.A = w(i, fC);
                        this.B = w(i2, fC);
                        if (z) {
                            v("finished setup for calling load in " + EI3.a(this.u));
                        }
                        obj = obj2;
                        try {
                            this.t = this.v.f(this.h, this.i, this.k.B(), this.A, this.B, this.k.A(), this.j, this.n, this.k.o(), this.k.E(), this.k.T(), this.k.M(), this.k.u(), this.k.K(), this.k.G(), this.k.F(), this.k.t(), this, this.r);
                            if (this.w != aVar) {
                                this.t = null;
                            }
                            if (z) {
                                v("finished onSizeReady in " + EI3.a(this.u));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
            }
        }
    }

    @Override // ir.nasim.RP5
    public boolean e() {
        boolean z;
        synchronized (this.d) {
            z = this.w == a.CLEARED;
        }
        return z;
    }

    @Override // ir.nasim.FW5
    public Object f() {
        this.c.c();
        return this.d;
    }

    @Override // ir.nasim.RP5
    public boolean g() {
        boolean z;
        synchronized (this.d) {
            z = this.w == a.COMPLETE;
        }
        return z;
    }

    @Override // ir.nasim.RP5
    public void h() {
        synchronized (this.d) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.RP5
    public void i() {
        synchronized (this.d) {
            try {
                k();
                this.c.c();
                this.u = EI3.b();
                Object obj = this.i;
                if (obj == null) {
                    if (YM7.v(this.l, this.m)) {
                        this.A = this.l;
                        this.B = this.m;
                    }
                    A(new GlideException("Received null model"), r() == null ? 5 : 3);
                    return;
                }
                a aVar = this.w;
                a aVar2 = a.RUNNING;
                if (aVar == aVar2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (aVar == a.COMPLETE) {
                    b(this.s, EnumC21012sz1.MEMORY_CACHE, false);
                    return;
                }
                p(obj);
                this.a = XI2.b("GlideRequest");
                a aVar3 = a.WAITING_FOR_SIZE;
                this.w = aVar3;
                if (YM7.v(this.l, this.m)) {
                    d(this.l, this.m);
                } else {
                    this.o.h(this);
                }
                a aVar4 = this.w;
                if ((aVar4 == aVar2 || aVar4 == aVar3) && m()) {
                    this.o.e(s());
                }
                if (E) {
                    v("finished run method in " + EI3.a(this.u));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.RP5
    public boolean isRunning() {
        boolean z;
        synchronized (this.d) {
            try {
                a aVar = this.w;
                z = aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE;
            } finally {
            }
        }
        return z;
    }

    @Override // ir.nasim.RP5
    public boolean j(RP5 rp5) {
        int i;
        int i2;
        Object obj;
        Class cls;
        AbstractC6302Na0 abstractC6302Na0;
        EnumC6212Mq5 enumC6212Mq5;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class cls2;
        AbstractC6302Na0 abstractC6302Na02;
        EnumC6212Mq5 enumC6212Mq52;
        int size2;
        if (!(rp5 instanceof C23617xD6)) {
            return false;
        }
        synchronized (this.d) {
            try {
                i = this.l;
                i2 = this.m;
                obj = this.i;
                cls = this.j;
                abstractC6302Na0 = this.k;
                enumC6212Mq5 = this.n;
                List list = this.p;
                size = list != null ? list.size() : 0;
            } finally {
            }
        }
        C23617xD6 c23617xD6 = (C23617xD6) rp5;
        synchronized (c23617xD6.d) {
            try {
                i3 = c23617xD6.l;
                i4 = c23617xD6.m;
                obj2 = c23617xD6.i;
                cls2 = c23617xD6.j;
                abstractC6302Na02 = c23617xD6.k;
                enumC6212Mq52 = c23617xD6.n;
                List list2 = c23617xD6.p;
                size2 = list2 != null ? list2.size() : 0;
            } finally {
            }
        }
        return i == i3 && i2 == i4 && YM7.d(obj, obj2) && cls.equals(cls2) && YM7.c(abstractC6302Na0, abstractC6302Na02) && enumC6212Mq5 == enumC6212Mq52 && size == size2;
    }

    public String toString() {
        Object obj;
        Class cls;
        synchronized (this.d) {
            obj = this.i;
            cls = this.j;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
