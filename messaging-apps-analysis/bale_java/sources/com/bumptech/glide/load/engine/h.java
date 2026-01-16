package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.f;
import com.bumptech.glide.load.engine.i;
import ir.nasim.AbstractC18254oL6;
import ir.nasim.AbstractC21437tf2;
import ir.nasim.AbstractC23175wU1;
import ir.nasim.B73;
import ir.nasim.C16602lZ1;
import ir.nasim.C23097wL4;
import ir.nasim.DW5;
import ir.nasim.EI3;
import ir.nasim.EnumC21012sz1;
import ir.nasim.EnumC6212Mq5;
import ir.nasim.HL4;
import ir.nasim.InterfaceC14373ho3;
import ir.nasim.InterfaceC15645jv7;
import ir.nasim.InterfaceC20850si5;
import ir.nasim.InterfaceC21989uU1;
import ir.nasim.InterfaceC8666Wy1;
import ir.nasim.KW5;
import ir.nasim.T72;
import ir.nasim.XI2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
class h implements f.a, Runnable, Comparable, AbstractC21437tf2.f {
    private EnumC21012sz1 A;
    private InterfaceC8666Wy1 B;
    private volatile com.bumptech.glide.load.engine.f D;
    private volatile boolean G;
    private volatile boolean H;
    private boolean J;
    private final e d;
    private final InterfaceC20850si5 e;
    private com.bumptech.glide.d h;
    private InterfaceC14373ho3 i;
    private EnumC6212Mq5 j;
    private m k;
    private int l;
    private int m;
    private AbstractC23175wU1 n;
    private HL4 o;
    private b p;
    private int q;
    private EnumC0150h r;
    private g s;
    private long t;
    private boolean u;
    private Object v;
    private Thread w;
    private InterfaceC14373ho3 x;
    private InterfaceC14373ho3 y;
    private Object z;
    private final com.bumptech.glide.load.engine.g a = new com.bumptech.glide.load.engine.g();
    private final List b = new ArrayList();
    private final AbstractC18254oL6 c = AbstractC18254oL6.a();
    private final d f = new d();
    private final f g = new f();

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[T72.values().length];
            c = iArr;
            try {
                iArr[T72.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[T72.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC0150h.values().length];
            b = iArr2;
            try {
                iArr2[EnumC0150h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[EnumC0150h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[EnumC0150h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[EnumC0150h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[EnumC0150h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    interface b {
        void b(DW5 dw5, EnumC21012sz1 enumC21012sz1, boolean z);

        void c(GlideException glideException);

        void d(h hVar);
    }

    private final class c implements i.a {
        private final EnumC21012sz1 a;

        c(EnumC21012sz1 enumC21012sz1) {
            this.a = enumC21012sz1;
        }

        @Override // com.bumptech.glide.load.engine.i.a
        public DW5 a(DW5 dw5) {
            return h.this.E(this.a, dw5);
        }
    }

    private static class d {
        private InterfaceC14373ho3 a;
        private KW5 b;
        private r c;

        d() {
        }

        void a() {
            this.a = null;
            this.b = null;
            this.c = null;
        }

        void b(e eVar, HL4 hl4) {
            XI2.a("DecodeJob.encode");
            try {
                eVar.a().b(this.a, new com.bumptech.glide.load.engine.e(this.b, this.c, hl4));
            } finally {
                this.c.g();
                XI2.e();
            }
        }

        boolean c() {
            return this.c != null;
        }

        void d(InterfaceC14373ho3 interfaceC14373ho3, KW5 kw5, r rVar) {
            this.a = interfaceC14373ho3;
            this.b = kw5;
            this.c = rVar;
        }
    }

    interface e {
        InterfaceC21989uU1 a();
    }

    private static class f {
        private boolean a;
        private boolean b;
        private boolean c;

        f() {
        }

        private boolean a(boolean z) {
            return (this.c || z || this.b) && this.a;
        }

        synchronized boolean b() {
            this.b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.c = true;
            return a(false);
        }

        synchronized boolean d(boolean z) {
            this.a = true;
            return a(z);
        }

        synchronized void e() {
            this.b = false;
            this.a = false;
            this.c = false;
        }
    }

    private enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* renamed from: com.bumptech.glide.load.engine.h$h, reason: collision with other inner class name */
    private enum EnumC0150h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    h(e eVar, InterfaceC20850si5 interfaceC20850si5) {
        this.d = eVar;
        this.e = interfaceC20850si5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A(DW5 dw5, EnumC21012sz1 enumC21012sz1, boolean z) {
        r rVar;
        XI2.a("DecodeJob.notifyEncodeAndRelease");
        try {
            if (dw5 instanceof B73) {
                ((B73) dw5).initialize();
            }
            if (this.f.c()) {
                dw5 = r.d(dw5);
                rVar = dw5;
            } else {
                rVar = 0;
            }
            z(dw5, enumC21012sz1, z);
            this.r = EnumC0150h.ENCODE;
            try {
                if (this.f.c()) {
                    this.f.b(this.d, this.o);
                }
                C();
                XI2.e();
            } finally {
                if (rVar != 0) {
                    rVar.g();
                }
            }
        } catch (Throwable th) {
            XI2.e();
            throw th;
        }
    }

    private void B() {
        L();
        this.p.c(new GlideException("Failed to load resource", new ArrayList(this.b)));
        D();
    }

    private void C() {
        if (this.g.b()) {
            G();
        }
    }

    private void D() {
        if (this.g.c()) {
            G();
        }
    }

    private void G() {
        this.g.e();
        this.f.a();
        this.a.a();
        this.G = false;
        this.h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.D = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0L;
        this.H = false;
        this.v = null;
        this.b.clear();
        this.e.a(this);
    }

    private void H(g gVar) {
        this.s = gVar;
        this.p.d(this);
    }

    private void I() {
        this.w = Thread.currentThread();
        this.t = EI3.b();
        boolean zB = false;
        while (!this.H && this.D != null && !(zB = this.D.b())) {
            this.r = u(this.r);
            this.D = t();
            if (this.r == EnumC0150h.SOURCE) {
                H(g.SWITCH_TO_SOURCE_SERVICE);
                return;
            }
        }
        if ((this.r == EnumC0150h.FINISHED || this.H) && !zB) {
            B();
        }
    }

    private DW5 J(Object obj, EnumC21012sz1 enumC21012sz1, q qVar) {
        HL4 hl4V = v(enumC21012sz1);
        com.bumptech.glide.load.data.a aVarL = this.h.i().l(obj);
        try {
            return qVar.a(aVarL, hl4V, this.l, this.m, new c(enumC21012sz1));
        } finally {
            aVarL.b();
        }
    }

    private void K() {
        int i = a.a[this.s.ordinal()];
        if (i == 1) {
            this.r = u(EnumC0150h.INITIALIZE);
            this.D = t();
            I();
        } else if (i == 2) {
            I();
        } else {
            if (i == 3) {
                s();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.s);
        }
    }

    private void L() {
        Throwable th;
        this.c.c();
        if (!this.G) {
            this.G = true;
            return;
        }
        if (this.b.isEmpty()) {
            th = null;
        } else {
            List list = this.b;
            th = (Throwable) list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    private int getPriority() {
        return this.j.ordinal();
    }

    private DW5 q(InterfaceC8666Wy1 interfaceC8666Wy1, Object obj, EnumC21012sz1 enumC21012sz1) {
        if (obj == null) {
            interfaceC8666Wy1.b();
            return null;
        }
        try {
            long jB = EI3.b();
            DW5 dw5R = r(obj, enumC21012sz1);
            if (Log.isLoggable("DecodeJob", 2)) {
                x("Decoded result " + dw5R, jB);
            }
            return dw5R;
        } finally {
            interfaceC8666Wy1.b();
        }
    }

    private DW5 r(Object obj, EnumC21012sz1 enumC21012sz1) {
        return J(obj, enumC21012sz1, this.a.h(obj.getClass()));
    }

    private void s() {
        DW5 dw5Q;
        if (Log.isLoggable("DecodeJob", 2)) {
            y("Retrieved data", this.t, "data: " + this.z + ", cache key: " + this.x + ", fetcher: " + this.B);
        }
        try {
            dw5Q = q(this.B, this.z, this.A);
        } catch (GlideException e2) {
            e2.k(this.y, this.A);
            this.b.add(e2);
            dw5Q = null;
        }
        if (dw5Q != null) {
            A(dw5Q, this.A, this.J);
        } else {
            I();
        }
    }

    private com.bumptech.glide.load.engine.f t() {
        int i = a.b[this.r.ordinal()];
        if (i == 1) {
            return new s(this.a, this);
        }
        if (i == 2) {
            return new com.bumptech.glide.load.engine.c(this.a, this);
        }
        if (i == 3) {
            return new v(this.a, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.r);
    }

    private EnumC0150h u(EnumC0150h enumC0150h) {
        int i = a.b[enumC0150h.ordinal()];
        if (i == 1) {
            return this.n.a() ? EnumC0150h.DATA_CACHE : u(EnumC0150h.DATA_CACHE);
        }
        if (i == 2) {
            return this.u ? EnumC0150h.FINISHED : EnumC0150h.SOURCE;
        }
        if (i == 3 || i == 4) {
            return EnumC0150h.FINISHED;
        }
        if (i == 5) {
            return this.n.b() ? EnumC0150h.RESOURCE_CACHE : u(EnumC0150h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + enumC0150h);
    }

    private HL4 v(EnumC21012sz1 enumC21012sz1) {
        HL4 hl4 = this.o;
        if (Build.VERSION.SDK_INT < 26) {
            return hl4;
        }
        boolean z = enumC21012sz1 == EnumC21012sz1.RESOURCE_DISK_CACHE || this.a.x();
        C23097wL4 c23097wL4 = C16602lZ1.j;
        Boolean bool = (Boolean) hl4.c(c23097wL4);
        if (bool != null && (!bool.booleanValue() || z)) {
            return hl4;
        }
        HL4 hl42 = new HL4();
        hl42.d(this.o);
        hl42.f(c23097wL4, Boolean.valueOf(z));
        return hl42;
    }

    private void x(String str, long j) {
        y(str, j, null);
    }

    private void y(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(EI3.a(j));
        sb.append(", load key: ");
        sb.append(this.k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void z(DW5 dw5, EnumC21012sz1 enumC21012sz1, boolean z) {
        L();
        this.p.b(dw5, enumC21012sz1, z);
    }

    DW5 E(EnumC21012sz1 enumC21012sz1, DW5 dw5) {
        DW5 dw5A;
        InterfaceC15645jv7 interfaceC15645jv7;
        T72 t72A;
        InterfaceC14373ho3 dVar;
        Class<?> cls = dw5.get().getClass();
        KW5 kw5N = null;
        if (enumC21012sz1 != EnumC21012sz1.RESOURCE_DISK_CACHE) {
            InterfaceC15645jv7 interfaceC15645jv7S = this.a.s(cls);
            interfaceC15645jv7 = interfaceC15645jv7S;
            dw5A = interfaceC15645jv7S.a(this.h, dw5, this.l, this.m);
        } else {
            dw5A = dw5;
            interfaceC15645jv7 = null;
        }
        if (!dw5.equals(dw5A)) {
            dw5.a();
        }
        if (this.a.w(dw5A)) {
            kw5N = this.a.n(dw5A);
            t72A = kw5N.a(this.o);
        } else {
            t72A = T72.NONE;
        }
        KW5 kw5 = kw5N;
        if (!this.n.d(!this.a.y(this.x), enumC21012sz1, t72A)) {
            return dw5A;
        }
        if (kw5 == null) {
            throw new Registry.NoResultEncoderAvailableException(dw5A.get().getClass());
        }
        int i = a.c[t72A.ordinal()];
        if (i == 1) {
            dVar = new com.bumptech.glide.load.engine.d(this.x, this.i);
        } else {
            if (i != 2) {
                throw new IllegalArgumentException("Unknown strategy: " + t72A);
            }
            dVar = new t(this.a.b(), this.x, this.i, this.l, this.m, interfaceC15645jv7, cls, this.o);
        }
        r rVarD = r.d(dw5A);
        this.f.d(dVar, kw5, rVarD);
        return rVarD;
    }

    void F(boolean z) {
        if (this.g.d(z)) {
            G();
        }
    }

    boolean M() {
        EnumC0150h enumC0150hU = u(EnumC0150h.INITIALIZE);
        return enumC0150hU == EnumC0150h.RESOURCE_CACHE || enumC0150hU == EnumC0150h.DATA_CACHE;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void a(InterfaceC14373ho3 interfaceC14373ho3, Exception exc, InterfaceC8666Wy1 interfaceC8666Wy1, EnumC21012sz1 enumC21012sz1) {
        interfaceC8666Wy1.b();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.l(interfaceC14373ho3, enumC21012sz1, interfaceC8666Wy1.a());
        this.b.add(glideException);
        if (Thread.currentThread() != this.w) {
            H(g.SWITCH_TO_SOURCE_SERVICE);
        } else {
            I();
        }
    }

    @Override // ir.nasim.AbstractC21437tf2.f
    public AbstractC18254oL6 h() {
        return this.c;
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void i(InterfaceC14373ho3 interfaceC14373ho3, Object obj, InterfaceC8666Wy1 interfaceC8666Wy1, EnumC21012sz1 enumC21012sz1, InterfaceC14373ho3 interfaceC14373ho32) {
        this.x = interfaceC14373ho3;
        this.z = obj;
        this.B = interfaceC8666Wy1;
        this.A = enumC21012sz1;
        this.y = interfaceC14373ho32;
        this.J = interfaceC14373ho3 != this.a.c().get(0);
        if (Thread.currentThread() != this.w) {
            H(g.DECODE_DATA);
            return;
        }
        XI2.a("DecodeJob.decodeFromRetrievedData");
        try {
            s();
        } finally {
            XI2.e();
        }
    }

    @Override // com.bumptech.glide.load.engine.f.a
    public void j() {
        H(g.SWITCH_TO_SOURCE_SERVICE);
    }

    public void o() {
        this.H = true;
        com.bumptech.glide.load.engine.f fVar = this.D;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public int compareTo(h hVar) {
        int priority = getPriority() - hVar.getPriority();
        return priority == 0 ? this.q - hVar.q : priority;
    }

    @Override // java.lang.Runnable
    public void run() {
        XI2.c("DecodeJob#run(reason=%s, model=%s)", this.s, this.v);
        InterfaceC8666Wy1 interfaceC8666Wy1 = this.B;
        try {
            try {
                if (this.H) {
                    B();
                    if (interfaceC8666Wy1 != null) {
                        interfaceC8666Wy1.b();
                    }
                    XI2.e();
                    return;
                }
                K();
                if (interfaceC8666Wy1 != null) {
                    interfaceC8666Wy1.b();
                }
                XI2.e();
            } catch (Throwable th) {
                if (interfaceC8666Wy1 != null) {
                    interfaceC8666Wy1.b();
                }
                XI2.e();
                throw th;
            }
        } catch (com.bumptech.glide.load.engine.b e2) {
            throw e2;
        } catch (Throwable th2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.H + ", stage: " + this.r, th2);
            }
            if (this.r != EnumC0150h.ENCODE) {
                this.b.add(th2);
                B();
            }
            if (!this.H) {
                throw th2;
            }
            throw th2;
        }
    }

    h w(com.bumptech.glide.d dVar, Object obj, m mVar, InterfaceC14373ho3 interfaceC14373ho3, int i, int i2, Class cls, Class cls2, EnumC6212Mq5 enumC6212Mq5, AbstractC23175wU1 abstractC23175wU1, Map map, boolean z, boolean z2, boolean z3, HL4 hl4, b bVar, int i3) {
        this.a.v(dVar, obj, interfaceC14373ho3, i, i2, abstractC23175wU1, cls, cls2, enumC6212Mq5, hl4, map, z, z2, this.d);
        this.h = dVar;
        this.i = interfaceC14373ho3;
        this.j = enumC6212Mq5;
        this.k = mVar;
        this.l = i;
        this.m = i2;
        this.n = abstractC23175wU1;
        this.u = z3;
        this.o = hl4;
        this.p = bVar;
        this.q = i3;
        this.s = g.INITIALIZE;
        this.v = obj;
        return this;
    }
}
