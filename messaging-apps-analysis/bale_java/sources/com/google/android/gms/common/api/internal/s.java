package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.C2060d;
import ir.nasim.AbstractC12468ef8;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.BinderC17850nf8;
import ir.nasim.C13695gf8;
import ir.nasim.C4982Hj7;
import ir.nasim.C9205Yy;
import ir.nasim.DG4;
import ir.nasim.KJ;
import ir.nasim.Qf8;
import ir.nasim.VJ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* loaded from: classes3.dex */
public final class s implements c.a, c.b {
    private final a.f h;
    private final C9205Yy i;
    private final C2068l j;
    private final int m;
    private final BinderC17850nf8 n;
    private boolean o;
    final /* synthetic */ C2059c s;
    private final Queue a = new LinkedList();
    private final Set k = new HashSet();
    private final Map l = new HashMap();
    private final List p = new ArrayList();
    private ConnectionResult q = null;
    private int r = 0;

    public s(C2059c c2059c, com.google.android.gms.common.api.b bVar) {
        this.s = c2059c;
        a.f fVarV = bVar.v(c2059c.p.getLooper(), this);
        this.h = fVarV;
        this.i = bVar.q();
        this.j = new C2068l();
        this.m = bVar.u();
        if (fVarV.i()) {
            this.n = bVar.w(c2059c.g, c2059c.p);
        } else {
            this.n = null;
        }
    }

    private final Feature b(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] featureArrO = this.h.o();
            if (featureArrO == null) {
                featureArrO = new Feature[0];
            }
            KJ kj = new KJ(featureArrO.length);
            for (Feature feature : featureArrO) {
                kj.put(feature.P(), Long.valueOf(feature.S()));
            }
            for (Feature feature2 : featureArr) {
                Long l = (Long) kj.get(feature2.P());
                if (l == null || l.longValue() < feature2.S()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    private final void c(ConnectionResult connectionResult) {
        Iterator it = this.k.iterator();
        if (!it.hasNext()) {
            this.k.clear();
            return;
        }
        AbstractC18350oW3.a(it.next());
        if (DG4.a(connectionResult, ConnectionResult.e)) {
            this.h.e();
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Status status) {
        AbstractC3795Cj5.d(this.s.p);
        e(status, null, false);
    }

    private final void e(Status status, Exception exc, boolean z) {
        AbstractC3795Cj5.d(this.s.p);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            H h = (H) it.next();
            if (!z || h.a == 2) {
                if (status != null) {
                    h.a(status);
                } else {
                    h.b(exc);
                }
                it.remove();
            }
        }
    }

    private final void f() {
        ArrayList arrayList = new ArrayList(this.a);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            H h = (H) arrayList.get(i);
            if (!this.h.a()) {
                return;
            }
            if (l(h)) {
                this.a.remove(h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        z();
        c(ConnectionResult.e);
        k();
        Iterator it = this.l.values().iterator();
        while (it.hasNext()) {
            C13695gf8 c13695gf8 = (C13695gf8) it.next();
            if (b(c13695gf8.a.c()) != null) {
                it.remove();
            } else {
                try {
                    c13695gf8.a.d(this.h, new C4982Hj7());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    this.h.b("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        f();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(int i) {
        z();
        this.o = true;
        this.j.e(i, this.h.p());
        C2059c c2059c = this.s;
        c2059c.p.sendMessageDelayed(Message.obtain(c2059c.p, 9, this.i), this.s.a);
        C2059c c2059c2 = this.s;
        c2059c2.p.sendMessageDelayed(Message.obtain(c2059c2.p, 11, this.i), this.s.b);
        this.s.i.c();
        Iterator it = this.l.values().iterator();
        while (it.hasNext()) {
            ((C13695gf8) it.next()).c.run();
        }
    }

    private final void i() {
        this.s.p.removeMessages(12, this.i);
        C2059c c2059c = this.s;
        c2059c.p.sendMessageDelayed(c2059c.p.obtainMessage(12, this.i), this.s.c);
    }

    private final void j(H h) {
        h.d(this.j, I());
        try {
            h.c(this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.h.b("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    private final void k() {
        if (this.o) {
            this.s.p.removeMessages(11, this.i);
            this.s.p.removeMessages(9, this.i);
            this.o = false;
        }
    }

    private final boolean l(H h) {
        if (!(h instanceof AbstractC12468ef8)) {
            j(h);
            return true;
        }
        AbstractC12468ef8 abstractC12468ef8 = (AbstractC12468ef8) h;
        Feature featureB = b(abstractC12468ef8.g(this));
        if (featureB == null) {
            j(h);
            return true;
        }
        Log.w("GoogleApiManager", this.h.getClass().getName() + " could not execute call because it requires feature (" + featureB.P() + ", " + featureB.S() + ").");
        if (!this.s.q || !abstractC12468ef8.f(this)) {
            abstractC12468ef8.b(new UnsupportedApiCallException(featureB));
            return true;
        }
        t tVar = new t(this.i, featureB, null);
        int iIndexOf = this.p.indexOf(tVar);
        if (iIndexOf >= 0) {
            t tVar2 = (t) this.p.get(iIndexOf);
            this.s.p.removeMessages(15, tVar2);
            C2059c c2059c = this.s;
            c2059c.p.sendMessageDelayed(Message.obtain(c2059c.p, 15, tVar2), this.s.a);
            return false;
        }
        this.p.add(tVar);
        C2059c c2059c2 = this.s;
        c2059c2.p.sendMessageDelayed(Message.obtain(c2059c2.p, 15, tVar), this.s.a);
        C2059c c2059c3 = this.s;
        c2059c3.p.sendMessageDelayed(Message.obtain(c2059c3.p, 16, tVar), this.s.b);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (m(connectionResult)) {
            return false;
        }
        this.s.h(connectionResult, this.m);
        return false;
    }

    private final boolean m(ConnectionResult connectionResult) {
        synchronized (C2059c.t) {
            try {
                C2059c c2059c = this.s;
                if (c2059c.m == null || !c2059c.n.contains(this.i)) {
                    return false;
                }
                this.s.m.s(connectionResult, this.m);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final boolean n(boolean z) {
        AbstractC3795Cj5.d(this.s.p);
        if (!this.h.a() || this.l.size() != 0) {
            return false;
        }
        if (!this.j.g()) {
            this.h.b("Timing out service connection.");
            return true;
        }
        if (z) {
            i();
        }
        return false;
    }

    static /* bridge */ /* synthetic */ void x(s sVar, t tVar) {
        if (sVar.p.contains(tVar) && !sVar.o) {
            if (sVar.h.a()) {
                sVar.f();
            } else {
                sVar.A();
            }
        }
    }

    static /* bridge */ /* synthetic */ void y(s sVar, t tVar) {
        Feature[] featureArrG;
        if (sVar.p.remove(tVar)) {
            sVar.s.p.removeMessages(15, tVar);
            sVar.s.p.removeMessages(16, tVar);
            Feature feature = tVar.b;
            ArrayList arrayList = new ArrayList(sVar.a.size());
            for (H h : sVar.a) {
                if ((h instanceof AbstractC12468ef8) && (featureArrG = ((AbstractC12468ef8) h).g(sVar)) != null && VJ.c(featureArrG, feature)) {
                    arrayList.add(h);
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                H h2 = (H) arrayList.get(i);
                sVar.a.remove(h2);
                h2.b(new UnsupportedApiCallException(feature));
            }
        }
    }

    public final void A() {
        AbstractC3795Cj5.d(this.s.p);
        if (this.h.a() || this.h.d()) {
            return;
        }
        try {
            C2059c c2059c = this.s;
            int iB = c2059c.i.b(c2059c.g, this.h);
            if (iB == 0) {
                C2059c c2059c2 = this.s;
                a.f fVar = this.h;
                v vVar = new v(c2059c2, fVar, this.i);
                if (fVar.i()) {
                    ((BinderC17850nf8) AbstractC3795Cj5.j(this.n)).E2(vVar);
                }
                try {
                    this.h.f(vVar);
                    return;
                } catch (SecurityException e) {
                    D(new ConnectionResult(10), e);
                    return;
                }
            }
            ConnectionResult connectionResult = new ConnectionResult(iB, null);
            Log.w("GoogleApiManager", "The service for " + this.h.getClass().getName() + " is not available: " + connectionResult.toString());
            D(connectionResult, null);
        } catch (IllegalStateException e2) {
            D(new ConnectionResult(10), e2);
        }
    }

    public final void B(H h) {
        AbstractC3795Cj5.d(this.s.p);
        if (this.h.a()) {
            if (l(h)) {
                i();
                return;
            } else {
                this.a.add(h);
                return;
            }
        }
        this.a.add(h);
        ConnectionResult connectionResult = this.q;
        if (connectionResult == null || !connectionResult.s0()) {
            A();
        } else {
            D(this.q, null);
        }
    }

    final void C() {
        this.r++;
    }

    public final void D(ConnectionResult connectionResult, Exception exc) {
        AbstractC3795Cj5.d(this.s.p);
        BinderC17850nf8 binderC17850nf8 = this.n;
        if (binderC17850nf8 != null) {
            binderC17850nf8.F2();
        }
        z();
        this.s.i.c();
        c(connectionResult);
        if ((this.h instanceof Qf8) && connectionResult.P() != 24) {
            this.s.d = true;
            C2059c c2059c = this.s;
            c2059c.p.sendMessageDelayed(c2059c.p.obtainMessage(19), 300000L);
        }
        if (connectionResult.P() == 4) {
            d(C2059c.s);
            return;
        }
        if (this.a.isEmpty()) {
            this.q = connectionResult;
            return;
        }
        if (exc != null) {
            AbstractC3795Cj5.d(this.s.p);
            e(null, exc, false);
            return;
        }
        if (!this.s.q) {
            d(C2059c.i(this.i, connectionResult));
            return;
        }
        e(C2059c.i(this.i, connectionResult), null, true);
        if (this.a.isEmpty() || m(connectionResult) || this.s.h(connectionResult, this.m)) {
            return;
        }
        if (connectionResult.P() == 18) {
            this.o = true;
        }
        if (!this.o) {
            d(C2059c.i(this.i, connectionResult));
        } else {
            C2059c c2059c2 = this.s;
            c2059c2.p.sendMessageDelayed(Message.obtain(c2059c2.p, 9, this.i), this.s.a);
        }
    }

    public final void E(ConnectionResult connectionResult) {
        AbstractC3795Cj5.d(this.s.p);
        a.f fVar = this.h;
        fVar.b("onSignInFailed for " + fVar.getClass().getName() + " with " + String.valueOf(connectionResult));
        D(connectionResult, null);
    }

    public final void F() {
        AbstractC3795Cj5.d(this.s.p);
        if (this.o) {
            A();
        }
    }

    public final void G() {
        AbstractC3795Cj5.d(this.s.p);
        d(C2059c.r);
        this.j.f();
        for (C2060d.a aVar : (C2060d.a[]) this.l.keySet().toArray(new C2060d.a[0])) {
            B(new G(aVar, new C4982Hj7()));
        }
        c(new ConnectionResult(4));
        if (this.h.a()) {
            this.h.m(new r(this));
        }
    }

    public final void H() {
        AbstractC3795Cj5.d(this.s.p);
        if (this.o) {
            k();
            C2059c c2059c = this.s;
            d(c2059c.h.g(c2059c.g) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.h.b("Timing out connection while resuming.");
        }
    }

    public final boolean I() {
        return this.h.i();
    }

    public final boolean a() {
        return n(true);
    }

    public final int o() {
        return this.m;
    }

    @Override // ir.nasim.InterfaceC17823nd1
    public final void onConnected(Bundle bundle) {
        if (Looper.myLooper() == this.s.p.getLooper()) {
            g();
        } else {
            this.s.p.post(new o(this));
        }
    }

    @Override // ir.nasim.ZI4
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        D(connectionResult, null);
    }

    @Override // ir.nasim.InterfaceC17823nd1
    public final void onConnectionSuspended(int i) {
        if (Looper.myLooper() == this.s.p.getLooper()) {
            h(i);
        } else {
            this.s.p.post(new p(this, i));
        }
    }

    final int p() {
        return this.r;
    }

    public final a.f r() {
        return this.h;
    }

    public final Map t() {
        return this.l;
    }

    public final void z() {
        AbstractC3795Cj5.d(this.s.p);
        this.q = null;
    }
}
