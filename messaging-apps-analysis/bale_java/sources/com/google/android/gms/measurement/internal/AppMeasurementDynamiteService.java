package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.zzcl;
import ir.nasim.AbstractBinderC13164fl8;
import ir.nasim.AbstractC12578eq8;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.CG4;
import ir.nasim.Do8;
import ir.nasim.InterfaceC19683ql8;
import ir.nasim.InterfaceC20883sl8;
import ir.nasim.InterfaceC22750vl8;
import ir.nasim.KJ;
import ir.nasim.XZ2;
import java.util.Map;

@DynamiteApi
/* loaded from: classes3.dex */
public class AppMeasurementDynamiteService extends AbstractBinderC13164fl8 {
    H1 a = null;
    private final Map h = new KJ();

    private final void C2() {
        if (this.a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void D2(InterfaceC19683ql8 interfaceC19683ql8, String str) {
        C2();
        this.a.N().J(interfaceC19683ql8, str);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void beginAdUnitExposure(String str, long j) {
        C2();
        this.a.y().l(str, j);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        C2();
        this.a.I().o(str, str2, bundle);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void clearMeasurementEnabled(long j) {
        C2();
        this.a.I().I(null);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void endAdUnitExposure(String str, long j) {
        C2();
        this.a.y().m(str, j);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void generateEventId(InterfaceC19683ql8 interfaceC19683ql8) {
        C2();
        long jR0 = this.a.N().r0();
        C2();
        this.a.N().I(interfaceC19683ql8, jR0);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void getAppInstanceId(InterfaceC19683ql8 interfaceC19683ql8) {
        C2();
        this.a.a().z(new I2(this, interfaceC19683ql8));
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void getCachedAppInstanceId(InterfaceC19683ql8 interfaceC19683ql8) {
        C2();
        D2(interfaceC19683ql8, this.a.I().V());
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void getConditionalUserProperties(String str, String str2, InterfaceC19683ql8 interfaceC19683ql8) {
        C2();
        this.a.a().z(new g4(this, interfaceC19683ql8, str, str2));
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void getCurrentScreenClass(InterfaceC19683ql8 interfaceC19683ql8) {
        C2();
        D2(interfaceC19683ql8, this.a.I().W());
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void getCurrentScreenName(InterfaceC19683ql8 interfaceC19683ql8) {
        C2();
        D2(interfaceC19683ql8, this.a.I().X());
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void getGmpAppId(InterfaceC19683ql8 interfaceC19683ql8) {
        String strB;
        C2();
        G2 g2I = this.a.I();
        if (g2I.a.O() != null) {
            strB = g2I.a.O();
        } else {
            try {
                strB = AbstractC12578eq8.b(g2I.a.f(), "google_app_id", g2I.a.R());
            } catch (IllegalStateException e) {
                g2I.a.b().r().b("getGoogleAppId failed with exception", e);
                strB = null;
            }
        }
        D2(interfaceC19683ql8, strB);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void getMaxUserProperties(String str, InterfaceC19683ql8 interfaceC19683ql8) {
        C2();
        this.a.I().Q(str);
        C2();
        this.a.N().H(interfaceC19683ql8, 25);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void getSessionId(InterfaceC19683ql8 interfaceC19683ql8) {
        C2();
        G2 g2I = this.a.I();
        g2I.a.a().z(new RunnableC2312u2(g2I, interfaceC19683ql8));
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void getTestFlag(InterfaceC19683ql8 interfaceC19683ql8, int i) {
        C2();
        if (i == 0) {
            this.a.N().J(interfaceC19683ql8, this.a.I().Y());
            return;
        }
        if (i == 1) {
            this.a.N().I(interfaceC19683ql8, this.a.I().U().longValue());
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.a.N().H(interfaceC19683ql8, this.a.I().T().intValue());
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.a.N().D(interfaceC19683ql8, this.a.I().R().booleanValue());
                return;
            }
        }
        f4 f4VarN = this.a.N();
        double dDoubleValue = this.a.I().S().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", dDoubleValue);
        try {
            interfaceC19683ql8.F1(bundle);
        } catch (RemoteException e) {
            f4VarN.a.b().w().b("Error returning double value to wrapper", e);
        }
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void getUserProperties(String str, String str2, boolean z, InterfaceC19683ql8 interfaceC19683ql8) {
        C2();
        this.a.a().z(new G3(this, interfaceC19683ql8, str, str2, z));
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void initForTests(Map map) {
        C2();
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void initialize(XZ2 xz2, zzcl zzclVar, long j) {
        H1 h1 = this.a;
        if (h1 == null) {
            this.a = H1.H((Context) AbstractC3795Cj5.j((Context) CG4.D2(xz2)), zzclVar, Long.valueOf(j));
        } else {
            h1.b().w().a("Attempting to initialize multiple times");
        }
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void isDataCollectionEnabled(InterfaceC19683ql8 interfaceC19683ql8) {
        C2();
        this.a.a().z(new h4(this, interfaceC19683ql8));
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        C2();
        this.a.I().s(str, str2, bundle, z, z2, j);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void logEventAndBundle(String str, String str2, Bundle bundle, InterfaceC19683ql8 interfaceC19683ql8, long j) {
        C2();
        AbstractC3795Cj5.f(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.a.a().z(new RunnableC2244g3(this, interfaceC19683ql8, new zzaw(str2, new zzau(bundle), "app", j), str));
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void logHealthData(int i, String str, XZ2 xz2, XZ2 xz22, XZ2 xz23) {
        C2();
        this.a.b().F(i, true, false, str, xz2 == null ? null : CG4.D2(xz2), xz22 == null ? null : CG4.D2(xz22), xz23 != null ? CG4.D2(xz23) : null);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void onActivityCreated(XZ2 xz2, Bundle bundle, long j) {
        C2();
        F2 f2 = this.a.I().c;
        if (f2 != null) {
            this.a.I().p();
            f2.onActivityCreated((Activity) CG4.D2(xz2), bundle);
        }
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void onActivityDestroyed(XZ2 xz2, long j) {
        C2();
        F2 f2 = this.a.I().c;
        if (f2 != null) {
            this.a.I().p();
            f2.onActivityDestroyed((Activity) CG4.D2(xz2));
        }
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void onActivityPaused(XZ2 xz2, long j) {
        C2();
        F2 f2 = this.a.I().c;
        if (f2 != null) {
            this.a.I().p();
            f2.onActivityPaused((Activity) CG4.D2(xz2));
        }
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void onActivityResumed(XZ2 xz2, long j) {
        C2();
        F2 f2 = this.a.I().c;
        if (f2 != null) {
            this.a.I().p();
            f2.onActivityResumed((Activity) CG4.D2(xz2));
        }
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void onActivitySaveInstanceState(XZ2 xz2, InterfaceC19683ql8 interfaceC19683ql8, long j) {
        C2();
        F2 f2 = this.a.I().c;
        Bundle bundle = new Bundle();
        if (f2 != null) {
            this.a.I().p();
            f2.onActivitySaveInstanceState((Activity) CG4.D2(xz2), bundle);
        }
        try {
            interfaceC19683ql8.F1(bundle);
        } catch (RemoteException e) {
            this.a.b().w().b("Error returning bundle value to wrapper", e);
        }
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void onActivityStarted(XZ2 xz2, long j) {
        C2();
        if (this.a.I().c != null) {
            this.a.I().p();
        }
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void onActivityStopped(XZ2 xz2, long j) {
        C2();
        if (this.a.I().c != null) {
            this.a.I().p();
        }
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void performAction(Bundle bundle, InterfaceC19683ql8 interfaceC19683ql8, long j) {
        C2();
        interfaceC19683ql8.F1(null);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void registerOnMeasurementEventListener(InterfaceC20883sl8 interfaceC20883sl8) {
        Do8 j4Var;
        C2();
        synchronized (this.h) {
            try {
                j4Var = (Do8) this.h.get(Integer.valueOf(interfaceC20883sl8.d()));
                if (j4Var == null) {
                    j4Var = new j4(this, interfaceC20883sl8);
                    this.h.put(Integer.valueOf(interfaceC20883sl8.d()), j4Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.a.I().x(j4Var);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void resetAnalyticsData(long j) {
        C2();
        this.a.I().y(j);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void setConditionalUserProperty(Bundle bundle, long j) {
        C2();
        if (bundle == null) {
            this.a.b().r().a("Conditional user property must not be null");
        } else {
            this.a.I().E(bundle, j);
        }
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void setConsent(final Bundle bundle, final long j) {
        C2();
        final G2 g2I = this.a.I();
        g2I.a.a().A(new Runnable() { // from class: com.google.android.gms.measurement.internal.f2
            @Override // java.lang.Runnable
            public final void run() {
                G2 g2 = g2I;
                Bundle bundle2 = bundle;
                long j2 = j;
                if (TextUtils.isEmpty(g2.a.B().t())) {
                    g2.F(bundle2, 0, j2);
                } else {
                    g2.a.b().x().a("Using developer consent only; google app id found");
                }
            }
        });
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void setConsentThirdParty(Bundle bundle, long j) {
        C2();
        this.a.I().F(bundle, -20, j);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void setCurrentScreen(XZ2 xz2, String str, String str2, long j) {
        C2();
        this.a.K().D((Activity) CG4.D2(xz2), str, str2);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void setDataCollectionEnabled(boolean z) {
        C2();
        G2 g2I = this.a.I();
        g2I.i();
        g2I.a.a().z(new D2(g2I, z));
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void setDefaultEventParameters(Bundle bundle) {
        C2();
        final G2 g2I = this.a.I();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        g2I.a.a().z(new Runnable() { // from class: com.google.android.gms.measurement.internal.g2
            @Override // java.lang.Runnable
            public final void run() {
                g2I.q(bundle2);
            }
        });
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void setEventInterceptor(InterfaceC20883sl8 interfaceC20883sl8) {
        C2();
        i4 i4Var = new i4(this, interfaceC20883sl8);
        if (this.a.a().C()) {
            this.a.I().H(i4Var);
        } else {
            this.a.a().z(new d4(this, i4Var));
        }
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void setInstanceIdProvider(InterfaceC22750vl8 interfaceC22750vl8) {
        C2();
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void setMeasurementEnabled(boolean z, long j) {
        C2();
        this.a.I().I(Boolean.valueOf(z));
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void setMinimumSessionDuration(long j) {
        C2();
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void setSessionTimeoutDuration(long j) {
        C2();
        G2 g2I = this.a.I();
        g2I.a.a().z(new RunnableC2268l2(g2I, j));
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void setUserId(final String str, long j) {
        C2();
        final G2 g2I = this.a.I();
        if (str != null && TextUtils.isEmpty(str)) {
            g2I.a.b().w().a("User ID must be non-empty or null");
        } else {
            g2I.a.a().z(new Runnable() { // from class: com.google.android.gms.measurement.internal.h2
                @Override // java.lang.Runnable
                public final void run() {
                    G2 g2 = g2I;
                    if (g2.a.B().w(str)) {
                        g2.a.B().v();
                    }
                }
            });
            g2I.L(null, "_id", str, true, j);
        }
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void setUserProperty(String str, String str2, XZ2 xz2, boolean z, long j) throws SecurityException {
        C2();
        this.a.I().L(str, str2, CG4.D2(xz2), z, j);
    }

    @Override // ir.nasim.InterfaceC15546jl8
    public void unregisterOnMeasurementEventListener(InterfaceC20883sl8 interfaceC20883sl8) {
        Do8 j4Var;
        C2();
        synchronized (this.h) {
            j4Var = (Do8) this.h.remove(Integer.valueOf(interfaceC20883sl8.d()));
        }
        if (j4Var == null) {
            j4Var = new j4(this, interfaceC20883sl8);
        }
        this.a.I().N(j4Var);
    }
}
