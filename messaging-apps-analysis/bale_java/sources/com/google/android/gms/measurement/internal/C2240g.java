package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.os.Bundle;
import android.text.TextUtils;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.AbstractC7666Sr5;
import ir.nasim.Fb8;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.google.android.gms.measurement.internal.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2240g extends AbstractC2213a2 {
    private Boolean b;
    private InterfaceC2235f c;
    private Boolean d;

    C2240g(H1 h1) {
        super(h1);
        this.c = new InterfaceC2235f() { // from class: com.google.android.gms.measurement.internal.e
            @Override // com.google.android.gms.measurement.internal.InterfaceC2235f
            public final String e(String str, String str2) {
                return null;
            }
        };
    }

    public static final long I() {
        return ((Long) S0.e.a(null)).longValue();
    }

    public static final long i() {
        return ((Long) S0.E.a(null)).longValue();
    }

    private final String j(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            AbstractC3795Cj5.j(str3);
            return str3;
        } catch (ClassNotFoundException e) {
            this.a.b().r().b("Could not find SystemProperties class", e);
            return "";
        } catch (IllegalAccessException e2) {
            this.a.b().r().b("Could not access SystemProperties.get()", e2);
            return "";
        } catch (NoSuchMethodException e3) {
            this.a.b().r().b("Could not find SystemProperties.get() method", e3);
            return "";
        } catch (InvocationTargetException e4) {
            this.a.b().r().b("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    public final boolean A() {
        Boolean boolT = t("google_analytics_adid_collection_enabled");
        return boolT == null || boolT.booleanValue();
    }

    public final boolean B(String str, R0 r0) {
        if (str == null) {
            return ((Boolean) r0.a(null)).booleanValue();
        }
        String strE = this.c.e(str, r0.b());
        return TextUtils.isEmpty(strE) ? ((Boolean) r0.a(null)).booleanValue() : ((Boolean) r0.a(Boolean.valueOf("1".equals(strE)))).booleanValue();
    }

    public final boolean C(String str) {
        return "1".equals(this.c.e(str, "gaia_collection_enabled"));
    }

    public final boolean D() {
        Boolean boolT = t("google_analytics_automatic_screen_reporting_enabled");
        return boolT == null || boolT.booleanValue();
    }

    public final boolean E() {
        this.a.d();
        Boolean boolT = t("firebase_analytics_collection_deactivated");
        return boolT != null && boolT.booleanValue();
    }

    public final boolean F(String str) {
        return "1".equals(this.c.e(str, "measurement.event_sampling_enabled"));
    }

    final boolean G() {
        if (this.b == null) {
            Boolean boolT = t("app_measurement_lite");
            this.b = boolT;
            if (boolT == null) {
                this.b = Boolean.FALSE;
            }
        }
        return this.b.booleanValue() || !this.a.s();
    }

    public final boolean H() {
        if (this.d == null) {
            synchronized (this) {
                try {
                    if (this.d == null) {
                        ApplicationInfo applicationInfo = this.a.f().getApplicationInfo();
                        String strA = AbstractC7666Sr5.a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            boolean z = false;
                            if (str != null && str.equals(strA)) {
                                z = true;
                            }
                            this.d = Boolean.valueOf(z);
                        }
                        if (this.d == null) {
                            this.d = Boolean.TRUE;
                            this.a.b().r().a("My process not in the list of running processes");
                        }
                    }
                } finally {
                }
            }
        }
        return this.d.booleanValue();
    }

    public final double k(String str, R0 r0) {
        if (str == null) {
            return ((Double) r0.a(null)).doubleValue();
        }
        String strE = this.c.e(str, r0.b());
        if (TextUtils.isEmpty(strE)) {
            return ((Double) r0.a(null)).doubleValue();
        }
        try {
            return ((Double) r0.a(Double.valueOf(Double.parseDouble(strE)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) r0.a(null)).doubleValue();
        }
    }

    final int l(String str) {
        return p(str, S0.I, SIPTransactionStack.BASE_TIMER_INTERVAL, 2000);
    }

    public final int m() {
        f4 f4VarN = this.a.N();
        Boolean boolJ = f4VarN.a.L().J();
        if (f4VarN.o0() < 201500) {
            return (boolJ == null || boolJ.booleanValue()) ? 25 : 100;
        }
        return 100;
    }

    public final int n(String str) {
        return p(str, S0.J, 25, 100);
    }

    public final int o(String str, R0 r0) {
        if (str == null) {
            return ((Integer) r0.a(null)).intValue();
        }
        String strE = this.c.e(str, r0.b());
        if (TextUtils.isEmpty(strE)) {
            return ((Integer) r0.a(null)).intValue();
        }
        try {
            return ((Integer) r0.a(Integer.valueOf(Integer.parseInt(strE)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) r0.a(null)).intValue();
        }
    }

    public final int p(String str, R0 r0, int i, int i2) {
        return Math.max(Math.min(o(str, r0), i2), i);
    }

    public final long q() {
        this.a.d();
        return 74029L;
    }

    public final long r(String str, R0 r0) {
        if (str == null) {
            return ((Long) r0.a(null)).longValue();
        }
        String strE = this.c.e(str, r0.b());
        if (TextUtils.isEmpty(strE)) {
            return ((Long) r0.a(null)).longValue();
        }
        try {
            return ((Long) r0.a(Long.valueOf(Long.parseLong(strE)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) r0.a(null)).longValue();
        }
    }

    final Bundle s() {
        try {
            if (this.a.f().getPackageManager() == null) {
                this.a.b().r().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfoC = Fb8.a(this.a.f()).c(this.a.f().getPackageName(), 128);
            if (applicationInfoC != null) {
                return applicationInfoC.metaData;
            }
            this.a.b().r().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            this.a.b().r().b("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    final Boolean t(String str) {
        AbstractC3795Cj5.f(str);
        Bundle bundleS = s();
        if (bundleS == null) {
            this.a.b().r().a("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleS.containsKey(str)) {
            return Boolean.valueOf(bundleS.getBoolean(str));
        }
        return null;
    }

    public final String u() {
        return j("debug.firebase.analytics.app", "");
    }

    public final String v() {
        return j("debug.deferred.deeplink", "");
    }

    final String w() {
        this.a.d();
        return "FA";
    }

    public final String x(String str, R0 r0) {
        return str == null ? (String) r0.a(null) : (String) r0.a(this.c.e(str, r0.b()));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final java.util.List y(java.lang.String r4) throws android.content.res.Resources.NotFoundException {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            ir.nasim.AbstractC3795Cj5.f(r4)
            android.os.Bundle r0 = r3.s()
            r1 = 0
            if (r0 != 0) goto L1d
            com.google.android.gms.measurement.internal.H1 r4 = r3.a
            com.google.android.gms.measurement.internal.d1 r4 = r4.b()
            com.google.android.gms.measurement.internal.b1 r4 = r4.r()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.a(r0)
        L1b:
            r4 = r1
            goto L2c
        L1d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L24
            goto L1b
        L24:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L2c:
            if (r4 == 0) goto L58
            com.google.android.gms.measurement.internal.H1 r0 = r3.a     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.Context r0 = r0.f()     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L48
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L48
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            if (r4 != 0) goto L43
            return r1
        L43:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            return r4
        L48:
            r4 = move-exception
            com.google.android.gms.measurement.internal.H1 r0 = r3.a
            com.google.android.gms.measurement.internal.d1 r0 = r0.b()
            com.google.android.gms.measurement.internal.b1 r0 = r0.r()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.b(r2, r4)
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C2240g.y(java.lang.String):java.util.List");
    }

    final void z(InterfaceC2235f interfaceC2235f) {
        this.c = interfaceC2235f;
    }
}
