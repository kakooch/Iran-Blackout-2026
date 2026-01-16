package io.sentry;

import io.sentry.B1;
import io.sentry.protocol.C3168c;
import io.sentry.util.AbstractC3207f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: io.sentry.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3121h implements X {
    private final X a;
    private final X b;
    private final X c;

    /* renamed from: io.sentry.h$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[F1.values().length];
            a = iArr;
            try {
                iArr[F1.CURRENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[F1.ISOLATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[F1.GLOBAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[F1.COMBINED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C3121h(X x, X x2, X x3) {
        this.a = x;
        this.b = x2;
        this.c = x3;
    }

    private X h() {
        return i(null);
    }

    @Override // io.sentry.X
    public void A(String str) {
        h().A(str);
    }

    @Override // io.sentry.X
    public InterfaceC3092b0 B() {
        InterfaceC3092b0 interfaceC3092b0B = this.c.B();
        if (!(interfaceC3092b0B instanceof U0)) {
            return interfaceC3092b0B;
        }
        InterfaceC3092b0 interfaceC3092b0B2 = this.b.B();
        return !(interfaceC3092b0B2 instanceof U0) ? interfaceC3092b0B2 : this.a.B();
    }

    @Override // io.sentry.X
    public List C() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.addAll(this.a.C());
        copyOnWriteArrayList.addAll(this.b.C());
        copyOnWriteArrayList.addAll(this.c.C());
        return copyOnWriteArrayList;
    }

    @Override // io.sentry.X
    public void D(L2 l2) {
        this.a.D(l2);
    }

    @Override // io.sentry.X
    public C3199u1 E(B1.a aVar) {
        return h().E(aVar);
    }

    @Override // io.sentry.X
    public void F(B1.c cVar) {
        h().F(cVar);
    }

    @Override // io.sentry.X
    public void G(io.sentry.protocol.v vVar) {
        this.a.G(vVar);
        this.b.G(vVar);
        this.c.G(vVar);
    }

    @Override // io.sentry.X
    public List H() {
        return AbstractC3207f.a(q());
    }

    @Override // io.sentry.X
    public void I(C3199u1 c3199u1) {
        h().I(c3199u1);
    }

    @Override // io.sentry.X
    public Y2 a() {
        Y2 y2A = this.c.a();
        if (y2A != null) {
            return y2A;
        }
        Y2 y2A2 = this.b.a();
        return y2A2 != null ? y2A2 : this.a.a();
    }

    @Override // io.sentry.X
    public void b(C3106e c3106e, I i) {
        h().b(c3106e, i);
    }

    @Override // io.sentry.X
    public InterfaceC3117g0 c() {
        InterfaceC3117g0 interfaceC3117g0C = this.c.c();
        if (interfaceC3117g0C != null) {
            return interfaceC3117g0C;
        }
        InterfaceC3117g0 interfaceC3117g0C2 = this.b.c();
        return interfaceC3117g0C2 != null ? interfaceC3117g0C2 : this.a.c();
    }

    @Override // io.sentry.X
    public void clear() {
        h().clear();
    }

    @Override // io.sentry.X
    public void d(Throwable th, InterfaceC3117g0 interfaceC3117g0, String str) {
        this.a.d(th, interfaceC3117g0, str);
    }

    @Override // io.sentry.X
    public C3155n3 e() {
        return this.a.e();
    }

    @Override // io.sentry.X
    public InterfaceC3127i0 f() {
        InterfaceC3127i0 interfaceC3127i0F = this.c.f();
        if (interfaceC3127i0F != null) {
            return interfaceC3127i0F;
        }
        InterfaceC3127i0 interfaceC3127i0F2 = this.b.f();
        return interfaceC3127i0F2 != null ? interfaceC3127i0F2 : this.a.f();
    }

    @Override // io.sentry.X
    public C3 g() {
        return h().g();
    }

    @Override // io.sentry.X
    public Map getExtras() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(this.a.getExtras());
        concurrentHashMap.putAll(this.b.getExtras());
        concurrentHashMap.putAll(this.c.getExtras());
        return concurrentHashMap;
    }

    @Override // io.sentry.X
    public io.sentry.protocol.m getRequest() {
        io.sentry.protocol.m request = this.c.getRequest();
        if (request != null) {
            return request;
        }
        io.sentry.protocol.m request2 = this.b.getRequest();
        return request2 != null ? request2 : this.a.getRequest();
    }

    @Override // io.sentry.X
    public io.sentry.protocol.G getUser() {
        io.sentry.protocol.G user = this.c.getUser();
        if (user != null) {
            return user;
        }
        io.sentry.protocol.G user2 = this.b.getUser();
        return user2 != null ? user2 : this.a.getUser();
    }

    X i(F1 f1) {
        if (f1 != null) {
            int i = a.a[f1.ordinal()];
            if (i == 1) {
                return this.c;
            }
            if (i == 2) {
                return this.b;
            }
            if (i == 3) {
                return this.a;
            }
            if (i == 4) {
                return this;
            }
        }
        int i2 = a.a[e().getDefaultScopeType().ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? this.c : this.a : this.b : this.c;
    }

    @Override // io.sentry.X
    public io.sentry.protocol.v j() {
        io.sentry.protocol.v vVarJ = this.c.j();
        io.sentry.protocol.v vVar = io.sentry.protocol.v.b;
        if (!vVar.equals(vVarJ)) {
            return vVarJ;
        }
        io.sentry.protocol.v vVarJ2 = this.b.j();
        return !vVar.equals(vVarJ2) ? vVarJ2 : this.a.j();
    }

    @Override // io.sentry.X
    public void k(io.sentry.protocol.v vVar) {
        h().k(vVar);
    }

    @Override // io.sentry.X
    public B1.d l() {
        return h().l();
    }

    @Override // io.sentry.X
    public void m(C3155n3 c3155n3) {
        this.a.m(c3155n3);
    }

    @Override // io.sentry.X
    public Queue n() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.a.n());
        arrayList.addAll(this.b.n());
        arrayList.addAll(this.c.n());
        Collections.sort(arrayList);
        Queue queueK = B1.K(this.c.e().getMaxBreadcrumbs());
        queueK.addAll(arrayList);
        return queueK;
    }

    @Override // io.sentry.X
    public C3 o(B1.b bVar) {
        return h().o(bVar);
    }

    @Override // io.sentry.X
    public Map p() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putAll(this.a.p());
        concurrentHashMap.putAll(this.b.p());
        concurrentHashMap.putAll(this.c.p());
        return concurrentHashMap;
    }

    @Override // io.sentry.X
    public List q() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.addAll(this.a.q());
        copyOnWriteArrayList.addAll(this.b.q());
        copyOnWriteArrayList.addAll(this.c.q());
        Collections.sort(copyOnWriteArrayList);
        return copyOnWriteArrayList;
    }

    @Override // io.sentry.X
    public C3168c r() {
        return new C3116g(this.a.r(), this.b.r(), this.c.r(), e().getDefaultScopeType());
    }

    @Override // io.sentry.X
    public String s() {
        String strS = this.c.s();
        if (strS != null) {
            return strS;
        }
        String strS2 = this.b.s();
        return strS2 != null ? strS2 : this.a.s();
    }

    @Override // io.sentry.X
    public void t(InterfaceC3127i0 interfaceC3127i0) {
        h().t(interfaceC3127i0);
    }

    @Override // io.sentry.X
    public List u() {
        List listU = this.c.u();
        if (!listU.isEmpty()) {
            return listU;
        }
        List listU2 = this.b.u();
        return !listU2.isEmpty() ? listU2 : this.a.u();
    }

    @Override // io.sentry.X
    public String v() {
        String strV = this.c.v();
        if (strV != null) {
            return strV;
        }
        String strV2 = this.b.v();
        return strV2 != null ? strV2 : this.a.v();
    }

    @Override // io.sentry.X
    public void w() {
        h().w();
    }

    @Override // io.sentry.X
    public void x(InterfaceC3092b0 interfaceC3092b0) {
        h().x(interfaceC3092b0);
    }

    @Override // io.sentry.X
    public C3 y() {
        C3 c3Y = this.c.y();
        if (c3Y != null) {
            return c3Y;
        }
        C3 c3Y2 = this.b.y();
        return c3Y2 != null ? c3Y2 : this.a.y();
    }

    @Override // io.sentry.X
    public C3199u1 z() {
        return h().z();
    }

    @Override // io.sentry.X
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public X m22clone() {
        return new C3121h(this.a, this.b.m15clone(), this.c.m15clone());
    }
}
