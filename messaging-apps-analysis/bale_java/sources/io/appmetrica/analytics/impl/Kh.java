package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class Kh extends C2598hm {
    public final Jh e;
    public final ICommonExecutor f;

    public Kh(C2484d5 c2484d5, Jk jk, ICommonExecutor iCommonExecutor) {
        super(c2484d5, jk);
        this.e = new Jh(this);
        this.f = iCommonExecutor;
    }

    @Override // io.appmetrica.analytics.impl.C2598hm
    public final void a() {
        this.f.remove(this.e);
    }

    @Override // io.appmetrica.analytics.impl.C2598hm
    public final void f() {
        this.d.a();
        Cg cg = (Cg) ((C2484d5) this.a).l.a();
        if (cg.l.a(cg.k)) {
            String str = cg.n;
            if (TextUtils.isEmpty(str) || "-1".equals(str)) {
                return;
            }
            try {
                NetworkTask networkTaskA = C2732nd.a((C2484d5) this.a);
                C2586ha.C.getClass();
                NetworkServiceLocator.getInstance().getNetworkCore().startTask(networkTaskA);
            } catch (Throwable unused) {
            }
        }
    }

    public final void g() {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    this.f.remove(this.e);
                    h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        if (((Cg) ((C2484d5) this.a).l.a()).h > 0) {
            this.f.executeDelayed(this.e, TimeUnit.SECONDS.toMillis(((Cg) ((C2484d5) this.a).l.a()).h));
        }
    }
}
