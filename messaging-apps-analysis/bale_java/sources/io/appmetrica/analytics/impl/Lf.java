package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import ir.nasim.AbstractC20723sV3;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class Lf {
    public final Context a;
    public final SafePackageManager b;
    public final La c;
    public final C2707mc d;
    public final long e;
    public final String f;
    public final String g;

    public Lf(Context context, SafePackageManager safePackageManager, La la) {
        this.a = context;
        this.b = safePackageManager;
        this.c = la;
        C2707mc c2707mc = new C2707mc(0);
        c2707mc.a(Bf.d, 1);
        c2707mc.a(Bf.c, 2);
        this.d = c2707mc;
        this.e = TimeUnit.DAYS.toSeconds(1L);
        this.f = "com.android.vending";
        this.g = "com.huawei.appmarket";
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.appmetrica.analytics.impl.Cf a(java.util.List r14) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.appmetrica.analytics.impl.Lf.a(java.util.List):io.appmetrica.analytics.impl.Cf");
    }

    public /* synthetic */ Lf(Context context) {
        this(context, new SafePackageManager(), AbstractC2648k1.a());
    }

    public static final int a(Lf lf, Cf cf, Cf cf2) {
        int iB = AbstractC20723sV3.b(cf.c - cf2.c);
        return iB == 0 ? ((Number) lf.d.a(cf.d)).intValue() - ((Number) lf.d.a(cf2.d)).intValue() : iB;
    }
}
