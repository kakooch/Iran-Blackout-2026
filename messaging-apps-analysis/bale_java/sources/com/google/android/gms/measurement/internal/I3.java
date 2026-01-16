package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import ir.nasim.Rs8;
import ir.nasim.Wt8;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
final class I3 {
    final /* synthetic */ J3 a;

    I3(J3 j3) {
        this.a = j3;
    }

    final void a() {
        this.a.h();
        if (this.a.a.F().v(this.a.a.c().currentTimeMillis())) {
            this.a.a.F().l.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.a.a.b().v().a("Detected application was in foreground");
                c(this.a.a.c().currentTimeMillis(), false);
            }
        }
    }

    final void b(long j, boolean z) {
        this.a.h();
        this.a.s();
        if (this.a.a.F().v(j)) {
            this.a.a.F().l.a(true);
            Wt8.b();
            if (this.a.a.z().B(null, S0.o0)) {
                this.a.a.B().v();
            }
        }
        this.a.a.F().o.b(j);
        if (this.a.a.F().l.b()) {
            c(j, z);
        }
    }

    final void c(long j, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.a.h();
        if (this.a.a.o()) {
            this.a.a.F().o.b(j);
            this.a.a.b().v().b("Session started, time", Long.valueOf(this.a.a.c().elapsedRealtime()));
            long j2 = j / 1000;
            this.a.a.I().M("auto", "_sid", Long.valueOf(j2), j);
            this.a.a.F().p.b(j2);
            this.a.a.F().l.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j2);
            if (this.a.a.z().B(null, S0.b0) && z) {
                bundle.putLong("_aib", 1L);
            }
            this.a.a.I().v("auto", "_s", j, bundle);
            Rs8.b();
            if (this.a.a.z().B(null, S0.e0)) {
                String strA = this.a.a.F().u.a();
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", strA);
                this.a.a.I().v("auto", "_ssr", j, bundle2);
            }
        }
    }
}
