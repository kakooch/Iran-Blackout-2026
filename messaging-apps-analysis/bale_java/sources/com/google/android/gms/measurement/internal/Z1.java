package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzd;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import ir.nasim.AbstractC24556yo8;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C16097kh8;
import ir.nasim.Fm8;
import ir.nasim.Ik8;
import ir.nasim.SA7;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
public final class Z1 extends Fm8 {
    private final Y3 a;
    private Boolean h;
    private String i;

    public Z1(Y3 y3, String str) {
        AbstractC3795Cj5.j(y3);
        this.a = y3;
        this.i = null;
    }

    private final void C2(zzaw zzawVar, zzq zzqVar) throws IOException {
        this.a.e();
        this.a.j(zzawVar, zzqVar);
    }

    private final void I2(zzq zzqVar, boolean z) {
        AbstractC3795Cj5.j(zzqVar);
        AbstractC3795Cj5.f(zzqVar.a);
        J2(zzqVar.a, false);
        this.a.h0().L(zzqVar.b, zzqVar.q);
    }

    private final void J2(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.a.b().r().a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.h == null) {
                    boolean z2 = true;
                    if (!"com.google.android.gms".equals(this.i) && !SA7.a(this.a.f(), Binder.getCallingUid()) && !com.google.android.gms.common.e.a(this.a.f()).c(Binder.getCallingUid())) {
                        z2 = false;
                    }
                    this.h = Boolean.valueOf(z2);
                }
                if (this.h.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.a.b().r().b("Measurement Service called with invalid calling package. appId", C2227d1.z(str));
                throw e;
            }
        }
        if (this.i == null && com.google.android.gms.common.d.j(this.a.f(), Binder.getCallingUid(), str)) {
            this.i = str;
        }
        if (str.equals(this.i)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // ir.nasim.Gm8
    public final void C0(zzkw zzkwVar, zzq zzqVar) {
        AbstractC3795Cj5.j(zzkwVar);
        I2(zzqVar, false);
        H2(new V1(this, zzkwVar, zzqVar));
    }

    final zzaw D2(zzaw zzawVar, zzq zzqVar) {
        zzau zzauVar;
        if ("_cmp".equals(zzawVar.a) && (zzauVar = zzawVar.b) != null && zzauVar.P() != 0) {
            String strC0 = zzawVar.b.C0("_cis");
            if ("referrer broadcast".equals(strC0) || "referrer API".equals(strC0)) {
                this.a.b().u().b("Event has been filtered ", zzawVar.toString());
                return new zzaw("_cmpx", zzawVar.b, zzawVar.c, zzawVar.d);
            }
        }
        return zzawVar;
    }

    final void F2(zzaw zzawVar, zzq zzqVar) throws IOException {
        if (!this.a.a0().C(zzqVar.a)) {
            C2(zzawVar, zzqVar);
            return;
        }
        this.a.b().v().b("EES config found for", zzqVar.a);
        B1 b1A0 = this.a.a0();
        String str = zzqVar.a;
        Ik8 ik8 = TextUtils.isEmpty(str) ? null : (Ik8) b1A0.j.d(str);
        if (ik8 == null) {
            this.a.b().v().b("EES not loaded for", zzqVar.a);
            C2(zzawVar, zzqVar);
            return;
        }
        try {
            Map mapI = this.a.g0().I(zzawVar.b.d0(), true);
            String strA = AbstractC24556yo8.a(zzawVar.a);
            if (strA == null) {
                strA = zzawVar.a;
            }
            if (ik8.e(new C16097kh8(strA, zzawVar.d, mapI))) {
                if (ik8.g()) {
                    this.a.b().v().b("EES edited event", zzawVar.a);
                    C2(this.a.g0().A(ik8.a().b()), zzqVar);
                } else {
                    C2(zzawVar, zzqVar);
                }
                if (ik8.f()) {
                    for (C16097kh8 c16097kh8 : ik8.a().c()) {
                        this.a.b().v().b("EES logging created event", c16097kh8.d());
                        C2(this.a.g0().A(c16097kh8), zzqVar);
                    }
                    return;
                }
                return;
            }
        } catch (zzd unused) {
            this.a.b().r().c("EES error. appId, eventName", zzqVar.b, zzawVar.a);
        }
        this.a.b().v().b("EES was not applied to event", zzawVar.a);
        C2(zzawVar, zzqVar);
    }

    @Override // ir.nasim.Gm8
    public final void G0(zzq zzqVar) {
        AbstractC3795Cj5.f(zzqVar.a);
        AbstractC3795Cj5.j(zzqVar.v);
        R1 r1 = new R1(this, zzqVar);
        AbstractC3795Cj5.j(r1);
        if (this.a.a().C()) {
            r1.run();
        } else {
            this.a.a().A(r1);
        }
    }

    final /* synthetic */ void G2(String str, Bundle bundle) {
        C2260k c2260kW = this.a.W();
        c2260kW.h();
        c2260kW.i();
        byte[] bArrG = c2260kW.b.g0().B(new C2285p(c2260kW.a, "", str, "dep", 0L, 0L, bundle)).g();
        c2260kW.a.b().v().c("Saving default event parameters, appId, data size", c2260kW.a.D().d(str), Integer.valueOf(bArrG.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put(CommonUrlParts.APP_ID, str);
        contentValues.put("parameters", bArrG);
        try {
            if (c2260kW.P().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                c2260kW.a.b().r().b("Failed to insert default event parameters (got -1). appId", C2227d1.z(str));
            }
        } catch (SQLiteException e) {
            c2260kW.a.b().r().c("Error storing default event parameters. appId", C2227d1.z(str), e);
        }
    }

    final void H2(Runnable runnable) {
        AbstractC3795Cj5.j(runnable);
        if (this.a.a().C()) {
            runnable.run();
        } else {
            this.a.a().z(runnable);
        }
    }

    @Override // ir.nasim.Gm8
    public final void I(zzac zzacVar) {
        AbstractC3795Cj5.j(zzacVar);
        AbstractC3795Cj5.j(zzacVar.c);
        AbstractC3795Cj5.f(zzacVar.a);
        J2(zzacVar.a, true);
        H2(new K1(this, new zzac(zzacVar)));
    }

    @Override // ir.nasim.Gm8
    public final List K(zzq zzqVar, boolean z) {
        I2(zzqVar, false);
        String str = zzqVar.a;
        AbstractC3795Cj5.j(str);
        try {
            List<c4> list = (List) this.a.a().s(new W1(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (c4 c4Var : list) {
                if (z || !f4.W(c4Var.c)) {
                    arrayList.add(new zzkw(c4Var));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            this.a.b().r().c("Failed to get user properties. appId", C2227d1.z(zzqVar.a), e);
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            this.a.b().r().c("Failed to get user properties. appId", C2227d1.z(zzqVar.a), e);
            return null;
        }
    }

    @Override // ir.nasim.Gm8
    public final List M0(String str, String str2, boolean z, zzq zzqVar) {
        I2(zzqVar, false);
        String str3 = zzqVar.a;
        AbstractC3795Cj5.j(str3);
        try {
            List<c4> list = (List) this.a.a().s(new L1(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (c4 c4Var : list) {
                if (z || !f4.W(c4Var.c)) {
                    arrayList.add(new zzkw(c4Var));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            this.a.b().r().c("Failed to query user properties. appId", C2227d1.z(zzqVar.a), e);
            return Collections.emptyList();
        } catch (ExecutionException e2) {
            e = e2;
            this.a.b().r().c("Failed to query user properties. appId", C2227d1.z(zzqVar.a), e);
            return Collections.emptyList();
        }
    }

    @Override // ir.nasim.Gm8
    public final void P0(zzq zzqVar) {
        AbstractC3795Cj5.f(zzqVar.a);
        J2(zzqVar.a, false);
        H2(new P1(this, zzqVar));
    }

    @Override // ir.nasim.Gm8
    public final List S1(String str, String str2, zzq zzqVar) {
        I2(zzqVar, false);
        String str3 = zzqVar.a;
        AbstractC3795Cj5.j(str3);
        try {
            return (List) this.a.a().s(new N1(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.a.b().r().b("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override // ir.nasim.Gm8
    public final void b2(zzaw zzawVar, String str, String str2) {
        AbstractC3795Cj5.j(zzawVar);
        AbstractC3795Cj5.f(str);
        J2(str, true);
        H2(new T1(this, zzawVar, str));
    }

    @Override // ir.nasim.Gm8
    public final void h1(zzq zzqVar) {
        I2(zzqVar, false);
        H2(new Q1(this, zzqVar));
    }

    @Override // ir.nasim.Gm8
    public final void k1(final Bundle bundle, zzq zzqVar) {
        I2(zzqVar, false);
        final String str = zzqVar.a;
        AbstractC3795Cj5.j(str);
        H2(new Runnable() { // from class: com.google.android.gms.measurement.internal.I1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.G2(str, bundle);
            }
        });
    }

    @Override // ir.nasim.Gm8
    public final List l1(String str, String str2, String str3, boolean z) {
        J2(str, true);
        try {
            List<c4> list = (List) this.a.a().s(new M1(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (c4 c4Var : list) {
                if (z || !f4.W(c4Var.c)) {
                    arrayList.add(new zzkw(c4Var));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            this.a.b().r().c("Failed to get user properties as. appId", C2227d1.z(str), e);
            return Collections.emptyList();
        } catch (ExecutionException e2) {
            e = e2;
            this.a.b().r().c("Failed to get user properties as. appId", C2227d1.z(str), e);
            return Collections.emptyList();
        }
    }

    @Override // ir.nasim.Gm8
    public final void m0(zzaw zzawVar, zzq zzqVar) {
        AbstractC3795Cj5.j(zzawVar);
        I2(zzqVar, false);
        H2(new S1(this, zzawVar, zzqVar));
    }

    @Override // ir.nasim.Gm8
    public final void n2(zzac zzacVar, zzq zzqVar) {
        AbstractC3795Cj5.j(zzacVar);
        AbstractC3795Cj5.j(zzacVar.c);
        I2(zzqVar, false);
        zzac zzacVar2 = new zzac(zzacVar);
        zzacVar2.a = zzqVar.a;
        H2(new J1(this, zzacVar2, zzqVar));
    }

    @Override // ir.nasim.Gm8
    public final void o0(zzq zzqVar) {
        I2(zzqVar, false);
        H2(new X1(this, zzqVar));
    }

    @Override // ir.nasim.Gm8
    public final byte[] r1(zzaw zzawVar, String str) {
        AbstractC3795Cj5.f(str);
        AbstractC3795Cj5.j(zzawVar);
        J2(str, true);
        this.a.b().q().b("Log and bundle. event", this.a.X().d(zzawVar.a));
        long jNanoTime = this.a.c().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.a.a().t(new U1(this, zzawVar, str)).get();
            if (bArr == null) {
                this.a.b().r().b("Log and bundle returned null. appId", C2227d1.z(str));
                bArr = new byte[0];
            }
            this.a.b().q().d("Log and bundle processed. event, size, time_ms", this.a.X().d(zzawVar.a), Integer.valueOf(bArr.length), Long.valueOf((this.a.c().nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException e) {
            e = e;
            this.a.b().r().d("Failed to log and bundle. appId, event, error", C2227d1.z(str), this.a.X().d(zzawVar.a), e);
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            this.a.b().r().d("Failed to log and bundle. appId, event, error", C2227d1.z(str), this.a.X().d(zzawVar.a), e);
            return null;
        }
    }

    @Override // ir.nasim.Gm8
    public final String u1(zzq zzqVar) {
        I2(zzqVar, false);
        return this.a.j0(zzqVar);
    }

    @Override // ir.nasim.Gm8
    public final void v0(long j, String str, String str2, String str3) {
        H2(new Y1(this, str2, str3, str, j));
    }

    @Override // ir.nasim.Gm8
    public final List y1(String str, String str2, String str3) {
        J2(str, true);
        try {
            return (List) this.a.a().s(new O1(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.a.b().r().b("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }
}
