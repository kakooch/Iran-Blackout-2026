package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ModuleEvent;

/* loaded from: classes3.dex */
public final class Ti implements Ka {
    public final /* synthetic */ ModuleEvent a;

    public Ti(ModuleEvent moduleEvent) {
        this.a = moduleEvent;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.reportEvent(this.a);
    }
}
