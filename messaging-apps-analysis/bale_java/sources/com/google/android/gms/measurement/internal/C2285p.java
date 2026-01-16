package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import ir.nasim.AbstractC3795Cj5;
import java.util.Iterator;

/* renamed from: com.google.android.gms.measurement.internal.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2285p {
    final String a;
    final String b;
    final String c;
    final long d;
    final long e;
    final zzau f;

    C2285p(H1 h1, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzau zzauVar;
        AbstractC3795Cj5.f(str2);
        AbstractC3795Cj5.f(str3);
        this.a = str2;
        this.b = str3;
        this.c = true == TextUtils.isEmpty(str) ? null : str;
        this.d = j;
        this.e = j2;
        if (j2 != 0 && j2 > j) {
            h1.b().w().b("Event created with reverse previous/current timestamps. appId", C2227d1.z(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzauVar = new zzau(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    h1.b().r().a("Param name can't be null");
                    it.remove();
                } else {
                    Object objO = h1.N().o(next, bundle2.get(next));
                    if (objO == null) {
                        h1.b().w().b("Param value can't be null", h1.D().e(next));
                        it.remove();
                    } else {
                        h1.N().C(bundle2, next, objO);
                    }
                }
            }
            zzauVar = new zzau(bundle2);
        }
        this.f = zzauVar;
    }

    final C2285p a(H1 h1, long j) {
        return new C2285p(h1, this.c, this.a, this.b, this.d, j, this.f);
    }

    public final String toString() {
        return "Event{appId='" + this.a + "', name='" + this.b + "', params=" + this.f.toString() + "}";
    }

    private C2285p(H1 h1, String str, String str2, String str3, long j, long j2, zzau zzauVar) {
        AbstractC3795Cj5.f(str2);
        AbstractC3795Cj5.f(str3);
        AbstractC3795Cj5.j(zzauVar);
        this.a = str2;
        this.b = str3;
        this.c = true == TextUtils.isEmpty(str) ? null : str;
        this.d = j;
        this.e = j2;
        if (j2 != 0 && j2 > j) {
            h1.b().w().c("Event created with reverse previous/current timestamps. appId, name", C2227d1.z(str2), C2227d1.z(str3));
        }
        this.f = zzauVar;
    }
}
