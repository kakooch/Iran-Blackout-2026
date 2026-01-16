package io.sentry.android.ndk;

import io.sentry.AbstractC3141l;
import io.sentry.C3106e;
import io.sentry.C3155n3;
import io.sentry.E1;
import io.sentry.H3;
import io.sentry.X;
import io.sentry.Y2;
import io.sentry.ndk.NativeScope;
import io.sentry.util.u;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public final class d extends E1 {
    private final C3155n3 a;
    private final io.sentry.ndk.a b;

    public d(C3155n3 c3155n3) {
        this(c3155n3, new NativeScope());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(C3106e c3106e) {
        String strF = null;
        String lowerCase = c3106e.t() != null ? c3106e.t().name().toLowerCase(Locale.ROOT) : null;
        String strH = AbstractC3141l.h(c3106e.v());
        try {
            Map mapS = c3106e.s();
            if (!mapS.isEmpty()) {
                strF = this.a.getSerializer().f(mapS);
            }
        } catch (Throwable th) {
            this.a.getLogger().a(Y2.ERROR, th, "Breadcrumb data is not serializable.", new Object[0]);
        }
        this.b.a(lowerCase, c3106e.u(), c3106e.r(), c3106e.w(), strH, strF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(H3 h3) {
        this.b.b(h3.n().toString(), h3.k().toString());
    }

    @Override // io.sentry.Y
    public void a(final C3106e c3106e) {
        try {
            this.a.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.ndk.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.h(c3106e);
                }
            });
        } catch (Throwable th) {
            this.a.getLogger().a(Y2.ERROR, th, "Scope sync addBreadcrumb has an error.", new Object[0]);
        }
    }

    @Override // io.sentry.Y
    public void c(final H3 h3, X x) {
        if (h3 == null) {
            return;
        }
        try {
            this.a.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.ndk.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.i(h3);
                }
            });
        } catch (Throwable th) {
            this.a.getLogger().a(Y2.ERROR, th, "Scope sync setTrace failed.", new Object[0]);
        }
    }

    d(C3155n3 c3155n3, io.sentry.ndk.a aVar) {
        this.a = (C3155n3) u.c(c3155n3, "The SentryOptions object is required.");
        this.b = (io.sentry.ndk.a) u.c(aVar, "The NativeScope object is required.");
    }
}
