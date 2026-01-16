package io.appmetrica.analytics.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: io.appmetrica.analytics.impl.zk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3026zk implements S2 {
    public final Context a;

    public C3026zk(Context context) {
        this.a = context;
    }

    @Override // io.appmetrica.analytics.impl.S2, io.appmetrica.analytics.impl.InterfaceC2668kl
    public final void a(C2549fl c2549fl) {
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider
    public final SSLSocketFactory getSslSocketFactory() {
        return null;
    }

    public final Context a() {
        return this.a;
    }
}
