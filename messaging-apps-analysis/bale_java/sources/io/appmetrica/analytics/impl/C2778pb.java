package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.InterfaceC9173Yu3;

/* renamed from: io.appmetrica.analytics.impl.pb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2778pb implements ConfigProvider {
    public final C2484d5 a;
    public final InterfaceC9173Yu3 b = AbstractC13269fw3.a(new C2754ob(this));

    public C2778pb(C2484d5 c2484d5) {
        this.a = c2484d5;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Cg getConfig() {
        return (Cg) this.b.getValue();
    }
}
