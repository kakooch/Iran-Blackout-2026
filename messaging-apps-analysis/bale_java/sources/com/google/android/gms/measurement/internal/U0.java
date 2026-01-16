package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C11384cu8;
import ir.nasim.Fb8;
import ir.nasim.Qh8;
import ir.nasim.Wt8;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class U0 extends AbstractC2311u1 {
    private String c;
    private String d;
    private int e;
    private String f;
    private String g;
    private long h;
    private final long i;
    private List j;
    private String k;
    private int l;
    private String m;
    private String n;
    private String o;
    private long p;
    private String q;

    U0(H1 h1, long j) {
        super(h1);
        this.p = 0L;
        this.q = null;
        this.i = j;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:0|2|(1:4)(21:88|6|(1:10)(2:11|(1:13))|84|14|(4:16|(1:18)(1:20)|86|21)|26|(1:31)(1:30)|32|33|43|(1:45)|90|46|(1:48)|49|(3:51|(1:53)(1:54)|55)|(3:59|(1:61)(1:62)|63)|66|(2:69|(1:71)(4:72|(3:75|(1:93)(1:94)|73)|92|78))(1:78)|(2:80|81)(2:82|83))|5|26|(2:28|31)(0)|32|33|43|(0)|90|46|(0)|49|(0)|(0)|66|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01bb, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01de, code lost:
    
        r11.a.b().r().c("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.C2227d1.z(r0), r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0194 A[Catch: IllegalStateException -> 0x01bb, TryCatch #3 {IllegalStateException -> 0x01bb, blocks: (B:46:0x0173, B:49:0x018c, B:51:0x0194, B:55:0x01b2, B:54:0x01ae, B:59:0x01bf, B:61:0x01d5, B:63:0x01da, B:62:0x01d8), top: B:90:0x0173 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01bf A[Catch: IllegalStateException -> 0x01bb, TryCatch #3 {IllegalStateException -> 0x01bb, blocks: (B:46:0x0173, B:49:0x018c, B:51:0x0194, B:55:0x01b2, B:54:0x01ae, B:59:0x01bf, B:61:0x01d5, B:63:0x01da, B:62:0x01d8), top: B:90:0x0173 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x024e  */
    @Override // com.google.android.gms.measurement.internal.AbstractC2311u1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void l() throws android.content.res.Resources.NotFoundException, android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 614
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.U0.l():void");
    }

    @Override // com.google.android.gms.measurement.internal.AbstractC2311u1
    protected final boolean n() {
        return true;
    }

    final int o() {
        i();
        return this.l;
    }

    final int p() {
        i();
        return this.e;
    }

    final zzq q(String str) throws IllegalAccessException, NoSuchAlgorithmException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        String str2;
        long j;
        long jMin;
        List list;
        long j2;
        String str3;
        h();
        String strS = s();
        String strT = t();
        i();
        String str4 = this.d;
        i();
        long j3 = this.e;
        i();
        AbstractC3795Cj5.j(this.f);
        String str5 = this.f;
        this.a.z().q();
        i();
        h();
        long j4 = this.h;
        if (j4 == 0) {
            f4 f4VarN = this.a.N();
            Context contextF = this.a.f();
            String packageName = this.a.f().getPackageName();
            f4VarN.h();
            AbstractC3795Cj5.j(contextF);
            AbstractC3795Cj5.f(packageName);
            PackageManager packageManager = contextF.getPackageManager();
            MessageDigest messageDigestT = f4.t();
            long jQ0 = -1;
            if (messageDigestT == null) {
                f4VarN.a.b().r().a("Could not get MD5 instance");
            } else {
                if (packageManager != null) {
                    try {
                        if (f4VarN.V(contextF, packageName)) {
                            jQ0 = 0;
                        } else {
                            Signature[] signatureArr = Fb8.a(contextF).e(f4VarN.a.f().getPackageName(), 64).signatures;
                            if (signatureArr == null || signatureArr.length <= 0) {
                                f4VarN.a.b().w().a("Could not get signatures");
                            } else {
                                jQ0 = f4.q0(messageDigestT.digest(signatureArr[0].toByteArray()));
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        f4VarN.a.b().r().b("Package name not found", e);
                    }
                }
                j4 = 0;
                this.h = j4;
            }
            j4 = jQ0;
            this.h = j4;
        }
        long j5 = j4;
        boolean zO = this.a.o();
        boolean z = !this.a.F().q;
        h();
        if (this.a.o()) {
            C11384cu8.b();
            if (this.a.z().B(null, S0.c0)) {
                this.a.b().v().a("Disabled IID for tests.");
            } else {
                try {
                    Class<?> clsLoadClass = this.a.f().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                    if (clsLoadClass != null) {
                        try {
                            Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, this.a.f());
                            if (objInvoke != null) {
                                try {
                                    str2 = (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", null).invoke(objInvoke, null);
                                } catch (Exception unused) {
                                    this.a.b().x().a("Failed to retrieve Firebase Instance Id");
                                }
                            }
                        } catch (Exception unused2) {
                            this.a.b().y().a("Failed to obtain Firebase Analytics instance");
                        }
                    }
                } catch (ClassNotFoundException unused3) {
                }
            }
            str2 = null;
        } else {
            str2 = null;
        }
        H1 h1 = this.a;
        long jA = h1.F().e.a();
        if (jA == 0) {
            jMin = h1.G;
            j = j5;
        } else {
            j = j5;
            jMin = Math.min(h1.G, jA);
        }
        i();
        int i = this.l;
        boolean zA = this.a.z().A();
        C2292q1 c2292q1F = this.a.F();
        c2292q1F.h();
        boolean z2 = c2292q1F.o().getBoolean("deferred_analytics_collection", false);
        i();
        String str6 = this.n;
        Boolean boolValueOf = this.a.z().t("google_analytics_default_allow_ad_personalization_signals") == null ? null : Boolean.valueOf(!r2.booleanValue());
        long j6 = this.i;
        List list2 = this.j;
        String strH = this.a.F().q().h();
        if (this.k == null) {
            list = list2;
            if (this.a.z().B(null, S0.r0)) {
                this.k = this.a.N().q();
            } else {
                this.k = "";
            }
        } else {
            list = list2;
        }
        String str7 = this.k;
        Wt8.b();
        if (this.a.z().B(null, S0.o0)) {
            h();
            if (this.p == 0) {
                j2 = j6;
            } else {
                j2 = j6;
                long jCurrentTimeMillis = this.a.c().currentTimeMillis() - this.p;
                if (this.o != null && jCurrentTimeMillis > 86400000 && this.q == null) {
                    v();
                }
            }
            if (this.o == null) {
                v();
            }
            str3 = this.o;
        } else {
            j2 = j6;
            str3 = null;
        }
        return new zzq(strS, strT, str4, j3, str5, 74029L, j, str, zO, z, str2, 0L, jMin, i, zA, z2, str6, boolValueOf, j2, list, (String) null, strH, str7, str3);
    }

    final String r() {
        i();
        return this.n;
    }

    final String s() {
        i();
        AbstractC3795Cj5.j(this.c);
        return this.c;
    }

    final String t() {
        h();
        i();
        AbstractC3795Cj5.j(this.m);
        return this.m;
    }

    final List u() {
        return this.j;
    }

    final void v() {
        String str;
        h();
        if (this.a.F().q().i(Qh8.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            this.a.N().u().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            this.a.b().q().a("Analytics Storage consent is not granted");
            str = null;
        }
        this.a.b().q().a(String.format("Resetting session stitching token to %s", str == null ? "null" : "not null"));
        this.o = str;
        this.p = this.a.c().currentTimeMillis();
    }

    final boolean w(String str) {
        String str2 = this.q;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.q = str;
        return z;
    }
}
