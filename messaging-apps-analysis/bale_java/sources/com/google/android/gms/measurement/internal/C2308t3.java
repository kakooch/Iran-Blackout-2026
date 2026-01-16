package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C3264Ad1;
import ir.nasim.Gm8;
import ir.nasim.InterfaceC19683ql8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.t3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2308t3 extends AbstractC2311u1 {
    private final ServiceConnectionC2303s3 c;
    private Gm8 d;
    private volatile Boolean e;
    private final AbstractC2275n f;
    private final K3 g;
    private final List h;
    private final AbstractC2275n i;

    protected C2308t3(H1 h1) {
        super(h1);
        this.h = new ArrayList();
        this.g = new K3(h1.c());
        this.c = new ServiceConnectionC2303s3(this);
        this.f = new C2224c3(this, h1);
        this.i = new C2234e3(this, h1);
    }

    private final zzq C(boolean z) {
        Pair pairA;
        this.a.d();
        U0 u0B = this.a.B();
        String str = null;
        if (z) {
            C2227d1 c2227d1B = this.a.b();
            if (c2227d1B.a.F().d != null && (pairA = c2227d1B.a.F().d.a()) != null && pairA != C2292q1.y) {
                str = String.valueOf(pairA.second) + ":" + ((String) pairA.first);
            }
        }
        return u0B.q(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        h();
        this.a.b().v().b("Processing queued up service tasks", Integer.valueOf(this.h.size()));
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e) {
                this.a.b().r().b("Task exception while flushing queue", e);
            }
        }
        this.h.clear();
        this.i.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        h();
        this.g.b();
        AbstractC2275n abstractC2275n = this.f;
        this.a.z();
        abstractC2275n.d(((Long) S0.K.a(null)).longValue());
    }

    private final void F(Runnable runnable) {
        h();
        if (z()) {
            runnable.run();
            return;
        }
        int size = this.h.size();
        this.a.z();
        if (size >= 1000) {
            this.a.b().r().a("Discarding data. Max runnable queue size reached");
            return;
        }
        this.h.add(runnable);
        this.i.d(60000L);
        P();
    }

    private final boolean G() {
        this.a.d();
        return true;
    }

    static /* bridge */ /* synthetic */ void M(C2308t3 c2308t3, ComponentName componentName) {
        c2308t3.h();
        if (c2308t3.d != null) {
            c2308t3.d = null;
            c2308t3.a.b().v().b("Disconnected from device MeasurementService", componentName);
            c2308t3.h();
            c2308t3.P();
        }
    }

    final boolean A() {
        h();
        i();
        return !B() || this.a.N().o0() >= ((Integer) S0.h0.a(null)).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final boolean B() {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2308t3.B():boolean");
    }

    final Boolean J() {
        return this.e;
    }

    protected final void O() {
        h();
        i();
        zzq zzqVarC = C(true);
        this.a.C().r();
        F(new Z2(this, zzqVarC));
    }

    final void P() {
        h();
        i();
        if (z()) {
            return;
        }
        if (B()) {
            this.c.c();
            return;
        }
        if (this.a.z().G()) {
            return;
        }
        this.a.d();
        List<ResolveInfo> listQueryIntentServices = this.a.f().getPackageManager().queryIntentServices(new Intent().setClassName(this.a.f(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            this.a.b().r().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        Context contextF = this.a.f();
        this.a.d();
        intent.setComponent(new ComponentName(contextF, "com.google.android.gms.measurement.AppMeasurementService"));
        this.c.b(intent);
    }

    public final void Q() {
        h();
        i();
        this.c.d();
        try {
            C3264Ad1.b().c(this.a.f(), this.c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.d = null;
    }

    public final void R(InterfaceC19683ql8 interfaceC19683ql8) {
        h();
        i();
        F(new Y2(this, C(false), interfaceC19683ql8));
    }

    public final void S(AtomicReference atomicReference) {
        h();
        i();
        F(new X2(this, atomicReference, C(false)));
    }

    protected final void T(InterfaceC19683ql8 interfaceC19683ql8, String str, String str2) {
        h();
        i();
        F(new RunnableC2269l3(this, str, str2, C(false), interfaceC19683ql8));
    }

    protected final void U(AtomicReference atomicReference, String str, String str2, String str3) {
        h();
        i();
        F(new RunnableC2264k3(this, atomicReference, null, str2, str3, C(false)));
    }

    protected final void V(InterfaceC19683ql8 interfaceC19683ql8, String str, String str2, boolean z) {
        h();
        i();
        F(new U2(this, str, str2, C(false), z, interfaceC19683ql8));
    }

    protected final void W(AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        h();
        i();
        F(new RunnableC2274m3(this, atomicReference, null, str2, str3, C(false), z));
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2311u1
    protected final boolean n() {
        return false;
    }

    protected final void o(zzaw zzawVar, String str) {
        AbstractC3795Cj5.j(zzawVar);
        h();
        i();
        G();
        F(new RunnableC2254i3(this, true, C(true), this.a.C().v(zzawVar), zzawVar, str));
    }

    public final void p(InterfaceC19683ql8 interfaceC19683ql8, zzaw zzawVar, String str) {
        h();
        i();
        if (this.a.N().p0(12451000) == 0) {
            F(new RunnableC2229d3(this, zzawVar, str, interfaceC19683ql8));
        } else {
            this.a.b().w().a("Not bundling data. Service unavailable or out of date");
            this.a.N().G(interfaceC19683ql8, new byte[0]);
        }
    }

    protected final void q() {
        h();
        i();
        zzq zzqVarC = C(false);
        G();
        this.a.C().q();
        F(new W2(this, zzqVarC));
    }

    final void r(Gm8 gm8, AbstractSafeParcelable abstractSafeParcelable, zzq zzqVar) {
        int size;
        h();
        i();
        G();
        this.a.z();
        int i = 100;
        int i2 = 0;
        while (i2 < 1001 && i == 100) {
            ArrayList arrayList = new ArrayList();
            List listP = this.a.C().p(100);
            if (listP != null) {
                arrayList.addAll(listP);
                size = listP.size();
            } else {
                size = 0;
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i3);
                if (abstractSafeParcelable2 instanceof zzaw) {
                    try {
                        gm8.m0((zzaw) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e) {
                        this.a.b().r().b("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkw) {
                    try {
                        gm8.C0((zzkw) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e2) {
                        this.a.b().r().b("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzac) {
                    try {
                        gm8.n2((zzac) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e3) {
                        this.a.b().r().b("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    this.a.b().r().a("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i = size;
        }
    }

    protected final void s(zzac zzacVar) {
        AbstractC3795Cj5.j(zzacVar);
        h();
        i();
        this.a.d();
        F(new RunnableC2259j3(this, true, C(true), this.a.C().u(zzacVar), new zzac(zzacVar), zzacVar));
    }

    protected final void t(boolean z) {
        h();
        i();
        if (z) {
            G();
            this.a.C().q();
        }
        if (A()) {
            F(new RunnableC2249h3(this, C(false)));
        }
    }

    protected final void u(M2 m2) {
        h();
        i();
        F(new RunnableC2214a3(this, m2));
    }

    public final void v(Bundle bundle) {
        h();
        i();
        F(new RunnableC2219b3(this, C(false), bundle));
    }

    protected final void w() {
        h();
        i();
        F(new RunnableC2239f3(this, C(true)));
    }

    protected final void x(Gm8 gm8) {
        h();
        AbstractC3795Cj5.j(gm8);
        this.d = gm8;
        E();
        D();
    }

    protected final void y(zzkw zzkwVar) {
        h();
        i();
        G();
        F(new V2(this, C(true), this.a.C().w(zzkwVar), zzkwVar));
    }

    public final boolean z() {
        h();
        i();
        return this.d != null;
    }
}
