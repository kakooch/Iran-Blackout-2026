package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;

/* loaded from: classes3.dex */
public abstract class R4 extends AbstractC2819r5 {
    public R4(BaseRequestConfig.ComponentLoader<Object, Object, M5> componentLoader, C2549fl c2549fl, BaseRequestConfig.BaseRequestArguments<C3010z4, Object> baseRequestArguments) {
        super(componentLoader, c2549fl, baseRequestArguments);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2819r5
    public final void a(Object obj) {
        C3010z4 c3010z4 = (C3010z4) obj;
        synchronized (this) {
            super.a((Object) c3010z4);
        }
    }

    public final synchronized void a(C3010z4 c3010z4) {
        super.a((Object) c3010z4);
    }
}
