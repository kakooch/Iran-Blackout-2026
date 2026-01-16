package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import io.appmetrica.analytics.impl.C2501dm;

/* renamed from: io.appmetrica.analytics.impl.dm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2501dm {
    public final C2743o0 a;
    public final Cn b;
    public final C2766p c;
    public final Xj d;
    public final F5 e;

    public C2501dm(C2743o0 c2743o0, Cn cn, C2766p c2766p, Xj xj, F5 f5) {
        this.a = c2743o0;
        this.b = cn;
        this.c = c2766p;
        this.d = xj;
        this.e = f5;
    }

    public static Intent a(Activity activity) {
        return (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new FunctionWithThrowable() { // from class: ir.nasim.hd8
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                return C2501dm.b((Activity) obj);
            }
        });
    }

    public static final Intent b(Activity activity) {
        return activity.getIntent();
    }

    public C2501dm(C2743o0 c2743o0, Cn cn) {
        this(c2743o0, cn, C2747o4.g().a(), C2747o4.g().k(), C2747o4.g().e());
    }
}
