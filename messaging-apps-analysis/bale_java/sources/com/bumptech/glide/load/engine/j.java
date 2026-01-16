package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.o;
import ir.nasim.AbstractC21437tf2;
import ir.nasim.AbstractC23175wU1;
import ir.nasim.AbstractC3322Aj5;
import ir.nasim.C22579vU1;
import ir.nasim.DW5;
import ir.nasim.EI3;
import ir.nasim.EnumC21012sz1;
import ir.nasim.EnumC6212Mq5;
import ir.nasim.FW5;
import ir.nasim.HL4;
import ir.nasim.InterfaceC14373ho3;
import ir.nasim.InterfaceC20850si5;
import ir.nasim.InterfaceC21989uU1;
import ir.nasim.K34;
import ir.nasim.PI2;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class j implements l, K34.a, o.a {
    private static final boolean i = Log.isLoggable("Engine", 2);
    private final p a;
    private final n b;
    private final K34 c;
    private final b d;
    private final u e;
    private final c f;
    private final a g;
    private final com.bumptech.glide.load.engine.a h;

    static class a {
        final h.e a;
        final InterfaceC20850si5 b = AbstractC21437tf2.d(150, new C0151a());
        private int c;

        /* renamed from: com.bumptech.glide.load.engine.j$a$a, reason: collision with other inner class name */
        class C0151a implements AbstractC21437tf2.d {
            C0151a() {
            }

            @Override // ir.nasim.AbstractC21437tf2.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h create() {
                a aVar = a.this;
                return new h(aVar.a, aVar.b);
            }
        }

        a(h.e eVar) {
            this.a = eVar;
        }

        h a(com.bumptech.glide.d dVar, Object obj, m mVar, InterfaceC14373ho3 interfaceC14373ho3, int i, int i2, Class cls, Class cls2, EnumC6212Mq5 enumC6212Mq5, AbstractC23175wU1 abstractC23175wU1, Map map, boolean z, boolean z2, boolean z3, HL4 hl4, h.b bVar) {
            h hVar = (h) AbstractC3322Aj5.d((h) this.b.b());
            int i3 = this.c;
            this.c = i3 + 1;
            return hVar.w(dVar, obj, mVar, interfaceC14373ho3, i, i2, cls, cls2, enumC6212Mq5, abstractC23175wU1, map, z, z2, z3, hl4, bVar, i3);
        }
    }

    static class b {
        final PI2 a;
        final PI2 b;
        final PI2 c;
        final PI2 d;
        final l e;
        final o.a f;
        final InterfaceC20850si5 g = AbstractC21437tf2.d(150, new a());

        class a implements AbstractC21437tf2.d {
            a() {
            }

            @Override // ir.nasim.AbstractC21437tf2.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public k create() {
                b bVar = b.this;
                return new k(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g);
            }
        }

        b(PI2 pi2, PI2 pi22, PI2 pi23, PI2 pi24, l lVar, o.a aVar) {
            this.a = pi2;
            this.b = pi22;
            this.c = pi23;
            this.d = pi24;
            this.e = lVar;
            this.f = aVar;
        }

        k a(InterfaceC14373ho3 interfaceC14373ho3, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((k) AbstractC3322Aj5.d((k) this.g.b())).l(interfaceC14373ho3, z, z2, z3, z4);
        }
    }

    private static class c implements h.e {
        private final InterfaceC21989uU1.a a;
        private volatile InterfaceC21989uU1 b;

        c(InterfaceC21989uU1.a aVar) {
            this.a = aVar;
        }

        @Override // com.bumptech.glide.load.engine.h.e
        public InterfaceC21989uU1 a() {
            if (this.b == null) {
                synchronized (this) {
                    try {
                        if (this.b == null) {
                            this.b = this.a.a();
                        }
                        if (this.b == null) {
                            this.b = new C22579vU1();
                        }
                    } finally {
                    }
                }
            }
            return this.b;
        }
    }

    public class d {
        private final k a;
        private final FW5 b;

        d(FW5 fw5, k kVar) {
            this.b = fw5;
            this.a = kVar;
        }

        public void a() {
            synchronized (j.this) {
                this.a.r(this.b);
            }
        }
    }

    public j(K34 k34, InterfaceC21989uU1.a aVar, PI2 pi2, PI2 pi22, PI2 pi23, PI2 pi24, boolean z) {
        this(k34, aVar, pi2, pi22, pi23, pi24, null, null, null, null, null, null, z);
    }

    private o e(InterfaceC14373ho3 interfaceC14373ho3) {
        DW5 dw5E = this.c.e(interfaceC14373ho3);
        if (dw5E == null) {
            return null;
        }
        return dw5E instanceof o ? (o) dw5E : new o(dw5E, true, true, interfaceC14373ho3, this);
    }

    private o g(InterfaceC14373ho3 interfaceC14373ho3) {
        o oVarE = this.h.e(interfaceC14373ho3);
        if (oVarE != null) {
            oVarE.c();
        }
        return oVarE;
    }

    private o h(InterfaceC14373ho3 interfaceC14373ho3) {
        o oVarE = e(interfaceC14373ho3);
        if (oVarE != null) {
            oVarE.c();
            this.h.a(interfaceC14373ho3, oVarE);
        }
        return oVarE;
    }

    private o i(m mVar, boolean z, long j) {
        if (!z) {
            return null;
        }
        o oVarG = g(mVar);
        if (oVarG != null) {
            if (i) {
                j("Loaded resource from active resources", j, mVar);
            }
            return oVarG;
        }
        o oVarH = h(mVar);
        if (oVarH == null) {
            return null;
        }
        if (i) {
            j("Loaded resource from cache", j, mVar);
        }
        return oVarH;
    }

    private static void j(String str, long j, InterfaceC14373ho3 interfaceC14373ho3) {
        Log.v("Engine", str + " in " + EI3.a(j) + "ms, key: " + interfaceC14373ho3);
    }

    private d l(com.bumptech.glide.d dVar, Object obj, InterfaceC14373ho3 interfaceC14373ho3, int i2, int i3, Class cls, Class cls2, EnumC6212Mq5 enumC6212Mq5, AbstractC23175wU1 abstractC23175wU1, Map map, boolean z, boolean z2, HL4 hl4, boolean z3, boolean z4, boolean z5, boolean z6, FW5 fw5, Executor executor, m mVar, long j) {
        k kVarA = this.a.a(mVar, z6);
        if (kVarA != null) {
            kVarA.a(fw5, executor);
            if (i) {
                j("Added to existing load", j, mVar);
            }
            return new d(fw5, kVarA);
        }
        k kVarA2 = this.d.a(mVar, z3, z4, z5, z6);
        h hVarA = this.g.a(dVar, obj, mVar, interfaceC14373ho3, i2, i3, cls, cls2, enumC6212Mq5, abstractC23175wU1, map, z, z2, z6, hl4, kVarA2);
        this.a.c(mVar, kVarA2);
        kVarA2.a(fw5, executor);
        kVarA2.s(hVarA);
        if (i) {
            j("Started new load", j, mVar);
        }
        return new d(fw5, kVarA2);
    }

    @Override // ir.nasim.K34.a
    public void a(DW5 dw5) {
        this.e.a(dw5, true);
    }

    @Override // com.bumptech.glide.load.engine.o.a
    public void b(InterfaceC14373ho3 interfaceC14373ho3, o oVar) {
        this.h.d(interfaceC14373ho3);
        if (oVar.e()) {
            this.c.c(interfaceC14373ho3, oVar);
        } else {
            this.e.a(oVar, false);
        }
    }

    @Override // com.bumptech.glide.load.engine.l
    public synchronized void c(k kVar, InterfaceC14373ho3 interfaceC14373ho3) {
        this.a.d(interfaceC14373ho3, kVar);
    }

    @Override // com.bumptech.glide.load.engine.l
    public synchronized void d(k kVar, InterfaceC14373ho3 interfaceC14373ho3, o oVar) {
        if (oVar != null) {
            try {
                if (oVar.e()) {
                    this.h.a(interfaceC14373ho3, oVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.a.d(interfaceC14373ho3, kVar);
    }

    public d f(com.bumptech.glide.d dVar, Object obj, InterfaceC14373ho3 interfaceC14373ho3, int i2, int i3, Class cls, Class cls2, EnumC6212Mq5 enumC6212Mq5, AbstractC23175wU1 abstractC23175wU1, Map map, boolean z, boolean z2, HL4 hl4, boolean z3, boolean z4, boolean z5, boolean z6, FW5 fw5, Executor executor) {
        long jB = i ? EI3.b() : 0L;
        m mVarA = this.b.a(obj, interfaceC14373ho3, i2, i3, map, cls, cls2, hl4);
        synchronized (this) {
            try {
                o oVarI = i(mVarA, z3, jB);
                if (oVarI == null) {
                    return l(dVar, obj, interfaceC14373ho3, i2, i3, cls, cls2, enumC6212Mq5, abstractC23175wU1, map, z, z2, hl4, z3, z4, z5, z6, fw5, executor, mVarA, jB);
                }
                fw5.b(oVarI, EnumC21012sz1.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k(DW5 dw5) {
        if (!(dw5 instanceof o)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((o) dw5).g();
    }

    j(K34 k34, InterfaceC21989uU1.a aVar, PI2 pi2, PI2 pi22, PI2 pi23, PI2 pi24, p pVar, n nVar, com.bumptech.glide.load.engine.a aVar2, b bVar, a aVar3, u uVar, boolean z) {
        this.c = k34;
        c cVar = new c(aVar);
        this.f = cVar;
        com.bumptech.glide.load.engine.a aVar4 = aVar2 == null ? new com.bumptech.glide.load.engine.a(z) : aVar2;
        this.h = aVar4;
        aVar4.f(this);
        this.b = nVar == null ? new n() : nVar;
        this.a = pVar == null ? new p() : pVar;
        this.d = bVar == null ? new b(pi2, pi22, pi23, pi24, this, this) : bVar;
        this.g = aVar3 == null ? new a(cVar) : aVar3;
        this.e = uVar == null ? new u() : uVar;
        k34.d(this);
    }
}
