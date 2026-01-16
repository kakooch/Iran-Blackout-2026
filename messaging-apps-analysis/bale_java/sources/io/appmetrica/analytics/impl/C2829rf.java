package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.InterfaceC9173Yu3;
import java.util.ArrayList;

/* renamed from: io.appmetrica.analytics.impl.rf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2829rf {
    public final Af a;
    public final C2872ta b;
    public final Lf c;
    public final InterfaceC9173Yu3 d = AbstractC13269fw3.a(new C2758of(this));
    public final InterfaceC9173Yu3 e = AbstractC13269fw3.a(new C2710mf(this));
    public final InterfaceC9173Yu3 f = AbstractC13269fw3.a(new C2806qf(this));
    public final ArrayList g = new ArrayList();

    public C2829rf(Af af, Kf kf, C2872ta c2872ta, Lf lf) {
        this.a = af;
        this.b = c2872ta;
        this.c = lf;
    }

    public static final InterfaceC2638jf a(C2829rf c2829rf) {
        return (InterfaceC2638jf) c2829rf.d.getValue();
    }

    public static final void a(C2829rf c2829rf, Cf cf, InterfaceC2638jf interfaceC2638jf) {
        boolean zD;
        c2829rf.g.add(cf);
        Lf lf = c2829rf.c;
        if (cf == null) {
            lf.getClass();
        } else {
            SafePackageManager safePackageManager = lf.b;
            Context context = lf.a;
            String installerPackageName = safePackageManager.getInstallerPackageName(context, context.getPackageName());
            int iOrdinal = cf.d.ordinal();
            if (iOrdinal == 1) {
                zD = AbstractC13042fc3.d(lf.f, installerPackageName);
            } else if (iOrdinal == 2) {
                zD = AbstractC13042fc3.d(lf.g, installerPackageName);
            }
            if (zD) {
                c2829rf.a(cf);
                return;
            }
        }
        interfaceC2638jf.a();
    }

    public final void a(Cf cf) {
        Af af = this.a;
        synchronized (af) {
            af.b = cf;
            af.c = true;
            af.d.a(cf);
            af.d.d();
            af.a(af.b);
        }
    }
}
