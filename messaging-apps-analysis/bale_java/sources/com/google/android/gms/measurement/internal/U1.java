package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.C2109c0;
import com.google.android.gms.internal.measurement.C2112d0;
import io.appmetrica.analytics.coreutils.internal.system.ConstantDeviceInfo;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Qh8;
import ir.nasim.Wt8;
import ir.nasim.Xh8;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
final class U1 implements Callable {
    final /* synthetic */ zzaw a;
    final /* synthetic */ String b;
    final /* synthetic */ Z1 c;

    U1(Z1 z1, zzaw zzawVar, String str) {
        this.c = z1;
        this.a = zzawVar;
        this.b = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws IOException {
        c4 c4Var;
        C2263k2 c2263k2;
        com.google.android.gms.internal.measurement.Q q;
        String str;
        Bundle bundle;
        com.google.android.gms.internal.measurement.T t;
        String str2;
        C2290q c2290qC;
        long j;
        String str3;
        byte[] bArr;
        Y3 y3;
        this.c.a.e();
        L2 l2D0 = this.c.a.d0();
        zzaw zzawVar = this.a;
        String str4 = this.b;
        l2D0.h();
        H1.t();
        AbstractC3795Cj5.j(zzawVar);
        AbstractC3795Cj5.f(str4);
        if (!l2D0.a.z().B(str4, S0.U)) {
            l2D0.a.b().q().b("Generating ScionPayload disabled. packageName", str4);
            return new byte[0];
        }
        if (!"_iap".equals(zzawVar.a) && !"_iapx".equals(zzawVar.a)) {
            l2D0.a.b().q().c("Generating a payload for this event is not available. package_name, event_name", str4, zzawVar.a);
            return null;
        }
        com.google.android.gms.internal.measurement.Q qA = com.google.android.gms.internal.measurement.S.A();
        l2D0.b.W().e0();
        try {
            C2263k2 c2263k2R = l2D0.b.W().R(str4);
            if (c2263k2R == null) {
                l2D0.a.b().q().b("Log and bundle not available. package_name", str4);
                bArr = new byte[0];
                y3 = l2D0.b;
            } else {
                if (c2263k2R.J()) {
                    com.google.android.gms.internal.measurement.T tO1 = com.google.android.gms.internal.measurement.U.O1();
                    tO1.X(1);
                    tO1.R(ConstantDeviceInfo.APP_PLATFORM);
                    if (!TextUtils.isEmpty(c2263k2R.d0())) {
                        tO1.u(c2263k2R.d0());
                    }
                    if (!TextUtils.isEmpty(c2263k2R.f0())) {
                        tO1.w((String) AbstractC3795Cj5.j(c2263k2R.f0()));
                    }
                    if (!TextUtils.isEmpty(c2263k2R.g0())) {
                        tO1.x((String) AbstractC3795Cj5.j(c2263k2R.g0()));
                    }
                    if (c2263k2R.L() != -2147483648L) {
                        tO1.y((int) c2263k2R.L());
                    }
                    tO1.M(c2263k2R.W());
                    tO1.G(c2263k2R.U());
                    String strI0 = c2263k2R.i0();
                    String strB0 = c2263k2R.b0();
                    if (!TextUtils.isEmpty(strI0)) {
                        tO1.L(strI0);
                    } else if (!TextUtils.isEmpty(strB0)) {
                        tO1.t(strB0);
                    }
                    Xh8 xh8V = l2D0.b.V(str4);
                    tO1.D(c2263k2R.T());
                    if (l2D0.a.o() && l2D0.a.z().C(tO1.k0()) && xh8V.i(Qh8.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                        tO1.F(null);
                    }
                    tO1.C(xh8V.h());
                    if (xh8V.i(Qh8.AD_STORAGE) && c2263k2R.I()) {
                        Pair pairN = l2D0.b.e0().n(c2263k2R.d0(), xh8V);
                        if (c2263k2R.I() && !TextUtils.isEmpty((CharSequence) pairN.first)) {
                            try {
                                tO1.Y(L2.e((String) pairN.first, Long.toString(zzawVar.d)));
                                Object obj = pairN.second;
                                if (obj != null) {
                                    tO1.O(((Boolean) obj).booleanValue());
                                }
                            } catch (SecurityException e) {
                                l2D0.a.b().q().b("Resettable device id encryption failed", e.getMessage());
                                bArr = new byte[0];
                                y3 = l2D0.b;
                            }
                        }
                    }
                    l2D0.a.A().k();
                    tO1.E(Build.MODEL);
                    l2D0.a.A().k();
                    tO1.Q(Build.VERSION.RELEASE);
                    tO1.e0((int) l2D0.a.A().p());
                    tO1.i0(l2D0.a.A().q());
                    try {
                        if (xh8V.i(Qh8.ANALYTICS_STORAGE) && c2263k2R.e0() != null) {
                            tO1.v(L2.e((String) AbstractC3795Cj5.j(c2263k2R.e0()), Long.toString(zzawVar.d)));
                        }
                        if (!TextUtils.isEmpty(c2263k2R.h0())) {
                            tO1.K((String) AbstractC3795Cj5.j(c2263k2R.h0()));
                        }
                        String strD0 = c2263k2R.d0();
                        List listC0 = l2D0.b.W().c0(strD0);
                        Iterator it = listC0.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                c4Var = null;
                                break;
                            }
                            c4Var = (c4) it.next();
                            if ("_lte".equals(c4Var.c)) {
                                break;
                            }
                        }
                        if (c4Var == null || c4Var.e == null) {
                            c4 c4Var2 = new c4(strD0, "auto", "_lte", l2D0.a.c().currentTimeMillis(), 0L);
                            listC0.add(c4Var2);
                            l2D0.b.W().x(c4Var2);
                        }
                        a4 a4VarG0 = l2D0.b.g0();
                        a4VarG0.a.b().v().a("Checking account type status for ad personalization signals");
                        if (a4VarG0.a.A().s()) {
                            String strD02 = c2263k2R.d0();
                            AbstractC3795Cj5.j(strD02);
                            if (c2263k2R.I() && a4VarG0.b.a0().B(strD02)) {
                                a4VarG0.a.b().q().a("Turning off ad personalization due to account type");
                                Iterator it2 = listC0.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    if ("_npa".equals(((c4) it2.next()).c)) {
                                        it2.remove();
                                        break;
                                    }
                                }
                                listC0.add(new c4(strD02, "auto", "_npa", a4VarG0.a.c().currentTimeMillis(), 1L));
                            }
                        }
                        C2112d0[] c2112d0Arr = new C2112d0[listC0.size()];
                        for (int i = 0; i < listC0.size(); i++) {
                            C2109c0 c2109c0D = C2112d0.D();
                            c2109c0D.w(((c4) listC0.get(i)).c);
                            c2109c0D.x(((c4) listC0.get(i)).d);
                            l2D0.b.g0().K(c2109c0D, ((c4) listC0.get(i)).e);
                            c2112d0Arr[i] = (C2112d0) c2109c0D.m();
                        }
                        tO1.z0(Arrays.asList(c2112d0Arr));
                        C2232e1 c2232e1B = C2232e1.b(zzawVar);
                        l2D0.a.N().z(c2232e1B.d, l2D0.b.W().Q(str4));
                        l2D0.a.N().A(c2232e1B, l2D0.a.z().n(str4));
                        Bundle bundle2 = c2232e1B.d;
                        bundle2.putLong("_c", 1L);
                        l2D0.a.b().q().a("Marking in-app purchase as real-time");
                        bundle2.putLong("_r", 1L);
                        bundle2.putString("_o", zzawVar.c);
                        if (l2D0.a.N().T(tO1.k0())) {
                            l2D0.a.N().C(bundle2, "_dbg", 1L);
                            l2D0.a.N().C(bundle2, "_r", 1L);
                        }
                        C2290q c2290qV = l2D0.b.W().V(str4, zzawVar.a);
                        if (c2290qV == null) {
                            t = tO1;
                            c2263k2 = c2263k2R;
                            q = qA;
                            str = str4;
                            bundle = bundle2;
                            str2 = null;
                            c2290qC = new C2290q(str4, zzawVar.a, 0L, 0L, 0L, zzawVar.d, 0L, null, null, null, null);
                            j = 0;
                        } else {
                            c2263k2 = c2263k2R;
                            q = qA;
                            str = str4;
                            bundle = bundle2;
                            t = tO1;
                            str2 = null;
                            long j2 = c2290qV.f;
                            c2290qC = c2290qV.c(zzawVar.d);
                            j = j2;
                        }
                        l2D0.b.W().q(c2290qC);
                        C2285p c2285p = new C2285p(l2D0.a, zzawVar.c, str, zzawVar.a, zzawVar.d, j, bundle);
                        com.google.android.gms.internal.measurement.I iE = com.google.android.gms.internal.measurement.J.E();
                        iE.D(c2285p.d);
                        iE.z(c2285p.b);
                        iE.C(c2285p.e);
                        r rVar = new r(c2285p.f);
                        while (rVar.hasNext()) {
                            String next = rVar.next();
                            com.google.android.gms.internal.measurement.M mE = com.google.android.gms.internal.measurement.N.E();
                            mE.A(next);
                            Object objA0 = c2285p.f.A0(next);
                            if (objA0 != null) {
                                l2D0.b.g0().J(mE, objA0);
                                iE.v(mE);
                            }
                        }
                        com.google.android.gms.internal.measurement.T t2 = t;
                        t2.B0(iE);
                        com.google.android.gms.internal.measurement.V vA = com.google.android.gms.internal.measurement.X.A();
                        com.google.android.gms.internal.measurement.K kA = com.google.android.gms.internal.measurement.L.A();
                        kA.r(c2290qC.c);
                        kA.s(zzawVar.a);
                        vA.r(kA);
                        t2.U(vA);
                        t2.u0(l2D0.b.T().m(c2263k2.d0(), Collections.emptyList(), t2.o0(), Long.valueOf(iE.t()), Long.valueOf(iE.t())));
                        if (iE.H()) {
                            t2.c0(iE.t());
                            t2.H(iE.t());
                        }
                        long jX = c2263k2.X();
                        if (jX != 0) {
                            t2.V(jX);
                        }
                        long jZ = c2263k2.Z();
                        if (jZ != 0) {
                            t2.W(jZ);
                        } else if (jX != 0) {
                            t2.W(jX);
                        }
                        String strB = c2263k2.b();
                        Wt8.b();
                        if (l2D0.a.z().B(str2, S0.n0)) {
                            str3 = str;
                            if (l2D0.a.z().B(str3, S0.p0) && strB != null) {
                                t2.b0(strB);
                            }
                        } else {
                            str3 = str;
                        }
                        c2263k2.e();
                        t2.z((int) c2263k2.Y());
                        l2D0.a.z().q();
                        t2.g0(74029L);
                        t2.f0(l2D0.a.c().currentTimeMillis());
                        t2.a0(true);
                        if (l2D0.a.z().B(str2, S0.t0)) {
                            l2D0.b.h(t2.k0(), t2);
                        }
                        com.google.android.gms.internal.measurement.Q q2 = q;
                        q2.r(t2);
                        C2263k2 c2263k22 = c2263k2;
                        c2263k22.C(t2.r0());
                        c2263k22.z(t2.q0());
                        l2D0.b.W().p(c2263k22);
                        l2D0.b.W().o();
                        l2D0.b.W().f0();
                        try {
                            return l2D0.b.g0().O(((com.google.android.gms.internal.measurement.S) q2.m()).g());
                        } catch (IOException e2) {
                            l2D0.a.b().r().c("Data loss. Failed to bundle and serialize. appId", C2227d1.z(str3), e2);
                            return str2;
                        }
                    } catch (SecurityException e3) {
                        l2D0.a.b().q().b("app instance id encryption failed", e3.getMessage());
                        byte[] bArr2 = new byte[0];
                        l2D0.b.W().f0();
                        return bArr2;
                    }
                }
                l2D0.a.b().q().b("Log and bundle disabled. package_name", str4);
                bArr = new byte[0];
                y3 = l2D0.b;
            }
            y3.W().f0();
            return bArr;
        } catch (Throwable th) {
            l2D0.b.W().f0();
            throw th;
        }
    }
}
