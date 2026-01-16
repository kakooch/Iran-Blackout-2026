package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C46;
import ir.nasim.OZ2;
import ir.nasim.Xs8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public abstract class b {
    private boolean A;
    private volatile zzk B;
    protected AtomicInteger D;
    private int a;
    private long b;
    private long c;
    private int d;
    private long e;
    private volatile String f;
    z g;
    private final Context h;
    private final Looper i;
    private final com.google.android.gms.common.internal.d j;
    private final com.google.android.gms.common.b k;
    final Handler l;
    private final Object m;
    private final Object n;
    private OZ2 o;
    protected c p;
    private IInterface q;
    private final ArrayList r;
    private r s;
    private int t;
    private final a u;
    private final InterfaceC0173b v;
    private final int w;
    private final String x;
    private volatile String y;
    private ConnectionResult z;
    private static final Feature[] H = new Feature[0];
    public static final String[] G = {"service_esmobile", "service_googleme"};

    public interface a {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    /* renamed from: com.google.android.gms.common.internal.b$b, reason: collision with other inner class name */
    public interface InterfaceC0173b {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public interface c {
        void a(ConnectionResult connectionResult);
    }

    protected class d implements c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.b.c
        public final void a(ConnectionResult connectionResult) {
            if (connectionResult.x0()) {
                b bVar = b.this;
                bVar.l(null, bVar.C());
            } else if (b.this.v != null) {
                b.this.v.onConnectionFailed(connectionResult);
            }
        }
    }

    public interface e {
        void a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    protected b(Context context, Looper looper, int i, a aVar, InterfaceC0173b interfaceC0173b, String str) {
        com.google.android.gms.common.internal.d dVarA = com.google.android.gms.common.internal.d.a(context);
        com.google.android.gms.common.b bVarF = com.google.android.gms.common.b.f();
        AbstractC3795Cj5.j(aVar);
        AbstractC3795Cj5.j(interfaceC0173b);
        this(context, looper, dVarA, bVarF, i, aVar, interfaceC0173b, str);
    }

    static /* bridge */ /* synthetic */ void c0(b bVar, zzk zzkVar) {
        bVar.B = zzkVar;
        if (bVar.S()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzkVar.d;
            C46.b().c(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.A0());
        }
    }

    static /* bridge */ /* synthetic */ void d0(b bVar, int i) {
        int i2;
        int i3;
        synchronized (bVar.m) {
            i2 = bVar.t;
        }
        if (i2 == 3) {
            bVar.A = true;
            i3 = 5;
        } else {
            i3 = 4;
        }
        Handler handler = bVar.l;
        handler.sendMessage(handler.obtainMessage(i3, bVar.D.get(), 16));
    }

    static /* bridge */ /* synthetic */ boolean g0(b bVar, int i, int i2, IInterface iInterface) {
        synchronized (bVar.m) {
            try {
                if (bVar.t != i) {
                    return false;
                }
                bVar.i0(i2, iInterface);
                return true;
            } finally {
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean h0(b bVar) throws ClassNotFoundException {
        if (bVar.A || TextUtils.isEmpty(bVar.E()) || TextUtils.isEmpty(bVar.B())) {
            return false;
        }
        try {
            Class.forName(bVar.E());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(int i, IInterface iInterface) {
        z zVar;
        AbstractC3795Cj5.a((i == 4) == (iInterface != null));
        synchronized (this.m) {
            try {
                this.t = i;
                this.q = iInterface;
                if (i == 1) {
                    r rVar = this.s;
                    if (rVar != null) {
                        com.google.android.gms.common.internal.d dVar = this.j;
                        String strB = this.g.b();
                        AbstractC3795Cj5.j(strB);
                        dVar.d(strB, this.g.a(), 4225, rVar, X(), this.g.c());
                        this.s = null;
                    }
                } else if (i == 2 || i == 3) {
                    r rVar2 = this.s;
                    if (rVar2 != null && (zVar = this.g) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zVar.b() + " on " + zVar.a());
                        com.google.android.gms.common.internal.d dVar2 = this.j;
                        String strB2 = this.g.b();
                        AbstractC3795Cj5.j(strB2);
                        dVar2.d(strB2, this.g.a(), 4225, rVar2, X(), this.g.c());
                        this.D.incrementAndGet();
                    }
                    r rVar3 = new r(this, this.D.get());
                    this.s = rVar3;
                    z zVar2 = (this.t != 3 || B() == null) ? new z(G(), F(), false, 4225, I()) : new z(y().getPackageName(), B(), true, 4225, false);
                    this.g = zVar2;
                    if (zVar2.c() && n() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.g.b())));
                    }
                    com.google.android.gms.common.internal.d dVar3 = this.j;
                    String strB3 = this.g.b();
                    AbstractC3795Cj5.j(strB3);
                    if (!dVar3.e(new Xs8(strB3, this.g.a(), 4225, this.g.c()), rVar3, X(), w())) {
                        Log.w("GmsClient", "unable to connect to service: " + this.g.b() + " on " + this.g.a());
                        e0(16, null, this.D.get());
                    }
                } else if (i == 4) {
                    AbstractC3795Cj5.j(iInterface);
                    K(iInterface);
                }
            } finally {
            }
        }
    }

    protected Bundle A() {
        return new Bundle();
    }

    protected String B() {
        return null;
    }

    protected Set C() {
        return Collections.emptySet();
    }

    public final IInterface D() {
        IInterface iInterface;
        synchronized (this.m) {
            try {
                if (this.t == 5) {
                    throw new DeadObjectException();
                }
                r();
                iInterface = this.q;
                AbstractC3795Cj5.k(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    protected abstract String E();

    protected abstract String F();

    protected String G() {
        return "com.google.android.gms";
    }

    public ConnectionTelemetryConfiguration H() {
        zzk zzkVar = this.B;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.d;
    }

    protected boolean I() {
        return n() >= 211700000;
    }

    public boolean J() {
        return this.B != null;
    }

    protected void K(IInterface iInterface) {
        this.c = System.currentTimeMillis();
    }

    protected void L(ConnectionResult connectionResult) {
        this.d = connectionResult.P();
        this.e = System.currentTimeMillis();
    }

    protected void M(int i) {
        this.a = i;
        this.b = System.currentTimeMillis();
    }

    protected void N(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.l.sendMessage(this.l.obtainMessage(1, i2, -1, new s(this, i, iBinder, bundle)));
    }

    public boolean O() {
        return false;
    }

    public void P(String str) {
        this.y = str;
    }

    public void Q(int i) {
        this.l.sendMessage(this.l.obtainMessage(6, this.D.get(), i));
    }

    protected void R(c cVar, int i, PendingIntent pendingIntent) {
        AbstractC3795Cj5.k(cVar, "Connection progress callbacks cannot be null.");
        this.p = cVar;
        this.l.sendMessage(this.l.obtainMessage(3, this.D.get(), i, pendingIntent));
    }

    public boolean S() {
        return false;
    }

    protected final String X() {
        String str = this.x;
        return str == null ? this.h.getClass().getName() : str;
    }

    public boolean a() {
        boolean z;
        synchronized (this.m) {
            z = this.t == 4;
        }
        return z;
    }

    public void b(String str) {
        this.f = str;
        c();
    }

    public void c() {
        this.D.incrementAndGet();
        synchronized (this.r) {
            try {
                int size = this.r.size();
                for (int i = 0; i < size; i++) {
                    ((p) this.r.get(i)).d();
                }
                this.r.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.n) {
            this.o = null;
        }
        i0(1, null);
    }

    public boolean d() {
        boolean z;
        synchronized (this.m) {
            int i = this.t;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    public String e() {
        z zVar;
        if (!a() || (zVar = this.g) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return zVar.a();
    }

    protected final void e0(int i, Bundle bundle, int i2) {
        this.l.sendMessage(this.l.obtainMessage(7, i2, -1, new t(this, i, null)));
    }

    public void f(c cVar) {
        AbstractC3795Cj5.k(cVar, "Connection progress callbacks cannot be null.");
        this.p = cVar;
        i0(2, null);
    }

    public boolean h() {
        return true;
    }

    public boolean i() {
        return false;
    }

    public void l(com.google.android.gms.common.internal.e eVar, Set set) {
        Bundle bundleA = A();
        String str = this.y;
        int i = com.google.android.gms.common.b.a;
        Scope[] scopeArr = GetServiceRequest.o;
        Bundle bundle = new Bundle();
        int i2 = this.w;
        Feature[] featureArr = GetServiceRequest.p;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i2, i, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.d = this.h.getPackageName();
        getServiceRequest.g = bundleA;
        if (set != null) {
            getServiceRequest.f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (i()) {
            Account accountU = u();
            if (accountU == null) {
                accountU = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.h = accountU;
            if (eVar != null) {
                getServiceRequest.e = eVar.asBinder();
            }
        } else if (O()) {
            getServiceRequest.h = u();
        }
        getServiceRequest.i = H;
        getServiceRequest.j = v();
        if (S()) {
            getServiceRequest.m = true;
        }
        try {
            synchronized (this.n) {
                try {
                    OZ2 oz2 = this.o;
                    if (oz2 != null) {
                        oz2.X(new q(this, this.D.get()), getServiceRequest);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            Q(3);
        } catch (RemoteException e3) {
            e = e3;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            N(8, null, null, this.D.get());
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            N(8, null, null, this.D.get());
        }
    }

    public void m(e eVar) {
        eVar.a();
    }

    public abstract int n();

    public final Feature[] o() {
        zzk zzkVar = this.B;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.b;
    }

    public String p() {
        return this.f;
    }

    public void q() throws PackageManager.NameNotFoundException {
        int iH = this.k.h(this.h, n());
        if (iH == 0) {
            f(new d());
        } else {
            i0(1, null);
            R(new d(), iH, null);
        }
    }

    protected final void r() {
        if (!a()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected abstract IInterface s(IBinder iBinder);

    protected boolean t() {
        return false;
    }

    public Account u() {
        return null;
    }

    public Feature[] v() {
        return H;
    }

    protected Executor w() {
        return null;
    }

    public Bundle x() {
        return null;
    }

    public final Context y() {
        return this.h;
    }

    public int z() {
        return this.w;
    }

    protected b(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, com.google.android.gms.common.b bVar, int i, a aVar, InterfaceC0173b interfaceC0173b, String str) {
        this.f = null;
        this.m = new Object();
        this.n = new Object();
        this.r = new ArrayList();
        this.t = 1;
        this.z = null;
        this.A = false;
        this.B = null;
        this.D = new AtomicInteger(0);
        AbstractC3795Cj5.k(context, "Context must not be null");
        this.h = context;
        AbstractC3795Cj5.k(looper, "Looper must not be null");
        this.i = looper;
        AbstractC3795Cj5.k(dVar, "Supervisor must not be null");
        this.j = dVar;
        AbstractC3795Cj5.k(bVar, "API availability must not be null");
        this.k = bVar;
        this.l = new o(this, looper);
        this.w = i;
        this.u = aVar;
        this.v = interfaceC0173b;
        this.x = str;
    }
}
