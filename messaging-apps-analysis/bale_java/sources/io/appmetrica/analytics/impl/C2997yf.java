package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;

/* renamed from: io.appmetrica.analytics.impl.yf, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2997yf implements InterfaceC2853sf {
    public final boolean a;
    public final Lh b;
    public final C2637je c;
    public final G7 d;
    public final Gf e;
    public final Handler f;

    public C2997yf(Lh lh, C2637je c2637je, Handler handler) {
        this(lh, c2637je, handler, c2637je.s());
    }

    public final void a() {
        if (this.a) {
            return;
        }
        Lh lh = this.b;
        If r1 = new If(this.f, this);
        lh.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", r1);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = AbstractC2776p9.a;
        Ta ta = Ta.EVENT_TYPE_UNDEFINED;
        C2433b4 c2433b4 = new C2433b4("", "", 4098, 0, anonymousInstance);
        c2433b4.m = bundle;
        Q4 q4 = lh.a;
        lh.a(Lh.a(c2433b4, q4), q4, 1, null);
    }

    public C2997yf(Lh lh, C2637je c2637je, Handler handler, boolean z) {
        this(lh, c2637je, handler, z, new G7(z), new Gf());
    }

    public C2997yf(Lh lh, C2637je c2637je, Handler handler, boolean z, G7 g7, Gf gf) {
        this.b = lh;
        this.c = c2637je;
        this.a = z;
        this.d = g7;
        this.e = gf;
        this.f = handler;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2853sf
    public final void a(Cf cf) {
        String str = cf == null ? null : cf.a;
        if (!this.a) {
            synchronized (this) {
                G7 g7 = this.d;
                this.e.getClass();
                g7.d = Gf.a(str);
                g7.a();
            }
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        try {
            G7 g7 = this.d;
            g7.c = deferredDeeplinkParametersListener;
            if (g7.a) {
                g7.a(1);
            } else {
                g7.a();
            }
            this.c.u();
        } catch (Throwable th) {
            this.c.u();
            throw th;
        }
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        try {
            G7 g7 = this.d;
            g7.b = deferredDeeplinkListener;
            if (g7.a) {
                g7.a(1);
            } else {
                g7.a();
            }
            this.c.u();
        } catch (Throwable th) {
            this.c.u();
            throw th;
        }
    }
}
