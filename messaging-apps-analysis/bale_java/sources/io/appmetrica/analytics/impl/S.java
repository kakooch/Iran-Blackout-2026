package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdTrackingInfoResult;
import io.appmetrica.analytics.coreapi.internal.identifiers.AdvertisingIdsHolder;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* loaded from: classes3.dex */
public final class S implements InterfaceC2896ua {
    public final String a;
    public final Object b;
    public C2549fl c;
    public volatile FutureTask d;
    public final O e;
    public final O f;
    public final O g;
    public final D h;
    public final D i;
    public final D j;
    public Context k;
    public final ICommonExecutor l;
    public volatile AdvertisingIdsHolder m;

    public S(O o, O o2, O o3, ICommonExecutor iCommonExecutor, String str) {
        this(o, o2, o3, iCommonExecutor, new G(new Of("google")), new G(new Of("huawei")), new G(new Of("yandex")), str);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2896ua
    public final void a(Context context, C2549fl c2549fl) {
        this.c = c2549fl;
        b(context);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2896ua
    public final void b(Context context) {
        this.k = context.getApplicationContext();
        if (this.d == null) {
            synchronized (this.b) {
                try {
                    if (this.d == null) {
                        this.d = new FutureTask(new J(this));
                        this.l.execute(this.d);
                    }
                } finally {
                }
            }
        }
    }

    public final O c() {
        return this.f;
    }

    public final String d() {
        return this.a;
    }

    public final O e() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.identifiers.SimpleAdvertisingIdGetter
    public final AdvertisingIdsHolder getIdentifiers(Context context) throws ExecutionException, InterruptedException {
        b(context);
        try {
            this.d.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
        return this.m;
    }

    public S(O o, O o2, O o3, ICommonExecutor iCommonExecutor, G g, G g2, G g3, String str) {
        this.b = new Object();
        this.e = o;
        this.f = o2;
        this.g = o3;
        this.h = g;
        this.i = g2;
        this.j = g3;
        this.l = iCommonExecutor;
        this.m = new AdvertisingIdsHolder();
        this.a = "[AdvertisingIdGetter" + str + "]";
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2896ua, io.appmetrica.analytics.impl.InterfaceC2668kl
    public final void a(C2549fl c2549fl) {
        this.c = c2549fl;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2896ua
    public final AdvertisingIdsHolder a(Context context) {
        return a(context, new C2780pd());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2896ua
    public final AdvertisingIdsHolder a(Context context, Uh uh) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new K(this, context.getApplicationContext(), uh));
        this.l.execute(futureTask);
        try {
            futureTask.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
        return this.m;
    }

    public static AdTrackingInfoResult b(S s, Context context) {
        if (s.f.a(s.c)) {
            return s.i.a(context);
        }
        C2549fl c2549fl = s.c;
        if (c2549fl != null && c2549fl.p) {
            if (!c2549fl.n.e) {
                return new AdTrackingInfoResult(null, IdentifierStatus.FEATURE_DISABLED, "startup forbade advertising identifiers collecting");
            }
            return new AdTrackingInfoResult(null, IdentifierStatus.UNKNOWN, "identifiers collecting is forbidden for unknown reason");
        }
        return new AdTrackingInfoResult(null, IdentifierStatus.NO_STARTUP, "startup has not been received yet");
    }

    public static AdTrackingInfoResult a(S s, Context context) {
        if (s.e.a(s.c)) {
            return s.h.a(context);
        }
        C2549fl c2549fl = s.c;
        if (c2549fl != null && c2549fl.p) {
            if (!c2549fl.n.c) {
                return new AdTrackingInfoResult(null, IdentifierStatus.FEATURE_DISABLED, "startup forbade advertising identifiers collecting");
            }
            return new AdTrackingInfoResult(null, IdentifierStatus.UNKNOWN, "identifiers collecting is forbidden for unknown reason");
        }
        return new AdTrackingInfoResult(null, IdentifierStatus.NO_STARTUP, "startup has not been received yet");
    }

    public final O b() {
        return this.e;
    }

    public final ICommonExecutor a() {
        return this.l;
    }
}
